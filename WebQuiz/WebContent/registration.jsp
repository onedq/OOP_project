<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

		<form action="/WebQuizProject/Login/Reg_Servlet" method="POST">
					
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
				
				<tr>
					<td>
						First Name:
					</td>
					<td>
						<input id="first_name" type="text" name="first_name">
					</td>
				</tr>
				
				<tr>
					<td>
						Last Name:
					</td>
					<td>
						<input id="last_name" type="text" name="last_name">
					</td>
				</tr>
				
				<tr>
					<td>
						Mail:
					</td>
					<td>
						<input id="mail" type="text" name="mail">
					</td>
				</tr>
						
			
				</tbody>
			</table>
				
			<label> <input value="Register" type="submit"></label>
			
		</form>

</body>
</html>