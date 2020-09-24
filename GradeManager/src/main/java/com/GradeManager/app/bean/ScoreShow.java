package com.GradeManager. app.bean;

public class ScoreShow {

	private int lessonId;
	private String courseName;
	private double usualScore;
	private String score;
	private double judgeCcore;
	private double supplementScore;
	private double clearScore;
	private double normalScore;
    private double usualProportion;
    
	public double getUsualScore() {
		return usualScore;
	}
	public void setUsualScore(double usualScore) {
		this.usualScore = usualScore;
	}
	public double getSupplementScore() {
		return supplementScore;
	}
	public void setSupplementScore(double supplementScore) {
		this.supplementScore = supplementScore;
	}
	public double getClearScore() {
		return clearScore;
	}
	public void setClearScore(double clearScore) {
		this.clearScore = clearScore;
	}
	public double getUsualProportion() {
		return usualProportion;
	}
	public void setUsualProportion(double usualProportion) {
		this.usualProportion = usualProportion;
	}
	
	
	public int getLessonId() {
		return lessonId;
	}
	public void setLessonId(int lessonId) {
		this.lessonId = lessonId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public double getNormalScore() {
		return normalScore;
	}
	public void setNormalScore(double normalScore) {
		this.normalScore = normalScore;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public double getJudgeCcore() {
		return judgeCcore;
	}
	public void setJudgeCcore(double judgeCcore) {
		this.judgeCcore = judgeCcore;
	}
}
