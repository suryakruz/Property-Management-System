package com.Agilysys.Controller;



	import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Agilysys.DAO.RoomModelDAO;
import com.Agilysys.Model.Room;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

public class RoomController extends HttpServlet {
	/**
	 * Servlet implementation class RoomController
	 */
	
		private static final long serialVersionUID = 1L;
	       
	    /**
	     * @see HttpServlet#HttpServlet()
	     */
	
		/**
		 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			try
			{
			
				String roomType = request.getParameter("roomType");
				String action = request.getParameter("action");
				ArrayList<Room> roomList = new ArrayList<Room>();
				if (roomType != null && action == null)
				{
					roomList = RoomModelDAO.getAvailableRooms(roomType);
				}
				else if (action != null && roomType == null)
				{
					switch (action)
					{
					case "All Rooms" : {
						roomList = RoomModelDAO.getAllRooms();
						break;
					}
					case "Occupied Rooms" : {
						roomList = RoomModelDAO.getRoomsByStatus(true);
						break;
					}
					case "Available Rooms" : {
						roomList = RoomModelDAO.getRoomsByStatus(false);
						break;
					}
					case "InActive Rooms" : {
						roomList = RoomModelDAO.getInActiveRooms();
						break;
					}
					default : break; 
					}
				}
				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(roomList, new TypeToken<List<Room>>() {
				}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				response.setContentType("application/json");
				response.getWriter().print(jsonArray);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
//			ArrayList<Room> roomList = new ArrayList<Room>();
//			roomList = RoomModelDAO.getAvailableRooms(roomType);
//			Gson gson = new Gson();
//			JsonElement element = gson.toJsonTree(roomList, new TypeToken<List<Room>>() {
//			}.getType());
//			JsonArray jsonArray = element.getAsJsonArray();
//			response.setContentType("application/json");
//			response.getWriter().print(jsonArray);
		}

		/**
		 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
		 */
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			System.out.println("welcome");
			try
			{
				String roomType = request.getParameter("roomType");
				String action = request.getParameter("action");
				ArrayList<Room> roomList = new ArrayList<Room>();
				if (roomType != null && action == null)
				{
					roomList = RoomModelDAO.getAvailableRoomsForRoomType(roomType);
				}
				else if (action != null && roomType == null)
				{
					switch (action)
					{
					case "All Rooms" : {
						System.out.println("all rooms");
						roomList = RoomModelDAO.getAllRooms();
						break;
					}
					case "Occupied Rooms" : {
						roomList = RoomModelDAO.getRoomsByStatus(true);
						break;
					}
					case "Available Rooms" : {
						roomList = RoomModelDAO.getRoomsByStatus(false);
						break;
					}
					case "InActive Rooms" : {
						roomList = RoomModelDAO.getInActiveRooms();
						break;
					}
					default : break; 
					}
				}
				Gson gson = new Gson();
				JsonElement element = gson.toJsonTree(roomList, new TypeToken<List<Room>>() {
				}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				response.setContentType("application/json");
				response.getWriter().print(jsonArray);
			}
			catch (Exception e) {
				e.printStackTrace();
			}
			
		}

	}

	
	
	
	
