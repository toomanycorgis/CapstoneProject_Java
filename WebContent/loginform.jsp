<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login Page</title>
<link rel="stylesheet" type="text/css" href="LoginLogoutStyle.css">
</head>
<body>

	<form>
	
	<h2>You've Reached DarkSpace</h2>
	<div class="enter">
		<button type="button" onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Enter Site</button>
	</div>
	</form>


	<div id="id01" class="modal"> 
	  <form class="modal-content animate" action="user_login" method="post">
	    <div class="imgcontainer">
	      <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
	      <img src="img_avatar2.png" alt="Avatar" class="avatar">
	    </div>
	
	    <div class="container">
	      <label for="username"><b>Username</b></label>
	      <input type="text" placeholder="Enter Username" name="username" required>
	
	      <label for="password"><b>Password</b></label>
	      <input type="password" placeholder="Enter Password" name="password" required>
	        
	      <button type="submit">Login</button>
		      <%-- not sure if we want this feature, leaving commented out for now
		      <label>
		        <input type="checkbox" checked="checked" name="remember"> Remember me
		      </label> 
		      --%>
	    </div>
	
	    <div class="container" style="background-color:#f1f1f1">
	      <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
		      <%-- not sure if we want this feature, leaving commented out for now, just need to map the href to a function/jsp
		      <span class="psw">Forgot <a href="#">password?</a></span>
		       --%>
	    </div>
	  </form>
	</div>

	<script>
	// Get the modal
	var modal = document.getElementById('id01');
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	    if (event.target == modal) {
	        modal.style.display = "none";
	    }
	}
	</script>

<%-- 
<form action ="user_login" method="post">
	<table style="with: 50%">
		<tr>
			<!-- 
			<td><label for ="username"><b>Username</b></label></td>
			<td><input type="text" placeholder="Enter Username" name="username" required/>
			</td></tr>
			
			<tr>
			<td><label for ="password"><b>Password</b></label></td>
			<td><input type="password" placeholder="Enter Password" name="password" required/>
			</td></tr>  -->
			
			
			
			<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">Enter</button>
			
			<!-- The Modal -->
		<div id="id01" class="modal">
		  <span onclick="document.getElementById('id01').style.display='none'"
		class="close" title="Close Modal">&times;</span>
		
		  <!-- Modal Content -->
		  <form class="modal-content animate" action="/action_page.php">
		    <div class="imgcontainer">
		      <img src="img_avatar2.png" alt="Avatar" class="avatar">
		    </div>
		
		    <div class="container">
		      <label for="username"><b>Username</b></label>
		      <input type="text" placeholder="Enter Username" name="username" required>
		
		      <label for="password"><b>Password</b></label>
		      <input type="password" placeholder="Enter Password" name="password" required>
		
		      <button type="submit">Login</button></table> 
</form>	--%>

	<br>
	<form action="register.jsp">
		<div class="register1">
	    <button type="submit" value="Register here">Register Here</button>
	    </div>
	</form>
	
	<br>
	<form action="password_recovery.jsp">
		<div class="register1">
	    <button type="submit" value="Recover Password">Recover Password</button>
	    </div>
	</form>

</body>
</html>