package Entity;

import java.lang.*;

public class Room {

	private String roomID;
	private String roomType;
	private String isAvailable;
	private String pricePerNight;

	public Room() {
	}

	public Room(String roomID, String roomType, String isAvailable,
			String pricePerNight) {
		this.roomID = roomID;
		this.roomType = roomType;
		this.isAvailable = isAvailable;
		this.pricePerNight = pricePerNight;

	}

	public void setRoomID(String roomID) {
		this.roomID = roomID;
	}

	public String getRoomID() {
		return roomID;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setIsAvailable(String isAvailable) {
		this.isAvailable = isAvailable;
	}

	public String getIsAvailable() {
		return isAvailable;
	}

	public String getPricePerNight() {
		return pricePerNight;
	}

	public void setPricePerNight(String pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	public void showInfo() {

		// System.out.println("--------Room Info---------");
		System.out.println("Room Number: " + getRoomID());
		System.out.println("Room Type: " + getRoomType());

		if (getIsAvailable().equals("Available")) {
			System.out.println("Room Availibility: Available");
		} else {
			System.out.println("Room Availibility: Not Available");
		}

		System.out.println("Room Price per Night: " + getPricePerNight());

	}

	public Room parseRoom(String data) {
		String[] tokens = data.split(",");
		String roomID = tokens[0];
		String roomType = tokens[1];
		String isAvailable = tokens[2];
		String pricePerNight = tokens[3];

		return new Room(roomID, roomType, isAvailable, pricePerNight);
	}

	@Override
	public String toString() {
		return getRoomID() + "," + getRoomType() + "," + getIsAvailable() + "," + getPricePerNight();
	}
}