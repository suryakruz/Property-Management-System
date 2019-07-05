package com.Agilysys.Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agilysys.DAO.UserDAO;
import com.Agilysys.Model.User;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/ViewUserController")
public class ViewUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewUserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		ArrayList<User> userList = new ArrayList<User>();
		
		if (action != null )
		{
			switch (action)
			{
			case "All Customers" : {
				userList = UserDAO.getAllUsers();
				break;
			}
			case "Active Customers" : {
				userList =UserDAO.getUsersByStatus(true);
				break;
			}
			case "InActive Customers" : {
				userList = UserDAO.getUsersByStatus(false);
				break;
			}
			default : break; 
			}
		}
		Gson gson = new Gson();
		JsonElement element = gson.toJsonTree(userList, new TypeToken<List<User>>() {
		}.getType());
		JsonArray jsonArray = element.getAsJsonArray();
		response.setContentType("application/json");
		response.getWriter().print(jsonArray);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
