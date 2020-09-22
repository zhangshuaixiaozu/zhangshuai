package com.GradeManager.app.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GradeManager.app.bean.Classs;
import com.GradeManager.app.service.classsService;

@RestController
public class classsController {
	@Autowired
	private classsService cla;
	@RequestMapping("classs/getClasss")
	public List<Classs> getClasss(String cName)
	{
		System.out.print("----------------------------"+cName);
		return cla.getClasss(cName);
	}
}
