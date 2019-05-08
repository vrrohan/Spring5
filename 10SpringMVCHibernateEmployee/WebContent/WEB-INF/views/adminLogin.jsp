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
	<div id="wrapper">

		<form name="login-form" class="login-form" action="emp/loginAdmin" method="post">

			<div class="header">
				<h1>Login Form</h1>
			</div>

			<div class="content">
				<input name="username" type="text" class="input username"
					placeholder="Username" />
				<div class="user-icon"></div>
				<input name="password" type="password" class="input password"
					placeholder="Password" />
				<div class="pass-icon"></div>
			</div>

			<div class="footer">
				<input type="submit" name="submit" value="Login" class="button" />
			</div>

		</form>

	</div>
	<div class="gradient"></div>

</body>
</html>