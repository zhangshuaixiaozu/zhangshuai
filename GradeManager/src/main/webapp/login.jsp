<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>成绩管理系统-登录</title>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="../layui/css/layui.css"  media="all">
  <link rel="stylesheet" href="../layui/css/index.css">
   <script src="../layui/layui.js"></script>
   <script src="../js/login.js"></script>


</head>
<body>


 

 
<div class="layui-fulid" id="house-login" >


  <form class="layui-form " >
 
			
 <div class="layui-input-block login">
    <p>账号登录</p>
      </div>
    <div class="layui-input-block login">
      <i class="layui-icon layui-icon-username "></i>
      <input type="text" name="username"  lay-verify="required" placeholder="用户名" class="layui-input">
    </div>
    <div class="layui-input-block login">
      <i class="layui-icon layui-icon-password"></i>
      <input type="password" name="password" required lay-verify="required" placeholder="密码" class="layui-input">
    </div>
    
			<select  name="profession"  style="width:10px;">
				
				<option value="1">学生</option>
				<option value="2">教师</option>
				<option value="3">管理员</option>
			</select>
	  
 
      <button type="button" class="layui-btn" lay-submit="lay-submi" lay-filter="userlogin">登录</button>

  </form>
  

</div>




