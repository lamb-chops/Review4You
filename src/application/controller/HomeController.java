package application.controller;

import application.Home;
import application.model.Faq;
import application.model.Recommended;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;

public class HomeController {
	Faq faq;
	Review review;
	Recommended recommended;
	
	public HomeController() {
		faq = new Faq();
		review = new Review();
		recommended = new Recommended();
	}
	
	@FXML
    void navToFaqs(ActionEvent event) {
		Scene scene = faq.getScene();
    	Home.stage.setScene(scene);
    }
	
	@FXML
    void navToRecommended(ActionEvent event) {
			Scene scene = recommended.getScene();
	    	Home.stage.setScene(scene);
	    }
		
	@FXML
    void navToReview(ActionEvent event) {
		Scene scene = review.getScene();
    	Home.stage.setScene(scene);
    
    }

}
