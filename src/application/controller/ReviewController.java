package application.controller;

import java.net.URL;
import java.util.ResourceBundle;

import application.Home;
import application.model.Faq;
import application.model.Recommended;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * ReviewController is in charge of the data flow between the 
 * java file and the fxml view file. Called and created when FXMLLoader
 * loads the Review.fxml file.
 */

public class ReviewController implements Initializable{
	
		String review;
		String selectedLocation;
		
		//instances of other application pages
		Home home;
		Faq faq;
		Recommended recommended;
		
		//generator, called when this class is created to set state
		public ReviewController() {
			recommended = new Recommended();
			home = new Home();
			faq = new Faq();
		}
		
		//private class variables from fxml
		@FXML
	    private ComboBox<String> placeList;

	    @FXML
	    private TextArea reviewText;
	    
	    //init method is called by the fxml loader method when this class is instantiated,
		//but after the generator. This allows us to set the state of the FXML elements for the 
		//set up of this page. Void because only sets up object state
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			Review.loadData(placeList);
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
	    void navToSuggested(ActionEvent event) {
	    	Scene scene = recommended.getScene();
	    	Home.stage.setScene(scene);
	    }

	    @FXML
	    void navToFaq(ActionEvent event) {
	    	Scene scene = faq.getScene();
	    	Home.stage.setScene(scene);
	    }
	    
	    // Retrieves data from user submitted fields reviewText and placeList and sends into to createReview
	    // Once process is completed fields are reset to default
	    @FXML
	    void clickSubmit(ActionEvent event) {
	    	review = reviewText.getText();
	    	selectedLocation = placeList.getSelectionModel().getSelectedItem();
	    	
	    	Review.createReview(review, selectedLocation);
	    	reviewText.clear();
	    	placeList.valueProperty().set(null);
	    } 
	}
