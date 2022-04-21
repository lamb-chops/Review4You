/**
 * FaqController.java
 *This controls the FAQ page
 *and is control of recieving the button inputs
 *and doing proper action based on input
 *
 *Process faq make sure user followed proper 
 *format and then stores question or concern
 *void navHome, navToReview, navToPlaces, constructor
 * @author Thomas Jondahl (rbs287)
 * UTSA CS 3443 - Lab 5
 * Spring 2022
 */

package application.controller;

import application.Home;
import application.model.Faq;
import application.model.Recommended;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class FaqController {
	@FXML
    private TextArea txtFAQ;
	
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
    	String key=txtFAQ.getText().toString().toLowerCase();
    	key.replaceAll("[\\n\\t ]", "");
    	if(key.trim().isEmpty()) {
    		txtFAQ.setPromptText("\t\t\tPlease be sure to type your concern!\n");
    	}
    	else{
    		Faq.processedFaq(key);
    		txtFAQ.clear();
    		txtFAQ.setText("Your concern: \n\n" + "\"" + key + "\"" + "\n\n"+"has been sent to our folks! Thank you for your time!\n");
    	}

    }
}
