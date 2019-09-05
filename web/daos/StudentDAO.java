package com.grade.web.daos;

import com.grade.web.domain.StudentBean;

public interface StudentDAO {
	public void Information(StudentBean param);
	public StudentBean login(StudentBean param);
}
