package com.GradeManager.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.GradeManager.app.service.ScoreService;

@RestController
public class ScoreController {
	@Autowired
	private ScoreService sco;
	@RequestMapping("score/delScore")
	public boolean  delScore(int lessonId){
		return  sco.delScore(lessonId);
	}
}
