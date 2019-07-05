<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Customers</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
 <link rel="stylesheet" type="text/css" href="TableView.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
function getUsers(actionParam) {
	 $.get('ViewUserController', {action:actionParam},
		    function(responseJson) {
            if(responseJson!=null){
                $("#usertable").find("tr:gt(0)").remove();
                var table1 = $("#usertable");
                $.each(responseJson, function(key,value) { 
                     var rowNew = $("<tr><td></td><td></td><td></td><td></td><td></td></tr>");
                        rowNew.children().eq(0).text(value['GuestId']); 
                        rowNew.children().eq(1).text(value['GuestName']); 
                        rowNew.children().eq(2).text(value['MobileNumber']); 
                        rowNew.children().eq(3).text(value['Address']); 
                      //  rowNew.children().eq(4).text(value['city']); 
                        rowNew.children().eq(4).text(value['userStatus']); 
                        rowNew.appendTo(table1);
                });
                }
            });
            $("#tablediv").show();
}

$(document).ready(function() {
 $("#tablediv").hide();
 $("#allCustomers").click(function(event){
        getUsers($(this).val());        
  });
 $("#activeCustomers").click(function(event){
	    getUsers($(this).val());        
 }); 
 $("#inActiveCustomers").click(function(event){
	    getUsers($(this).val());        
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
<body class="table-wrapper" onload="disableBackButton()">
	<center>
	<h1>View Customer Details</h1>
	<div align="center">
		<input type="button" class="button" value="All Customers" id="allCustomers" /> 
		<input type="button" class="button" value="Active Customers" id="activeCustomers" /> 
		<input type="button" class="button" value="InActive Customers" id="inActiveCustomers" /> 
	</div>
	
	<br><br>
	<div id="tablediv">
		<table class="fl-table" cellspacing="0" id="usertable">
			<tr>
				<th scope="col">CustomerId</th>
				<th scope="col">Name</th>
				<th scope="col">Phone</th>
				<th scope="col">Address</th>
				<th scope="col">Status</th>
			</tr>
		</table>
		<br><br>
	</div>
	</center>
</body>
</html>