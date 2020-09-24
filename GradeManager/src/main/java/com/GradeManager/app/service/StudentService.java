package com.GradeManager.app.service;

import java.util.List;



import com.GradeManager.app.bean.ScoreShow;

public interface StudentService {
	List<ScoreShow> getScore(String term,String term2,String sId);
}
