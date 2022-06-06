package br.edu.ufersa.sicon_quespro.controller;

import br.edu.ufersa.sicon_quespro.config.Router;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/secondary.fxml")
public class SecondaryController implements Initializable {
    @Autowired
    Router router;

    @FXML
    void switchToPrimary(ActionEvent event) throws IOException {
        router.navigate(LoginController.class, event);
    }


    public void initialize(URL location, ResourceBundle resources) {
    }


}