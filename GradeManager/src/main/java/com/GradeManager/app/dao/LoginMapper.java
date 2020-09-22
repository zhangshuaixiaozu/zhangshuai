package com.GradeManager.app.dao;



import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


import com.GradeManager.app.bean.Admin;
import com.GradeManager.app.bean.Student;
import com.GradeManager.app.bean.Teacher;

@Repository
@Mapper
public interface LoginMapper {
Admin getAdmin(@Param("username")String username,@Param("password")String password);
Student getStudent(@Param("username")String username,@Param("password")String password);
Teacher getTeacher(@Param("username")String username,@Param("password")String password);
}