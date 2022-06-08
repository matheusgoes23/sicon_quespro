package br.edu.ufersa.sicon_quespro.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.model.Atividade;
import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.service.AtividadeService;
import br.edu.ufersa.sicon_quespro.service.QuestaoService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/novaAtividade.fxml")
public class NovaAtividadeController implements Initializable {

	@Autowired
	QuestaoService questaoService;

	@Autowired
	AtividadeService atividadeService;
	@Autowired
	Router router;

	List<Questao> selectedQuestions = new ArrayList<>();

	public void initialize(URL location, ResourceBundle resources) {
		startTable(questaoService.listar());
		addButtonToTable();
	}

	@FXML
	private Button btn_alunos;

	@FXML
	private Button btn_atividade;

	@FXML
	private Button btn_cancelar;

	@FXML
	private Button btn_nova_questao;

	@FXML
	private Button btn_professores;

	@FXML
	private Button btn_questoes;

	@FXML
	private Button btn_sair;

	@FXML
	private Button btn_salvar;

	@FXML
	private TableView<Questao> tb_questao;

	@FXML
	private TableColumn<Questao, String> column_enunciado;

	@FXML
	private TableColumn<Questao, String> column_id;

	@FXML
	private TextField txf_semestre;

	@FXML
	private TextField txf_titulo;

	@FXML
	void backToAtividades(ActionEvent event) {
		router.navigate(AtividadesController.class, event);
	}

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
	void goToQuestao(ActionEvent event) {
		router.navigate(QuestaoController.class, event);
	}

	@FXML
	void goToQuestoes(ActionEvent event) {
		router.navigate(NovaAtividadeController.class, event);
	}

	@FXML
	void gotToprofessores(ActionEvent event) {

	}

	@FXML
	void save(ActionEvent event) {
		Atividade a = new Atividade();
		a.setSemestre(txf_semestre.getText());
		a.setTitulo(txf_titulo.getText());
		// Set<Questao> questoesMap = new HashSet<>(selectedQuestions);
		a.setQuestoes(selectedQuestions);
		a.setDisciplina(null);
		if (a.getTitulo() != "" || a.getQuestoes() != null) {

			try {
				atividadeService.cadastrar(a);
				goToAtividades(event);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	// Methods
	public void startTable(List<Questao> questoes) {
		column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		column_enunciado.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
		// column_id.setCellValueFactory(new PropertyValueFactory<>("id_equipamento"));
		ArrayList<Questao> temp = new ArrayList<>();
		for (int i = 0; i < questoes.size(); i++) {
			temp.add(questoes.get(i));
		}
		tb_questao.setItems(FXCollections.observableArrayList(temp));
		// tb_temas.setItems(FXCollections.observableArrayList());
		// ObservableList<Questao> obslist = FXCollections.observableArrayList(temp);
		// tb_temas.setItems(obslist);
	}

	private void addButtonToTable() {
		@SuppressWarnings({ "unchecked", "rawtypes" })
		TableColumn<Questao, Void> colBtn = new TableColumn("Opc");

		Callback<TableColumn<Questao, Void>, TableCell<Questao, Void>> cellFactory = new Callback<TableColumn<Questao, Void>, TableCell<Questao, Void>>() {
			@Override
			public TableCell<Questao, Void> call(final TableColumn<Questao, Void> param) {
				final TableCell<Questao, Void> cell = new TableCell<Questao, Void>() {
					private final CheckBox btn = new CheckBox("");

					{
						btn.setOnAction((ActionEvent event) -> {
							Questao data = getTableView().getItems().get(getIndex());

							if (btn.isSelected()) {

								// System.out.println("Selecionado: " + data);
								selectedQuestions.add(data);
								System.out.println(selectedQuestions.toString());
							} else {

								// System.out.println("Desselecionado: " + data);
								selectedQuestions.remove(data);
								System.out.println(selectedQuestions.toString());
							}

						});
					}

					@Override
					public void updateItem(Void item, boolean empty) {
						super.updateItem(item, empty);
						if (empty) {
							setGraphic(null);
						} else {
							setGraphic(btn);
							// setGraphic(editBtn);
						}
					}
				};
				return cell;
			}
		};

		colBtn.setCellFactory(cellFactory);

//        tb_questao.getColumns().add(colBtn);

		tb_questao.getColumns().add(0, colBtn);
	}
}
