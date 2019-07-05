package com.Agilysys.Controller;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginController extends HttpServlet  
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req,HttpServletResponse res)throws ServletException,IOException
	{
		PrintWriter pw=res.getWriter();
		res.setContentType("text/html");

		String user=req.getParameter("userName");
		String pass=req.getParameter("userPassword");

		if(user.equals("Surya")&&pass.equals("surya")|| user.equals("Chibi")&&pass.equals("chibi")) 
		{
			    
			 
		    req.getSession().setAttribute("userName", user); 
			res.sendRedirect("HomePage.jsp");  
		}	
                else
                {
                	
                	pw.println("<meta http-equiv='refresh' content='3;URL=loginPage.jsp'>");//redirects after 3 seconds
                	   pw.println("<p style='color:green;'>User or password incorrect!.Redirecting Again to Login Page</p>");
                	
                	
//                	pw.println("<script type=\"text/javascript\">");
//                	   pw.println("alert('User or password incorrect');");
//                	  // pw.println("location='loginPage.jsp';");
//                	   pw.println("</script>");
//                	res.sendRedirect("http://localhost:8080/PropertyManagement/loginPage.jsp"); 
                }
		 pw.close();

	}

}