package com.softronic.student.dao.JDBCDAO;

import java.io.ObjectInputFilter.Status;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.softronic.helper.JDBCBaseDAO;
import com.softronic.model.Master;
import com.softronic.model.Student;
import com.softronic.student.dao.StudentDAO;

public class JDBCStudentDAO extends JDBCBaseDAO implements StudentDAO {
	int result;
 

	public JDBCStudentDAO(Connection connection)
	{
		this.connection=connection;
	}

	@Override
	public int saveStudent(Student student) {
	
  String sqlQuery = "INSERT INTO student(firstname,lastname,email,contact,"
		
		+ "address,gender,stateid,cityid) values(?,?,?,?,?,?,?,?)";

		try
		{
		  PreparedStatement ps=connection.prepareStatement(sqlQuery);
		  ps.setString(1,student.getFirstname());
		  ps.setString(2,student.getLastname());
		  ps.setString(3,student.getEmail());
		  ps.setString(4,student.getContact());
		  ps.setString(5, student.getAddress());
		  ps.setString(6, student.getGender());
		  ps.setInt(7, student.getStaeid());
		  ps.setInt(8, student.getCityid());
		  
		  
		  //ps.setString();
		  
		   result=ps.executeUpdate();
		   //System.out.println(result);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
    	}
 
	@Override
	public List<Student> getAllStudent() {
		// TODO Auto-generated method stub
		
		List<Student> list=new ArrayList<Student>();
		try
		 {
			 StringBuffer sqlQuery=new StringBuffer();
		     sqlQuery.append(" select id, firstname, lastname , ");
			 sqlQuery.append(" email,contact,address ,gender , stateid,cityid ");
			 sqlQuery.append("from student ");
						
			PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			Student student= new Student();
			student.setId(rs.getInt("id"));
			student.setFirstname(rs.getString("Firstname"));
			student.setLastname(rs.getString("lastname"));
			student.setEmail(rs.getString("email"));
			student.setContact(rs.getString("contact"));
			student.setAddress(rs.getString("address"));
			student.setGender(rs.getString("gender"));
			student.setStaeid(rs.getInt("stateid"));
			student.setCityid(rs.getInt("cityid"));
			list.add(student);
			} 
			}
		    catch(Exception e)
		 {
			  e.printStackTrace();
		 }
		
		  return list;
		}

	@Override
	public Student fetchStudentDetails(int id) {
		StringBuffer sqlQuery=new StringBuffer();
		 sqlQuery.append("select id, firstname, lastname ,");
		 sqlQuery.append("email,contact,address ,gender , stateid,cityid ");
		 sqlQuery.append("from student where id=?");
		 Student student=new Student();
		 
		 try
		 {
	PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
			 student.setId(rs.getInt("id"));
			 student.setFirstname(rs.getString("firstname"));
			 student.setLastname(rs.getString("lastname"));
			 student.setEmail(rs.getString("email"));
			 student.setContact(rs.getString("contact"));
			 student.setAddress(rs.getString("address"));
			 student.setGender(rs.getString("gender"));
			 student.setStaeid(rs.getInt("stateid"));
			 student.setCityid(rs.getInt("cityid"));
			 System.out.println(student.getId());
			}
		 }
		 catch(Exception e) {
			e.printStackTrace(); 
		 }
		return student;
	}

	@Override
	public int updateStudentDetails(Student student) {
		// TODO Auto-generated method stub
		
		int result=0;
		StringBuffer sqlQuery=new StringBuffer();
		 sqlQuery.append("update student set  firstname=?, lastname=? , ");
		 sqlQuery.append(" email=? ,contact=? ,address=?  ,gender=?  , stateid=? ,cityid=?  ");
		 sqlQuery.append("where id=?");
try
{
	PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
//	ps.setInt(9, student.getId());
	ps.setString(1,student.getFirstname());
	ps.setString(2, student.getLastname());
	ps.setString(3, student.getEmail());
	ps.setString(4, student.getContact());
	ps.setString(5, student.getAddress());
	ps.setString(6, student.getGender());
	
	ps.setInt(7, student.getStaeid());
	ps.setInt(8,student.getCityid());
	ps.setInt(9, student.getId());
	
	result=ps.executeUpdate();
}
catch(Exception e)
{
	e.printStackTrace();

}
return result;
	}
	
	@Override
	public int insertStudentCredential(String userid, String password) {
		int result=0;
		StringBuffer sqlQuery=new StringBuffer();
		sqlQuery.append(" insert into credential ");
		sqlQuery.append("(userid,password )") ;
		sqlQuery.append("values(?,?);");
		try
		{
		PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
		ps.setString(1, userid);
		ps.setString(2, password);
		result=ps.executeUpdate();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return result;
	}
	    @Override
	    public Student validate(String userid, String password) {
	
		Student student=new Student();
		StringBuffer sqlQuery=new StringBuffer();
		sqlQuery.append("SELECT user_id,pass_word ");
		sqlQuery.append("FROM student_credentials ");
		sqlQuery.append("WHERE user_id=? AND pass_word=? ");
		try {
			PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
			ps.setString(1, userid);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				student.setUserid(rs.getString("userid"));
				student.setPassword(rs.getString("pass_word"));
			}
		}
			catch(Exception e)
			{
				e.printStackTrace();
			}
			
		
		return student ;
	}
	@Override
	public List<Master> getstatelist() {
		List<Master> list=new ArrayList<Master>();
	StringBuffer sqlQuery=new StringBuffer();
	
	 sqlQuery.append("SELECT id,statename ");
	 sqlQuery.append(" FROM statelis; ");
	try {
		//Master master=new Master();
		PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
		    Master master=new Master();	
			master.setId(rs.getInt("id"));
			master.setName(rs.getString("name"));
			list.add(master);
			}
		}
	catch(Exception e) {
		 e.printStackTrace();
	}
		return list;
	}

	@Override
	public List<Master> getcitylist() {
		
		List<Master>list=new  ArrayList<Master>();
		StringBuffer sqlQuery=new StringBuffer();
		 sqlQuery.append("SELECT id,cityname ");
		 sqlQuery.append(" FROM citylist");
		try
		{
			Master master=new Master();
			PreparedStatement ps=connection.prepareStatement(sqlQuery.toString());
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				master.setId(rs.getInt("id"));
				master.setName(rs.getString("name"));
				list.add(master);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return list;
	}


	}