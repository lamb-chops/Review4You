package application.controller;

import application.Home;
import application.model.Faq;
import application.model.Recommended;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class ReviewController {
		
		Home home;
		Faq faq;
		Recommended recommended;
		public ReviewController() {
			recommended = new Recommended();
			home = new Home();
			faq = new Faq();
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
	    void processFAQ(ActionEvent event) {

	    }
	}
