package Modal;

import javafx.stage.Stage;

/**
 * It's a class that is used to save all the necessary details of a user from
 * the time he/she is signed in until the time he/she gets signed out. After
 * that, this class will have all the values to null
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class UserSession {

	// instance variables
	public static Student currentUser;
	public static Stage primaryStage;
	public static TutorialRoom selectedRoom = new TutorialRoom(0, 0, 0, false, false);
	public static Reservations selectedReservation = new Reservations(0, null, 0, null, null, null, null);
	public static SearchVars selectedSearchVars = new SearchVars();
	public static boolean modifyStatus = false;

	// getters and setters
	public static SearchVars getSelectedSearchVars() {
		return selectedSearchVars;
	}

	public static void setSelectedSearchVars(SearchVars selectedSearchVars) {
		UserSession.selectedSearchVars = selectedSearchVars;
	}

	public static TutorialRoom getSelectedRoom() {
		return selectedRoom;
	}

	public static void setSelectedRoom(TutorialRoom selectedRoom) {
		UserSession.selectedRoom = selectedRoom;
	}

	public static Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void setPrimaryStage(Stage primaryStage) {
		UserSession.primaryStage = primaryStage;
	}

	static public Student getCurrentUser() {
		return currentUser;
	}

	static public void setCurrentUser(Student currentUser) {
		UserSession.currentUser = currentUser;
	}

	public static Reservations getSelectedReservation() {
		return selectedReservation;
	}

	public static void setSelectedReservation(Reservations selectedReservation) {
		UserSession.selectedReservation = selectedReservation;
	}

	public static boolean getModifyStatus() {
		return UserSession.modifyStatus;
	}

	public static void setModifyStatus(boolean status) {
		UserSession.modifyStatus = status;
	}
}
