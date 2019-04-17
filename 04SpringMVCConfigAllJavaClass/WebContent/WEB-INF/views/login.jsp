<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<form action="loginController" method="POST">
		<label>Username</label> <input type="text" name="name"> <br/> <br/>
		<label>Password</label> <input type="password" name="password"> <br/> <br/>
		<input type="submit" value="Login">
		</form>
	</fieldset>
	
</body>
</html>