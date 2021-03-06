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
 * UTSA CS 3443 - Semester Project
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
	
	Review review; //object for review page
	Recommended recommended; //object for recommended page
	public FaqController() { // contructor for faq controller that initializes the objects
		review = new Review();
		recommended = new Recommended();
	}
	
    @FXML
    void navHome(ActionEvent event) { //controls the home button from faq
    	Scene scene = Home.scene; //using Home to call homes create scene
    	Home.stage.setScene(scene);
    }

    @FXML
    void navToReview(ActionEvent event) { //controls button to review from faqs
    	Scene scene = review.getScene(); //review to get review scene
    	Home.stage.setScene(scene);
    }

    @FXML
    void navToPlaces(ActionEvent event) { //controls suggested places button from faqs
    	Scene scene = recommended.getScene();
    	Home.stage.setScene(scene);
    }

    @FXML
    void processFAQ(ActionEvent event) {
    	String key=txtFAQ.getText().toString().toLowerCase(); //converts txt to all lower case
    	key.replaceAll("[\\n\\t ]", "");//changes new lines to nothing
    	if(key.trim().isEmpty()) { //checks if string is empty to re set prompt text
    		txtFAQ.setPromptText("\t\t\tPlease be sure to type your concern!\n");
    	}
    	else{
    		Faq.processedFaq(key);
    		txtFAQ.clear(); //clearing text area
    		txtFAQ.setText("Your concern: \n\n" + "\"" + key + "\"" + "\n\n"+"has been sent to our folks! Thank you for your time!\n");
    		//sets text for confirmation
    	}

    }
}
