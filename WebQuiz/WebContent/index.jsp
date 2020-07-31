<%@page import="Quiz.question"%>
<%@page import="Quiz.QuestionDao"%>
<%@page import="Account.accountDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Statement"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>

<head>

<title>WebQuiz</title>

<%
	ServletContext cont = getServletContext();
	DataBase.DateBaseManager d = (DataBase.DateBaseManager)cont.getAttribute("baseManager");
	Connection con = d.getConnection();
	
	accountDao acc = (accountDao)cont.getAttribute("manager");
	String username = (String)request.getSession().getAttribute("username");
	
	QuestionDao quest = (QuestionDao)cont.getAttribute("Question");
	ArrayList<question> arr = quest.getAllQuestion(con);
%>

</head>

<body>
	<h1>Quiz WebSite</h1>
	
	
	<%
	
	if(username!=null){
		%>
		
		
		<h1><%= username %></h1>
		
		
		
		<form action="/WebQuizProject/Login/Logout_Servlet" method="POST">

			<label> <input value="Logout" type="submit"></label>
			
		</form>
		
		<%
		
		for(int i=0; i<arr.size(); i++){
			%>
			
			<h1><%= arr.get(i).getTitle() %></h1>
			
			<%
		}
		
		
	} else{
		%>
		
		
		<form action="/WebQuizProject/Login/Login_Servlet" method="POST">
					
			<table>
			<tbody>
			<tr>
				<td>
					Username:
				</td>
				<td>
					<input id="username" type="text" name="username">
				</td>
			</tr>
					
			<tr>
				<td>
					Password:
				</td>
				<td>
					<input id="password" type="password" name="password">
				</td>
			</tr>
		
			</tbody>
			</table>
				
			<label> <input value="Login" type="submit"></label>
			
		</form>
		
		<div>
			<a href="/WebQuizProject/registration.jsp"> Registration </a>
		</div>
		
		
		<%
	}
	
	
	%>
	
	
</body>

</html>