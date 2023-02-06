package com.softronic.student.dao;

import java.util.List;

import com.softronic.model.Master;
import com.softronic.model.Student;

public interface StudentDAO {
	public int saveStudent(Student student) ;
	public List<Student> getAllStudent() ;
	public Student fetchStudentDetails(int id);
	public int updateStudentDetails(Student student) ;
	int insertStudentCredential(String userid, String password);
	public Student validate(String userid,String password);
	public List<Master> getstatelist();
	public List<Master> getcitylist();

	//List<Student> fetchAllStudentDetails(String rollnumber);
}
