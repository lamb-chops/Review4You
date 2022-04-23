package application.model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;

// Review class contains data manipulation functions for the ReviewController/Review.fxml
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

	// Creates and loads the scene with the Review.fxml file
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
	
	// This function takes in a ComboBox that will be set to all the locations that can be reviewed
	public static void loadData(ComboBox<String> placeList) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./other/locations.txt"));
			StringBuilder sb = new StringBuilder();
			String line = br.readLine();
			
			while(line != null) {
				placeList.getItems().add(line);
				
				sb.append(line);
				line = br.readLine();
			}
			br.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// Takes in two strings one being the user's review and the other the location
	// Data is then written to reviews.txt
	public static void createReview(String review, String location) {
		
		File file = new File("./other/reviews.txt");
		BufferedWriter bf = null;
		
		try {
			bf = new BufferedWriter(new FileWriter(file, true));
				bf.write(location + "," + review);
				bf.newLine();
				
		}catch(IOException e) {
			e.printStackTrace();		
			}
		finally {
			try {
				bf.flush();
				bf.close();
			}
			catch (Exception e) {
			}
		}
	}
	
	

}
