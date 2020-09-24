package com.GradeManager.app.service.impl;



import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.Admin;
import com.GradeManager.app.bean.ScoreShow;
import com.GradeManager.app.bean.Student;
import com.GradeManager.app.bean.Teacher;
import com.GradeManager.app.dao.LoginMapper;
import com.GradeManager.app.dao.StudentMapper;
import com.GradeManager.app.service.LoginService;
import com.GradeManager.app.service.StudentService;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper std;


	@Override
	public List<ScoreShow> getScore(String term,String term2,String sId) {
	
		return std.getScore( term, term2, sId);
	}
	
	
}
