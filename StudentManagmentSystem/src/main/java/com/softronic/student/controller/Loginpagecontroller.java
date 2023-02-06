package com.softronic.student.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.softronic.student.service.serviceimpl;
import com.softronic.student.service.implservice.StudentServiceimple;

public class Loginpagecontroller extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse responce, String Fetchstudent) throws ServletException, IOException {
	try {	
		//value come from user
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		//decare boolean value
		boolean isValid=false;
		//used httpservlet 
		HttpSession session=request.getSession();
		if(session.getAttribute("userid")!=null)
		{
			
		    String existing_userid=(String) session.getAttribute("userid");
		   if(existing_userid.equals(userid))
			   isValid=true;
		}
			if(!isValid)
		{
			StudentServiceimple serviceimple=new StudentServiceimple();
			isValid=serviceimple.validateUserCredentials(userid, password);
		}
		if(isValid)
		{
			session.setAttribute("userid",userid);
			RequestDispatcher rd=request.getRequestDispatcher("/Fetchstudent");
			rd.forward(request, responce);
		}
		else
		{
			responce.setContentType("text/html");
			PrintWriter out=responce.getWriter();
			out.append("<h1>Userid is invalid</h2>");
			RequestDispatcher rd=request.getRequestDispatcher("/pages.Loginpage.jsp");
			rd.include(request, responce);
			session.invalidate();
		}
	}
		catch (Exception e) {
			e.printStackTrace();
		}
		}
}
	