import java.sql.SQLException;
import GUI.Buttons;
import GUI.Labels;
import GUI.SceneBuilder;
import Modal.Student;
import Modal.UserSession;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * It's a class that has main method to start the program. Also it calls a few
 * starting methods like attaching event handlers to Buttons and setting style
 * to all GUI elements
 * 
 * @author Amatul Saboor
 * @version 01-04-2020
 */

public class StartProgramme extends Application {

	public static void callStartMethods() {
		SceneBuilder.setStyleVBox();
		Labels.setStyle();
		Buttons.setStyle();
		Buttons.attachEventHandler();
	}

	// start method
	public void start(Stage primaryStage) throws Exception {
		StartProgramme.callStartMethods();
		UserSession.setPrimaryStage(primaryStage);
		SceneBuilder.sceneChange(SceneBuilder.login_title, SceneBuilder.getLoginScene());
	}

	// main method
	public static void main(String[] args) throws SQLException {

		// setting the values of student object by hard coding the values. In an
		// integrated program, these values can be given by main method arguments
		UserSession.setCurrentUser(
				new Student(1, "Ali Mustafa", "ali@ali.com", "ali123", 20, 'M', "Masters Computer Science"));
		Application.launch(args);
	}
}
