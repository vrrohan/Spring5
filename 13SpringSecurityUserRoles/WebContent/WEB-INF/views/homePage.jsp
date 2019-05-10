<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<style>
.form-style-6 {
	font: 95% Arial, Helvetica, sans-serif;
	max-width: 400px;
	margin: 10px auto;
	padding: 16px;
	background: #F7F7F7;
}

.form-style-6 h1 {
	background: #43D1AF;
	padding: 20px 0;
	font-size: 140%;
	font-weight: 300;
	text-align: center;
	color: #fff;
	margin: -16px -16px 16px -16px;
}

.form-style-6 input[type="text"], .form-style-6 input[type="date"],
	.form-style-6 input[type="datetime"], .form-style-6 input[type="email"],
	.form-style-6 input[type="number"], .form-style-6 input[type="search"],
	.form-style-6 input[type="time"], .form-style-6 input[type="url"],
	.form-style-6 textarea, .form-style-6 select {
	-webkit-transition: all 0.30s ease-in-out;
	-moz-transition: all 0.30s ease-in-out;
	-ms-transition: all 0.30s ease-in-out;
	-o-transition: all 0.30s ease-in-out;
	outline: none;
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	width: 100%;
	background: #fff;
	margin-bottom: 4%;
	border: 1px solid #ccc;
	padding: 3%;
	color: #555;
	font: 95% Arial, Helvetica, sans-serif;
}

.form-style-6 input[type="text"]:focus, .form-style-6 input[type="date"]:focus,
	.form-style-6 input[type="datetime"]:focus, .form-style-6 input[type="email"]:focus,
	.form-style-6 input[type="number"]:focus, .form-style-6 input[type="search"]:focus,
	.form-style-6 input[type="time"]:focus, .form-style-6 input[type="url"]:focus,
	.form-style-6 textarea:focus, .form-style-6 select:focus {
	box-shadow: 0 0 5px #43D1AF;
	padding: 3%;
	border: 1px solid #43D1AF;
}

.form-style-6 input[type="submit"], .form-style-6 input[type="button"] {
	box-sizing: border-box;
	-webkit-box-sizing: border-box;
	-moz-box-sizing: border-box;
	width: 100%;
	padding: 3%;
	background: #43D1AF;
	border-bottom: 2px solid #30C29E;
	border-top-style: none;
	border-right-style: none;
	border-left-style: none;
	color: #fff;
}

.form-style-6 input[type="submit"]:hover, .form-style-6 input[type="button"]:hover
	{
	background: #2EBC99;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<h3>
		User :
		<security:authentication property="principal.username" />
	</h3>
	<h3>
		User Roles :
		<security:authentication property="principal.authorities" />
	</h3>

	<div class="form-style-6">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input name="firstname" placeholder="Your Firstname" type="text" />
			<br />
			<br />

			<input name="lastname" placeholder="Your Lastname" type="text" />
			<br />
			<br />

			<input name="email" placeholder="Your Email" type="email" />
			<br />
			<br />

			<input type="submit" value="Logout" />
			<br />
			<br />

		</form:form>
	</div>

	<br />
	<br />

	<!-- Only show this section link if user role is manager -->
	<security:authorize access="hasRole('MANAGER')">
		<!-- Add link to for managers -->
		<a href="${pageContext.request.contextPath}/manager">Managers
			Notice</a>
		<br />
		<br />
	</security:authorize>

	<!-- Only show this section link if user role is admin -->
	<security:authorize access="hasRole('ADMIN')">
		<!-- Add link to for Admins -->
		<a href="${pageContext.request.contextPath}/admin">Admin Notice</a>
	</security:authorize>
</body>

</html>