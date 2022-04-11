package application.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Review {
	public Scene scene;
	public Scene getScene() {
		if (scene == null) { //checking if scene null before creating scene again
			scene = createScene();
		}
		return scene;
	}
	public void setScene(Scene scene) {
		this.scene = scene;
	}

	public Scene createScene() {
		AnchorPane root;
		Scene scene = null;
		try {
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("../../Review.fxml")); //pulling main fxml to home page
			scene = new Scene(root,800,800); //setting size of window
			return scene;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene;
	}

}
