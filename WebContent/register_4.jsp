<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="LoginLogoutStyle.css">
</head>

<body>

	<table style="with: 50%">
	<tr><td>
	<% String username = request.getParameter("username"); %>
<a>Welcome   <% out.println(username); %> User!!!! You have logged in. Welcome to your homepage.</a></td></tr>
<tr></tr><tr><td></td><td></td><td><a href="logout.jsp"><b>Logout</b></a></td></tr>
</table>

</body>

</html>