<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
 <link rel="stylesheet" type="text/css" href="loginPage.css">
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
<div class="login-page" >
<form class="form">
<a href="CheckUserDetails.jsp"><button type="button" class="button" >Check-In</button></a>
<br></br>
<a href="CheckOutSearch.jsp"><button type="button" class="button" name="checkOut">Checkout</button></a>
<br></br>
<a href="ViewRooms.jsp"><button type="button" class="button" name="checkOut">View Rooms</button></a>
<br></br>
<a href="ViewUsers.jsp"><button type="button" class="button" name="viewUsers">View Users</button></a>
<br></br>
<a href="ViewBookings.jsp"><button type="button" class="button" name="viewBookings">View Bookings</button></a>

</form>
</div>
</body>
</html>