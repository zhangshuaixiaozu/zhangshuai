<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title>学生成绩查询</title>
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="../layui/css/layui.css" media="all">
<script src="../layui/layui.js"></script>
<script src="../js/student.js"></script>


</head>
<body>
	<!-- style="background: url(../layui/images/image/xuesheng.jpg)  no-repeat;  background-size:100% 100% ; background-attachment: fixed" -->

	<div class="layui-input-inline layui-form">
		<select id="term" lay-filter="college" style="width: 200px;">
			<option value="">全部</option>
			<option value="2015-2016">2015-2016</option>
			<option value="2016-2017">2016-2017</option>
			<option value="2017-2018">2017-2018</option>
			<option value="2018-2019">2018-2019</option>
			<option value="2019-2020" selected>2019-2020</option>
		</select>
	</div>

	<select id="term2" style="width: 200px; height: 37px">

		<option value="1">第一学期</option>
		<option value="2">第二学期</option>

	</select>

	<button class="layui-btn layui-btn-radius layui-btn-normal" id="but">查询</button>


	<table id="score"></table>



</body>
</html>



