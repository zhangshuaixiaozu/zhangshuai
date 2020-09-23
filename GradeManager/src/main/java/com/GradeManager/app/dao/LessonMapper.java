package com.GradeManager.app.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.GradeManager.app.bean.Lesson;


@Repository
@Mapper
public interface LessonMapper {
int setLessonEntered(@Param("lessonId")int lessonId);

Lesson getLesson(@Param("lessonId")int lessonId);

boolean updateLesson(@Param("lessonId")int lessonId,
		@Param("examTime")String examTime, 
		@Param("examOrigin")int eo, 
		@Param("examWay")String examWay, 
		@Param("remark1")String remark1, 
		@Param("remark2")String remark2,
		@Param("remark3")String remark3);
}
