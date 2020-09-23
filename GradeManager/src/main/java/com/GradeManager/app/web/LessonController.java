package com.GradeManager.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GradeManager.app.service.LessonService;

@RestController
public class LessonController {
	@Autowired
	private LessonService les;
	@RequestMapping("lesson/setLessonEntered")
	public boolean  setLessonEntered(int lessonId){
		return  les.setLessonEntered(lessonId);
	}
}
