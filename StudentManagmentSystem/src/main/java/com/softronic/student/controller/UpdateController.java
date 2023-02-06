package com.softronic.student.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronic.model.Student;
import com.softronic.student.service.implservice.StudentServiceimple;

public class UpdateController extends HttpServlet {

		private static final long serialVersionUID = 1L;
         
		
protected void doPost(HttpServletRequest request, HttpServletResponse responce)
{
	try
	{
	    int id=Integer.parseInt( request.getParameter("id"));
		String firstname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		
		String email=request.getParameter("email");
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		int stateid=Integer.parseInt(request.getParameter("stateid")); 
		int cityid=Integer.parseInt(request.getParameter("cityid"));
	  
		if(id==0 || firstname==null ||  lastname==null || email==null || contact==null
				|| address==null || firstname.equals("") || lastname.equals("") || email.equals("")
				|| contact.equals("") || address.equals(""))
		{
			PrintWriter out=responce.getWriter();
			out.print("hellooo");
			responce.setContentType("text/html");
			RequestDispatcher rd=request.getRequestDispatcher("/Fetchstudent");
			rd.forward(request, responce);
			
		}
		else
		{
			Student student=new Student();
			student.setId(id);
			student.setFirstname(firstname);
	        student.setLastname(lastname);
			student.setEmail(email);
			student.setGender(gender);
			student.setContact(contact);
			student.setAddress(address);
			student.setStaeid(stateid);
			student.setCityid(cityid);
			
			StudentServiceimple studentservice=new StudentServiceimple();
			int result=studentservice.UpdateStudentDetailsService(student);
			//responce.setContentType("text/html");
			PrintWriter out=responce.getWriter();
			if(result==1)
			{
				out.println("<b>Student Data submit Sussefully</b>");	
				
				responce.setContentType("text/html");
				RequestDispatcher rd= request.getRequestDispatcher("/Fetchstudent");
				rd.include(request, responce);
			}
			else {
				RequestDispatcher rd= request.getRequestDispatcher("/Fetchstudent");
				rd.include(request, responce);
				 //msg
				out.println("<b>Student Data not updated Sussefully</b>");	
			}
			
			
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}
}
