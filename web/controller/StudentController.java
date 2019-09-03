package com.grade.web.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.grade.web.domain.StudentBean;
import com.grade.web.service.StudentService;
import com.grade.web.serviceimpl.StudentServiceImpl;

@WebServlet("/grade.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String ssn = request.getParameter("ssn");
		String kor = request.getParameter("kor");
		String eng = request.getParameter("eng");
		String math = request.getParameter("math");
		String society = request.getParameter("society");
		StudentBean param = new StudentBean();
		param.setName(name);
		param.setKor(kor);
		param.setEng(eng);
		param.setMath(math);
		param.setSociety(society);
		param.setSsn(ssn);
		StudentService service = new StudentServiceImpl();
		service.createGrade(param);
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
