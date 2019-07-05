package com.Agilysys.Model;

public class Room {

	private int roomId;
	private int roomNo;
	private String roomType;
	private String availabilityStatus;
	private String isCheckedInStatus;
	
	public String getIsCheckedInStatus() {
		return isCheckedInStatus;
	}
	public void setIsCheckedInStatus(Boolean isCheckedInStatus) {
		this.isCheckedInStatus = isCheckedInStatus ? "Yes" : "No";
	}
	public Room(int roomId, int roomNo, String roomType, Boolean availabilityStatus) {
		super();
		this.roomId = roomId;
		this.roomNo = roomNo;
		this.roomType = roomType;
		this.availabilityStatus = availabilityStatus? "Active" : "InActive";
	}
	public Room() {
		// TODO Auto-generated constructor stub
	}
	public int getRoomId() {
		return roomId;
	}
	public void setRoomId(int roomId) {
		this.roomId = roomId;
	}
	public int getRoomNo() {
		return roomNo;
	}
	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}
	public String getRoomType() {
		return roomType;
	}
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	public String getAvailabilityStatus() {
		return availabilityStatus;
	}
	public void setAvailabilityStatus(Boolean availabilityStatus) {
		this.availabilityStatus = availabilityStatus? "Active" : "InActive";
	}
	
	
}
