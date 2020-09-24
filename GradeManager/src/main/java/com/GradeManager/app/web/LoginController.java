package com.GradeManager.app.web;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GradeManager.app.bean.Student;
import com.GradeManager.app.bean.Teacher;
import com.GradeManager.app.service.LoginService;


@RestController
public class LoginController {

	@Autowired
	private LoginService log;
	 @Autowired
	private HttpSession session;
	@RequestMapping("/user/login")
	public String login(String username,String password,String profession){
		
		int i=log.getUser(username,password,profession);
		if(i==1) {return "学生登陆成功";}
		else if(i==2) {return "老师登陆成功";}
		else if (i==3) {return "管理员登陆成功";}
		else {return "登录失败";}
	
	}
	@RequestMapping("/user/getTname")
	public String getTname(){
		Teacher t=(Teacher) session.getAttribute("user");
		return t.gettName();
	}
	@RequestMapping("/user/getSname")
	public String getSname(){
		Student s=(Student) session.getAttribute("user");
		return s.getsName();
	}

}
