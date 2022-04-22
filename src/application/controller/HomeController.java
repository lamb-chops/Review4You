package application.controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

import application.Home;
import application.model.Faq;
import application.model.Recommended;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * The HomeController handles the flow of data between Home.java and 
 * the home.fxml view file. It loads the locations from the two files
 * and displays it into the appropriate fxml text area
 */
public class HomeController {
	//class variables
	Faq faq;
	Review review;
	Recommended recommended;
	
	//private fxml elements of the view
	@FXML
    private TextArea recommend, recent;
	
	//generator, called when homecontroller class is called from another file
	//no return types or params, as it is initializing variables for the class
	public HomeController() {
		faq = new Faq();
		review = new Review();
		//recommended = new Recommended();
	}
	
	//init method, called when object is first created to set up class state
	//Reads in the two files line by line and appends to appropriate textarea
	//void return type as it is setting up object state only
	 public void initialize() {
		try {
			BufferedReader br = new BufferedReader(new FileReader("./other/suggested.txt"));
			String line = br.readLine();
			
			while(line != null) {
				recommend.appendText(line+"\n");
				line = br.readLine();
			}			
			br.close();
		} catch(IOException e) {
			e.printStackTrace();		
		}
		try {
			BufferedReader br = new BufferedReader(new FileReader("./other/locations.txt"));
			String line = br.readLine();
			
			while(line != null) {
				recent.appendText(line+"\n");
				line = br.readLine();
			}	
			br.close();
		} catch(IOException e) {
			e.printStackTrace();		
		}
    }
	//These last methods are to navigate to the relevant page when clicked on in the fxml file
	 //void as the method changes the fxml page only, takes actionevent as param
	@FXML
    void navToFaqs(ActionEvent event) {
		Scene scene = faq.getScene();
    	Home.stage.setScene(scene);
    }
	@FXML
    void navToRecommended(ActionEvent event) {
		try {
			URL url = new File("src/Recommended.fxml").toURI().toURL();
			AnchorPane anchor = FXMLLoader.load(url);
			Scene scene = new Scene(anchor);
			Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	@FXML
    void navToReview(ActionEvent event) {
		Scene scene = review.getScene();
    	Home.stage.setScene(scene);   
    }
}
