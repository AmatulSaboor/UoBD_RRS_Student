package GUI;

import Modal.UserSession;
import javafx.scene.control.Label;

/**
 * It's a view class for all the LABELS in this program. It has some labels with
 * fixed content and some with dynamic content. Dynamic labels are being called
 * in other classes to set the values
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class Labels {

	static String styleCSS = "-fx-font-family: 'Comic Sans MS', cursive, sans-serif; -fx-font-size: 16px; -fx-letter-spacing: -1.2px; -fx-text-fill: #4AB7E0; -fx-font-weight: 400; -fx-text-transform: capitalize;";
	static String styleCSSForHeader = "-fx-font-family: 'Comic Sans MS', cursive, sans-serif; -fx-font-size: 20px; -fx-letter-spacing: -1.2px; -fx-text-fill: #FFFFFF; -fx-font-weight: 400; -fx-text-transform: capitalize;";

	// labels with fixed content
	public static Label SYSTEM_NAME = new Label();
	public static Label WELCOME_USER = new Label();
	public static Label ROOMS_RESERVED_BY_YOU = new Label(
			"Rooms reserved by " + UserSession.getCurrentUser().getStdName());
	public static Label ROOMS_RESERVED_BY_OTHERS = new Label("Rooms reserved by others!");
	public static Label ROOM_TYPE = new Label("Room Type");
	public static Label DATE = new Label("Date");
	public static Label CAPACITY = new Label("Capacity");
	public static Label RESERVED_FROM = new Label("From");
	public static Label RESERVED_TILL = new Label("Untill");
	public static Label SELECT_COURSE = new Label("Select Course");
	public static Label COURSE_ID = new Label("Course ID");
	public static Label EVENT_DESCRIPTION = new Label("Event Description");

	// labels with dynamic content
	public static Label descriptionLabel = new Label();
	public static Label availableRooms = new Label();
	public static Label unavailableRooms = new Label();
	public static Label roomTypeAndNo = new Label();
	public static Label reservedBy = new Label();
	public static Label resForDate = new Label();
	public static Label reservedForTime = new Label();
	public static Label reservedForEvent = new Label();

	// creating WELCOME USER label
	public static Label createWelcomeUserLabel() {
		WELCOME_USER = new Label("Welcome " + UserSession.getCurrentUser().getStdName());
		WELCOME_USER.setStyle(styleCSSForHeader);
		return WELCOME_USER;
	}

	// creating SYSTEM NAME label
	public static Label createSystemNameLabel() {
		SYSTEM_NAME = new Label("UoBD RRS");
		SYSTEM_NAME.setStyle(styleCSSForHeader);
		return SYSTEM_NAME;
	}

	// set style to Labels
	public static void setStyle() {
		SYSTEM_NAME.setStyle(styleCSS);
		WELCOME_USER.setStyle(styleCSS);
		ROOMS_RESERVED_BY_YOU.setStyle(styleCSS);
		ROOMS_RESERVED_BY_OTHERS.setStyle(styleCSS);
		ROOM_TYPE.setStyle(styleCSS);
		DATE.setStyle(styleCSS);
		CAPACITY.setStyle(styleCSS);
		RESERVED_FROM.setStyle(styleCSS);
		RESERVED_TILL.setStyle(styleCSS);
		SELECT_COURSE.setStyle(styleCSS);
		COURSE_ID.setStyle(styleCSS);
		EVENT_DESCRIPTION.setStyle(styleCSS);

		descriptionLabel.setStyle(styleCSS);
		availableRooms.setStyle(styleCSS);
		unavailableRooms.setStyle(styleCSS);
		roomTypeAndNo.setStyle(styleCSS);
		reservedBy.setStyle(styleCSS);
		resForDate.setStyle(styleCSS);
		reservedForTime.setStyle(styleCSS);
		reservedForEvent.setStyle(styleCSS);
	}
}
