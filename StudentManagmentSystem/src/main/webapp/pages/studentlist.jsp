<%@page import="com.softronic.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("studentlist");
%>




<body>
	<form action="fetchstudentdetails" method="post">
		Roll Number:<input type="number" name="roll_number" id="roll_number">
		<input type="submit" value="view">
	</form>
	<h>List Of Students</h>
	<table border=1px>
		<thead>
			<tr>
				<th>id</th>
				<th>firstname</th>
				<th>lastname</th>
				<th>email</th>
				<th>contact</th>
				<th>address</th>
				<th>gender</th>
				<th>stateid</th>
				<th>cityid</th>
				<th>Edit</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (Student student : list) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getFirstname()%></td>
				<td><%=student.getLastname()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getContact()%></td>
				<td><%=student.getAddress()%></td>
				<td><%=student.getGender()%></td>
				<td><%=student.getStaeid()%></td>
				<td><%=student.getCityid()%></td>
				<td><a
					href="fetch_single_studentdetails?id=<%=student.getId()%>">edit</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
</body>
</html>