package gui.controllers;

import db.DataBase;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {

		@FXML
		private Label loginMessageLabel;
		@FXML
		private TextField usernameTextField;	
		@FXML
		private PasswordField passwordPasswordField;
		@FXML
		private Button loginButton;
		@FXML
		private Button cancelButton;

		@FXML
		public void cancelButtonOnAction() {
			Stage stage = (Stage) cancelButton.getScene().getWindow();
			stage.close();
		}

		@FXML
		public void loginButtonOnAction(ActionEvent e) {
			
			if (usernameTextField.getText().isBlank() || passwordPasswordField.getText().isBlank()) {
				loginMessageLabel.setText("Please, enter a username and a password!");
			}
			else {
				if (usernameTextField.getText().isBlank() == false && passwordPasswordField.getText().isBlank() == false) {
					validateLogin();
				}

			}
			
		}
		
		
		public void validateLogin() {
			Connection connectDB = DataBase.getConnection();
			
			String verifyLogin = "SELECT count(1) FROM adminaccounts WHERE "
								+ "Username = '" + usernameTextField.getText() + "' AND "
								+ "Password = '" + passwordPasswordField.getText() + "'";
			
			//System.out.println(verifyLogin);
			
			try {
				
				Statement state = connectDB.createStatement();
				
				ResultSet queryResult = state.executeQuery(verifyLogin);
				
				while (queryResult.next()) {
					if (queryResult.getInt(1) == 1) {
						loginMessageLabel.setText("Welcome!");
						
						loginButton.getScene().getWindow().hide();
						
						try {
							
							Parent root = FXMLLoader.load(getClass().getResource("/gui/scenes/index.fxml"));

		                    Stage mainStage = new Stage();
	   
		                    Scene scene = new Scene(root, 750, 550);
		       			 
		                    mainStage.setTitle("REP - Management System");
		        			//loginStage.initStyle(StageStyle.UNDECORATED);
		        			//loginStage.getIcons().add(icon);
		                    mainStage.setScene(scene);
		                    mainStage.setResizable(false);
		                    mainStage.show();
		                    
						}
						catch (IOException e) {
							e.printStackTrace();
						}
						
					}
					else {
						loginMessageLabel.setText("Invalid login, try again!");
					}
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			}	
		}
					
			
}

