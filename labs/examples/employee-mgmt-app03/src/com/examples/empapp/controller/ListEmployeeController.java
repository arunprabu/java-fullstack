package com.examples.empapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.examples.empapp.model.Employee;
import com.examples.empapp.service.EmployeeService;

@WebServlet("/listEmployees.do")
public class ListEmployeeController extends HttpServlet {

		EmployeeService empService = new EmployeeService();
		
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			this.doPost(req, resp);
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			List<Employee> employees = empService.getAll();
			
			req.setAttribute("empList", employees);
			
			RequestDispatcher rd = req.getRequestDispatcher("listEmployees.jsp");
			rd.forward(req, resp);
		}
}
