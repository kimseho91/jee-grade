package com.grade.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.grade.web.pool.Constants;
import com.grade.web.domain.StudentBean;
import com.grade.web.service.StudentService;
import com.grade.web.serviceimpl.StudentServiceImpl;

@WebServlet("/student.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println(action);
		String dest = request.getParameter("dest");
		System.out.println(dest);
		switch (request.getParameter("action")) {
		case "move":
			request.getRequestDispatcher
			(String.format(
					Constants.VIEW_PATH,
					"student",
					request.getParameter("dest")))
					.forward(request, response);
			break;
		case "register":
			String name = request.getParameter("name");
			String ssn = request.getParameter("ssn");
			StudentBean param = new StudentBean();
			param.setName(name);
			param.setSsn(ssn);
//		StudentService service = new StudentServiceImpl();
//		service.createGrade(param);
			request.getRequestDispatcher
			(String.format(
					Constants.VIEW_PATH, 
					"student", 
					request.getParameter("dest")))
					.forward(request, response);
			break;
		case "login":
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
