<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Spring Rest Api Call</h3>
	<hr>
	<a href="${pageContext.request.contextPath}/test/hello">Display
		Hello Page</a>
	<br />
	<br />
	<a href="${pageContext.request.contextPath}/student/all">Get All
		Students as JSON</a>
</body>
</html>