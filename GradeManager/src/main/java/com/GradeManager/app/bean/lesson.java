package com.GradeManager.app.bean;

public class lesson {
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public String getCourseId() {
		return courseId;
	}
	public void setCourseId(String courseId) {
		this.courseId = courseId;
	}
	public String gettId() {
		return tId;
	}
	public void settId(String tId) {
		this.tId = tId;
	}
	public String getTerm() {
		return term;
	}
	public void setTerm(String term) {
		this.term = term;
	}
	public String getRemark1() {
		return remark1;
	}
	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}
	public String getRemark2() {
		return remark2;
	}
	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}
	public String getRemark3() {
		return remark3;
	}
	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}
	public String getExamWay() {
		return examWay;
	}
	public void setExamWay(String examWay) {
		this.examWay = examWay;
	}
	public int getExamStuNum() {
		return examStuNum;
	}
	public void setExamStuNum(int examStuNum) {
		this.examStuNum = examStuNum;
	}
	public int getExamOrigin() {
		return examOrigin;
	}
	public void setExamOrigin(int examOrigin) {
		this.examOrigin = examOrigin;
	}
	public int getEntered() {
		return entered;
	}
	public void setEntered(int entered) {
		this.entered = entered;
	}
	public String getScoreType() {
		return scoreType;
	}
	public void setScoreType(String scoreType) {
		this.scoreType = scoreType;
	}
	private int lessonId;
	private String courseId;
	private String tId;
	private String term;
	private String remark1;
	private String remark2;
	private String remark3;
	private String examWay;//考试方法，这是分析表中老师手动填的内容
	private int examStuNum;//参加考试的人数，这是分析表中老师手动填的内容
	private int examOrigin;//试题源，这是分析表中老师手动填的内容
	private int entered;
	private String scoreType;//分数类别，1为百分制，0为等级制
}
