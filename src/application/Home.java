package application;
import java.io.File;
import java.net.URL;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

public class Home extends Application {
	@Override
	//takes primarystage as param before loading and displaying main.fxml
	public void start(Stage primaryStage) {
		try {
			URL url = new File("src/Home.fxml").toURI().toURL();
			AnchorPane root = FXMLLoader.load(url);
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}