<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<head>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/admin_login.css" />
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="emp/loginAdmin" method="POST">
		<div class="login">
			<input type="text" placeholder="Username" id="username"
				name="username"> <input type="password"
				placeholder="Password" id="password" name="password"> <input
				type="submit" value="Sign In">
		</div>
		<div class="shadow"></div>
	</form>
</body>
</html>