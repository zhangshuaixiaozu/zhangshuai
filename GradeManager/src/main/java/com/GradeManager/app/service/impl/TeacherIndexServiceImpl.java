package com.GradeManager.app.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	@Override
	public boolean revocation(String reason, int type, String lessonId){
		return teacherIndexMapper.revocation(reason, type, lessonId);
	}
	@Override
	public List<HashMap<String, Object>> getMessageList() {
		// TODO Auto-generated method stub
		Teacher teacher = new Teacher();
		teacher.settId("2001001");
		session.setAttribute("user", teacher);
		Teacher newTeacher = (Teacher)session.getAttribute("user");
		
		//根据tID查出lesson
		List<HashMap<String, Object>> lessons = teacherIndexMapper.getLessons(newTeacher.gettId());
		List<HashMap<String, Object>> ret = new ArrayList<HashMap<String,Object>>();
		
		//根据lessonId查撤销表
		for(HashMap<String, Object> lesson : lessons){
			List<HashMap<String, Object>> messages = teacherIndexMapper.getLessonMessage(String.valueOf((Integer) lesson.get("lessonId")));
			for(HashMap<String, Object> message : messages){
				ret.add(message);
				message.put("courseId", lesson.get("courseName"));
			}
		}
		return ret;
	}
}
