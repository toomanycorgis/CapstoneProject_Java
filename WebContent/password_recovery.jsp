<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Password Recovery</title>
</head>
<body>
	<h3>Password Recovery</h3>
	<form action ="password_recovery" method="post">
	    <table style="width: 50%">
	        <tr>
	            <td>UserName</td>
	            <td><input type="text" name="userName" required/>
	            </td></tr>
	            
	            </table>
	            <input type="submit" value="Send Password"/>
	</form>
	<br>
	<form action="loginform.jsp">
	    <input type="submit" value="Back to login" />
	</form>
</body>
</html>