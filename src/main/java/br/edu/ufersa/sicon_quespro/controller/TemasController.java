package br.edu.ufersa.sicon_quespro.controller;

import java.net.URL;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.service.TemaService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/temas.fxml")
public class TemasController implements Initializable{
	
	@Autowired
    TemaService temaService;
	
	@Autowired
	Router router;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert btn_salvar != null : "fx:id=\"btn_salvar\" was not injected: check your FXML file 'Untitled'.";
		assert tb_temas != null : "fx:id=\"tb_temas\" was not injected: check your FXML file 'Untitled'.";
		assert tbn_cancel != null : "fx:id=\"tbn_cancel\" was not injected: check your FXML file 'Untitled'.";
		assert txf_nome != null : "fx:id=\"txf_nome\" was not injected: check your FXML file 'Untitled'.";


	}
	
	@FXML
    private Button btn_newTema;

	@FXML
	private Button btn_salvar;

	@FXML
	private TableView<?> tb_temas;

	@FXML
	private Button tbn_cancel;

	@FXML
	private TextField txf_nome;

	@FXML
	private Pane pn_modal;

	@FXML
	void cancelModal(ActionEvent event) {
		pn_modal.setVisible(false);
	}

	@FXML
	void saveTema(ActionEvent event) {

	}
    @FXML
    void openModal(ActionEvent event) {
    	pn_modal.setVisible(true);
    }
	
}