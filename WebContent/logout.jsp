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

<table style="with: 50%">
	<tr><td>
	<% String username = request.getParameter("username"); %>
<a>Goodbye,   <% out.println(username); %> User!!!! You have logged out. We'll see you next time.</a></td></tr>
</table>

</body>
</html>