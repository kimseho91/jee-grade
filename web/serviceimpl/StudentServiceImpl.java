package com.grade.web.serviceimpl;

import java.util.Random;

import com.grade.web.dao.StudentDAO;
import com.grade.web.daoimpl.StudentDAOImpl;
import com.grade.web.domain.StudentBean;
import com.grade.web.service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDAO dao;
	private StudentBean sb;
	Random ran;
	public StudentServiceImpl() {
		dao = new StudentDAOImpl();
		ran = new Random();
	}

	@Override
	public void reportCard(StudentBean param) {
		String classNum, average, totalScore = "";
		int kor,eng,math,society,sum,sum2,num=0;
		kor = Integer.parseInt(param.getKor());
		eng = Integer.parseInt(param.getEng());
		math = Integer.parseInt(param.getMath());
		society = Integer.parseInt(param.getSociety());
		sum = kor+eng+math+society;
		sum2 = sum/4;
		totalScore = String.valueOf(sum);
		average = String.valueOf(sum2);
		param.setTotatlScore(totalScore);
		param.setAverage(average);
		num = ran.nextInt(999);
		classNum = "2019-"+param.getSsn().substring(7,8)+String.format("%03d", num);
		param.setClassNum(classNum);
		dao.Information(param);
	}

}
