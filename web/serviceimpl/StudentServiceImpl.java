package com.grade.web.serviceimpl;

import java.util.Random;

import com.grade.web.dao.StudentDAO;
import com.grade.web.daoimpl.StudentDAOImpl;
import com.grade.web.domain.StudentBean;
import com.grade.web.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	Random ran;

	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
		ran = new Random();
	}

	@Override
	public void createGrade(StudentBean param) {
		sum(param);
		createNum(param);
		dao.Information(param);
	}

	@Override
	public void sum(StudentBean param) {
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

	@Override
	public void createNum(StudentBean param) {
		String classNum = "";
		int num = 0;
		num = ran.nextInt(999);
		classNum = "2019-" + param.getSsn().substring(7, 8) + String.format("%03d", num);
		param.setClassNum(classNum);
	}

}
