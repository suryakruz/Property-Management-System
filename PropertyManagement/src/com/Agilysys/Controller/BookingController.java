package com.Agilysys.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agilysys.DAO.BookingDAO;
import com.Agilysys.DAO.UserDAO;
import com.Agilysys.Model.Booking;
import com.Agilysys.Model.BookingDetails;
import com.Agilysys.Model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class BookingController extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BookingController() {
	}

	
	
	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		String checkInDate = request.getParameter("checkInDate");
		ArrayList<BookingDetails> bookingList = new ArrayList<BookingDetails>();
		if (action != null)
		{
			switch (action)
			{
			case "All Bookings" : {
				bookingList = BookingDAO.getBookingsByDate(checkInDate);
				break;
			}
			default : break; 
			}
		}
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(bookingList, new TypeToken<List<User>>() {
		}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter out = res.getWriter();
		res.setContentType("text/html");
		
		 int userId=Integer.parseInt(req.getParameter("userId"));
	     int noOfCoGuest=Integer.parseInt(req.getParameter("co-guest"));
	     String checkInDate=req.getParameter("checkin_date");
	     
	     String checkOutDate=req.getParameter("checkout_date");
	   
	     int stayDuration=Integer.parseInt(req.getParameter("numdays"));
	      
	     int roomId=Integer.parseInt(req.getParameter("roomno"));
	    
	     int bill=Integer.parseInt(req.getParameter("bill"));
	     
	     User user=UserDAO.getCustomerById(userId);
	     
	     if(user.getUserStatus().equals("InActive")) {
	    	 
	    	 Booking booking=new Booking();
	 		booking.setUserId(userId);
	 		booking.setBill(bill);
	 		booking.setCheckInDate(checkInDate);
	 		booking.setCheckOutDate(checkOutDate);
	 		booking.setNoOfCoGuest(noOfCoGuest);
	 		booking.setRoomId(roomId);
	 		booking.setStayDuration(stayDuration);
	 	   int status=0;
	 		try {
	 			 status=BookingDAO.saveBooking(booking);
	 		} catch (SQLException e) {
	 			// TODO Auto-generated catch block
	 			e.printStackTrace();
	 		}
	 	   if(status>0) {
	 		   out.println("<meta http-equiv='refresh' content='3;URL=HomePage.jsp'>");//redirects after 3 seconds
	 		   out.println("<center><h2 style='color:green;'>Checked In successfully.</h2><br><br><h3>Redirecting to Home Page</h3></center>");
	 		    
	 	   }
	 	   else
	 		   out.print("not save successfully");
	     }else
	     {
	    	 
	    	 out.println("<meta http-equiv='refresh' content='3;URL=HomePage.jsp'>");//redirects after 3 seconds
	 		   out.println("<center><h3 style='color:red;'>Already Checked In</h3></center>");
	    	 
	     }

	}

}