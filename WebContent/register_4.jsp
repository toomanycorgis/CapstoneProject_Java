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
	
	<button type = "button" class = "classrooms" a href="sample_classroom.html">To Classroom</button>
	<button type = "button" class = "logoutbtn" a href="logout.jsp">Logout</button>
	
	<a><h3>Your Courses:</h3></a>
	
	<table id='table_id'>
	        <th>Fall 2020:</th>
	    		
		            <td><button type="button" value="Class 1">Class 1</button></td>
		            <td><button type="button" value="Class 2">Class 2</button></td>
		            <td><button type="button" value="Class 3">Class 3</button></td>
		            <td><button type="button" value="Class 4">Class 4</button></td>
		        
	    </table>

</body>
</html>
