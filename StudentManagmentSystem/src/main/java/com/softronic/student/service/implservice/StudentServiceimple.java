package com.softronic.student.service.implservice;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import com.softronic.connection.ConnectionProvider;
import com.softronic.model.Master;
import com.softronic.model.Student;
import com.softronic.student.controller.ListStudentDetailsController;
import com.softronic.student.dao.StudentDAO;
import com.softronic.student.dao.JDBCDAO.JDBCStudentDAO;
import com.softronic.student.service.serviceimpl;

public class StudentServiceimple implements serviceimpl
{
	int result;
	@Override
	public int saveStudentService(Student student) throws SQLException {
		Connection connection=null;
		try
		{
			connection=ConnectionProvider.getConnection();
			JDBCStudentDAO studentDAo=new JDBCStudentDAO(connection);
			result=studentDAo.saveStudent(student);
			//result=studentDAo.insert
			//printwriter implisiit,request responce session 
			//session if i exeuute request :-it is conection between host and client
			//HttpSessions session=request.getsession(true);
			//method:session.setAtribute 2)session.getAttribute 3)session.removeatributr
	        //not thredsafe
			//login controller , jsp login page , table creansial 
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return result;
	}

	@Override
	public ArrayList<Student> getStudentListService() throws SQLException {
		Connection connection=null;

		ArrayList<Student> studentlist=new ArrayList<Student>();
		try
		{
			
			connection=ConnectionProvider.getConnection();
			JDBCStudentDAO	studentDao=new JDBCStudentDAO(connection);
			studentlist=(ArrayList<Student>) studentDao.getAllStudent();

			
			
			//for(Student student:studentlist)
//			{
//				System.out.println(student.toString());
//			}
			
		}
		
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			connection.close();
		}
		return studentlist;
		
	
	}

	@Override
	public Student getStudentDetailsByIDService(int id) throws SQLException {
		
		Connection connection=null;
		Student student=new Student();
		try {
			connection=ConnectionProvider.getConnection();
			StudentDAO studentDao=new JDBCStudentDAO(connection);
			student=studentDao.fetchStudentDetails(id);
		 System.out.println(student.getId());
			}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally {
			connection.close();
		}
		return student;
	}

	@Override
	public int UpdateStudentDetailsService(Student student) throws SQLException {
		
		Connection connection =null;
		try
		{
			connection=ConnectionProvider.getConnection();
			StudentDAO studentDao =new JDBCStudentDAO(connection);
			result=studentDao.updateStudentDetails(student);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally 
		{
			connection.close();
		}
		return result;

	
	}
@Override
	public boolean validateUserCredentials(String userid, String pass) throws SQLException {
        Connection connection=null;
		boolean result=false;
		Student student=new Student();
		try
		{
			connection=ConnectionProvider.getConnection();
			StudentDAO studentDAO=new JDBCStudentDAO(connection);
			student=studentDAO.validate(userid, pass);
			
if(userid.equals(student.getUserid()) && pass.equals(student.getPassword()))
   {
	return true;
   }
		}
finally {
			connection=null;
        }
		return result;
        }

@Override
public ArrayList<Master> fetchsatelist() throws SQLException {
	 Connection connection=null;
	
	ArrayList<Master>statelist=new ArrayList<Master>();
	  try
	  {
		  connection=ConnectionProvider.getConnection();
			StudentDAO studentDao=new JDBCStudentDAO(connection);
			studentDao.getstatelist();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	  finally
	  {
		  connection.close();
	  }
	
	return statelist;
}

@Override
public ArrayList<Master> fetchcitylist() {

	 Connection connection=null;
	 ArrayList<Master>citylist=new ArrayList<Master>();
	  try
	  {
		  connection=ConnectionProvider.getConnection();
			StudentDAO studentDao=new JDBCStudentDAO(connection);
			citylist=(ArrayList<Master>) studentDao.getcitylist();
	  }
	  catch(Exception e)
	  {
		  e.printStackTrace();
	  }
	return citylist;
}

}
	



		