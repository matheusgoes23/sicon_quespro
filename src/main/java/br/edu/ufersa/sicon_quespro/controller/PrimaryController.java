package br.edu.ufersa.sicon_quespro.controller;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.model.Tema;
import br.edu.ufersa.sicon_quespro.service.QuestaoService;
import br.edu.ufersa.sicon_quespro.service.TemaService;
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

    @Autowired
    TemaService temaService;

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
//            questaoService.listarPublicas().forEach(System.out::println);
//            testeBuscarQuestaoPorId(10L);
//            testeTornarQuestaoPublica(10L, false);
//            testeDeletarQuestaoPorId(3L);
//            testeEditarQuestao(10L);
//            temaService.cadastrar(new Tema("Novo tema"));
//            temaService.deletar(13L);
//            temaService.editar(12L, new Tema("Novo tema"));
//            temaService.listar().forEach(System.out::println);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        txtFullName.setText(user);
    }

    private void testeTornarQuestaoPublica(Long id, boolean visibilidade) throws Exception {
        questaoService.tornarPublica(id, visibilidade);
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

    private void testeEditarQuestao(Long id) throws Exception {
        Questao questao = new Questao();
        Set<Tema> temas = new HashSet<>();
        Set<String> respostas = new HashSet<>();

        temas.add(new Tema(1L, "Primeiro Tema"));
        temas.add(new Tema("Terceira Tema"));
        temas.add(new Tema("Quarta Tema"));

        respostas.add("Terceira Resposta");
        respostas.add("Quarta Resposta");

        questao.setEnunciado("Segunda Questão");
        questao.setTemas(temas);
        questao.setRespostas(respostas);
        questao.setVisibilidade(false);
        questao.setCorreta(10);
        questao.setRespondida(11);

        System.out.println(questaoService.editar(id, questao).toString());
    }
}