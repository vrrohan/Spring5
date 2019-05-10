<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
</head>
<body>

	<div class="form-style-6">
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST">
			<input name="firstname" placeholder="Your Firstname" />
			<br />
			<br />

			<input name="firstname" placeholder="Your Firstname" />
			<br />
			<br />

			<input name="firstname" placeholder="Your Firstname" />
			<br />
			<br />

			<input type="submit" value="Logout" />
			<br />
			<br />

		</form:form>
	</div>

	<br />
	<br />


</body>

		</html>