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
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/updateEmployeeForm.css" />
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="form-style-6">
		<form:form action="updateEmployee" method="POST"
			modelAttribute="employee">
			<form:label path="firstname" type="text"></form:label>
			<form:input path="firstname" placeholder="Your Firstname"></form:input>
			<form:errors path="firstname" cssClass="errors"></form:errors>
			<br />
			<br />

			<form:label path="lastname" type="text"></form:label>
			<form:input path="lastname" placeholder="Your Lastname"></form:input>
			<form:errors path="lastname" cssClass="errors"></form:errors>
			<br />
			<br />

			<form:label path="email" type="text"></form:label>
			<form:input path="email" placeholder="Your Email-id"></form:input>
			<form:errors path="email" cssClass="errors"></form:errors>
			<br />
			<br />

			<form:label path="designation" type="text"></form:label>
			<form:input path="designation" placeholder="Your Designation"></form:input>
			<form:errors path="designation" cssClass="errors"></form:errors>
			<br />
			<br />

			<input type="submit" value="Update Employee" />
			<br />
			<br />
			<a href="${pageContext.request.contextPath}/emp/list">Back</a>
		</form:form>
	</div>

</body>
</html>