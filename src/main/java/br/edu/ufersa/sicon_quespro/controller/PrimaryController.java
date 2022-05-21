package br.edu.ufersa.sicon_quespro.controller;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.model.Tema;
import br.edu.ufersa.sicon_quespro.service.QuestaoService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.HashSet;
import java.util.ResourceBundle;
import java.util.Set;

@Component
@FxmlView("/primary.fxml")
public class PrimaryController implements Initializable {

    @Autowired
    Router router;

    @Autowired
    QuestaoService questaoService;

    @FXML
    private TextField txtFullName;

    @FXML
    private void switchToSecondary(ActionEvent event) throws IOException {
        router.navigate(SecondaryController.class, event);
    }

    public void initialize(URL location, ResourceBundle resources) {
        var user = "user: " + Math.random();

        try {
//            testeCriarQuestao();
//            testeListarTodasQuestoes();
//            testeBuscarQuestaoPorId(3L);
//            testeDeletarQuestaoPorId(3L);

        } catch (Exception e) {
            System.out.println("Erro");
        }


        txtFullName.setText(user);
    }

    private void testeDeletarQuestaoPorId(Long id) throws Exception {
        questaoService.deletar(id);
    }

    private void testeListarTodasQuestoes() {
        questaoService.listar().forEach(System.out::println);
    }

    private void testeBuscarQuestaoPorId(Long id) throws Exception {
        System.out.println(questaoService.buscarPorId(id).toString());
    }

    private void testeCriarQuestao() {
        Questao questao = new Questao();
        Set<Tema> temas = new HashSet<>();
        Set<String> respostas = new HashSet<>();

        temas.add(new Tema(1L, "Primeiro Tema"));
        temas.add(new Tema("Primeiro Tema"));
        temas.add(new Tema("Segundo Tema"));

        respostas.add("Primeira Resposta");
        respostas.add("Segunda Resposta");

        questao.setEnunciado("Segunda Questão");
        questao.setTemas(temas);
        questao.setRespostas(respostas);
        questao.setVisibilidade(true);
        questao.setCorreta(7);
        questao.setRespondida(9);

        System.out.println(questaoService.cadastrar(questao).toString());
    }
}