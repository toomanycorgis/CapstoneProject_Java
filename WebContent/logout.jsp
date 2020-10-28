<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>See you next time!</title>
<link rel="stylesheet" type="text/css" href="LoginLogoutStyle.css">
</head>
	<body>
		
		<div class="loggingout">
			<table style="with: 50%">
				<tr><td>
				<% String username = request.getParameter("username");%>
			<h2>Goodbye, <% out.println(username);%>!</h2>
			<p>You're now logged out. We'll see you next time.</p>
			</td></tr>
			</table>
		</div>
	</body>
</html>