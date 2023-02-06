<%@page import="com.softronic.model.Student"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.softronic.model.Master"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Resister Student</title>

</head>

<body>
	<center>

		<h1>Student Resistation From</h1>
		<form action="resisterstudents" method="post">
			<table>
				<tr>
					<!-- first row -->
					<td>First name</td>
					<!-- first coloum -->
					<td><input type="text" name="firstname" id="firstname"></td>

				</tr>
				<tr>
					<!-- secound row -->
					<td>Last Name</td>
					<!-- first colum -->
					<td><input type="text" name="lastname" id="lastname"></td>
				</tr>

				<tr>
					<!-- third row -->
					<td>email</td>
					<!-- third colum -->
					<td><input type="email" name="email" id="email"></td>
				</tr>

				<tr>
					<!-- fourt row -->
					<td>contact</td>
					<!-- third colum -->
					<td><input type="text" name="contact" id="contact"></td>
				</tr>


				</tr>
				<tr>
					<!-- fifth  row -->
					<td>address</td>
					<!-- third colum -->
					<td><textarea rows="2" cols="8" name="address" id="address"></textarea></td>
				</tr>

				<tr>
					<!-- fourt row -->
					<td>gender</td>
					<!-- third coloum -->
					<!--  if(student.getGender().equals("male"))%>-->

					<td>Male<input type="radio" name="gender" value="male"
						checked="checked"> Female<input type="radio" name="gender"
						value="female">
					</td>
				</tr>

				<tr>
					<td>State</td>
					<%
					ArrayList<Master> list = (ArrayList<Master>) request.getAttribute("statelist");
					%>

					<td><select name="stateid" id="state">
							<option value=0>select State</option>
							<%
							for (Master master : list) {
							%>
							<option value="<%=master.getId()%>"><%=master.getName()%></option>
							<%
							}
							%>
					</select></td>
				</tr>
				<tr>
					<td>cityid</td>
					<%
					ArrayList<Master> list1 = (ArrayList<Master>) request.getAttribute("citylist");
					%>

					<td><select name="cityid" id="city">
							<option value=0>select city</option>
							<%
							for (Master master : list) {
							%>
							<option value="<%=master.getId()%>"><%=master.getName()%></option>
							<%
							}
							%>
					</select></td>
				</tr>

				<tr>
					<!-- last row -->
					<td><select name="class" id="class">
							<option value="0">1 st</option>
							<option value="0">2 nd</option>
							<option value="0">3 rd</option>
							<option value="0">5 th</option>
							<option value="0">6 th</option>
							<option value="0">7 th</option>
							<option value="0">8 th</option>
							<option value="0">9 tt</option>
							<option value="0">10 th</option>
							<option value="0">1 st</option>

					</select></td>
				</tr>
				<tr>
					<td>section</td>
					<td><input type="radio" name="section" value="A"> A <input
						type="radio" name="section" value="B"> B <input
						type="radio" name="section" value="C"> C <input
						type="radio" name="section" value="D"> D</td>
				</tr>
				<tr>
					<td><input type="reset"></td>
					<td><input type="submit"
						onclick=" return validRegistrationForm() "></td>
				</tr>
			</table>
		</form>
	</center>
</body>
<script type="text/javascript">
	function validRegistrationForm() {
		let firstname = document.getElementById("firstname").value;
		let lastname = document.getElementById("lastname").value;
		let gender = document.getElementById("gender").value;
		let email_id = document.getElementById("email_id").value;
		let contact_no = document.getElementById("contact_no").value;
		let address = document.getElementById("address").value;
		let state = document.getElementById("state").value;
		let city = document.getElementById("city").value;
		if (firstname == '') {
			alert("firstname cannot be empty");
			return false;
		} else if (lastname == '') {
			alert("lastname is manadtory");
			return false;
		} else if (gender == '') {
			alert("gender is manadtory");
			return false;
		} else if (email_id == '') {
			alert("email_id is manadtory");
			return false;
		} else if (contact_no == '') {
			alert("contact_no is manadtory");
			return false;
		} else if (address == '') {
			alert("address is manadtory");
			return false;
		} else if (state == '') {
			alert("state is manadtory");
			return false;
		} else if (city == '') {
			alert("city is manadtory");
			return false;
		}

		else {
			return true;
		}
	}
</script>
</html>