<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" type="text/css" href="Homepagestyle.css">
</head>

<body>

	<div class="header">
	
		<% String username = request.getParameter("username"); %>
		<h1>Welcome to Darkspace, <% out.println(username); %>!</h1>
	</div>
	
	
	<div class="courselist"> 
		<a href="#">Class 1</a>
		<a href="#">Class 2</a>
		<a href="#">Class 3</a>
		<a href="#">Class 4</a>
		<a href="aboutus.jsp" style="float:right">About Our Project</a>
	</div>
	
	
    <div class="listfunctions">
	    <ul>
			  <li><a href="#msgboard">Student Messageboard</a></li>
			  <li><a href="#announce">View Class Announcements</a></li>
			  <li><a href="#grades">Your Grades</a></li>
			  <li><a href="#forms">Print Forms</a></li>
			  <li><a href="#resources">Digital Resources</a></li>
		</ul>
	</div>
	
	<div class="teachersinfo">
	<a><h3>Your Teachers:</h3></a></td></tr>

	<label for="teachers">Teacher:</label>
	
		<select id="teach" name="teachers">
		  <option value="teach1">Jesus</option>
		  <option value="teach2">Other teacher</option>
		  <option value="teach3">Mr Ratburn</option>
		  <option value="teach4">Mrs. Teacher</option>
		</select>
		
	<form action="/action_page.php">
	  <a><h5>Send a message to your teacher:</h5></a></td></tr>
			<textarea id="txt" name="w3review" rows="12" cols="70">
			</textarea>
	</form>
	  <td><input type ="submit" class = "submitbtn" value="Send"/></td>
		<br>
	</div>
	
	<div class="listfunctions">
		<a href="sample_classroom.html" class = "classrooms">To Classroom</a>
		<a href="logout.jsp" class = "logoutbtn">Logout</a>
	</div>
	
	<div class="footer">
		<h5>Generic Footer Business ©2020</h5>
	</div>

</body>
</html>
