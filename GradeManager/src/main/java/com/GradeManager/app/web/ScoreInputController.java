package com.GradeManager.app.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.GradeManager.app.service.impl.ScoreInputServiceImpl;

@RestController
@RequestMapping("/ScoreInput")
public class ScoreInputController {

	@Autowired
	private ScoreInputServiceImpl impl;

	// // 查询某课程的相关信息--平时分占比，评分类型，成绩是否录入
	@RequestMapping("/getExamInfo")
	public Map<String, Object> getExamInfo(@RequestParam("lessonId") String lessonId) {

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", 1);
		result.put("data", impl.getExamInfo(lessonId));
		return result;
	}

	// 更新成绩----录入成绩
	@RequestMapping("/updateScore")
	public boolean updateScore(@RequestBody List<Map<String, Object>> score) {

		Map<String, Object> map = new HashMap<String, Object>();
		return impl.updateScore(score);
	}

	// 更新录入状态
	@RequestMapping("/updateInputStatus")
	public boolean updateInputStatus(@RequestParam("entered") String entered,@RequestParam("lessonId") String lessonId) {
		
		return impl.updateInputStatus(entered,lessonId);
	}

	// 查询某课程所有成绩信息
	@RequestMapping("/getScoreInfo")
	public Map<String, Object> getScoreInfo(@RequestParam("lessonId") String lessonId) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lessonId", lessonId);

		Map<String, Object> result = new HashMap<String, Object>();
		result.put("code", 0);
		result.put("msg", "");
		result.put("count", impl.getCountStudent(lessonId));
		result.put("data", impl.getScoreInfo(map));

		return result;
	}

}
