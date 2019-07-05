<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CheckUserDetails.css">
 <link rel="stylesheet" type="text/css" href="loginPage.css">
 
<title>Check User</title>
<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script> 
<%@ include file = "header.jsp" %>
</head>
<body onload="disableBackButton()">
<form class="login-page" action="search" method="get">
  <label for="name"><b>Guest Name</b></label>
    <input type="text" placeholder="Enter Guest Name" name="name" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
    
     <button type="submit" class="registerbtn">Search</button>
     <input type="hidden" value="check-out" name="checkInOrCheckOut">
</form>
</body>
</html>