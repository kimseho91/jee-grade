package com.grade.web.serviceimpl;

import java.util.Random;

import com.grade.web.daoimpls.StudentDAOImpl;
import com.grade.web.daos.StudentDAO;
import com.grade.web.domain.GradeBean;
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
	public void createHakbun(StudentBean param) {
		createNum(param);
		dao.Information(param);
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
