package com.GradeManager.app.bean;

public class Revocation {
private int revocationId;
private String revocationReason;
private int revocationType;
private String removeLessonId;
public int getRevocationId() {
	return revocationId;
}
public void setRevocationId(int revocationId) {
	this.revocationId = revocationId;
}
public String getRevocationReason() {
	return revocationReason;
}
public void setRevocationReason(String revocationReason) {
	this.revocationReason = revocationReason;
}
public int getRevocationType() {
	return revocationType;
}
public void setRevocationType(int revocationType) {
	this.revocationType = revocationType;
}
public String getRemoveLessonId() {
	return removeLessonId;
}
public void setRemoveLessonId(String removeLessonId) {
	this.removeLessonId = removeLessonId;
}

}
