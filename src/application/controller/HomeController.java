package application.controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import application.Home;
import application.model.Faq;
import application.model.Recommended;
import application.model.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;

public class HomeController {
	Faq faq;
	Review review;
	Recommended recommended;
	
	@FXML
    private TextArea recommend, recent;
	
	public HomeController() {
		faq = new Faq();
		review = new Review();
		recommended = new Recommended();
	}
	
	
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
