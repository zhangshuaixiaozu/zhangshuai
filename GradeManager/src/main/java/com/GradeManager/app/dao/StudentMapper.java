package com.GradeManager.app.dao;



import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.GradeManager.app.bean.Admin;
import com.GradeManager.app.bean.ScoreShow;
import com.GradeManager.app.bean.Student;
import com.GradeManager.app.bean.Teacher;

@Repository
@Mapper
public interface StudentMapper {
//public	List<ScoreShow> getScore(@Param("sId")String sId);
	public	List<ScoreShow> getScore(@Param("term")String term,@Param("term2")String term2,@Param("sId")String sId);
}