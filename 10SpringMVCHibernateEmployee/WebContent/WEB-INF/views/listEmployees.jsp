<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/listEmpTable.css" />
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th>Designation</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.firstname}</td>
				<td>${employee.lastname}</td>
				<td>${employee.email}</td>
				<td>${employee.designation}</td>
			</tr>
		</c:forEach>
	</table>
	
	<input type="button" value="Add Customer" onclick="window.location.href='addEmployee'; return false;" class="add-employee-button pure-button">
</body>
</html>