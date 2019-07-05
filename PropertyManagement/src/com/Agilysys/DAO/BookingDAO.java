package com.Agilysys.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.Agilysys.Model.Booking;
import com.Agilysys.Model.BookingDetails;
import com.Agilysys.Model.DbConnection;
import com.Agilysys.Model.User;

public class BookingDAO {

	
	private static String parseDateToSqlString(String date) throws ParseException {
		SimpleDateFormat fromUser = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");

		try {

			String reformattedStr = myFormat.format(fromUser.parse(date));
			return reformattedStr;
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

//	private static Date parseDateToDate(String date) throws ParseException {
//		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
//		// System.out.println(formatter.parse(date));
//		return formatter.parse(date);
//	}



	public static BookingDetails checkOutUser(User user) throws SQLException {

		String selectSQL = "select BookingId,a.RoomId,CheckInDetails,CheckOutDetails,StayDays,Bill,Name,Email,Phone,RoomNo,RoomType,CoGuests  from bookings a join user b on a.UserId=b.UserId join rooms c on a.RoomId=c.RoomId where b.UserId=?";

		Connection con = DbConnection.getConnection();
		PreparedStatement ps = con.prepareStatement(selectSQL);
		ps.setInt(1, user.getGuestId());
		ResultSet rs = ps.executeQuery();
		BookingDetails checkOutUser = new BookingDetails();
		if (!rs.isBeforeFirst()) {
			return null;
		}
		try {
			while (rs.next()) {

				checkOutUser.setBookingId(rs.getInt("BookingId"));
				checkOutUser.setCheckInDate(rs.getDate("CheckInDetails"));
				checkOutUser.setCheckOutDate(rs.getDate("CheckOutDetails"));
				checkOutUser.setStayDuration(rs.getInt("StayDays"));
				checkOutUser.setBill(rs.getInt("Bill"));
				checkOutUser.setRoomId(rs.getInt("RoomId"));
				checkOutUser.setNoOfCoGuest(rs.getInt("CoGuests"));
				checkOutUser.setName(rs.getString("Name"));
				checkOutUser.setEmail(rs.getString("Email"));
				checkOutUser.setPhoneNo(rs.getLong("Phone"));
				checkOutUser.setRoomNo(rs.getInt("RoomNo"));
				checkOutUser.setRoomType(rs.getString("RoomType"));
				break;
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		} finally {
			ps.close();

		}
		return checkOutUser;

	}
	
	

	public static int checkOutUpdateStatus(int userId, int roomId) {
		
		String updateStatus="update bookings a, user b, rooms c set a.Status=false,b.Status=false,c.ISCheckedIn=false where a.UserId=b.UserId and a.RoomId=c.RoomId and a.UserId=? and a.RoomId=?"; 
		int status=0;
		Connection con = DbConnection.getConnection();
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(updateStatus);
			ps.setInt(1,userId);
			ps.setInt(2, roomId);
			status=ps.executeUpdate();
			   ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	
	
	
	
	
	
	
	public static int saveBooking(Booking booking) throws SQLException {

		int status = 0;
		String updateQuery = "update bookings a, user b, rooms c set b.Status=1,c.ISCheckedIn=1 where a.UserId=b.UserId and a.RoomId=c.RoomId and a.UserId=? and a.RoomId=?";

		String selectSQL = "insert into bookings(CheckInDetails, CheckOutDetails, StayDays, CoGuests, Bill, UserId, RoomId, Status) values (?,?,?,?,?,?,?,?)";

		try {
			Connection con = DbConnection.getConnection();
			//String checkInString = parseDateToSqlString(booking.getCheckInDate());
//			System.out.println(checkInString);
//			System.out.println(booking.getUserId());
			//Date checkInDate = parseDateToDate(checkInString);
			//System.out.println(java.sql.Date.valueOf(booking.getCheckInDate()));
			//String checkOutString = parseDateToSqlString(booking.getCheckOutDate());
			//System.out.println(checkOutString);
			//Date checkOutDate = parseDateToDate(checkOutString);
			//System.out.println(java.sql.Date.valueOf(checkOutString));
			PreparedStatement ps = con.prepareStatement(selectSQL);
			PreparedStatement uQ = con.prepareStatement(updateQuery);
			uQ.setInt(1, booking.getUserId());
			uQ.setInt(2, booking.getRoomId());
			ps.setDate(1, java.sql.Date.valueOf(booking.getCheckInDate()));
			ps.setDate(2, java.sql.Date.valueOf(booking.getCheckOutDate()));
			ps.setInt(3, booking.getStayDuration());
			ps.setInt(4, booking.getNoOfCoGuest());
			ps.setInt(5, booking.getBill());
			ps.setInt(6, booking.getUserId());
			ps.setInt(7, booking.getRoomId());
			ps.setBoolean(8, true);

			status = ps.executeUpdate();
			status = uQ.executeUpdate();
           ps.close();
           uQ.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;

	}
	
	
	
	public static ArrayList<BookingDetails> getBookingsByDate(String checkInDate) {
		ArrayList<BookingDetails> bookingList = new ArrayList<BookingDetails>();
		try {
			Connection con = DbConnection.getConnection();
			PreparedStatement statement = con.prepareStatement(""
					+ "select * from bookings a join user b on a.userId = b.userId join rooms c on a.roomid=c.roomid "
					+ " where a.CheckInDetails = DATE(?)");
			statement.setString(1, checkInDate);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				
				BookingDetails bookingDetails = new BookingDetails();
				bookingDetails.setCheckInDate(rs.getDate("CheckInDetails"));
				bookingDetails.setBookingId(rs.getInt("BookingId"));
		        bookingDetails.setEmail(rs.getString("Email"));
				bookingDetails.setCheckOutDate(rs.getDate("CheckOutDetails"));
				bookingDetails.setBill(rs.getInt("Bill"));
				bookingDetails.setAddress(rs.getString("Address"));
				bookingDetails.setStayDuration(rs.getInt("StayDays"));
				bookingDetails.setNoOfCoGuest(rs.getInt("CoGuests"));
				bookingDetails.setPhoneNo(rs.getLong("Phone"));
				bookingDetails.setRoomNo(rs.getInt("RoomNo"));
				bookingDetails.setRoomType(rs.getString("RoomType"));
				bookingDetails.setStatus(rs.getBoolean("Status"));
				bookingDetails.setName(rs.getString("Name"));
				
				bookingList.add(bookingDetails);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return bookingList;
	}
}
