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
	public String getSchoolYear() {
		return schoolYear;
	}
	public void setSchoolYear(String schoolYear) {
		this.schoolYear = schoolYear;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	private int lessonId;
	private String courseId;
	private String tId;
	private String term;
	private String schoolYear;
	private String examTime;
	private String remark1;
	private String remark2;
	private String remark3;
	private String examWay;//���Է��������Ƿ���������ʦ�ֶ��������
	private int examStuNum;//�μӿ��Ե����������Ƿ���������ʦ�ֶ��������
	private int examOrigin;//����Դ�����Ƿ���������ʦ�ֶ��������
	private int entered;
	private String scoreType;//�������1Ϊ�ٷ��ƣ�0Ϊ�ȼ���
}
