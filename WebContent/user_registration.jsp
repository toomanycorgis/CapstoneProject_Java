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

<!-- 	
	import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AppDAO;
import users.Admin;
import users.Student;
import users.Teacher;
import users.User;
import users.UserFactory; -->
	

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
			if (dao.userExists(userName)){
				message = "Username already in use, new account not created.";
			} else {
				int rows = dao.insertNewUser(user);
				
				if(rows==0) { //error message throws
					message="an error occurred";
				} else {
					message = "User added successfully. " + rows + " rows affected"; //adds user & prints console message confirming
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} else {
		message = "Passwords do not match.";
	}
%>


	<h2><%=message%></h2>
	<form action="loginform.jsp">
		<input type="submit" value="Back to login" />
	</form>
</body>
</html>