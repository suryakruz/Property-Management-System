package com.Agilysys.Model;

public class Booking {

	
	private int userId;
	private int noOfCoGuest;
	private String checkInDate;
	private String checkOutDate;
	private int stayDuration;
	private int roomId;
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	
	private int roomNo;
	private int bill;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getNoOfCoGuest() {
		return noOfCoGuest;
	}
	public void setNoOfCoGuest(int noOfCoGuest) {
		this.noOfCoGuest = noOfCoGuest;
	}
	public String getCheckInDate() {
		return checkInDate;
	}
	public void setCheckInDate(String checkInDate) {
		this.checkInDate = checkInDate;
	}
	public String getCheckOutDate() {
		return checkOutDate;
	}
	public void setCheckOutDate(String checkOutDate) {
		this.checkOutDate = checkOutDate;
	}
	public int getStayDuration() {
		return stayDuration;
	}
	public void setStayDuration(int stayDuration) {
		this.stayDuration = stayDuration;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public int getBill() {
		return bill;
	}
	public void setBill(int bill) {
		this.bill = bill;
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
