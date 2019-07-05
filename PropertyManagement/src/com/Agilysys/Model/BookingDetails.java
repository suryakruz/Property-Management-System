package com.Agilysys.Model;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class BookingDetails {

	private int bookingId;
	private String checkInDate;
	private String checkOutDate;
	private int stayDuration;
	private int bill;
	private int roomNo;
	private String Name;
	private int RoomId;
	private String roomType;
	private String email;
	private long phoneNo;
	private int noOfCoGuest;
	private String status;
	private String address;
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}

	public String getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status?"CheckedIn":"CheckedOut";
	}
	public int getNoOfCoGuest() {
		return noOfCoGuest;
	}
	public void setNoOfCoGuest(int noOfCoGuest) {
		this.noOfCoGuest = noOfCoGuest;
	}
	public int getRoomId() {
		return RoomId;
	}
	public void setRoomId(int roomId) {
		RoomId = roomId;
	}
	
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = new SimpleDateFormat("yyyy-MM-dd").format(checkInDate);;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = new SimpleDateFormat("yyyy-MM-dd").format(checkOutDate);
	}
	public int getStayDuration() {
		return stayDuration;
	}
	public void setStayDuration(int stayDuration) {
		this.stayDuration = stayDuration;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	
	
	
}
