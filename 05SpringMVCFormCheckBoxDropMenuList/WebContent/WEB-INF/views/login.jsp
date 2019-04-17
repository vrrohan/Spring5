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
		<legend>Reservation Details Form</legend>
		<form:form method="POST" action="submitForm" modelAttribute="person">
			<table>
				<tr>
					<td><form:label path="firstname">Firstname</form:label></td>
					<td><form:input path="firstname" /></td>
				</tr>
				<tr>
					<td><form:label path="lastname">Lastname</form:label></td>
					<td><form:input path="lastname" /></td>
				</tr>
				<tr>
					<td><form:label path="email">Email</form:label></td>
					<td><form:input type="email" path="email" /></td>
				</tr>
				<tr>
					<td><form:label path="gender">Gender</form:label><br />
					<td>Male <form:radiobutton path="gender" value="M" />
					</td>
					<td>Female <form:radiobutton path="gender" value="F" />
					</td>
				</tr>
				<tr>
					<td><form:label path="mealType">Meal Type</form:label><br />
					<td>Veg <form:radiobutton path="mealType" value="Veg" />
					</td>
					<td>Non-Veg <form:radiobutton path="mealType" value="Non-Veg" />
					</td>
				</tr>
				<tr>
					<td><form:label path="meals">Meals</form:label></td>
					<td>Breakfast<form:checkbox path="meals" value="Breakfast" /></td>
					<td>Lunch<form:checkbox path="meals" value="Lunch" /></td>
					<td>TeaSnacks<form:checkbox path="meals" value="Tea&Snacks" /></td>
					<td>Dinner<form:checkbox path="meals" value="Dinner" /></td>
				</tr>
				<tr>
					<td>Source City</td>
					<td><form:select path="fromCity">
							<form:option value="Bangalore" label="Bangalore" />
							<form:option value="Pune" label="Pune" />
							<form:option value="Delhi" label="Delhi" />
							<form:option value="Amristar" label="Amristar" />
						</form:select></td>
				</tr>
				<tr>
					<td>Destination City</td>
					<td><form:select path="toCity">
						<form:option value="Bangalore" label="Bangalore" />
						<form:option value="Pune" label="Pune" />
						<form:option value="Delhi" label="Delhi" />
						<form:option value="Amristar" label="Amristar" />
					</form:select></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit"/></td>
				</tr>
			</table>
		</form:form>
	</fieldset>


</body>
</html>