<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Bookings</title>
<link rel="stylesheet" type="text/css" href="TableView.css">
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<link href="http://code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css" rel="Stylesheet" type="text/css" />
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/jquery-1.7.2.min.js"></script>
<script type="text/javascript" src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
<script type="text/javascript">
function getBookings(actionParam) {
	 $.get('viewBookingDetails', {action:actionParam, checkInDate: $("#checkInDate").val()},
		    function(responseJson) {
		            if(responseJson!=null){
		                $("#bookingtable").find("tr:gt(0)").remove();
		                var table1 = $("#bookingtable");
		                $.each(responseJson, function(key,value) { 
		                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td><td></td></tr>");
		                        rowNew.children().eq(0).text(value['bookingId']); 
		                        rowNew.children().eq(1).text(value['roomNo']); 
		                        rowNew.children().eq(2).text(value['roomType']); 
		                        rowNew.children().eq(3).text(value['Name']); 
		                        rowNew.children().eq(4).text(value['phoneNo']); 
		                        rowNew.children().eq(5).text(value['address']);
		 						rowNew.children().eq(6).text(value['email']); 
		                        rowNew.children().eq(7).text(value['checkInDate']); 
		                        rowNew.children().eq(8).text(value['checkOutDate']); 
		                        rowNew.children().eq(9).text(value['noOfCoGuest']); 
		                        rowNew.children().eq(10).text(value['bill']); 
		                        rowNew.children().eq(11).text(value['stayDuration']); 
		                        rowNew.children().eq(12).text(value['status']);  
		                        rowNew.appendTo(table1);
		                });
		                }
		            });
		            $("#tablediv").show(); 
}

$(document).ready(function() {
$("#tablediv").hide();
$('#checkInDate').datepicker({
    dateFormat: 'yy-mm-dd'
	});
 $('#checkInDate').change(function(event){
          getBookings("All Bookings")    
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
<body class="table-wrapper" onload="disableBackButton()">
	<center>
	<h1>View Customer Details</h1>
<br/>
Select CheckIn Date : <input type="text" name="checkInDate" id="checkInDate">
	<br><br>
	<div id="tablediv">
		<table class="fl-table" cellspacing="0" id="bookingtable">
			<tr>
				<th scope="col">Booking Id</th>
				<th scope="col">Room Number</th>
				<th scope="col">Room Type</th>
				<th scope="col">Name</th>
				<th scope="col">Phone</th>
				<th scope="col">Address</th>
				<th scope="col">Email</th>
				<th scope="col">CheckIn Date</th>
				<th scope="col">CheckOut Date</th>
				<th scope="col">No Of Guests</th>
				<th scope="col">Bill</th>
				
				<th scope="col">No Of Days</th>
				<th scope="col">Status</th>
			</tr>
		</table>
		<br><br>
	</div>
	</center>
</body>
</html>