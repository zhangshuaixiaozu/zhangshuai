
/**
 * 成绩录入js文件
 * 
 */

layui.use(['table','form','layer'], function(){
  var table = layui.table;
  var layer = layui.layer;
  var $ = layui.jquery;
  var form = layui.form;
  
  var newData;
  var courseData;    // 课程评分相关信息
  var table1;
  var table2;
  var table3;
  var lessonId = getUrlParams('lessonId');
  
  $.ajaxSettings.async=false;    // 设置为同步
  
    // 获取课程评分相关信息
	$.ajax({
		url:'/ScoreInput/getExamInfo' // 数据接口
	  ,method: 'post'
	  ,data:{
		 lessonId:lessonId
	  }
	  ,success: function(data){
		  courseData=data.data;
		  console.log(courseData);
	  }
	  ,error: function(data){
		  console.log("获取课程成绩参数失败");
		  }
	});
  
  $.ajax({
	  url:'/ScoreInput/getScoreInfo' // 数据接口
	  ,method: 'post'
	  ,data:{
		  lessonId: lessonId
	  }
      ,success: function(data){
    	  newData=data.data;
    	  var data1 = new Array();
      	  for(var i=0;i<data.count;i++){
      		var supplementScore = newData[i].supplementScore;
      		var totalScore;
      		if(courseData.scoreType=="等级制"){
      			console.log(supplementScore);
	      	    if(newData[i].supplementScore>=60 && newData[i].supplementScore<100) totalScore="D";
	      	    else if(newData[i].supplementScore> 0  && newData[i].supplementScore<60 ) totalScore="E";
	      	    else totalScore=supplementScore;
	      	    console.log("+++++++")
	      	    console.log(totalScore);
      		}else{
      			if(supplementScore>=60 && supplementScore<100)
      				totalScore=60;
      			else
      				totalScore=supplementScore;
      		}      		
      		data1[i]={
      			scoreId: newData[i].scoreId,
      			studentId: newData[i].studentId,
      			sName: newData[i].sName,
      			supplementScore: supplementScore,
      			totalScore: totalScore,
      			lessonId: lessonId
      		}
      	} 
      	// 表格渲染所用数据
      	newData=data1; 
      	
      	// 等级制
      	if(courseData.scoreType=="等级制"){
      		alert("成绩已录入，无法修改");
      	  console.log("等级制");
      	  // 判断是否已录入  
      	  if(courseData.entered==1){
      		// 成绩录入表格
	    	table1 = table.render({
	    	    elem: '#GradeInput'
	    	    ,toolbar: '#toolbarDemo'
	    	    ,page: true // 开启分页
	    	    ,method: 'post'
	    	    ,data: newData
	    	    ,cols: [[ // 表头
	    	      {field: 'scoreId', title: 'ID', width:120,align: 'center',  fixed: 'left'}
	    	      ,{field: 'studentId', title: '学生ID', width:120,align: 'center'}
	    	      ,{field: 'sName', title: '学生姓名', width:120 ,align: 'center'}
	    	      ,{field: 'supplementScore', title: '补考成绩', width:120,align: 'center',style:'background-color: #eee;',
	    	    	  templet: function(d){
	    	    			  return d.totalScore;    // supplementScore 与 totalScore 值相同
	    	    	  }
	    	    	}
	    	      ,{field: 'totalScore', title: '总评成绩', width: 120,align: 'center'
	    	      }
	    	    ]]
	    	    ,done: function(res, curr, count){
	       	      // 由于layui 设置了超出隐藏，所以这里改变下，以兼容操作按钮的下拉菜单
	    	      $(".layui-table-body, .layui-table-box, .layui-table-cell").css('overflow', 'visible');
	    	    }
	    	  });
      	  }else{
      		// 成绩录入表格
  	    	table3 = table.render({
  	    	    elem: '#GradeInput'
  	    	    ,toolbar: '#toolbarDemo'
  	    	    ,defaultToolbar: []
  	    	    ,page: true // 开启分页
  	    	    ,method: 'post'
  	    	    ,height: 800
  		        ,width:  1000
  	    	    ,data: newData
  	    	    ,cols: [[ // 表头
  	    	      {field: 'scoreId', title: 'ID',align: 'center' }
  	    	      ,{field: 'studentId', title: '学生ID',align: 'center', width:120}
  	    	      ,{field: 'sName', title: '学生姓名',align: 'center'}
  	    	      ,{field: 'supplementScore', title: '补考成绩',  align: 'center',
  	    	    	  templet: '#selectSupplementScore'
  	    	    	}
  	    	      ,{field: 'totalScore', title: '总评成绩',align: 'center'
  	    	      }
  	    	    ]]
  	    	    ,done: function(res, curr, count){
  	       	      // 由于layui 设置了超出隐藏，所以这里改变下，以兼容操作按钮的下拉菜单
  	    	      $(".layui-table-body, .layui-table-box, .layui-table-cell").css('overflow', 'visible');
  	    	    }
  	    	  });
      	  }
      	}
      	
      	// 百分制
      	else{
      	  console.log("百分制");
      	  // 成绩录入表格
      	  table2=table.render({
      	    elem: '#GradeInput'
      	    ,toolbar: '#toolbarDemo'
      	    ,page: true // 开启分页
      	    ,method: 'post'
      	    ,data: newData
      	    ,cols: [[ // 表头
      	      {field: 'scoreId', title: 'ID', width:120, align: 'center' }
      	      ,{field: 'studentId', title: '学生ID', width:140, align: 'center'}
      	      ,{field: 'sName', title: '学生姓名', width:120 , align: 'center'}
      	      ,{field: 'supplementScore', title: '补考成绩', width: 120, align: 'center', edit:'text'}
      	      ,{field: 'totalScore', title: '总评成绩', width: 120, align: 'center'}
      	    ]]
      	    ,done:function(res,curr,count){
              // 关闭可编辑状态：
      		  if(courseData.entered==1){
      			alert("成绩已录入，无法修改");
      			 $(".layui-table").find('td').data('edit', false);
      		  }
      		    
                // 打开可编辑状态：   
//      		  else
//      	    	 $(".layui-table").find('td').data('edit', true);
      	    }
      	  });
      	}
      }
      // 外层表格的error函数
      ,error: function(data){
		console.log("失败");
      }
//	  
  });

  table.on('edit(GradeInput)',function(obj){
	// 获取当前选中行的数据
  	var data = obj.data;　

  	var supplementScore = parseInt(obj.data['supplementScore']) ;
  	var totalScore1;
  	if(supplementScore>=60)
  		totalScore1=60;
  	else
  		totalScore1=supplementScore;
  	
  	// 更新该行的数据
  	obj.update({
  		supplementScore: supplementScore,
  		totalScore: totalScore1
  	});
  });
  
  // 监听工具栏事件
  table.on('toolbar(GradeInput)', function(obj){
    var checkStatus = table.checkStatus(obj.config.id);
    // 判断是否为录入状态
    if(courseData.entered==0){
    	// 提交成绩
    	if(courseData.scoreType=="等级制"){
        	for(var i=0;i<newData.length;i++){
        		  var tempScore;
        		  console.log("-----提交成绩-------")
        		  console.log(newData[i].supplementScore);
        		  if(newData[i].supplementScore>=60 && newData[i].supplementScore<100 || newData[i].supplementScore!='E')
        			  tempScore=60;
        		  else if(newData[i].supplementScore<60 && newData[i].supplementScore>=0 || newData[i].supplementScore=='E')
        			  tempScore=50;
        		  else
        			  tempScore=-1;
	    		  newData[i].supplementScore=tempScore;
	    		  console.log(newData[i].supplementScore);
        	}
        }        
        $.ajax({
        	url: "/ScoreInput/updateScore"
            ,type: 'post'
            ,contentType: "application/json"
            ,dataType: "json"
            ,data: JSON.stringify(newData)
            ,success: function(data){
            	console.log("提交成绩成功");
            	table.reload('GradeInput',{});
            },error: function(data){
            	console.log("提交失败");
            }
        });
        
	    switch(obj.event){
	      case 'save':
	        layer.msg('提交成绩');
	       // 更改录入状态
    		$.ajax({
        		url: "/ScoreInput/updateInputStatus"
        		,data: {  entered: 1, lessonId: lessonId }
        	    ,success: function(d){  
        	    	window.parent.location.reload();
        	    }
        	});
        	
	      break;
	      case 'temporary':
	        layer.msg('暂存成功');
	        window.parent.location.reload();
	      break;
	    };
    }else
    	alert("成绩已录入，无法修改");
    
  });
  
  var rowObj;
  // 监听行单击事件（双击事件为：rowDouble）
  table.on('row(GradeInput)', function(obj){
    rowObj=obj;
    console.log(obj.data);
    console.log(newData);
  });

  
  
  // 添加评审栏下拉框点击事件（这里是添加点击事件）
  form.on('select(_selectSupplementScore)', function(data){
	  // 更新缓存的值 
	  console.log(data.value);
	  var temp;
	  if(data.value!='E')
		  temp='D';
	  else
		  temp='E';
	  
	  rowObj.update({
		  supplementScore: data.value,
		  totalScore: temp
	  });  
      form.render('select');
  });
});


//lessonId获取
function getUrlParams(name) { // 不传name返回所有值，否则返回对应值
	var url = window.location.search;
	if (url.indexOf('?') == 1) {
		return false;
	}
	url = url.substr(1);
	url = url.split('&');
	var name = name || '';
	var nameres;
	// 获取全部参数及其值
	for (var i = 0; i < url.length; i++) {
		var info = url[i].split('=');
		var obj = {};
		obj[info[0]] = decodeURI(info[1]);
		url[i] = obj;
	}
	// 如果传入一个参数名称，就匹配其值
	if (name) {
		for (var i = 0; i < url.length; i++) {
			for ( const key in url[i]) {
				if (key == name) {
					nameres = url[i][key];
				}
			}
		}
	} else {
		nameres = url;
	}
	// 返回结果
	return nameres;
}