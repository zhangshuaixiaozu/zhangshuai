package com.GradeManager.app.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.GradeManager.app.bean.classs;
import com.GradeManager.app.dao.classsMapper;
import com.GradeManager.app.service.classsService;
@Service
@Transactional
public class classsServiceImpl implements classsService {
	@Autowired
	private classsMapper cla;
	@Override
	public List<classs> getClasss(String cName) {
		// TODO Auto-generated method stub
		return cla.getClasss(cName);
	}

}
