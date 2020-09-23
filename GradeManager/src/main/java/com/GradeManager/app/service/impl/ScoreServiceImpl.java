package com.GradeManager.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.Score;
import com.GradeManager.app.dao.ScoreMapper;
import com.GradeManager.app.service.ScoreService;

@Service
@Transactional
public class ScoreServiceImpl implements ScoreService {
	@Autowired
	private ScoreMapper sco;

	@Override
	public boolean delScore(int lessonId) {
		// TODO Auto-generated method stub
		return sco.delScore(lessonId)>0;
	}

	@Override
	public List<Score> getLessonScore(int lessonId) {
		// TODO Auto-generated method stub
		return sco.getLessonScore(lessonId);
	}

}
