package com.GradeManager.app.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GradeManager.app.service.TeacherIndexService;

@RestController
public class TeacherIndexController {
	@Autowired
	private TeacherIndexService teacherIndexService;
	
	@RequestMapping("/teacher/getLessons")
	public List<HashMap<String, Object>> getLessons(){
		System.out.println("hello");
		List<HashMap<String, Object>> ret = teacherIndexService.getLessonList();
		
		return ret;
	}
	@RequestMapping("/teacher/revocation")
	public boolean revocation(String reason, int type, String lessonId){
		return teacherIndexService.revocation(reason, type, lessonId);
	}
	@RequestMapping("/teacher/getMessages")
	public List<HashMap<String, Object>> getMessages(){
		System.out.println("hello");
		List<HashMap<String, Object>> ret = teacherIndexService.getMessageList();
		return ret;
	}

}
