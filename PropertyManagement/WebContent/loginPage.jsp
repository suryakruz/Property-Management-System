<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>LoginPage</title>
 <link rel="stylesheet" type="text/css" href="loginPage.css">
<script src="LoginPage.js"></script>
<script type="text/javaScript">
function disableBackButton()
{
window.history.forward();
}
setTimeout("disableBackButton()", 0);
</script> 
</head>

<body onload="disableBackButton()">

<div>
<form class="login-page" action="login" method="post">
<div class="form">
<img src="https://www.agilysys.com/-/media/agilysys/Images/Company%20Logo/logo.png?h=46&la=en&w=200" alt="Agilysys Logo">
<br></br>
   <table>
   <tr>
      <td><font face="Roboto" size="4px">UserName:</font></td>
      <td><input type="text" name="userName" placeholder="Enter UserId" autocomplete="off"></td>
   </tr>
   <tr>
      <td><font face="Roboto" size="4px">Password:</font></td>
      <td><input type="password" name="userPassword" placeholder="Enter Password" autocomplete="off"></td>
   </tr>
   </table>
      <button type="submit" value="Login"> Login </button>
      
      <br/>
      <input type="reset" value="Reset">
 </div>     
</form>
</div>

</body>
</html>

