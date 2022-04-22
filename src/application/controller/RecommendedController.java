package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import application.Home;
import application.model.Faq;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

/**
 * RecommendedController is in charge of the data flow between the 
 * java file and the fxml view file. Called and created when FXMLLoader
 * loads the recommended.fxml file.
 */
public class RecommendedController {
	
	//private class variables from fxml 
	@FXML	
	private TextArea reviewField;
	
	//instances of other application pages
	Review review;
	Home home;
	Faq faq;
	
	//generator, called when this class is created to set state
	public RecommendedController() {
		review = new Review();
		home = new Home();
		faq = new Faq();
	}
	//init method is called by the fxml loader method when this class is instantiated,
	//but after the generator. This allows us to set the state of the FXML elements for the 
	//set up of this page. Void because only sets up object state
	 @FXML
	 public void initialize() {	
		try {
			BufferedReader br = new BufferedReader(new FileReader("./other/reviews.txt"));
			String line = br.readLine();
			while(line != null) {
				String[] attributes = line.split(",");
				reviewField.appendText("- "+attributes[0]+": \""+attributes[1]+"\"\n\n");
				line = br.readLine();			
			}			
			br.close();
		} catch(IOException e) {
				e.printStackTrace();		
		}
	}
	 //these methods below are for navigation. They take an actionevent
	 //as a param before loading the appropriate page. Void return type as 
	 //only the app page is changing.
	   @FXML
	   void navHome(ActionEvent event) {
	   		Scene scene = Home.scene;
	   		Home.stage.setScene(scene);	    
       }
	    @FXML
	    void navToReview(ActionEvent event) {
	    	Scene scene = review.getScene();
	    	Home.stage.setScene(scene);
	    }
	    @FXML
	    void navToFaq(ActionEvent event) {
	    	Scene scene = faq.getScene();
	    	Home.stage.setScene(scene);
	    }
	    @FXML
	    void processFAQ(ActionEvent event) {

	    }
	}
