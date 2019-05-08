<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<style>
.errors {
	color: red;
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<fieldset>
		<legend>Update Employee</legend>
		<!--  modelattribute same name as in employee controller in updateEmployeeForm() -->
		<form:form action="updateEmployee" method="POST"
			modelAttribute="employee" class="pure-form pure-form-aligned">
			<table>
				<form:hidden path="employeeId" />
				<tr>
					<td><form:label path="firstname">Firstname</form:label></td>
					<td><form:input type="text" path="firstname" /></td>
					<td><form:errors path="firstname" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="lastname">Lastname</form:label></td>
					<td><form:input path="lastname" /></td>
					<td><form:errors path="lastname" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input type="email" path="email" /></td>
					<td><form:errors path="email" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td><form:label path="designation">Designation</form:label></td>
					<td><form:input path="designation" /></td>
					<td><form:errors path="designation" cssClass="errors"></form:errors></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form:form>
	</fieldset>
</body>
</html>