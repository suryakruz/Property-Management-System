package com.Agilysys.Model;

public class User {
	
	private int GuestId;
	private String GuestName;
	private String Email;
	private long MobileNumber;
	private String Address;
	private String userStatus;
	public String getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(Boolean userStatus) {
		this.userStatus = userStatus? "Active" : "InActive";
	}
	public int getGuestId() {
		return GuestId;
	}
	public void setGuestId(int guestId) {
		GuestId = guestId;
	}
	public String getGuestName() {
		return GuestName;
	}
	public void setGuestName(String guestName) {
		GuestName = guestName;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public long getMobileNumber() {
		return MobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		MobileNumber = mobileNumber;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	
	
	
	

}
