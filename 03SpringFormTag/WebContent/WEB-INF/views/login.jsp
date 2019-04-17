<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Personal Details Form</legend>
		<form:form method="POST" action="submitForm" modelAttribute="person">
			<table>
				<tr>
					<td><form:label path="name">Name</form:label></td>
					<td><form:input path="name" name="name" width="60px"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="age">Age</form:label></td>
					<td><form:input path="age" name="age"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="country">Country</form:label></td>
					<td><form:input path="country" name="country"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input type="email" path="email" name="email"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="dateOfBirth">Date of Birth</form:label></td>
					<td><form:input type="date" path="dateOfBirth" name="date"></form:input></td>
				</tr>
				<tr>
					<td><form:label path="password">Password</form:label></td>
					<td><form:password path="password" name="pass"></form:password></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label>
					<td>Male <form:radiobutton path="gender" value="M"/> </td>
					<td>Female <form:radiobutton path="gender" value="F"/> </td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</fieldset>


</body>
</html>