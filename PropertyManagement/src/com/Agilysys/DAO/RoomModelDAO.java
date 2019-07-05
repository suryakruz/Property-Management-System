package com.Agilysys.DAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.Agilysys.Model.DbConnection;
import com.Agilysys.Model.Room;


public class RoomModelDAO {

	
	
	public RoomModelDAO() {
	}
//	public static Connection getConnection(){  
//        Connection con=null;  
//        try{  
//        	Class.forName("com.mysql.jdbc.Driver");  
//        	 con=DriverManager.getConnection("jdbc:mysql://localhost:3306/reservation","root","Surya@1997");     
//        }catch(Exception e){
//        	System.out.println(e);
//        	}  
//        return con;  
//    }  
	
	
	public static ArrayList<Room> getAvailableRooms(String roomType) {
		ArrayList<Room> roomList = new ArrayList<Room>();
		try {
			  Connection con=DbConnection.getConnection();  
			PreparedStatement statement = con.prepareStatement("select * from rooms where RoomType=? and AvailabilityStatus=? and ISCheckedIn=? ");
			statement.setString(1, roomType);
			statement.setInt(2, 1);
		    statement.setBoolean(3, false);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {	
				Room room = new Room();
				room.setRoomId(rs.getInt("RoomId"));
				room.setRoomNo(rs.getInt("RoomNo"));
				room.setRoomType(rs.getString("RoomType"));
				room.setIsCheckedInStatus(rs.getBoolean("ISCheckedIn"));
				room.setAvailabilityStatus(rs.getBoolean("AvailabilityStatus"));
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomList;
	}
	
	public static ArrayList<Room> getAllRooms() {
		ArrayList<Room> roomList = new ArrayList<Room>();
		try {
			  Connection con=DbConnection.getConnection();  
			PreparedStatement ps=con.prepareStatement("select * from rooms");  
            ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Room room = new Room();
				room.setRoomId(rs.getInt("RoomId"));
				room.setRoomNo(rs.getInt("RoomNo"));
				room.setRoomType(rs.getString("RoomType"));
				room.setIsCheckedInStatus(rs.getBoolean("ISCheckedIn"));
				room.setAvailabilityStatus(rs.getBoolean("AvailabilityStatus"));
				roomList.add(room);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roomList;
}
		public static ArrayList<Room> getAvailableRoomsForRoomType(String roomType) throws SQLException {
			ArrayList<Room> roomList = new ArrayList<Room>();
			Connection con = null;
			PreparedStatement statement = null;
			ResultSet rs = null;
			try {
				con = DbConnection.getConnection();
				statement = con.prepareStatement("select * from rooms where RoomType=? and AvailabilityStatus=? and ISCheckedIn=?");
				statement.setString(1, roomType);
				statement.setBoolean(2, true);
				statement.setBoolean(3, false);
				rs = statement.executeQuery();
				while (rs.next()) {	
					Room room = new Room();
					room.setRoomId(rs.getInt("RoomId"));
					room.setRoomNo(rs.getInt("RoomNumber"));
					room.setRoomType(rs.getString("RoomType"));
					room.setIsCheckedInStatus(rs.getBoolean("ISCheckedIn"));
					room.setAvailabilityStatus(rs.getBoolean("AvailabilityStatus"));
					roomList.add(room);
				}
				rs.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
			rs.close();
			statement.close();
			}
			return roomList;
		}
		
//		public ArrayList<Room> getAllRooms() {
//			ArrayList<Room> roomList = new ArrayList<Room>();
//			try {
//				Statement statement = DbConnection.getConnection().createStatement();
//				ResultSet rs = statement.executeQuery("select * from rooms");
//				while (rs.next()) {
//					Room room = new Room();
//					room.setRoomId(rs.getInt("RoomId"));
//					room.setRoomNumber(rs.getInt("RoomNumber"));
//					room.setRoomType(rs.getString("RoomType"));
//					room.setCheckedInStatus(rs.getBoolean("IsCheckedIn"));
//					room.setStatus(rs.getBoolean("Status"));
//					roomList.add(room);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//			return roomList;
//		}
		
		public static ArrayList<Room> getRoomsByStatus(Boolean status) throws SQLException {
			ArrayList<Room> roomList = new ArrayList<Room>();
			Connection con = null;
			PreparedStatement statement = null;
			ResultSet rs = null;
			try {
				con = DbConnection.getConnection();
				statement = con.prepareStatement("select * from rooms where AvailabilityStatus=? and IsCheckedIn=?");
				statement.setBoolean(1, true);
				statement.setBoolean(2, status);
				rs = statement.executeQuery();
				while (rs.next()) {	
					Room room = new Room();
					room.setRoomId(rs.getInt("RoomId"));
					room.setRoomNo(rs.getInt("RoomNo"));
					room.setRoomType(rs.getString("RoomType"));
					room.setIsCheckedInStatus(rs.getBoolean("ISCheckedIn"));
					room.setAvailabilityStatus(rs.getBoolean("AvailabilityStatus"));
					roomList.add(room);
				}
				rs.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
			rs.close();
			statement.close();
			}
			return roomList;
		}
		
		public static ArrayList<Room> getInActiveRooms() throws SQLException {
			ArrayList<Room> roomList = new ArrayList<Room>();
			Connection con = null;
			PreparedStatement statement = null;
			ResultSet rs = null;
			try {
				con = DbConnection.getConnection();
				statement = con.prepareStatement("select * from rooms where AvailabilityStatus=?");
				statement.setBoolean(1, false);
				rs = statement.executeQuery();
				while (rs.next()) {	
					Room room = new Room();
					room.setRoomId(rs.getInt("RoomId"));
					room.setRoomNo(rs.getInt("RoomNo"));
					room.setRoomType(rs.getString("RoomType"));
					room.setIsCheckedInStatus(rs.getBoolean("ISCheckedIn"));
					room.setAvailabilityStatus(rs.getBoolean("AvailabilityStatus"));
					roomList.add(room);
				}
				rs.close();
				statement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			finally {
			rs.close();
			statement.close();
			}
			return roomList;
		}
	}

	
	
	

