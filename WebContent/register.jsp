  
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Registration</title>
<link rel="stylesheet" type="text/css" href="Regstyle.css">
</head>
<body>
<div>
<form action ="user_registration.jsp" method="post">
    <table style="width: 50%">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="userName" required/>
            </td></tr>
            
            <tr>
            <td>Password</td>
            <td><input type="password" name="password" id="password" required/>
            </td></tr>
            
            <tr>
            <td>Re-Type Password</td>
            <td><input type="password" name="password2" id="password2" required/>
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
</div>


<div id="message1">
  <h3>Both passwords you type must match:</h3>
  <p id="match" class="invalid"> <b>passwords match</b> </p>
</div>

<div id="message">
  <h3>A strong password should contain the following:</h3>
  <p id="letter" class="invalid">A <b>lowercase</b> letter</p>
  <p id="capital" class="invalid">A <b>capital (uppercase)</b> letter</p>
  <p id="number" class="invalid">A <b>number</b></p>
  <p id="length" class="invalid">Minimum <b>8 characters</b></p>
</div>

<br>

<div>
<form action="loginform.jsp">
    <input type="submit" value="Back to login" />
</form>
</div>

<script>
var secondPassword  = document.getElementById("password2");
var myInput = document.getElementById("password");
var match = document.getElementById("match");
var letter = document.getElementById("letter");
var capital = document.getElementById("capital");
var number = document.getElementById("number");
var length = document.getElementById("length");
// When the user clicks on the password field, show the message box
myInput.onfocus = function() {
  document.getElementById("message").style.display = "block";
}
// When the user clicks outside of the password field, hide the message box
myInput.onblur = function() {
  document.getElementById("message").style.display = "none";
}
//When the user clicks on the password2 field, show the message box
secondPassword.onfocus = function() {
  document.getElementById("message1").style.display = "block";
}
// When the user clicks outside of the password2 field, hide the message box
secondPassword.onblur = function() {
  document.getElementById("message1").style.display = "none";
}
// When the user starts to type something inside the password field
myInput.onkeyup = function () {
  // Validate lowercase letters
  var lowerCaseLetters = /[a-z]/g;
  if(myInput.value.match(lowerCaseLetters)) {  
    letter.classList.remove("invalid");
    letter.classList.add("valid");
  } else {
    letter.classList.remove("valid");
    letter.classList.add("invalid");
  }
  
  // Validate capital letters
  var upperCaseLetters = /[A-Z]/g;
  if(myInput.value.match(upperCaseLetters)) {  
    capital.classList.remove("invalid");
    capital.classList.add("valid");
  } else {
    capital.classList.remove("valid");
    capital.classList.add("invalid");
  }
  // Validate numbers
  var numbers = /[0-9]/g;
  if(myInput.value.match(numbers)) {  
    number.classList.remove("invalid");
    number.classList.add("valid");
  } else {
    number.classList.remove("valid");
    number.classList.add("invalid");
  }
  
  // Validate length
  if(myInput.value.length >= 8) {
    length.classList.remove("invalid");
    length.classList.add("valid");
  } else {
    length.classList.remove("valid");
    length.classList.add("invalid");
  }
}
  
  secondPassword.onkeyup = function() {
	  // Validate lowercase letters
	  if(secondPassword.value == myInput.value) {  
	    match.classList.remove("invalid");
	    match.classList.add("valid");
	  } else {
	    match.classList.remove("valid");
	    match.classList.add("invalid");
	  }
}
</script>


</body>
</html>