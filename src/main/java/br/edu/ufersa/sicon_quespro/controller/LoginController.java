package br.edu.ufersa.sicon_quespro.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sicon_quespro.config.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/login.fxml")
public class LoginController implements Initializable {

	@Autowired
	Router router;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	private void switchToPrimary(ActionEvent event) throws IOException{
		router.navigate(PrimaryController.class, event);
	}
}
