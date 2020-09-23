package com.GradeManager.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface LessonMapper {
int setLessonEntered(@Param("lessonId")int lessonId);
}
