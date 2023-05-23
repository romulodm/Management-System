package gui.controllers;

import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import application.SceneController;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.fxml.FXML;

public class AdminController extends SceneController{
	@FXML
	private Hyperlink trelloLink;
	
	@FXML
	public void trelloLinkOnAction (ActionEvent e) throws URISyntaxException {
		Hyperlink link = new Hyperlink("https://www.google.com");
		try {
			Desktop.getDesktop().browse(new URI(link.getText()));
		} 
		catch (IOException error) {
			error.printStackTrace();
		}

	}
}
