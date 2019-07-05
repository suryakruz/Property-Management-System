<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Rooms</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="TableView.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function getRooms(actionParam) {
	 $.get('RoomController', {action:actionParam},
		    function(responseJson) {
            if(responseJson!=null){
                $("#roomtable").find("tr:gt(0)").remove();
                var table1 = $("#roomtable");
                $.each(responseJson, function(key,value) { 
                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text(value['roomId']); 
                        rowNew.children().eq(1).text(value['roomNo']); 
                        rowNew.children().eq(2).text(value['roomType']); 
                        rowNew.children().eq(3).text(value['isCheckedInStatus']); 
                        rowNew.children().eq(4).text(value['availabilityStatus']); 
                        rowNew.appendTo(table1);
                });
                }
            });
            $("#tablediv").show();
}

$(document).ready(function() {
 $("#tablediv").hide();
 $("#allRooms").click(function(event){
        getRooms($(this).val());        
  });
 $("#occupiedRooms").click(function(event){
	    getRooms($(this).val());        
 }); 
 $("#availableRooms").click(function(event){
		 getRooms($(this).val());        
 }); 
 $("#inactiveRooms").click(function(event){
	    getRooms($(this).val());        
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
<style >

.button {
  background-color: #f44336; /* Green */
  border: none;
  color: white;
  padding: 15px 32px;
  text-align: center;
  text-decoration: none;
  display: inline-block;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
}
</style>
</head>
<body  class="table-wrapper" onload="disableBackButton()">
	<center>
	<h1>View Room Details</h1>


	<div align="center">
		<input type="button" class="button" value="All Rooms" id="allRooms" /> 
		<input type="button" class="button" value="Occupied Rooms" id="occupiedRooms" /> 
		<input type="button" class="button" value="Available Rooms" id="availableRooms" /> 
		<input type="button" class="button" value="InActive Rooms" id="inactiveRooms" /> 
	</div>
	
	<br><br>
	<div id="tablediv">
		<table class="fl-table" cellspacing="0" id="roomtable">
			<tr>
				<th scope="col">RoomId</th>
				<th scope="col">Room Number</th>
				<th scope="col">Room Type</th>
				<th scope="col">CheckedIn</th>
				<th scope="col">Status</th>
			</tr>
		</table>
		<br><br>
	</div>
	</center>
</body>
</html>