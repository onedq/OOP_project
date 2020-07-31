<%@page import="Quiz.question"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Quiz.QuestionDao"%>
<%@page import="Account.accountDao"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<%
	ServletContext cont = getServletContext();
	DataBase.DateBaseManager d = (DataBase.DateBaseManager)cont.getAttribute("baseManager");
	Connection con = d.getConnection();
	
	accountDao acc = (accountDao)cont.getAttribute("manager");
	String username = (String)request.getSession().getAttribute("username");
	
	QuestionDao quest = (QuestionDao)cont.getAttribute("Question");
	ArrayList<question> arr = quest.getAllQuestion(con);
	
	request.getSession().setAttribute("currQuiz", arr);
%>

<title>My Quiz</title>
</head>
<body>


	<form action="/WebQuizProject/Quiz/QuizServlet" method="POST">
		<%	
			/* int questID = 0;
			if(request.getParameter("question_id")!=null){
				questID = Integer.parseInt(request.getParameter("question_id"));
			}
				
			question q = arr.get(questID);	
			cont.setAttribute("currQuestion", q); */
			
			
			for(int i=0; i<arr.size(); i++){
				question q = arr.get(i);
				String ans = "answer" + i;
				%>
					
					<table>
						<tbody>
						
						<tr>
							<td>
								<h1><%= i+1 + ". " + q.getTitle() %></h1>
							</td>
						</tr>						
								
						<tr>
							<td>
								Your Answer:
							</td>
							<td>
								<input id="Answer" type="text" name="<%= ans %>">
							</td>
						</tr>
					
						</tbody>
					</table>
				<%
			}
			
			
		%>	
	
		
		
		<label> <input value="Finish Quiz" type="submit"></label>
		
	</form>

</body>
</html>