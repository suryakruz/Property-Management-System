package com.Agilysys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.Agilysys.Model.DbConnection;
import com.Agilysys.Model.Room;
import com.Agilysys.Model.User;

public class UserDAO {

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

	public static int saveRegister(User user) {

		int status = 0;
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement ps = con.prepareStatement("insert into user(Name,Email,Address,Phone) values (?,?,?,?)");
			// ps.setInt(1,2);
			ps.setString(1, user.getGuestName());
			ps.setString(2, user.getEmail());

			ps.setString(3, user.getAddress());
			ps.setLong(4, user.getMobileNumber());

			status = ps.executeUpdate();

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return status;
	}

	public static User getCustomerById(int userId) {
		String selectSQL = "SELECT * FROM user WHERE UserId=?";
		
		Connection con = DbConnection.getConnection();
		PreparedStatement 	preparedStatement;
		User user = new User();
		try {
		 	preparedStatement = con.prepareStatement(selectSQL);
			preparedStatement.setInt(1, userId);
		
		ResultSet rs = preparedStatement.executeQuery();
		
		if (!rs.isBeforeFirst()) {
			return null;
		}
		
			while (rs.next()) {
				Boolean userStatus = rs.getBoolean("Status");
				int guestId = rs.getInt("UserId");
				String guestName = rs.getString("Name");
				String email = rs.getString("Email");
				String address = rs.getString("Address");
				long phone = rs.getLong("Phone");
				user.setGuestId(guestId);
				user.setUserStatus(userStatus);
				user.setGuestName(guestName);
				user.setEmail(email);
				user.setAddress(address);
				user.setMobileNumber(phone);
				break;
			}
			preparedStatement.close();

		} catch (SQLException e1) {

			e1.printStackTrace();
		} 
		return user;
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static User getCustomerByNameEmail(String customerName, String customerEmail) throws SQLException {

		String selectSQL = "SELECT * FROM user WHERE Name = ? and Email = ?";

		Connection con = DbConnection.getConnection();
		PreparedStatement preparedStatement = con.prepareStatement(selectSQL);
		preparedStatement.setString(1, customerName);
		preparedStatement.setString(2, customerEmail);

		ResultSet rs = preparedStatement.executeQuery();
		User user = new User();
		if (!rs.isBeforeFirst()) {
			return null;
		}
		try {
			while (rs.next()) {
				Boolean userStatus = rs.getBoolean("Status");
				int guestId = rs.getInt("UserId");
				String guestName = rs.getString("Name");
				String email = rs.getString("Email");
				String address = rs.getString("Address");
				long phone = rs.getLong("Phone");
				user.setGuestId(guestId);
				user.setUserStatus(userStatus);
				user.setGuestName(guestName);
				user.setEmail(email);
				user.setAddress(address);
				user.setMobileNumber(phone);
				break;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			preparedStatement.close();

		}
		return user;
	}

	public static Room getRoomNoById(int roomId) {

		return null;

	}

//	public static Date stringToDate(String date) {
//		
//		DateFormat formatter = new SimpleDateFormat("yyyy-mm-dd");
//		java.util.Date date1;
//		try {
//			date1 = formatter.parse(date);
//			java.sql.Date sqlDate = new java.sql.Date(date1.getTime());
//			return sqlDate;
//		} catch (ParseException e) {
//			
//			e.printStackTrace();
//		}
//		return null;
//	}
	
	public static ArrayList<User> getAllUsers() {
		ArrayList<User> userList = new ArrayList<User>();
		try {
			Statement statement = DbConnection.getConnection().createStatement();
			ResultSet rs = statement.executeQuery("select * from user");
			while (rs.next()) {
				User user = new User();
				user.setGuestId(rs.getInt("UserId"));
				user.setGuestName(rs.getString("Name"));
				user.setEmail(rs.getString("Email"));
				user.setMobileNumber(rs.getLong("Phone"));
				user.setAddress(rs.getString("Address"));
				//user.setCity(rs.getString("City"));
				user.setUserStatus(rs.getBoolean("Status"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	
	public static ArrayList<User> getUserDetails(String userName, long phone) {
		ArrayList<User> userList = new ArrayList<>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from user where Name=? and Phone=?");
			statement.setString(1, userName);
			statement.setLong(2, phone);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				User user = new User();
				user.setGuestId(rs.getInt("UserId"));
				user.setGuestName(rs.getString("Name"));
				user.setMobileNumber(rs.getLong("Phone"));
				user.setAddress(rs.getString("Address"));
			//	user.setCity(rs.getString("City"));
				user.setUserStatus(rs.getBoolean("Status"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
	
	
	public static ArrayList<User> getUsersByStatus(Boolean status) {
		ArrayList<User> userList = new ArrayList<>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement statement = con.prepareStatement("select * from user where Status=?");
			statement.setBoolean(1, status);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				User user = new User();
				user.setGuestId(rs.getInt("UserId"));
				user.setGuestName(rs.getString("Name"));
				user.setMobileNumber(rs.getLong("Phone"));
				user.setAddress(rs.getString("Address"));
			//	user.setCity(rs.getString("City"));
				user.setUserStatus(rs.getBoolean("Status"));
				userList.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
	
	
	
	

