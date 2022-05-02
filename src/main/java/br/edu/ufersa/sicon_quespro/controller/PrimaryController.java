package br.edu.ufersa.sicon_quespro.controller;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.model.User;
import br.edu.ufersa.sicon_quespro.service.UserService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@Component
@FxmlView("/primary.fxml")
public class PrimaryController implements Initializable {

    @Autowired
    Router router;

    @Autowired
    UserService userService;

    @FXML
    private TextField txtFullName;

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        router.navigate(SecondaryController.class, event);
    }

    public void initialize(URL location, ResourceBundle resources) {
        User user = new User("Nome" + Math.random());

        txtFullName.setText(userService.findById(userService.save(user).getId()).getFullname());
    }


}