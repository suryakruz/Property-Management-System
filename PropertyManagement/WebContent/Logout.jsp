<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>LogOut Page</title>
<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script>
</head>
<body onload="disableBackButton()">
<center>
<h2>You have been logged out successfully.</h2>
<h2>Back to <a href="loginPage.jsp">Login</a></h2>
</center>
</body>
</html>