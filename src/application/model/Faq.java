/**
 * Faq.java
 * 
 * This is responsible for launching the FAQ
 * scene which involves a get scene function 
 * and create scene function based on faq fxml
 * 
 * @author Thomas Jondahl (rbs287)
 * UTSA CS 3443 - Semester project
 * Spring 2022
 */

package application.model;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;

public class Faq {
	public Scene scene;
	
	public static void processedFaq(String key) { // function that controls what is done with text area string
		return;
	}
	public Scene getScene() {
		if (scene == null) { //checking if scene null before creating scene again
			scene = createScene(); //calling create scene function into scene
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
			root = (AnchorPane)FXMLLoader.load(getClass().getResource("../../Faqs.fxml")); //pulling main fxml to home page
			scene = new Scene(root,800,800); //setting size of window
			return scene;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return scene; //returns scene
	}

}
