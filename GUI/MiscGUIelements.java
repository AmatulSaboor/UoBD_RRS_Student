package GUI;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;

import Modal.Database;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;

/**
 * It's a view class for miscellaneous GUI elements and a few related methods
 * @author Amatul Saboor
 * @version 01-04-2020
 */


public class MiscGUIelements {

	// miscellaneous GUI elements
	public static ComboBox<String> roomTypeComBox = new ComboBox<String>();
	public static ComboBox<String> coursesComboBox = new ComboBox<String>();
	public static ComboBox<Integer> courseIDcomboBox = new ComboBox<Integer>();
	public static ComboBox<String> reservedFromComboBox = new ComboBox<String>();
	public static ComboBox<String> reservedToComboBox = new ComboBox<String>();
	public static DatePicker datePicker = new DatePicker(LocalDate.now());	
	public static Spinner<Integer> roomCapacitySpinn = new Spinner<Integer>(new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 200, 5, 5));
	public static TextArea eventDescription = new TextArea();
	
	// all alerts
	public static Alert errorAlert1 = new Alert(AlertType.ERROR, "You can't book it for this time of today as the time has already passed", ButtonType.OK);
	public static Alert errorAlert2 = new Alert(AlertType.ERROR, "The start time can't be same or earlier than the end time", ButtonType.OK);
	public static Alert errorAlert3 = new Alert(AlertType.ERROR, "You can't book a room for more than one hour and 30 minutes", ButtonType.OK);
	public static Alert errorAlert4 = new Alert(AlertType.INFORMATION, "Please select a room first to reserve", ButtonType.OK);
	public static Alert errorAlert7 = new Alert(AlertType.ERROR, "You can't have two reservations on a single day!", ButtonType.OK);
	public static Alert errorAlert8 = new Alert(AlertType.INFORMATION, "Please select a reservation first", ButtonType.OK);
	public static Alert confirmationAlert13 = new Alert(AlertType.CONFIRMATION, "Do you want to sign out?", ButtonType.OK, ButtonType.CANCEL);
	public static Alert confirmationAlert10 = new Alert(AlertType.CONFIRMATION, "Do you want to modify this reservation?", ButtonType.OK, ButtonType.CANCEL);
	public static Alert confirmationAlert5 = new Alert(AlertType.CONFIRMATION, "Do you want to delete this reservation?", ButtonType.OK, ButtonType.CANCEL);
	public static Alert informationAlert6 = new Alert(AlertType.INFORMATION, "You have successfully booked the room!!", ButtonType.OK);
	public static Alert informationAlert9 = new Alert(AlertType.INFORMATION, "The reservation has been deleted", ButtonType.OK);
	public static Alert informationAlert11 = new Alert(AlertType.INFORMATION, "You have successfully updated the reservation!!", ButtonType.OK);
	public static Alert informationAlert12 = new Alert(AlertType.INFORMATION, "Please check the vaialibility of the changes you want!!", ButtonType.OK);
	public static Alert informationAlert14 = new Alert(AlertType.INFORMATION, "You are signed out. Please re-run the programme!", ButtonType.OK);
	
	// static block to initialize some static elements
	static {
		reservedFromComboBox.getItems()
				.addAll(Arrays.asList("09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00",
						"13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00",
						"18:30", "19:00", "19:30", "20:00", "20:30"));
		reservedToComboBox.getItems()
				.addAll(Arrays.asList("09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30",
						"14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30",
						"19:00", "19:30", "20:00", "20:30", "21:00"));
		reservedFromComboBox.getSelectionModel().select(0);
		reservedToComboBox.getSelectionModel().select(0);
		datePicker.setEditable(false);
	}

	// disable non valid dates( in which the room can't be booked) in calendar
	public static void disableDatesInCalendar() {
		MiscGUIelements.datePicker.setDayCellFactory(picker -> new DateCell() {
			public void updateItem(LocalDate date, boolean empty) {
				super.updateItem(date, empty);
				LocalDate today = LocalDate.now();
				setDisable(empty || date.compareTo(today) < 0 || date.compareTo(today.plusDays(31)) > 0
						|| date.getDayOfWeek() == DayOfWeek.FRIDAY || date.getDayOfWeek() == DayOfWeek.SATURDAY);
			}
		});
	}

	// fill combo box method
	@SuppressWarnings("unchecked")
	public static void fillComboBox(@SuppressWarnings("rawtypes") ComboBox c, String comboBoxQuery, String colName) {
		try {
			Connection conn;
			conn = Database.getConnection();
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery(comboBoxQuery);

			while (resultSet.next())
				c.getItems().addAll(resultSet.getString(colName));

			statement.close();
			Database.closeConnection(conn);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
		c.getSelectionModel().select(0);
	}

	// reset method
	public static void reset() {
		MiscGUIelements.roomTypeComBox.getSelectionModel().clearAndSelect(0);
		MiscGUIelements.roomCapacitySpinn.getValueFactory().setValue(5);
		MiscGUIelements.reservedFromComboBox.getSelectionModel().clearAndSelect(0);
		MiscGUIelements.reservedToComboBox.getSelectionModel().clearAndSelect(0);
		MiscGUIelements.datePicker.setValue(LocalDate.now());
	}
}
