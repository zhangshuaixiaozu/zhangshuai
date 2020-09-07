package com.GradeManager.app.bean;

public class score {
	private int scoreId;
	private int lessonId;
	private int normalScore;
	private int supplementScore;
	private int clearScore;
	private String studentId;
	public int getScoreId() {
		return scoreId;
	}
	public void setScoreId(int scoreId) {
		this.scoreId = scoreId;
	}
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public int getNormalScore() {
		return normalScore;
	}
	public void setNormalScore(int normalScore) {
		this.normalScore = normalScore;
	}
	public int getSupplementScore() {
		return supplementScore;
	}
	public void setSupplementScore(int supplementScore) {
		this.supplementScore = supplementScore;
	}
	public int getClearScore() {
		return clearScore;
	}
	public void setClearScore(int clearScore) {
		this.clearScore = clearScore;
	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

}
