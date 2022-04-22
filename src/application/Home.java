package application;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

/**
 * This is the launch section of the app. When ran, the stage and
 * scene are first set to display our opening home page
 */
public class Home extends Application {
	public static Stage stage;
	public static Scene scene;
	//function to create primary stage
	//void because it only sets the stage and scene, nothing to return
	//takes stage as param, so the start method knows which stage to load.
	@Override
	public void start(Stage primaryStage) {
			stage = primaryStage;
			scene = createScene();
			primaryStage.setTitle("Review4You");
			stage.setScene(scene);
			stage.show();
	}
	//Loads the home fxml file, and returns the scene to be set in the app
	public Scene createScene() {
		AnchorPane root;
		Scene scene = null;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("../Home.fxml")); //pulling main fxml to home page
			scene = new Scene(root,800,800); //setting size of window
			return scene;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return scene;
	}
	public static void main(String[] args) {
		launch(args); //launching commands
	}
}