package application.helloworld;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

public class HelloWorldController {

	private @FXML Label lblTitle;
	private @FXML Button btnButton1;
	private @FXML TextField txtField1;
	
	// Event Listener on Button.onAction
	@FXML
	public void btnOnClicked(ActionEvent event) {
		lblTitle.setText(txtField1.getText());
	}
}
