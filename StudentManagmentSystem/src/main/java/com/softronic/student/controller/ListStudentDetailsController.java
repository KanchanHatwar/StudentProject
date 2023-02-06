package com.softronic.student.controller;

import java.util.ArrayList;

//import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronic.model.Student;
import com.softronic.student.service.implservice.StudentServiceimple;

public class ListStudentDetailsController extends HttpServlet {
  
		private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse responce)
	{
		ArrayList<Student> list=new ArrayList<>();
		StudentServiceimple studentservice=new 	StudentServiceimple();
		
		try {
		
			list=studentservice.getStudentListService();
			request.setAttribute("studentlist",list);
			RequestDispatcher rd = request.getRequestDispatcher("pages/studentlist.jsp");
			rd.include(request, responce);
		    }
		    catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}
