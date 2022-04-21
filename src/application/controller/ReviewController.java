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


public class ReviewController implements Initializable{
	
		String review;
		String selectedLocation;
		Home home;
		Faq faq;
		Recommended recommended;
		public ReviewController() {
			recommended = new Recommended();
			home = new Home();
			faq = new Faq();
		}
		
		@FXML
	    private ComboBox<String> placeList;

	    @FXML
	    private TextArea reviewText;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
			Review.loadData(placeList);
		}
		
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
	    
	    @FXML
	    void clickSubmit(ActionEvent event) {
	    	review = reviewText.getText();
	    	selectedLocation = placeList.getSelectionModel().getSelectedItem();
	    	
	    	Review.createReview(review, selectedLocation);
	    	reviewText.clear();
	    	placeList.valueProperty().set(null);
	    } 
	}
