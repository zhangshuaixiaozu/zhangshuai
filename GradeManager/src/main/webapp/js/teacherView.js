//layui基本用法先声明组件，后使用
layui.use([ 'layer', 'form', 'jquery', 'table' ], function() {
	var layer = layui.layer;
	var form = layui.form;
	var $ = layui.jquery;
	var table = layui.table;
	var data;

	var lessonId = getUrlParams('lessonId');

	$.ajaxSettings.async = false;
	$.ajax({
		url : "/score/listScore",
		data : {
			lessonId : lessonId,
		},
		success : function(ret) {
			data = ret;
			console.info(ret);
		}
	});
	console.info(data);
	let newData = JSON.parse(JSON.stringify(data));
	console.info(newData);
	var table1 = table.render({
		elem : "#viewTable",
		page : true,//开启分页
		data : newData,
		cols : [[ //表头
		{
			field : 'studentId',
			title : '学生学号',

		}, {
			field : 'sName',
			title : '学生姓名',

		}, {
			field : 'usualScore',
			title : '平时成绩',
			templet : function(obj){
				console.info(obj);
				if(obj.scoreType === "等级制"){
					return ""
				}else{
					if(obj.usualScore === -1){
						return "尚未评分";
					}
					else{
						return obj.usualScore;
					} 
				}
			}
//			toolbar : '#barDemo',
		}, {
			field : 'normalScore',
			title : '正考成绩',
		}, {
			field : 'supplementScore',
			title : '补考成绩',
			templet : function(obj){
				console.info(obj);
				if(obj.supplementScore === -1){
					return "无";
				}else{
					return `<font color="red">${obj.supplementScore}</font>`;
				}
			}
		}, {
			field : 'clearScore',
			title : '清考成绩',
			templet : function(obj){
				console.info(obj);
				if(obj.clearScore === -1){
					return "无"
				}else{
					return `<font color="red">${obj.clearScore}</font>`;
				}
			}
		} , {
			field : 'score',
			title : '最终成绩',
			templet : function(obj){
				console.info(obj);
				if(obj.scoreType === "等级制"){
					return obj.normalScore
				}else{ //分数制
					if(obj.clearScore !== -1){
						if(obj.clearScore>60){
							return `<font color="red">60</font>`
						}else{
							return `<font color="red">${obj.clearScore}</font>`
						}
					}else if(obj.supplementScore !== -1){
						if(obj.supplementScore>60){
							return `<font color="red">60</font>`
						}else{
							return `<font color="red">${obj.supplementScore}</font>`
						}
					}else {
						return Math.round((obj.normalScore*(1-obj.usualProportion)+obj.usualScore*obj.usualProportion) * 100) / 100;
					}
				}
			}
//			toolbar : '#barDemo',
		} 
		]],
		
	});

	//查询按钮
	$('#search-btn').click(function() {
		//查找
		let finding = $('#sName').val();
		let finded = [];
		for(var i=0; i<data.length; i++){
			if(data[i].sName===finding || data[i].sId===finding){
				finded.push(data[i]);
			}
		}
		let newData = JSON.parse(JSON.stringify(finded));
		//执行重载
		table1.reload({
			data: newData
		});
	});
	$('#reset-btn').click(function(){
		let newData = JSON.parse(JSON.stringify(data));
		//执行重载
		table1.reload({
			data: newData
		});
	});
});

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