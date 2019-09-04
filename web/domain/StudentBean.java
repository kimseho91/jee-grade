package com.grade.web.domain;

import java.io.Serializable;

public class StudentBean implements Serializable {
	private static final long serialVersionUID = 1L;
	private String name,ssn,classNum,totatlScore,average;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSsn() {
		return ssn;
	}
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}
	public String getClassNum() {
		return classNum;
	}
	public void setClassNum(String classNum) {
		this.classNum = classNum;
	}
	public String getTotatlScore() {
		return totatlScore;
	}
	public void setTotatlScore(String totatlScore) {
		this.totatlScore = totatlScore;
	}
	public String getAverage() {
		return average;
	}
	public void setAverage(String average) {
		this.average = average;
	}
	@Override
	public String toString() {
		return String.format("%s님의 학번은 %s이고 총점은 %d점이고 평균은 %d점입니다."
							, name,classNum,totatlScore,average);
	}
	
}
