package br.edu.ufersa.sicon_quespro.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sicon_quespro.config.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/views/testeTemas.fxml")
public class NewTemasController implements Initializable {

	@Autowired
	Router router;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	private Button temas_btn;

	@FXML
	void newTema(ActionEvent event) {
	

	}

}
