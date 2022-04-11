package application.controller;

import application.Home;
import application.model.Recommended;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextField;

public class FaqController {
	@FXML
    private TextField txtFAQ;
	
	Review review;
	Recommended recommended;
	public FaqController() {
		review = new Review();
		recommended = new Recommended();
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
    void navToPlaces(ActionEvent event) {
    	Scene scene = recommended.getScene();
    	Home.stage.setScene(scene);
    }

    @FXML
    void processFAQ(ActionEvent event) {

    }
}
