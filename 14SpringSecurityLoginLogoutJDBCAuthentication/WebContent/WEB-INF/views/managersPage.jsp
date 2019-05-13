<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<style>
<!--
Simple Responsive Landing Page --> <link href ="https: //fonts.googleapis.com
	/css?family=Coiny" rel ="stylesheet ">body {
	padding: 0;
	margin: 0;
	font-family: 'Coiny', cursive;
	box-sizing: box-shadow;
}

.wrapper {
	padding: 0;
	margin: 0;
}

.header {
	height: 100vh;
	width: 100%;
	background: #cccccc;
	position: relative;
}

.intro {
	position: absolute;
	left: 50%;
	top: 50%;
	transform: translate(-50%, -50%);
}

.intro h2 {
	margin: 0;
	font-size: 5em;
	line-height: 1.2em;
}

.intro button {
	border-radius: 0;
	background: #000;
	bordeR: none;
	letter-spacing: 5px;
	margin-top: 20px;
	padding: 15px;
	line-height: 1.2em;
}

@media only screen and (max-width: 900px) {
	.intro h2 {
		font-size: 3em;
	}
	.intro button {
		letter-spacing: 3px;
	}
}

.body-section {
	width: 100%;
	background: #eee;
	height: 100vh;
}

.body-content {
	padding: 50px;
	text-align: center;
}

.body-content .holder {
	width: 20%;
	background: #fff;
	display: inline-block;
	margin: 0 20px;
	height: auto;
}

.body-content .holder p {
	padding: 5px 10px;
	line-height: 20px;
	text-align: left;
}

.body-content a {
	width: 100%;
	background: #e74c3c;
	display: block;
	padding: 10px;
	text-decoration: none;
	color: #fff;
	transition: all 0.5s ease-in-out;
}

.body-content a:hover {
	background: #1abc9c;
}
}
</style>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<div class="wrapper">
		<div class="header">
			<div class="intro">
				<h2>Welcome To Agreement Page</h2>
				<a href="${pageContext.request.contextPath}/">Get Back</a>
			</div>
			<!-- Ends Intro -->
		</div>
		<!-- Ends Header -->
	</div>
	<!-- Ends Wrapper -->



</body>
</html>