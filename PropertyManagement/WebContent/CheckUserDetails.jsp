<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="CheckUserDetails.css">
  <link rel="stylesheet" type="text/css" href="loginPage.css">
<title>User Search</title>
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

  <label for="name"><font color="white">Guest Name:</font></label>
    <input type="text" autocomplete="off" placeholder="Enter Guest Name" name="name" required >

    <label for="email"><font color="white">Email:</font></label>
    <input type="text" autocomplete="off" placeholder="Enter Email" name="email" required>
    
     <button type="submit" class="registerbtn">Search</button>
     
      <input type="hidden" value="check-in" name="checkInOrCheckOut">
     
</form>
</body>
</html>