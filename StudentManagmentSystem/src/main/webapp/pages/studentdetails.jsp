<%@page import="java.util.ArrayList"%>
<%@page import="java.lang.Thread.State"%>
<%@page import="com.softronic.model.Master"%>
<%@page import="com.softronic.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<%
Student student = (Student) request.getAttribute("studentid");
%>


<body>



	<h1>Student Details</h1>

	<form action="updatestudent" method="post">
		<table>

			<td>id</td>
			<!-- first coloum -->
			<td><input type="text" name="id" id="id"
				value="<%=student.getId()%>" readonly="true"></td>
			<!--readonlt="True"  -->
			</tr>


			<tr>
				<!-- first row -->
				<
				<td>First name</td>
				<!-- first coloum -->
				<td><input type="text" name="firstname" id="firstname"
					value="<%=student.getFirstname()%>"></td>
				<!--readonlt="True"  -->
			</tr>
			<tr>
				<!-- secound row -->
				<td>Last Name</td>
				<!-- first colum -->
				<td><input type="text" name="lastname" id="lastname"
					value="<%=student.getLastname()%>"></td>
			</tr>

			<tr>
				<!-- third row -->
				<td>email</td>
				<!-- third colum -->
				<td><input type="email" name="email" id="email"
					value="<%=student.getEmail()%>"></td>
			</tr>

			<tr>
				<!-- fourt row -->
				<td>contact</td>
				<!-- third colum -->
				<td><input type="text" name="contact" id="contact"
					value="<%=student.getContact()%>"></td>
			</tr>


			</tr>
			<tr>
				<!-- fifth  row -->
				<td>address</td>
				<!-- third colum -->
				<td><textarea rows="2" cols="8" name="address" id="address"><%=student.getAddress()%></textarea></td>
			</tr>

			<tr>
				<!-- fourt row -->
				<td>gender</td>
				<!-- third coloum -->
				<td>Male<input type="radio" name="gender" value="male">
					Female<input type="radio" name="gender" value="female">
				</td>
			</tr>

			<tr>
				<td>State</td>
				<td><select name="stateid">
						<%
						ArrayList<Master> state = (ArrayList<Master>) request.getAttribute("statelist");
						%>
						<%
						for (Master master : state) {
						%>
						<%
						if (master.getId() == student.getStateid()) {
						%>
						<option value="<%=master.getId()%>" selected="selected"><%=master.getName()%></option>
						<%
						} else
						%>
						<%
						{
						%>
						<option value="<%=master.getId()%>"><%=master.getName()%></option>
						<%
						}
						%>
						<%
						}
						%>
				</select></td>
			</tr>
			<tr>
				<td>cityid</td>
				<td><select name="cityid">
						<%
						ArrayList<Master> city = (ArrayList<Master>) request.getAttribute("citylist");
						%>
						<%
						for (Master master : city) {
						%>
						<%
						if (master.getId() == student.getCityid()) {
						%>
						<option value="<%=master.getId()%>" selected="selected"><%=master.getName()%></option>
						<%
						} else
						%>
						<%
						{
						%>
						<option value="<%=master.getId()%>"><%=master.getName()%></option>
						<%
						}
						%>
						<%
						}
						%>

				</select></td>
			</tr>

			</td>
			<tr>
				<!--last row-->
				<td><input type="reset"></td>
				<td><input type="submit"></td>
			</tr>
		</table>
	</form>

</body>
</html>