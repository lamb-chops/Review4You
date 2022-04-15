package application.controller;

import application.Home;
import application.model.Faq;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class RecommendedController {

	@FXML	
	  private TextField txtFAQ;
		
		Review review;
		Home home;
		Faq faq;
		public RecommendedController() {
			review = new Review();
			home = new Home();
			faq = new Faq();
		}
		
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
