<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page session="false"%>
<!DOCTYPE html>
<html>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/listEmpTable.css" />
<head>
<meta charset="ISO-8859-1">
<title>Employee</title>
</head>
<body>

	<%
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect(request.getServletContext().getContextPath());
		} else {
	%>
	<h2>
		Admin :
		<%=session.getAttribute("username")%>
	</h2>
	<p>
		Session Id :
		<%=session.getId()%></p>
	<table>
		<tr>
			<th>Employee ID</th>
			<th>Firstname</th>
			<th>Lastname</th>
			<th>Email</th>
			<th>Designation</th>
			<th>Modify Employee Data</th>
		</tr>
		<c:forEach var="employee" items="${employees}">
			<!-- Construct update link for each employee with their IDs -->
			<c:url var="updateLink" value="/emp/updateEmployeeForm">
				<c:param name="employeeId" value="${employee.employeeId}"></c:param>
			</c:url>

			<!-- Construct delete link for each employee with their IDs -->
			<c:url var="deleteLink" value="/emp/deleteEmployee">
				<c:param name="employeeId" value="${employee.employeeId}"></c:param>
			</c:url>

			<tr>
				<td>${employee.employeeId}</td>
				<td>${employee.firstname}</td>
				<td>${employee.lastname}</td>
				<td>${employee.email}</td>
				<td>${employee.designation}</td>
				<td><a href="${updateLink}">Update</a> or <a
					href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this Employee ?'))) return false">Delete</a></td>
			</tr>
		</c:forEach>
	</table>
	<br />
	<br />
	<input type="button" value="Add Customer"
		onclick="window.location.href='addEmployeeForm'; return false;"
		class="add-employee-button pure-button">
	<input type="button" value="Logout"
		onclick="window.location.href='logoutAdmin'; return false;"
		class="add-employee-button pure-button">
	<%
		}
	%>
</body>
</html>