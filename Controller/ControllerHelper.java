package Controller;

import java.time.LocalDate;

import GUI.Labels;
import GUI.MiscGUIelements;
import GUI.Tables;
import Modal.UserSession;
import javafx.scene.control.Label;

/**
 * It's a controller class that has helper methods that are being called in
 * controller class. The purpose of this class is just to make the code clean in
 * BUTTON CONTROLLER class
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class ControllerHelper {


	// fill RESERVATION tables
	@SuppressWarnings("unchecked")
	public static void fillReservationTables() {
		String reservationByUserQuery = "SELECT * from Reservations where reservedby == \""
				+ UserSession.getCurrentUser().getStdName() + "\" and res_date >= \"" + LocalDate.now() + "\"";
		String reservationByOthersQuery = "SELECT * from Reservations where reservedby != \""
				+ UserSession.getCurrentUser().getStdName() + "\" and res_date >= \"" + LocalDate.now() + "\"";
		Tables.reservationsByUser.setItems(Tables.buildData(Tables.reservationsByUser, reservationByUserQuery));
		Tables.reservationsByOthers.setItems(Tables.buildData(Tables.reservationsByOthers, reservationByOthersQuery));
	}

	// fill ROOMS tables
	@SuppressWarnings("unchecked")
	public static void fillRoomsTable() {

		String availableRoomQuery = "SELECT * from rooms where R_capacity >= "
				+ UserSession.getSelectedSearchVars().getCapacity() + " and R_roomType = \""
				+ UserSession.getSelectedSearchVars().getRoomType()
				+ "\" and R_number not in (SELECT Res_roomNO from reservations where res_date == \""
				+ UserSession.getSelectedSearchVars().getDate() + "\"and ((\""
				+ UserSession.getSelectedSearchVars().getStartTime() + "\" >= res_startTime and \""
				+ UserSession.getSelectedSearchVars().getStartTime() + "\" < res_endTime) or(\""
				+ UserSession.getSelectedSearchVars().getEndTime() + "\" >= res_startTime and \""
				+ UserSession.getSelectedSearchVars().getEndTime() + "\" < res_endTime) or (\""
				+ UserSession.getSelectedSearchVars().getStartTime() + "\" < res_startTime and \""
				+ UserSession.getSelectedSearchVars().getEndTime() + "\" > res_endTime)))";
		String unavailableRoomQuery = "SELECT * from rooms where R_capacity >= "
				+ UserSession.getSelectedSearchVars().getCapacity() + " and R_roomType = \""
				+ UserSession.getSelectedSearchVars().getRoomType()
				+ "\" and R_number in (SELECT Res_roomNO from reservations where res_date == \""
				+ UserSession.getSelectedSearchVars().getDate() + "\"and ((\""
				+ UserSession.getSelectedSearchVars().getStartTime() + "\" >= res_startTime and \""
				+ UserSession.getSelectedSearchVars().getStartTime() + "\" < res_endTime) or(\""
				+ UserSession.getSelectedSearchVars().getEndTime() + "\" >= res_startTime and \""
				+ UserSession.getSelectedSearchVars().getEndTime() + "\" < res_endTime) or (\""
				+ UserSession.getSelectedSearchVars().getStartTime() + "\" < res_startTime and \""
				+ UserSession.getSelectedSearchVars().getEndTime() + "\" > res_endTime)))";

		Tables.availableRooms.setItems(Tables.buildData(Tables.availableRooms, availableRoomQuery));
		Tables.unavailableRooms.setItems(Tables.buildData(Tables.unavailableRooms, unavailableRoomQuery));
	}

	// starting RESERE A ROOM scene method
	public static void startReserveScene() {
		String roomTypeComboBoxQuery = "select P_roomType from Policy where P_" + UserSession.getCurrentUser().USER_TYPE
				+ " == true";
		String colName = "P_roomType";

		MiscGUIelements.disableDatesInCalendar();
		MiscGUIelements.fillComboBox(MiscGUIelements.roomTypeComBox, roomTypeComboBoxQuery, colName);
	}

	// starting OK RESEREVATION scene method
	public static void startOkReserveScene() {
		String courseIdComboBoxQuery = "SELECT Programme_ID from Programmes";
		String idColName = "Programme_ID";
		String courseNameComboBoxQuery = "select Programme from Programmes;";
		String nameColName = "Programme";
		MiscGUIelements.fillComboBox(MiscGUIelements.courseIDcomboBox, courseIdComboBoxQuery, idColName);
		MiscGUIelements.fillComboBox(MiscGUIelements.coursesComboBox, courseNameComboBoxQuery, nameColName);
		Label tempLabel = new Label("You want to book a " + UserSession.getSelectedSearchVars().getRoomType() + " # "
				+ UserSession.getSelectedRoom().getRoomNo() + " on " + UserSession.getSelectedSearchVars().getDate()
				+ " from " + UserSession.getSelectedSearchVars().getStartTime() + " to "
				+ UserSession.getSelectedSearchVars().getEndTime());
		Labels.descriptionLabel = tempLabel;
	}

	// set Labels for SHOW DETAILS SCENE
	public static void setLabelsForShowDetailsScene() {
		Label temp1 = new Label(
				"Room Type & No : Tutorial Room No " + UserSession.getSelectedReservation().getRoomNo());
		Labels.roomTypeAndNo = temp1;
		Label temp2 = new Label("Reserved By : " + UserSession.getSelectedReservation().getReservedBy());
		Labels.reservedBy = temp2;
		Label temp3 = new Label("Reserved For The Date : " + UserSession.getSelectedReservation().getResForDate());
		Labels.resForDate = temp3;
		Label temp4 = new Label("Reserved From " + UserSession.getSelectedReservation().getReservedFrom() + " until "
				+ UserSession.getSelectedReservation().getReservedTo());
		Labels.reservedForTime = temp4;
		Label temp5 = new Label("Reserved For : " + UserSession.getSelectedReservation().getResName());
		Labels.reservedForEvent = temp5;
		Labels.setStyle();
	}

	// store search variables in SEARCH_VARS class
	public static void storeSearchVars() {
		UserSession.getSelectedSearchVars().setRoomType((String) MiscGUIelements.roomTypeComBox.getValue());
		UserSession.getSelectedSearchVars().setCapacity((int) MiscGUIelements.roomCapacitySpinn.getValue());
		UserSession.getSelectedSearchVars().setDate(MiscGUIelements.datePicker.getValue());
		UserSession.getSelectedSearchVars().setStartTime(MiscGUIelements.reservedFromComboBox.getValue());
		UserSession.getSelectedSearchVars().setEndTime(MiscGUIelements.reservedToComboBox.getValue());
	}

	// set labels for available/unavailable rooms scene
	public static void setLabelsForAvailableRoom() {
		Label temp1 = new Label("Available " + UserSession.getSelectedSearchVars().getRoomType()
				+ " rooms with minimum capacity of " + UserSession.getSelectedSearchVars().getCapacity() + " on "
				+ UserSession.getSelectedSearchVars().getDate() + " from "
				+ UserSession.getSelectedSearchVars().getStartTime() + " to "
				+ UserSession.getSelectedSearchVars().getEndTime());
		Labels.availableRooms = temp1;

		Label temp2 = new Label("Unvailable " + UserSession.getSelectedSearchVars().getRoomType()
				+ " rooms with minimum capacity of " + UserSession.getSelectedSearchVars().getCapacity() + " on "
				+ UserSession.getSelectedSearchVars().getDate() + " from "
				+ UserSession.getSelectedSearchVars().getStartTime() + " to "
				+ UserSession.getSelectedSearchVars().getEndTime());
		Labels.unavailableRooms = temp2;
		Labels.setStyle();
	}
}