package com.Agilysys.Controller;

	import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agilysys.DAO.BookingDAO;
import com.Agilysys.DAO.UserDAO;
import com.Agilysys.Model.BookingDetails;
import com.Agilysys.Model.User;

	public class UserController extends HttpServlet  
	{
	
	/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{    	
		PrintWriter out=res.getWriter();
		res.setContentType("text/html");
		
		
      
        String name=req.getParameter("name");  
        String email=req.getParameter("email");  
        
        //System.out.println(req.getParameter("checkInOrCheckOut"));
       
        
        if(req.getParameter("checkInOrCheckOut").equalsIgnoreCase("check-in")) {
        	
        	 
        	 try
        	 {
     		   User user=UserDAO.getCustomerByNameEmail(name,email);
     	
     			if(user!=null) {
     				
     		
     				req.setAttribute("CustomerName", user.getGuestName());
     				req.setAttribute("CustomerEmail", user.getEmail());
     				req.setAttribute("CustomerAddress", user.getAddress());
     				req.setAttribute("CustomerPhone", user.getMobileNumber());
     				req.setAttribute("CustomerId", user.getGuestId());
     				req.getRequestDispatcher("ExistingCustomer.jsp").forward(req, res);
     			}
     			else
     			{
     				
     				req.setAttribute("CustomerName",name);
     				req.setAttribute("CustomerEmail", email);
     				req.getRequestDispatcher("NewRegistration.jsp").forward(req, res);
     				
     				
     			}
     			
     			
     		} catch (SQLException e) {
     			// TODO Auto-generated catch block
     			e.printStackTrace();
     		}
     		 out.close();
        	
        }else
        {
        	try {
				User user=UserDAO.getCustomerByNameEmail(name,email);
//				System.out.println(user.getGuestName());
//				System.out.println(user.getEmail());
				if(user==null) {
					out.println("<meta http-equiv='refresh' content='3;URL=HomePage.jsp'>");//redirects after 3 seconds
			 		   out.println("<center><h2 style='color:green;'>No Guest with this name and email is present</h2></center>");
				}
				if(user.getUserStatus().equalsIgnoreCase("Active") ) 
				{
					BookingDetails checkOutUser=BookingDAO.checkOutUser(user);
//					System.out.println(checkOutUser.getName());
//					System.out.println( checkOutUser.getEmail());
					req.setAttribute("CustomerId",user.getGuestId());
					req.setAttribute("CustomerName", checkOutUser.getName());
     				req.setAttribute("CustomerEmail", checkOutUser.getEmail());
     				req.setAttribute("CustomerPhone", checkOutUser.getPhoneNo());
     				req.setAttribute("RoomNo", checkOutUser.getRoomNo());
     				req.setAttribute("RoomId",checkOutUser.getRoomId());
     				req.setAttribute("CoGuests",checkOutUser.getNoOfCoGuest());
     				System.out.println(checkOutUser.getRoomId());
     				req.setAttribute("RoomType", checkOutUser.getRoomType());
     				req.setAttribute("BookingId", checkOutUser.getBookingId());
     				req.setAttribute("CheckInDetails", checkOutUser.getCheckInDate());
     				req.setAttribute("CheckOutDetails", checkOutUser.getCheckOutDate());
     				req.setAttribute("bill", checkOutUser.getBill());
     				req.setAttribute("StayDays", checkOutUser.getStayDuration());
     				req.getRequestDispatcher("CheckOutDetails.jsp").forward(req, res);
				}
				else
					out.println("<meta http-equiv='refresh' content='3;URL=HomePage.jsp'>");//redirects after 3 seconds
		 		   out.println("<center><h2 style='color:green;'>Not Checked In.</h2><br><br><h3> Redirecting To Home Page</h3></center>");
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        	
        	
        	
        	
        }
        
       

	}
		
	    protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
		{
			PrintWriter out=res.getWriter();
			res.setContentType("text/html");

		
	          
	        String name=req.getParameter("name");  
	        String email=req.getParameter("email");  
	        long phone=Long.parseLong(req.getParameter("phone"));  
	        String address=req.getParameter("address"); 
	     System.out.println(name+" "+email+" "+address);
	        
	        User user=new User();
	        user.setGuestName(name);
	        user.setEmail(email);
	        user.setMobileNumber(phone);
	        user.setAddress(address);
	        int status=UserDAO.saveRegister(user);
	        User guestUser = null;
	        try {
				 guestUser=UserDAO.getCustomerByNameEmail(name,email);
				 
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	       
	        if(status>0) {
	        	out.print("<p>Registered the user successfully</p>");
	        	req.setAttribute("CustomerName", user.getGuestName());
				req.setAttribute("CustomerEmail", user.getEmail());
				req.setAttribute("CustomerAddress", user.getAddress());
				req.setAttribute("CustomerPhone", user.getMobileNumber());
				req.setAttribute("CustomerId", guestUser.getGuestId());
				req.getRequestDispatcher("ExistingCustomer.jsp").forward(req, res);
	        }
	        else
	        {
	        	out.print("<center><h2>Sorry unable to save</h2></center>");
	        }
			 out.close();

		}

	}

