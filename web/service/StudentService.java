package com.grade.web.service;

import com.grade.web.domain.GradeBean;
import com.grade.web.domain.StudentBean;

public interface StudentService {
	public void save(StudentBean param);
	public void createNum(StudentBean param);
	public StudentBean login(StudentBean param);
}
