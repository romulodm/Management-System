package application;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SceneController {

	private Stage stage;
	private Scene scene;
	private Parent root;
	
	@FXML
    private Button logout;
	
	@FXML
	public void switchToIndexScene (ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/gui/scenes/index.fxml"));	
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root, 750, 550);
			 
			stage.setTitle("REP - Management System");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void switchToProductsScene (ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/gui/scenes/products.fxml"));	
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root, 750, 550);
			 
			stage.setTitle("REP - Products");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void switchToOrdersScene (ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/gui/scenes/orders.fxml"));	
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root, 750, 550);
			 
			stage.setTitle("REP - Orders");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void switchToAdminScene (ActionEvent event) {
		try {
			root = FXMLLoader.load(getClass().getResource("/gui/scenes/admin.fxml"));	
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root, 750, 550);
			 
			stage.setTitle("REP - Admin");
			stage.setScene(scene);
			stage.setResizable(false);
			stage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@FXML
	public void logOut() {

        try {

            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setTitle("Confirmation Message");
            alert.setHeaderText(null);
            alert.setContentText("Are you sure you want to logout?");
            Optional<ButtonType> option = alert.showAndWait();

            if (option.get().equals(ButtonType.OK)) {

                logout.getScene().getWindow().hide();

                root = FXMLLoader.load(getClass().getResource("/gui/scenes/login.fxml"));
                scene = new Scene(root, 600, 400);
                
                stage = new Stage();
                stage.setTitle("REP - Login");
                stage.setResizable(false);
                stage.setScene(scene);
                stage.show();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
	

}
