package com.grade.web.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.grade.web.pool.Constants;
import com.grade.web.daoimpls.StudentDAOImpl;
import com.grade.web.daos.StudentDAO;
import com.grade.web.domain.StudentBean;
import com.grade.web.service.StudentService;
import com.grade.web.serviceimpl.StudentServiceImpl;

@WebServlet("/student.do")
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		StudentService service = new StudentServiceImpl();
		StudentBean param = new StudentBean();
		StudentDAO dao = new StudentDAOImpl();
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
			param.setName(name);
			param.setSsn(ssn);
			service.save(param);
			request.getRequestDispatcher
			(String.format(
					Constants.VIEW_PATH, 
					"student", 
					request.getParameter("dest")))
					.forward(request, response);
			break;
		case "login":
			name = request.getParameter("name");
			ssn = request.getParameter("ssn");
			if (name.equals(service.login(param).getName())&&ssn.equals(service.login(param).getSsn())) {
				request.setAttribute("customer",param);
				request.getRequestDispatcher(
						String.format(Constants.VIEW_PATH, "customer", request.getParameter("dest")))
						.forward(request, response);
			} else {
				request.setAttribute("customer",param);
				request.getRequestDispatcher(
						String.format(Constants.VIEW_PATH, "customer","login"))
						.forward(request, response);
			}
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
