package com.GradeManager.app.service;

import java.util.List;

import com.GradeManager.app.bean.Score;

public interface ScoreService {
	boolean delScore(int lessonId);

	List<Score> getLessonScore(int lessonId);
}
