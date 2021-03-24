package com.examples.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloWorldServlet extends HttpServlet {

	@Override
	public void init() throws ServletException {
		System.out.println("Servlet Initialized...");
	}
	
	// Generic version to handle all HTTP request
//	@Override
//	public void service(ServletRequest request, ServletResponse response) throws ServletException, IOException {
//		System.out.println("Request received...Service method called");
//		PrintWriter out = response.getWriter();
//		out.println("Hello World Service");
//	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Request received...GET method called");
		// processing logic
		// Can invoke java classes from here
				
		// Output generation
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<HTML>");
		out.println("<BODY>");
		out.println("<H2>GREETINGS FROM HELLO SERVLET</H2>");
		out.println("<a href=\"/hello-world-servlet\">Home</a>");
		out.println("</BODY>");
		out.println("</HTML>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("Request received...POST method called");
		PrintWriter out = resp.getWriter();
		out.println("Hello World POST");
	}
	
	
	@Override
	public void destroy() {
		System.out.println("Sevlet Destroyed...");
	}
	
	
}
