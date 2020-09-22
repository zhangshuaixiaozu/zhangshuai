package com.GradeManager.app.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.Admin;
import com.GradeManager.app.bean.Student;
import com.GradeManager.app.bean.Teacher;
import com.GradeManager.app.dao.LoginMapper;
import com.GradeManager.app.service.LoginService;

@Service
@Transactional
public class LoginServiceImpl implements LoginService {
	@Autowired
	private LoginMapper log;
	 @Autowired
    private HttpSession session;

	@Override
	public int getUser(String username, String password, String profession) {
		if (profession .equals("1")) {
			Student Student=log.getStudent(username, password);	
			if(Student!=null) {
			session.setAttribute("user", Student);
			return 1;}
			else return 0;
		}else if (profession .equals("2")){
			Teacher Teacher=log.getTeacher(username, password);
			if(Teacher!=null) {
			 session.setAttribute("user", Teacher);
			return 2;}
			else return 0;
		}
		 else if (profession.equals("3") ) {
				Admin Admin=log.getAdmin(username, password);
				if(Admin!=null) {
				session.setAttribute("user", Admin);
				return 3;}
				else return 0;
			} else return 0;

	}

}
