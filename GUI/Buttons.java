package GUI;

import Controller.ButtonController;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

/**
 * It's a view class for all the Buttons that are being used in the whole
 * program. Then there are methods to attach event handler to all buttons and
 * set style to the buttons
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class Buttons {

	static String styleCSS = "-fx-font-family: 'Arial', Helvetica, sans-serif; -fx-font-size: 15px; -fx-letter-spacing: -1.2px; -fx-color: #FFFFFF; -fx-font-weight: 400; -fx-text-transform: capitalize;";
	static String styleCSSforHeader = "-fx-font-family: 'Arial', Helvetica, sans-serif; -fx-font-size: 19px; -fx-letter-spacing: -1.2px; -fx-color: #FFFFFF; -fx-font-weight: 400; -fx-text-transform: capitalize;";

	// creating buttons
	public static Button START = new Button("Click Me To Start");
	public static Button RESERVATIONS = new Button("Show Reservations");
	public static Button RESERVE_NOW = new Button("Reserve Room Now");
	public static Button BACK = new Button("Back");
	public static Button SHOW_DETAILS_OF_SELECTED_RESERVATION = new Button("Show Details of Selected Room");
	public static Button SIGN_OUT = new Button("Sign Out");
	public static Button CEHCK_AVAIALIBILITY = new Button("Check Availibility");
	public static Button RESET = new Button("Reset");
	public static Button DELETE = new Button("Delete");
	public static Button MODIFY = new Button("Modify");
	public static Button RESERVE = new Button("Reserve it");
	public static Button CANCEL = new Button("Cancel");
	public static Button RESERVE_SELECTED_ROOM = new Button("Reserve Selected Room");
	public static Button MODIFY_FINAL = new Button("Modify");

	// create BACK button method
	public static Button createBackBtn() {
		BACK = new Button("Back");
		BACK.setStyle(styleCSS);
		BACK.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.backBtnEvent);
		return BACK;
	}

	// create SIGN OUT button method
	public static Button createSignOutBtn() {
		SIGN_OUT = new Button("Sign Out");
		SIGN_OUT.setStyle(styleCSSforHeader);
		SIGN_OUT.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.signOutBtnEvent);
		return SIGN_OUT;
	}

	// styling of buttons
	public static void setStyle() {
		START.setStyle(styleCSS);
		RESERVATIONS.setStyle(styleCSS);
		RESERVE_NOW.setStyle(styleCSS);
		CEHCK_AVAIALIBILITY.setStyle(styleCSS);
		RESET.setStyle(styleCSS);
		DELETE.setStyle(styleCSS);
		MODIFY.setStyle(styleCSS);
		RESERVE.setStyle(styleCSS);
		CANCEL.setStyle(styleCSS);
		RESERVE_SELECTED_ROOM.setStyle(styleCSS);
		SHOW_DETAILS_OF_SELECTED_RESERVATION.setStyle(styleCSS);
		MODIFY_FINAL.setStyle(styleCSS);
	}

	// attaching event handler to all buttons
	public static void attachEventHandler() {
		START.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.startBtnEvent);
		RESERVATIONS.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.reservationBtnEvent);
		RESERVE_NOW.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.reserveNowBtnEvent);
		CEHCK_AVAIALIBILITY.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.checkAvailibilityBtnEvent);
		RESET.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.resetBtnEvent);
		DELETE.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.deleteBtnEvent);
		MODIFY.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.modifyBtnEvent);
		RESERVE.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.reserveBtnEvent);
		CANCEL.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.reserveNowBtnEvent);
		RESERVE_SELECTED_ROOM.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.reserveSelectedRowEvenet);
		SHOW_DETAILS_OF_SELECTED_RESERVATION.addEventHandler(MouseEvent.MOUSE_CLICKED,
				ButtonController.showDetailsOfSelectedReservationEvent);
		MODIFY_FINAL.addEventHandler(MouseEvent.MOUSE_CLICKED, ButtonController.modifyFinalButtonEvent);
	}
}