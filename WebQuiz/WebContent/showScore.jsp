<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
	String score = (String)request.getSession().getAttribute("currScore");
%>

<title>My Score</title>
</head>
<body>

	<h1 style="color: #f30808; font-size: 100px;"> <%= score %> </h1>
	
	<h4>
		<a href="/WebQuizProject"> Go to main page </a>
	</h4>


</body>
</html>