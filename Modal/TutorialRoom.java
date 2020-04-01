package Modal;

/**
 * It's a modal class for TUTORIAL ROOM and has getters and setters and a
 * constructor for it
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class TutorialRoom {

	// instance variables
	private int roomID;
	private int roomNo;
	private int capacity;
	private boolean projector;
	private boolean soundSystem;
	final static String ROOM_TYPE = "Tutorial Room";

	// constructor
	public TutorialRoom(int roomID, int roomNo, int capacity, boolean projector, boolean soundSystem) {
		super();
		this.roomID = roomID;
		this.roomNo = roomNo;
		this.capacity = capacity;
		this.projector = projector;
		this.soundSystem = soundSystem;
	}

	// getter and setters
	public int getRoomID() {
		return roomID;
	}

	public void setRoomID(int roomID) {
		this.roomID = roomID;
	}

	public int getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(int roomNo) {
		this.roomNo = roomNo;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public boolean getProjector() {
		return projector;
	}

	public void setProjector(boolean projector) {
		this.projector = projector;
	}

	public boolean getSoundSystem() {
		return soundSystem;
	}

	public void setSoundSystem(boolean soundSystem) {
		this.soundSystem = soundSystem;
	}
}
