<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Spring Employee CRM Rest</h3>
	<hr>
	<a href="${pageContext.request.contextPath}/emp/all">Get All
		Employees JSON</a>
	<br>
	<br>
	<a href="${pageContext.request.contextPath}/emp/empBy/{employeeId}">Get
		Employee By Id JSON</a>
</body>
</html>