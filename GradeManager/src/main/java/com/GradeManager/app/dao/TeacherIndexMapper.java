package com.GradeManager.app.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TeacherIndexMapper {
	List<HashMap<String, Object>> getLessons(@Param("tId")String tId);
}
