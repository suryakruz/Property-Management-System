<%@page import="com.Agilysys.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ page import="java.util.*" %>
        <%@ page import="java.time.format.DateTimeFormatter" %>
          <%@ page import="java.time.LocalDateTime" %>
  
   
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="CheckUserDetails.css">
  <link rel="stylesheet" type="text/css" href="loginPage.css">
<link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="Stylesheet" type="text/css" />
<title>Check Out Page</title>
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



<form class="login-page" action="checkOutRoom" method="get">

 <label for="name"><b>Guest Name</b></label>
    <input type="text"  name="name" value="<%=request.getAttribute("CustomerName")%>" disabled="disabled"/>

 <label for="Email"><b>Email</b></label>  
<input type="text" name="Email" value="<%=request.getAttribute("CustomerEmail")%>" disabled="disabled""/>

 

<label for="phone"><b>Phone</b></label>  
<input type="text" name="phone" value="<%=request.getAttribute("CustomerPhone")%>" disabled="disabled"/>

<label for="co-guest"><b>No.of Co-guests </b></label>  
<input type="text" name="co-guest" value="<%=request.getAttribute("CoGuests")%>" id="co-guest" />

<br/>

<label >Check-In Date:</label>
<input type="text" class="textbox" id="in_date" name="checkin_date" value="<%=request.getAttribute("CheckInDetails")%>"/>

<div id="checkout_date"><p><label >Check-Out Date:</label>
<input type="text" class="textbox" id="out_date" name="checkout_date" value="<%=request.getAttribute("CheckOutDetails")%>"/></p></div>

<div id="stayDate"><label >Stay Duration:</label>
<input type="text" class="textbox" id="staydate2" name="numdays" value="<%=request.getAttribute("StayDays")%>" /></div>

  <!-- <label for="RoomType"><b>RoomType</b></label>  
<select id="roomType" type="text" name="roomid" onchange="calculatebill()">
    <option value="selectAnyOne">Select Any One</option>
    <option value="standard">standard</option>
    <option value="deluxe">deluxe</option>
  </select> -->
<label >Room Type</label>
<input type="text" class="textbox" id="RoomType" name="RoomType" value="<%=request.getAttribute("RoomType")%>" />
 <!--  Select Room Number:
<select id="rooms" name="roomno">
<option>Select RoomNumber</option>
</select>
<br>
  
  <br></br> -->
  
      
      <label >Room Number</label>
<input type="text" class="textbox" id="RoomNo" name="RoomNo" value="<%=request.getAttribute("RoomNo")%>" />
      
       
  <div id="amount"><label >Bill</label>
  <input type="text" class="textbox" id="revenue" name="bill" value="<%=request.getAttribute("bill")%>" /></div>

<button type="submit" class="registerbtn">CheckOut</button>
<%-- <input type="hidden" value="<%=request.getAttribute("CustomerId")%>" name="userId"> --%>

<input type="hidden" value="<%=request.getAttribute("CustomerId")%>" name="userId">
<input type="hidden" value="<%=request.getAttribute("RoomId")%>" name="roomId">

</form>








</body>
</html>