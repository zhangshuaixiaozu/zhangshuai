package com.GradeManager.app.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.Lesson;
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

	@Override
	public boolean updateLesson(int lessonId, String examTime, int eo, String examWay, String remark1, String remark2,
			String remark3) {
		// TODO Auto-generated method stub
		return les.updateLesson(lessonId,examTime,eo,examWay,remark1,remark2,remark3);
	}

	@Override
	public Lesson getLesson(int lessonId) {
		// TODO Auto-generated method stub
		return les.getLesson(lessonId);
	}

}
