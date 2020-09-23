package com.GradeManager.app.dao;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ScoreMapper {
int delScore(@Param("lessonId")int lessonId);
}
