package com.softronic.student.controller;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronic.model.Student;
import com.softronic.student.service.implservice.StudentServiceimple;

public class SaveController extends HttpServlet{
private static final long serialVersionUID=1L;
int result;
public void doPost(HttpServletRequest request, HttpServletResponse responce)
{
	try
	{
		
		String fristname=request.getParameter("firstname");
		String lastname=request.getParameter("lastname");
		String email=request.getParameter("email");
		//contact address
		String contact=request.getParameter("contact");
		String address=request.getParameter("address");
		String gender=request.getParameter("gender");
		int stateid=Integer.parseInt(request.getParameter("stateid")); 
		int cityid=Integer.parseInt(request.getParameter("cityid"));
	    //student object set value
	   //Studentservice object   save
		Student student=new Student();
		
		student.setFirstname(fristname);
		student.setLastname(lastname);
		student.setEmail(email);
		student.setContact(contact);
		student.setAddress(address);
		student.setGender(gender);
		student.setStaeid(stateid);
		student.setCityid(cityid);
		
		StudentServiceimple studentserviceimp = new StudentServiceimple();

		result=studentserviceimp.saveStudentService(student);
		PrintWriter out=responce.getWriter();
		if(result==1)
		{
			//out.println("<b>Student Data submit Sussefully</b>");	
			
			responce.setContentType("text/html");
			RequestDispatcher rd= request.getRequestDispatcher("/Fetchstudent");
			rd.forward(request,responce);
		}
		else
		{
			out.println("Error:");
		}
	    }
	      catch(Exception e)
	     {
		e.printStackTrace();
	   }

}
}
