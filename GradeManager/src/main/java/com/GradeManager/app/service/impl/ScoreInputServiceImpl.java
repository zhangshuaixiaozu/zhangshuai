package com.GradeManager.app.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.GradeManager.app.bean.Score;
import com.GradeManager.app.dao.ScoreInputMapper;
import com.GradeManager.app.service.ScoreInputService;

@Service
public class ScoreInputServiceImpl implements ScoreInputService{

	@Autowired
	private ScoreInputMapper mapper;
	
	public boolean updateScore(List<Map<String, Object>> score) {
		return mapper.updateScore(score);
	}

	public int getCountStudent(String lessonId) {
		return mapper.getCountStudent(lessonId);
	}

	public List<Map<String, String>> getScoreInfo(Map<String, Object> map) {
		return mapper.getScoreInfo(map);
	}

	public Map<String, Object> getExamInfo(String lessonId){
		return mapper.getExamInfo(lessonId);
	}
	
	public boolean updateInputStatus(String entered,String lessonId) {
		return mapper.updateInputStatus(entered,lessonId);
	}

}
