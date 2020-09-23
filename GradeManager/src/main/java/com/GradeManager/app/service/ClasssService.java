package com.GradeManager.app.service;

import java.util.List;


import com.GradeManager.app.bean.Classs;

public interface ClasssService {
	List<Classs> getClasss(String cName);
}
