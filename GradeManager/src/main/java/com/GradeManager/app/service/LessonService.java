package com.GradeManager.app.service;

import com.GradeManager.app.bean.Lesson;

public interface LessonService {
	boolean setLessonEntered(int lessonId);

	boolean updateLesson(int lessonId, String examTime, int eo, String examWay, String remark1, String remark2,
			String remark3);

	Lesson getLesson(int lessonId);
}
