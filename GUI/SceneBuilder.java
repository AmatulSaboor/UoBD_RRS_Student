package GUI;

import Modal.UserSession;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * It's a view class for creating and showing SCENES in the program. If a scene
 * is being called first time, the method creates it otherwise the scene is
 * returned to the calling method
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class SceneBuilder {

	// initializing root for scene
	private static VBox logInSceneRoot = new VBox();
	private static VBox welcomeSceneRoot = new VBox();
	private static VBox showReservationRoot = new VBox();
	private static VBox showReservationDetailsRoot = new VBox();
	private static VBox reserveA_RoomRoot = new VBox();
	private static VBox availableRoomRoot = new VBox();
	private static VBox okFinalReservationRoot = new VBox();

	// setting titles for every screen
	public static String login_title = "Log In Screen";
	public static String welcome_title = "Welcome " + UserSession.getCurrentUser().getStdName();
	public static String showReservation_title = "Show Reservation";
	public static String reservationDetails_title = "Reservation Details";
	public static String reserveA_room_title = "Reserve A Room";
	public static String availableRooms_title = "Available Rooms";
	public static String okReservation_title = "Ok Reservation";

	// 0 - log in scene get and init methods
	public static VBox getLoginScene() {
		if (logInSceneRoot.getChildren().isEmpty()) {
			logInSceneRoot.getChildren().addAll(Buttons.START);
		}
		return logInSceneRoot;
	}

	// 1 - welcome scene get and init methods
	public static VBox getWelcomeScene() {
		if (welcomeSceneRoot.getChildren().isEmpty()) {
			welcomeSceneRoot.getChildren().addAll(createHeader(), Buttons.RESERVATIONS, Buttons.RESERVE_NOW);
		}
		return welcomeSceneRoot;
	}

	// 2 - show reservation scene get and init methods
	public static VBox getShowReservationsScene() {
		if (showReservationRoot.getChildren().isEmpty()) {
			showReservationRoot.getChildren().addAll(createHeader(), Labels.ROOMS_RESERVED_BY_YOU,
					Tables.reservationsByUser, Buttons.SHOW_DETAILS_OF_SELECTED_RESERVATION,
					Labels.ROOMS_RESERVED_BY_OTHERS, Tables.reservationsByOthers, Buttons.createBackBtn());
		}
		return showReservationRoot;
	}

	// 3 - show reservation details scene get and init methods
	public static VBox getShowReservationsDetailsScene() {
		if (showReservationDetailsRoot.getChildren().isEmpty()) {
			showReservationDetailsRoot.getChildren().addAll(createHeader(), Labels.roomTypeAndNo, Labels.reservedBy,
					Labels.resForDate, Labels.reservedForTime, Labels.reservedForEvent, Buttons.DELETE, Buttons.MODIFY,
					Buttons.createBackBtn());
		}
		return showReservationDetailsRoot;
	}

	// 4 - reserve a room scene get and init methods
	public static VBox getReserveA_RoomScene() {
		if (reserveA_RoomRoot.getChildren().isEmpty()) {
			reserveA_RoomRoot.getChildren().addAll(createHeader(), Labels.ROOM_TYPE, MiscGUIelements.roomTypeComBox,
					Labels.DATE, MiscGUIelements.datePicker, Labels.CAPACITY, MiscGUIelements.roomCapacitySpinn,
					Labels.RESERVED_FROM, MiscGUIelements.reservedFromComboBox, Labels.RESERVED_TILL,
					MiscGUIelements.reservedToComboBox, Buttons.CEHCK_AVAIALIBILITY, Buttons.RESET,
					Buttons.createBackBtn());
		}
		return reserveA_RoomRoot;
	}

	// 5 - available/unavailable rooms screen (check availability button click) get
	// and init methods
	public static VBox getAvailableRoomScene() {
		if (availableRoomRoot.getChildren().isEmpty()) {
			availableRoomRoot.getChildren().addAll(createHeader(), Labels.availableRooms, Tables.availableRooms,
					Buttons.RESERVE_SELECTED_ROOM, Labels.unavailableRooms, Tables.unavailableRooms,
					Buttons.createBackBtn());
		}
		return availableRoomRoot;
	}

	// 6 - OK final reservation scene get and init methods
	public static VBox getOkFinalReservation() {
		if (okFinalReservationRoot.getChildren().isEmpty())
			okFinalReservationRoot.getChildren().addAll(createHeader(), Labels.descriptionLabel, Labels.SELECT_COURSE,
					MiscGUIelements.coursesComboBox, Labels.COURSE_ID, MiscGUIelements.courseIDcomboBox,
					Labels.EVENT_DESCRIPTION, MiscGUIelements.eventDescription, Buttons.RESERVE, Buttons.MODIFY_FINAL,
					Buttons.CANCEL, Buttons.createBackBtn());
		return okFinalReservationRoot;
	}

	// create header method
	public static HBox createHeader() {
		HBox header = new HBox();

		header.setPadding(new Insets(15, 12, 15, 12));
		header.setSpacing(150);
		header.setStyle("-fx-background-color: #4AB7E0;");
		header.getChildren().addAll(Labels.createSystemNameLabel(), Labels.createWelcomeUserLabel(),
				Buttons.createSignOutBtn());
		return header;
	}

	// scene change method
	public static void sceneChange(String title, VBox newRoot) {
		if (UserSession.getPrimaryStage().getScene() == null)
			UserSession.getPrimaryStage().setScene(new Scene(newRoot, 870, 700));
		else
			UserSession.getPrimaryStage().getScene().setRoot(newRoot);
		UserSession.getPrimaryStage().setTitle(title);
		UserSession.getPrimaryStage().show();

	}

	// styling all VBoxes
	public static void styleVBox(VBox vbox) {
		vbox.setPadding(new Insets(20, 20, 20, 20));
		vbox.setSpacing(20);
	}

	// calling style methods to all VBoxes
	public static void setStyleVBox() {
		SceneBuilder.styleVBox(logInSceneRoot);
		SceneBuilder.styleVBox(welcomeSceneRoot);
		SceneBuilder.styleVBox(showReservationRoot);
		SceneBuilder.styleVBox(showReservationDetailsRoot);
		SceneBuilder.styleVBox(reserveA_RoomRoot);
		SceneBuilder.styleVBox(availableRoomRoot);
		SceneBuilder.styleVBox(okFinalReservationRoot);
	}
}
