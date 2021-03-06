package com.GradeManager.app.service;

import java.util.HashMap;
import java.util.List;

public interface TeacherIndexService {
	List<HashMap<String, Object>> getLessonList();
	boolean revocation(String reason, int type, String lessonId);
	List<HashMap<String, Object>> getMessageList();
}
