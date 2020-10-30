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


<% String username = request.getParameter("username"); %>
<a><h1>Welcome to Darkspace, <% out.println(username); %>!</h1></a></td></tr>

<a><h3>Your Courses:</h3></a></td></tr>

<table id='table_id'>
        <th>Fall 2020:</th>
    
            <td><input type="button" value="Class 1"/></td>
            <td><input type="button" value="Class 2"/></td>
            <td><input type="button" value="Class 3"/></td>
            <td><input type="button" value="Class 4"/></td>
       
        
    </table>
    
    <ul>
  <li><a href="#msgboard">Student Messageboard</a></li>
  <li><a href="#announce">View Class Announcements</a></li>
  <li><a href="#grades">Your Grades</a></li>
  <li><a href="#forms">Print Forms</a></li>
  <li><a href="#resources">Digital Resources</a></li>
</ul>
    

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
<textarea id="txt" name="w3review" rows="15" cols="70">
  </textarea>
  <input type ="submit" value="Send"/>
</form>




</body>
</html>


<a href="sample_classroom.html"><b>To Classroom</b></a>
<br>
<a href="logout.jsp"><b>Logout</b></a>


</html>