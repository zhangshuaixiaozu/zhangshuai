package com.GradeManager.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.GradeManager.app.dao.LessonMapper;
import com.GradeManager.app.service.LessonService;

@Service
@Transactional
public class LessonServiceImpl implements LessonService {
	@Autowired
	private LessonMapper les;

	@Override
	public boolean setLessonEntered(int lessonId) {
		// TODO Auto-generated method stub
		return les.setLessonEntered(lessonId)>0;
	}

}
