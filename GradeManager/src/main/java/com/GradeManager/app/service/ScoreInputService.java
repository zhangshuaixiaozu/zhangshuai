package com.GradeManager.app.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestParam;

import com.GradeManager.app.bean.Score;
import com.GradeManager.app.dao.ScoreInputMapper;

public interface ScoreInputService {

	public boolean updateScore(List<Map<String, Object>> score);
	
	public int getCountStudent(String lessonId);

	public List<Map<String, String>> getScoreInfo(Map<String, Object> map) ;
	
	public Map<String, Object> getExamInfo(String lessonId);
	
	public boolean updateInputStatus(String entered,String lessonId);
}
