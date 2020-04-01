package Modal;
import java.sql.Date;
import java.sql.Time;

/**
 * It's a modal class for RESERVATION and has getters and setters and a
 * constructor for it
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class Reservations {

	// instance variables
	private int resID;
	private String resName;
	private int roomNo;
	private Date resForDate;
	private Time reservedFrom;
	private Time reservedTo;
	private String reservedBy;

	// constructor
	public Reservations(int resID, String resName, int roomNo, Date resForDate, Time reservedFrom, Time reservedTo,
			String reservedBy) {
		this.resID = resID;
		this.resName = resName;
		this.roomNo = roomNo;
		this.resForDate = resForDate;
		this.reservedFrom = reservedFrom;
		this.reservedTo = reservedTo;
		this.reservedBy = reservedBy;
	}

	// getters and setters
	public int getResID() {
		return resID;
	}

	public void setResID(int resID) {
		this.resID = resID;
	}

	public String getResName() {
		return resName;
	}

	public void setResName(String resName) {
		this.resName = resName;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public Date getResForDate() {
		return resForDate;
	}

	public void setResForDate(Date resForDate) {
		this.resForDate = resForDate;
	}

	public Time getReservedFrom() {
		return reservedFrom;
	}

	public void setReservedFrom(Time reservedFrom) {
		this.reservedFrom = reservedFrom;
	}

	public Time getReservedTo() {
		return reservedTo;
	}

	public void setReservedTo(Time reservedTo) {
		this.reservedTo = reservedTo;
	}

	public String getReservedBy() {
		return reservedBy;
	}

	public void setReservedBy(String reservedBy) {
		this.reservedBy = reservedBy;
	}
}
