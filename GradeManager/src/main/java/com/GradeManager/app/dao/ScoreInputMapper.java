package com.GradeManager.app.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Mapper
@Repository
public interface ScoreInputMapper {

	// 更新成绩--录入成绩
	public boolean updateScore(List<Map<String, Object>> score);
	// 更新录入状态
	public boolean updateInputStatus(@Param("entered")String entered,@Param("lessonId")String lessonId);
	// 查询某课程学生人数
	public int getCountStudent(String lessonId);
    // 查询某课程所有学生成绩
	public List<Map<String, String>> getScoreInfo(Map<String, Object> map);
	// 查询某课程的相关信息--平时分占比，评分类型，成绩是否录入
	public Map<String, Object> getExamInfo(String lessonId);
	
}
