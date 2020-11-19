<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
</head>
<body>
<form action ="user_register" method="post">
    <table style="width: 50%">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="userName" required/>
            </td></tr>
            
            <tr>
            <td>Password</td>
            <td><input type="password" name="password" required/>
            </td></tr>
            
            <tr>
            <td>Re-Type Password</td>
            <td><input type="password" name="password2" required/>
            </td></tr>
            
            <tr>
            <td>First Name</td>
            <td><input type="text" name="firstName"/>
            </tr>
            
            <tr>
            <td>Last Name</td>
            <td><input type="text" name="lastName"/>
            </tr>
            
            <tr>
            <td>Email</td>
            <td><input type="text" name="email" required/>
            </tr>
            
            <tr>
            <td>User Type</td>
            <td>  <input type="radio" id="S" name="role" value="S">
                  <label for="male">Student</label>
                  <input type="radio" id="T" name="role" value="T">
                  <label for="female">Teacher</label>
                  <input type="radio" id="A" name="role" value="A">
                  <label for="other">Admin</label>
            
            </table>
            <input type="submit" value="Register"/>
</form>
<br>
<form action="loginform.jsp">
    <input type="submit" value="Back to login" />
</form>
</body>
</html>