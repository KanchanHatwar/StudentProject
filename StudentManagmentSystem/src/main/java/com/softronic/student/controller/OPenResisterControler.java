package com.softronic.student.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.softronic.model.Master;

import com.softronic.student.service.implservice.StudentServiceimple;

public class OPenResisterControler extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		ArrayList<Master> list = new ArrayList<Master>();
		StudentServiceimple serviceimple = new StudentServiceimple();
		try {
			list = serviceimple.fetchsatelist();
			request.setAttribute("statelist", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ArrayList<Master> list1 = new ArrayList<Master>();
		ArrayList<Master> list2 = new ArrayList<Master>();
		// StudentServiceimple serviceimple2=new StudentServiceimple();
		try {
			// StudentServiceimple serviceimple1=new StudentServiceimple();
			list1 = serviceimple.fetchsatelist();
			list2 = serviceimple.fetchcitylist();
			request.setAttribute("citylist", list);
			RequestDispatcher rd = request.getRequestDispatcher("pages\\resisterstudents.jsp");
			rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
