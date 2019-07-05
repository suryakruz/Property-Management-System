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
<title>Existing Customers</title>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script>
 $(document).ready(function() {
	$('#in_date').datepicker({
	    dateFormat: 'yy-mm-dd',
		minDate: 0
	}).datepicker('setDate', 'today');
	$('#out_date').datepicker({
	    dateFormat: 'yy-mm-dd',
		minDate: 0
	}); 
	        $('#roomType').change(function(event) {  
	        var $roomType=$("select#roomType").val();
	           $.get('fetchRooms',{roomType:$roomType},function(responseJson) {   
	            var $select = $('#rooms');                           
	               $select.find('option').remove();                        
	               $.each(responseJson, function(key, value) {               
	                   $('<option>').val(value['roomId']).text(value['roomNo']).appendTo($select);      
	                    });
				   $('<option>Select RoomNumber</option>').appendTo($select); 
	            });
	        });
	    });              
</script>
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
        function GetDays(){
                var outdt = new Date(document.getElementById("out_date").value);
                var indt = new Date(document.getElementById("in_date").value);
                return parseInt((outdt - indt) / (24 * 3600 * 1000));
        }

        function cal(){
        if(document.getElementById("out_date")){
        	var stayDays=GetDays();
        	if(stayDays==0){
        		document.getElementById("staydate2").value=1;
        	}
        	else
        		{
        		document.getElementById("staydate2").value=stayDays;
        		}
        	
        }  
        
    }
    </script>
     <script type="text/javascript">
       function bill(amount,stay){
    	       var ret=amount*stay;
    	       console.log(ret);
        		return ret;
        		
        }
 
        function calculatebill(){

      var e=document.getElementById("roomType").value;
 
 
        	 var stay=document.getElementById("staydate2").value;
        	
         if(e.localeCompare("standard")==0){
           document.getElementById("revenue").value=bill(1000,stay);     
       
          }   
         else
        	 {
         	 document.getElementById("revenue").value=bill(2000,stay);
 
        	 }
        }
       
        </script>
    
    
<form class="login-page" action="checkInRoom" method="post">

 <label for="name"><b>Guest Name</b></label>
    <input type="text" placeholder="Enter Guest Name" name="name" value="<%=request.getAttribute("CustomerName")%>" disabled="disabled"/>

 <label for="Email"><b>Email</b></label>  
<input type="text" name="Email" value="<%=request.getAttribute("CustomerEmail")%>" disabled="disabled""/>

 <label for="Address"><b>Address</b></label>  
<input type="text" name="Address" value="<%=request.getAttribute("CustomerAddress")%>" disabled="disabled"/>

<label for="phone"><b>Phone</b></label>  
<input type="text" name="phone" value="<%=request.getAttribute("CustomerPhone")%>"/>

<label for="co-guest">No.of Co-guests</label>  
<input type="text" name="co-guest" id="co-guest" />

  <br></br>

<label>Check-In Date:</label>
<input type="text" class="textbox" id="in_date" name="checkin_date" onchange="cal()"/>

<label>Check-Out Date:</label>
<input type="text" class="textbox" id="out_date" name="checkout_date" onchange="cal()" autocomplete="off"/>

<div id="stayDate"><label >Stay Duration:</label>
<input type="text" class="textbox" id="staydate2" name="numdays" /></div>

  <label for="RoomType">RoomType: </label>  
<select id="roomType" type="text" name="roomid" onchange="calculatebill()">

    <option value="selectAnyOne">Select Any One</option>
    <option value="standard">standard</option>
    <option value="deluxe">deluxe</option>
  </select>
<br></br>

<label for="RoomNumber">Select Room Number:</label>
  
<select id="rooms" name="roomno">
<option>Select RoomNumber</option>
</select>
<br>
  
  <br></br>
       
  <label>Bill:</label>
  <input type="text" id="revenue" name="bill" />

<button type="submit" class="registerbtn">Save & CheckIn</button>
<input type="hidden" value="<%=request.getAttribute("CustomerId")%>" name="userId">



</form>
</body>
</html>