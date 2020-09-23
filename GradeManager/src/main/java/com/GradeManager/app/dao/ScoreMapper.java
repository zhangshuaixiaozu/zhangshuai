package com.GradeManager.app.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.GradeManager.app.bean.Score;

@Repository
@Mapper
public interface ScoreMapper {
int delScore(@Param("lessonId")int lessonId);

List<Score> getLessonScore(@Param("lessonId")int lessonId);
}
