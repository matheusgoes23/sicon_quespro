package br.edu.ufersa.sicon_quespro.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.model.Atividade;
import br.edu.ufersa.sicon_quespro.service.AtividadeService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/atividades.fxml")
public class AtividadesController implements Initializable{
	
	@Autowired
    Router router;
	
	@Autowired
	AtividadeService atividadeService;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		startTable(atividadeService.listar());
		addButtonToTable();
	}
	@FXML
    private Button btn_alunos;

    @FXML
    private Button btn_atividade;

    @FXML
    private Button btn_nova;

    @FXML
    private Button btn_professores;

    @FXML
    private Button btn_questoes;

    @FXML
    private Button btn_sair;

    @FXML
    private TableView<Atividade> tb_atividades;

    @FXML
    private TableColumn<Atividade, String> tbc_disciplina;

    @FXML
    private TableColumn<Atividade, String> tbc_id;

    @FXML
    private TableColumn<Atividade, String> tbc_semestre;

    @FXML
    private TableColumn<Atividade, String> tbc_titulo;

    @FXML
    void exit_app(ActionEvent event) {

    }

    @FXML
    void goToAlunos(ActionEvent event) {

    }

    @FXML
    void goToAtividades(ActionEvent event) {
    	router.navigate(DashboardController.class, event);
    }

    @FXML
    void goToNewAtiidade(ActionEvent event) {
    	router.navigate(NovaAtividadeController.class, event);
    }

    @FXML
    void goToQuestoes(ActionEvent event) {

    }

    @FXML
    void gotToprofessores(ActionEvent event) {

    }
    public void startTable(List<Atividade> questoes) {
		tbc_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		tbc_titulo.setCellValueFactory(new PropertyValueFactory<>("titulo"));
		tbc_disciplina.setCellValueFactory(new PropertyValueFactory<>("disciplina"));
		tbc_semestre.setCellValueFactory(new PropertyValueFactory<>("semestre"));
		ArrayList<Atividade> temp= new ArrayList<>();
		for(int i = 0; i < questoes.size();i++) {
			temp.add(questoes.get(i));
		}
		tb_atividades.setItems(FXCollections.observableArrayList(temp));
		
	}
    private void addButtonToTable() {
        @SuppressWarnings({ "unchecked", "rawtypes" })
		TableColumn<Atividade, Void> colBtn = new TableColumn("Opc");

        Callback<TableColumn<Atividade, Void>, TableCell<Atividade, Void>> cellFactory = new Callback<TableColumn<Atividade, Void>, TableCell<Atividade, Void>>() {
            @Override
            public TableCell<Atividade, Void> call(final TableColumn<Atividade, Void> param) {
                final TableCell<Atividade, Void> cell = new TableCell<Atividade, Void>() {
                    private final Button btn = new Button("Deletar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Atividade data = getTableView().getItems().get(getIndex());
                            
                            System.out.println("Deletado: " + data);
                            try {
								atividadeService.deletar(data.getId());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            startTable(atividadeService.listar());
                        });
                    }
                  
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                            //setGraphic(editBtn);
                        }
                    }
                };
                return cell;
            }
        };
        @SuppressWarnings({ "unchecked", "rawtypes" })
		TableColumn<Atividade, Void> colEditBtn = new TableColumn("Edit");
        Callback<TableColumn<Atividade, Void>, TableCell<Atividade, Void>> cellFactory2 = new Callback<TableColumn<Atividade, Void>, TableCell<Atividade, Void>>() {
            @Override
            public TableCell<Atividade, Void> call(final TableColumn<Atividade, Void> param) {
                final TableCell<Atividade, Void> cell = new TableCell<Atividade, Void>() {
            
                    private final Button editBtn = new Button("Editar");

                    {
                    	editBtn.setOnAction((ActionEvent event) -> {
                           
                        });
                    }
                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                           
                            setGraphic(editBtn);
                        }
                    }
                };
                return cell;
            }
        };
        colBtn.setCellFactory(cellFactory);
        colEditBtn.setCellFactory(cellFactory2);
        tb_atividades.getColumns().add(colBtn);
        tb_atividades.getColumns().add(colEditBtn);
    }
}
