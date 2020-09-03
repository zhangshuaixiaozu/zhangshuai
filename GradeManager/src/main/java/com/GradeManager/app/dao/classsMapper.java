package com.GradeManager.app.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.GradeManager.app.bean.classs;

@Repository
@Mapper
public interface classsMapper {
List<classs> getClasss(@Param("cName")String cName);

}
