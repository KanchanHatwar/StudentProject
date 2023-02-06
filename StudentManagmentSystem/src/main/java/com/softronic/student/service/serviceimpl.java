package com.softronic.student.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.softronic.model.Master;
import com.softronic.model.Student;

public interface serviceimpl {
	int saveStudentService(Student student) throws SQLException;

	ArrayList<Student> getStudentListService() throws SQLException;

	Student getStudentDetailsByIDService(int id) throws SQLException;

	int UpdateStudentDetailsService(Student student) throws SQLException;

	public boolean validateUserCredentials(String userid, String pass) throws SQLException;

	ArrayList<Master> fetchsatelist() throws SQLException;

	ArrayList<Master> fetchcitylist();

}
