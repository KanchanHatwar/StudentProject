package com.softronic.student.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronic.model.Student;
import com.softronic.student.service.serviceimpl;
import com.softronic.student.service.implservice.StudentServiceimple;

public class StudentDetailsController extends HttpServlet {
 
	
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse responce)
	{
		try
		{
			String studentid=request.getParameter("id");
			int id=Integer.parseInt(studentid);
			
			
			Student student=new Student();
			StudentServiceimple studentservice=new StudentServiceimple();
			student=studentservice.getStudentDetailsByIDService(id);
			request.setAttribute("studentid",student);
			RequestDispatcher rd=request.getRequestDispatcher("/pages/studentdetails.jsp");
		    rd.include(request, responce);		
		    }
		    catch(Exception e)
		    {
			e.printStackTrace();
		    
		    }
		
	} 
	
}
