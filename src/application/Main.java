package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.Parent;

public class Main extends Application {
	
	@Override
	public void start(Stage loginStage) {
		try {
			//Image icon = new Image(getClass().getResourceAsStream("/gui/img/rep-logo-icon.ico"));

			
			Parent root = FXMLLoader.load(getClass().getResource("/gui/scenes/login.fxml"));
			 
			Scene scene = new Scene(root, 600, 400);
			//Scene scene = new Scene(root, 750, 550);
			 
			loginStage.setTitle("REP - Login");
			//loginStage.initStyle(StageStyle.UNDECORATED);
			//loginStage.getIcons().add(icon);
			loginStage.setScene(scene);
			loginStage.setResizable(false);
			loginStage.show();
		 }
		
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
