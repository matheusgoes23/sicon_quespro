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
@FxmlView("/dashboard_admin.fxml")
public class DashboardController implements Initializable{

	@Autowired
	Router router;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
    private Button btn_alunos;

    @FXML
    private Button btn_atividade;

    @FXML
    private Button btn_professores;

    @FXML
    private Button btn_questoes;

    @FXML
    private Button btn_sair;

    @FXML
    void exit_app(ActionEvent event) {

    }

    @FXML
    void goToAlunos(ActionEvent event) {

    }

    @FXML
    void goToAtividades(ActionEvent event) {
    	router.navigate(AtividadesController.class, event);
    }

    @FXML
    void goToQuestoes(ActionEvent event) {

    }

    @FXML
    void gotToprofessores(ActionEvent event) {

    }


}
