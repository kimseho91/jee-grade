package com.grade.web.serviceimpl;

import com.grade.web.daoimpls.GradeDAOImpl;
import com.grade.web.daos.GradeDAO;
import com.grade.web.domain.GradeBean;
import com.grade.web.service.GradeService;

public class GradeServiceImpl implements GradeService{
	private GradeBean grade;
	private GradeDAO dao;
	
	public GradeServiceImpl() {
		grade = new GradeBean();
		dao = new GradeDAOImpl();
	}
	

	@Override
	public void createSum(GradeBean param) {
		sum(param);
		dao.createGrades(param);
	}
	
	@Override
	public void sum(GradeBean param) {
		String average, totalScore = "";
		int kor, eng, math, society, total, avg = 0;
		kor = Integer.parseInt(param.getKor());
		eng = Integer.parseInt(param.getEng());
		math = Integer.parseInt(param.getMath());
		society = Integer.parseInt(param.getSociety());
		total = kor+eng+math+society;
		avg = total/4;
		totalScore = String.valueOf(total);
		average = String.valueOf(avg);
		param.setTotatlScore(totalScore);
		param.setAverage(average);
	}


}
