package Modal;

import java.time.LocalDate;

/**
 * It's a class that is used to store temporary all the values that the user is
 * trying to search a room with. Later, these values will be used in search
 * query in database
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class SearchVars {

	// variables
	private String roomType;
	private LocalDate date;
	private int capacity;
	private String startTime;
	private String endTime;

	// getters and setters
	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
