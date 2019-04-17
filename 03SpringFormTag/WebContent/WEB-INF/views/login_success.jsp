<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
	<h3>Person Details</h3>
	<table>
		<tr>
			<td>Name</td>
			<td>Age</td>
			<td>Country</td>
			<td>Email</td>
			<td>Date of Birth</td>
			<td>Password</td>
			<td>Gender</td>
		</tr>
		<tr>
			<td>${person.name}</td>
			<td>${person.age}</td>
			<td>${person.country}</td>
			<td>${person.email}</td>
			<td>${person.dateOfBirth}</td>
			<td>${person.password}</td>
			<td>${person.gender}</td>
		</tr>
	</table>
	<a href="login">Logout</a>
</body>
</html>