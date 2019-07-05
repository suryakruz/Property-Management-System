<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <link rel="stylesheet" type="text/css" href="NewRegistration.css">
 <link rel="stylesheet" type="text/css" href="loginPage.css">
<title>New User Registration</title>
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


<script type="text/javascript">
function alertName(){
alert("He is a new Customer,Please Register");
} 
</script> 


<form class="login-page" action="success" method="post">
  <div class="container">
  
 <p>New Guest Registration</p>
    <hr>

    <label for="name"><b>Guest Name</b></label>
    <input type="text" placeholder="Enter Guest Name" name="name"  value="<%=request.getAttribute("CustomerName")%>" >

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" value="<%=request.getAttribute("CustomerEmail")%>"  >

    <label for="phone"><b>Mobile Number</b></label>
	<input type="text" placeholder="Enter Phone Number" id="phone" name="phone" required>
   <label for="name"><b>Address</b></label>
    <input type="text" placeholder="Enter address" name="address" required>
    
     
  

    <button type="submit" class="registerbtn">Register</button>
  </div>
</form>
<script type="text/javascript"> window.onload = alertName; </script>
</body>
</html>