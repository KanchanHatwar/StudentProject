<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login From</title>
</head>
<body>
	<form action="login" method="post">
		<table>
			<table>
		<tr>
		<td>Userid</td>
		<td><input type="text" id="userid" name="userid"/></td>
		</tr>
		<tr>
		<td>Password</td>
		<td><input type="password" id="password" name="password"/></td>
		</tr>
		<tr>
				<td><a href="opencotroller">new registration</a></td>
				<td><input type="submit" value="login"></td>
			</tr>
		</table>
	</form>
</body>
</html>