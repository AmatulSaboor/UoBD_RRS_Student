package Controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import GUI.*;
import Modal.UserSession;
import javafx.event.EventHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

/**
 * It's a controller class that has all the event handlers that are attached to
 * all the buttons of the system. This class calls different methods from other
 * classes depending on the need. It has the logic that how the program's flow
 * should be
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class ButtonController {

	// RESERVATION button event
	public static EventHandler<MouseEvent> reservationBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ControllerHelper.fillReservationTables();
			SceneBuilder.sceneChange(SceneBuilder.showReservation_title, SceneBuilder.getShowReservationsScene());
		}
	};

	// RESERVE NOW button event
	public static EventHandler<MouseEvent> reserveNowBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ControllerHelper.startReserveScene();
			SceneBuilder.sceneChange(SceneBuilder.reserveA_room_title, SceneBuilder.getReserveA_RoomScene());
		}
	};

	// CHECK AVAILIBILITY button event
	public static EventHandler<MouseEvent> checkAvailibilityBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			ControllerHelper.storeSearchVars();

			LocalTime startTime = LocalTime.parse(UserSession.getSelectedSearchVars().getStartTime(),
					DateTimeFormatter.ISO_LOCAL_TIME);
			LocalTime endTime = LocalTime.parse(UserSession.getSelectedSearchVars().getEndTime(),
					DateTimeFormatter.ISO_LOCAL_TIME);

			// condition to check if the user has selected current date and the time has
			// already passed
			if (UserSession.getSelectedSearchVars().getDate().compareTo(LocalDate.now()) == 0
					&& startTime.compareTo(LocalTime.now()) < 0)
				MiscGUIelements.errorAlert1.showAndWait();

			// if start time is less than or equal to end time
			else if (startTime.compareTo(endTime) >= 0)
				MiscGUIelements.errorAlert2.showAndWait();

			// if the duration of the reservation is more than one and a half hour
			else if (startTime.plusMinutes(90).compareTo(endTime) < 0)
				MiscGUIelements.errorAlert3.showAndWait();

			// if everything is fine
			else {
				ControllerHelper.fillRoomsTable();
				ControllerHelper.setLabelsForAvailableRoom();
				SceneBuilder.sceneChange(SceneBuilder.availableRooms_title, SceneBuilder.getAvailableRoomScene());
			}
		}
	};

	// RESERVE_SELECTED_ROOM button event
	public static EventHandler<MouseEvent> reserveSelectedRowEvenet = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			if (Tables.getSelectedTutorialRoomValues()) {
				ControllerHelper.startOkReserveScene();
				if (UserSession.getModifyStatus())
					Buttons.RESERVE.setDisable(true);
				else
					Buttons.MODIFY_FINAL.setDisable(true);
				SceneBuilder.sceneChange(SceneBuilder.okReservation_title, SceneBuilder.getOkFinalReservation());
			} else
				MiscGUIelements.errorAlert4.showAndWait();
		}
	};

	// RESET button event
	public static EventHandler<MouseEvent> resetBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			MiscGUIelements.reset();
		}
	};

	// SHOW_DETAILS_OF_SELECTED_RESERVATION button event
	public static EventHandler<MouseEvent> showDetailsOfSelectedReservationEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if (Tables.getSelectedReservationValues()) {
				ControllerHelper.setLabelsForShowDetailsScene();
				SceneBuilder.sceneChange(SceneBuilder.reservationDetails_title,
						SceneBuilder.getShowReservationsDetailsScene());
			} else
				MiscGUIelements.errorAlert8.showAndWait();
		}
	};

	// DELETE button event
	public static EventHandler<MouseEvent> deleteBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Optional<ButtonType> result = MiscGUIelements.confirmationAlert5.showAndWait();
			if (result.get() == ButtonType.OK) {
				Tables.deleteReservation(UserSession.getSelectedReservation().getResID());
				MiscGUIelements.informationAlert9.showAndWait();
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
			}
		}
	};

	// MODIFY button event
	public static EventHandler<MouseEvent> modifyBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if (Tables.getSelectedReservationValues()) {
				ControllerHelper.startReserveScene();
				UserSession.setModifyStatus(true);
				SceneBuilder.sceneChange(SceneBuilder.reserveA_room_title, SceneBuilder.getReserveA_RoomScene());
				// Buttons.BACK.setDisable(true);
				MiscGUIelements.informationAlert12.showAndWait();
			} else
				MiscGUIelements.errorAlert8.showAndWait();
		}
	};

	// RESERVE button event
	public static EventHandler<MouseEvent> reserveBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Tables.insertReservation();
		}
	};

	// MODIFY_FINAL button event
	public static EventHandler<MouseEvent> modifyFinalButtonEvent = new EventHandler<MouseEvent>() {

		@Override
		public void handle(MouseEvent event) {
			Optional<ButtonType> result = MiscGUIelements.confirmationAlert10.showAndWait();
			if (result.get() == ButtonType.OK) {
				Tables.modifyReservation(UserSession.getSelectedReservation().getResID());
				MiscGUIelements.informationAlert11.showAndWait();
				UserSession.setModifyStatus(false);
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
			}
		}
	};

	// CANCEL button event
	public static EventHandler<MouseEvent> cancelBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			SceneBuilder.sceneChange(SceneBuilder.reserveA_room_title, SceneBuilder.getReserveA_RoomScene());
		}
	};

	// SIGN OUT button event
	public static EventHandler<MouseEvent> signOutBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			Optional<ButtonType> result = MiscGUIelements.confirmationAlert13.showAndWait();
			if (result.get() == ButtonType.OK) {
				UserSession.setModifyStatus(false);
				UserSession.setSelectedReservation(null);
				UserSession.setSelectedRoom(null);
				UserSession.setSelectedSearchVars(null);
				UserSession.setCurrentUser(null);
				SceneBuilder.sceneChange(SceneBuilder.login_title, SceneBuilder.getLoginScene());
			}
		}
	};

	// START button event
	public static EventHandler<MouseEvent> startBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			if (UserSession.getCurrentUser() == null)
				MiscGUIelements.informationAlert14.showAndWait();
			else
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
		}
	};

	// BACK button event
	public static EventHandler<MouseEvent> backBtnEvent = new EventHandler<MouseEvent>() {
		@Override
		public void handle(MouseEvent event) {
			VBox currentScene = (VBox) UserSession.getPrimaryStage().getScene().getRoot();

			if (currentScene == SceneBuilder.getShowReservationsScene()) {
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
			} else if (currentScene == SceneBuilder.getReserveA_RoomScene()) {
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
			} else if (currentScene == SceneBuilder.getAvailableRoomScene()) {
				SceneBuilder.sceneChange(SceneBuilder.reserveA_room_title, SceneBuilder.getReserveA_RoomScene());
			} else if (currentScene == SceneBuilder.getOkFinalReservation()) {
				SceneBuilder.sceneChange(SceneBuilder.availableRooms_title, SceneBuilder.getAvailableRoomScene());
			} else if (currentScene == SceneBuilder.getShowReservationsDetailsScene()) {
				SceneBuilder.sceneChange(SceneBuilder.showReservation_title, SceneBuilder.getShowReservationsScene());
			} else {
				SceneBuilder.sceneChange(SceneBuilder.welcome_title, SceneBuilder.getWelcomeScene());
			}
		}
	};
}
