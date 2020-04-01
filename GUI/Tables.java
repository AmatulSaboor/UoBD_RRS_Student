package GUI;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalTime;

import Modal.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.util.Callback;

/**
 * It's a view class for all the TABLES in this program. Also it has all the
 * methods related to tables, such as populating tabel, getting values from
 * selected row of tables etc etc
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

@SuppressWarnings("unchecked")
public class Tables {

	// initializing tables
	@SuppressWarnings("rawtypes")
	public static TableView reservationsByUser = new TableView();
	@SuppressWarnings("rawtypes")
	public static TableView reservationsByOthers = new TableView();
	@SuppressWarnings("rawtypes")
	public static TableView availableRooms = new TableView();
	@SuppressWarnings("rawtypes")
	public static TableView unavailableRooms = new TableView();

	// disabling the clicking property from the tables that are just to show the
	// data
	static {
		Tables.unavailableRooms.setSelectionModel(null);
		Tables.reservationsByOthers.setSelectionModel(null);
	}

	// METHODS FOR TABLES
	// get values from selected row of available rooms' table
	public static boolean getSelectedTutorialRoomValues() {
		@SuppressWarnings("rawtypes")
		ObservableList selectedItem = (ObservableList) availableRooms.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			UserSession.getSelectedRoom().setRoomID(Integer.parseInt((String) selectedItem.get(0)));
			UserSession.getSelectedRoom().setRoomNo(Integer.parseInt((String) selectedItem.get(1)));
			UserSession.getSelectedRoom().setCapacity(Integer.parseInt((String) selectedItem.get(2)));
			UserSession.getSelectedRoom().setProjector(Boolean.parseBoolean((String) selectedItem.get(3)));
			UserSession.getSelectedRoom().setSoundSystem(Boolean.parseBoolean((String) selectedItem.get(4)));
			return true;
		} else
			return false;
	}

	// get values from selected row of reservations by the user's table
	public static boolean getSelectedReservationValues() {
		@SuppressWarnings("rawtypes")
		ObservableList selectedItem = (ObservableList) reservationsByUser.getSelectionModel().getSelectedItem();
		if (selectedItem != null) {
			UserSession.getSelectedReservation().setResID(Integer.parseInt((String) selectedItem.get(0)));
			UserSession.getSelectedReservation().setResName((String) selectedItem.get(1));
			UserSession.getSelectedReservation().setRoomNo(Integer.parseInt((String) selectedItem.get(2)));
			UserSession.getSelectedReservation().setResForDate(Date.valueOf((String) selectedItem.get(3)));
			UserSession.getSelectedReservation()
					.setReservedFrom(Time.valueOf(LocalTime.parse((String) selectedItem.get(4))));
			UserSession.getSelectedReservation()
					.setReservedTo(Time.valueOf(LocalTime.parse((String) selectedItem.get(5))));
			UserSession.getSelectedReservation().setReservedBy(((String) selectedItem.get(6)));
			return true;
		} else
			return false;
	}

	// build/populate data in tables
	@SuppressWarnings({ "rawtypes" })
	public static <E> ObservableList<E> buildData(TableView tableView, String query) {

		ObservableList<E> data;
		Connection c = null;
		data = FXCollections.observableArrayList();
		try {
			c = Database.getConnection();
			ResultSet rs = c.createStatement().executeQuery(query);
			// getting table columns dynamically
			for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
				final int j = i;
				TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i + 1));
				col.setCellValueFactory(
						new Callback<CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
							public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {
								return new SimpleStringProperty(param.getValue().get(j).toString());
							}
						});
				tableView.getColumns().addAll(col);
			}

			// adding data
			while (rs.next()) {
				ObservableList<String> row = FXCollections.observableArrayList(); // iterating row
				for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
					row.add(rs.getString(i));
				}
				data.add((E) row);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error on building data");
		} finally {
			Database.closeConnection(c);
		}
		return (ObservableList<E>) data;
	}

	// insert a reservation method
	public static void insertReservation() {
		try {
			Connection conn;
			conn = Database.getConnection();
			Statement statement = conn.createStatement();

			// checking if the user already has a reservation on that day
			String check = "SELECT * from Reservations where reservedby == \""
					+ UserSession.getCurrentUser().getStdName() + "\" and res_date == \""
					+ UserSession.getSelectedSearchVars().getDate() + "\"";
			String insertQuery = "insert into Reservations values(null, \"" + MiscGUIelements.eventDescription.getText()
					+ "\", " + UserSession.getSelectedRoom().getRoomNo() + ", \""
					+ UserSession.getSelectedSearchVars().getDate() + "\", \""
					+ UserSession.getSelectedSearchVars().getStartTime() + "\", \""
					+ UserSession.getSelectedSearchVars().getEndTime() + "\", \""
					+ UserSession.getCurrentUser().getStdName() + "\")";
			if (!conn.createStatement().executeQuery(check).isBeforeFirst()) {
				statement.executeUpdate(insertQuery);
				statement.close();
				MiscGUIelements.informationAlert6.showAndWait();
				MiscGUIelements.reset();
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
			} else
				MiscGUIelements.errorAlert7.showAndWait();
			Database.closeConnection(conn);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	// delete a reservation method
	public static void deleteReservation(int Res_ID) {
		try {
			Connection conn;
			conn = Database.getConnection();
			Statement statement = conn.createStatement();
			String deleteQuery = "delete from Reservations where Res_ID == " + Res_ID;
			statement.executeUpdate(deleteQuery);
			statement.close();
			Database.closeConnection(conn);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}

	// modify method
	public static void modifyReservation(int Res_ID) {
		try {
			Connection conn;
			conn = Database.getConnection();
			Statement statement = conn.createStatement();

			String modifyQuery = "UPDATE Reservations set res_name = \"" + MiscGUIelements.eventDescription.getText()
					+ "\", res_roomNo = " + UserSession.getSelectedRoom().getRoomNo() + ", res_date = \""
					+ UserSession.getSelectedSearchVars().getDate() + "\", res_startTime = \""
					+ UserSession.getSelectedSearchVars().getStartTime() + "\", res_endTime = \""
					+ UserSession.getSelectedSearchVars().getEndTime() + "\", reservedBy = \""
					+ UserSession.getSelectedReservation().getReservedBy() + "\" where res_ID = " + Res_ID;
			statement.executeUpdate(modifyQuery);
			statement.close();
			Database.closeConnection(conn);
		} catch (SQLException ex) {
			System.out.println(ex);
		}
	}
}
