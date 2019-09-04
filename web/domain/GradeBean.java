package com.grade.web.domain;

import java.io.Serializable;

public class GradeBean implements Serializable{
	private static final long serialVersionUID = 1L;
	private String kor, eng, math, society,totatlScore,average;
	
	public String getKor() {
		return kor;
	}



	public void setKor(String kor) {
		this.kor = kor;
	}



	public String getEng() {
		return eng;
	}



	public void setEng(String eng) {
		this.eng = eng;
	}



	public String getMath() {
		return math;
	}



	public void setMath(String math) {
		this.math = math;
	}



	public String getSociety() {
		return society;
	}



	public void setSociety(String society) {
		this.society = society;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
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
		return "GradeBean [kor=" + kor + ", eng=" + eng + ", math=" + math + ", society=" + society + ", totatlScore="
				+ totatlScore + ", average=" + average + "]";
	}
	
	
}
