<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<style>
table, td, th {
	border: 1px solid #ddd;
	text-align: left;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 15px;
}
</style>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Person Reservation Details</h3>
	<table>
		<tr>
			<td>FirstName</td>
			<td>LastName</td>
			<td>Email</td>
			<td>Gender</td>
			<td>Meal Type</td>
			<td>Meals</td>
			<td>Reservation From</td>
			<td>Reservation Upto</td>
		</tr>
		<tr>
			<td>${person.firstname}</td>
			<td>${person.lastname}</td>
			<td>${person.email}</td>
			<td>${person.gender}</td>
			<td>${person.mealType}</td>
			<td><c:forEach var="meals" items="${person.meals}">
					<li>${meals}</li>
				</c:forEach></td>
			<td>${person.fromCity}</td>
			<td>${person.toCity}</td>
		</tr>
	</table>
	<a href="login">Logout</a>
</body>
</html>