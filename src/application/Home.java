package application;
import java.io.IOException;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Home extends Application {
	public static Stage stage;
	public static Scene scene;
	//function to create primary stage
	@Override
	public void start(Stage primaryStage) {
			stage = primaryStage;
			scene = createScene();
			primaryStage.setTitle("Review4You");
			stage.setScene(scene);
			stage.show();
	}
	public Scene createScene() {
		AnchorPane root;
		Scene scene = null;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("../Home.fxml")); //pulling main fxml to home page
			scene = new Scene(root,800,800); //setting size of window
			return scene;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}
	public static void main(String[] args) {
		launch(args); //launching commands
	}
}