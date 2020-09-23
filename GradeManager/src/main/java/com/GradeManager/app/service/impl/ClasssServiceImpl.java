package com.GradeManager.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.Classs;
import com.GradeManager.app.dao.ClasssMapper;
import com.GradeManager.app.service.ClasssService;
@Service
@Transactional
public class ClasssServiceImpl implements ClasssService {
	@Autowired
	private ClasssMapper cla;
	public List<Classs> getClasss(String lessonId) {
		// TODO Auto-generated method stub
		return cla.getClasss(lessonId);
	}


}
