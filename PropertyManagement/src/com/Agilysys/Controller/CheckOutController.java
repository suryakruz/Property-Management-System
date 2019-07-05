
package com.Agilysys.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agilysys.DAO.BookingDAO;

public class CheckOutController extends HttpServlet  
{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

protected void doGet(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
{    	

	
	PrintWriter out=res.getWriter();
	res.setContentType("text/html");
//	System.out.println(req.getParameter("userId"));
	 int userId=Integer.parseInt(req.getParameter("userId"));
	 int roomId=Integer.parseInt(req.getParameter("roomId"));
//	 System.out.println(userId);
	 int status=0;
	
        
	 status= BookingDAO.checkOutUpdateStatus(userId,roomId);
	System.out.println(status);
	 if(status>0) {
		 
		 out.println("<meta http-equiv='refresh' content='3;URL=HomePage.jsp'>");//redirects after 3 seconds
		   out.println("<center><h2 style='color:green;'>Checked Out Successfully.</h2><br><br><h3>Redirecting To Home Page</h3></center>");
		 
	 }
	 else
	 {
		 out.println("<meta http-equiv='refresh' content='3;URL=HomePage.jsp'>");//redirects after 3 seconds
		   out.println("<center><h2 style='color:green;'>Not Checked In.</h2><br><br><h3>Redirecting To Home Page</h3></center>");
	 }
	 
	 


}
}
