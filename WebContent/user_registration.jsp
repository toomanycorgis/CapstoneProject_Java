<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="LoginLogoutStyle.css">
</head>
<body>

	<!-- Import necessary classes -->
	<%@page import="java.io.IOException"%>
	<%@page import="java.sql.Date"%>
	<%@page import="java.sql.SQLException"%>
	<%@page import="java.sql.Timestamp"%>
	<%@page import="java.io.IOException"%>
	<%@page import="java.sql.Date"%>
	<%@page import="java.sql.SQLException"%>
	<%@page import="dao.AppDAO"%>
	<%@page import="users.*"%>

	<!-- Java code to register new user -->

	<%
		AppDAO dao = AppDAO.getInstance(); //instantiating db object by accessing instance
	String message = "";
	//getting input from form
	String userName = request.getParameter("userName");
	String password = request.getParameter("password");
	String password2 = request.getParameter("password2");
	String firstName = request.getParameter("firstName");
	String lastName = request.getParameter("lastName");
	String email = request.getParameter("email");
	String userType = request.getParameter("role");

	if (password.contentEquals(password2)) {

		UserFactory factory = new UserFactory();
		User user = null;
		user = factory.createUser(userType, userName, firstName, lastName, email, password);
		try {
			if (dao.userExists(userName)) {
		message = "Username already in use, new account not created.";
			} else {
		int rows = dao.insertNewUser(user);

		if (rows == 0) { //error message throws
			message = "an error occurred";
		} else {
			message = "User added successfully. " + rows + " rows affected"; //adds user & prints console message confirming
		}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	} else {
		message = "Passwords do not match.";
	}
	%>

	<!-- HTML to display confirmation message -->

	<h2><%=message%></h2>
	<form action="loginform.jsp">
		<input type="submit" value="Back to login" />
	</form>
</body>
</html>