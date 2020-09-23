package com.GradeManager.app.service.impl;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.GradeManager.app.bean.Teacher;
import com.GradeManager.app.dao.TeacherIndexMapper;
import com.GradeManager.app.service.TeacherIndexService;

@Service
public class TeacherIndexServiceImpl implements TeacherIndexService {

	@Autowired
	private TeacherIndexMapper teacherIndexMapper;
	@Autowired
	private HttpSession session;
	@Override
	public List<HashMap<String, Object>> getLessonList() {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.settId("2001001");
		session.setAttribute("user", teacher);
		Teacher newTeacher = (Teacher)session.getAttribute("user");
		return teacherIndexMapper.getLessons(newTeacher.gettId());
	}
}
