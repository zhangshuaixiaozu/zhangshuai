

layui.use(["table","jquery","form",],function () {
   
   
    var $ = layui.jquery;
    var table = layui.table;
    var form=layui.form;
    $.ajaxSettings.async=false;
    var data;
	//挂科四门给出警告
    $.post('../student/score', function(flag) {
		console.log(flag);
		var count=0;
		for(var i=0;i<flag.length;i++)
			{
			if(flag[i].judgeCcore<60.0)
				count++;
			};
		if(count>=4){
			layer.msg('你挂科次数过多，请端正学习态度');
		};

		                      }); 
	$.post('../student/score',{'term':2019-2020,'term2':2}, function(flag) {
		data=flag;
				
	})
	
	 let newData = JSON.parse(JSON.stringify(data));
    //方法渲染
    var testTable = table.render({
        elem: "#score",
//        url:'../student/score?term=2017-2018&term2=2'
        autoSort: false,
        page: true,
        id: 'testReload',
       
        cols: [[
            {field: "lessonId", title: "课程ID", sort: true,},
            {field: "courseName", title: "课程名",},
            {field: "usualScore", title: "平时成绩",},
            {field: "normalScore", title: "卷面成绩",},
            {field: "score", title: "最终成绩",},
        ]],
        data: newData,
//        parseData: function(data){ //res 即为原始返回的数据
//        	console.log(data)
//            return {
//              "code": 0 //解析接口状态
//              ,"msg": "" //解析提示文本
//              ,"count": data.total //解析数据长度
//              ,"data": data //解析数据列表
//            };
//        },
        done: function (res, curr, count) {
            // layer.close(load);
            //如果是异步请求数据方式，res即为你接口返回的信息。
     		 //如果是直接赋值的方式，res即为：{data: [], count: 99} data为当前页数据、count为数据总长度
  	    console.log(res);
  	    //得到当前页码
  	    console.log(curr); 
  	    //得到数据总量
  	    console.log(count);
  		// 根据条件判断加背景色
  		 $.each(res.data, function (index, item) {
  			 if(item.judgeCcore<60.0){//item.score.substring(res.data.length-4)<"60.0"){
  			 $("#score").next().find('tbody tr[data-index="' + index +
             '"]').css("background-color", "#FFA07A");
  			 }
            });	    
        }
    
    });
    
    //查询
    $("#but").click(function(){
    		var term=$("#term").val();
    		var term2=$("#term2").val();
    		$.post('../student/score',{'term':term,'term2':term2}, function(flag) {
    			data=flag;
    					
    		});
    		 let newData = JSON.parse(JSON.stringify(data));
        	table.reload('testReload', { 
        		 data:newData, 
//        		 url:'../student/score?term='+term+'&term2='+term2,
        		          });
        
    	
				
	})
    
    //禁用效果
    form.on('select(college)', function (data) {
   	   if(data.value=="")
   	 $('#term2').attr('disabled',true);
   	 else
   		$('#term2').attr('disabled',false);
 	 });

});




   