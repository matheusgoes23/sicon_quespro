package br.edu.ufersa.sicon_quespro.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.edu.ufersa.sicon_quespro.config.Router;
import br.edu.ufersa.sicon_quespro.model.Questao;
import br.edu.ufersa.sicon_quespro.model.Tema;
import br.edu.ufersa.sicon_quespro.service.QuestaoService;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.util.Callback;
import net.rgielen.fxweaver.core.FxmlView;

@Component
@FxmlView("/questao.fxml")
public class QuestaoController implements Initializable {

	@Autowired
	QuestaoService questaoService;

	@Autowired
	Router router;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		assert btn_newTema != null : "fx:id=\"btn_newTema\" was not injected: check your FXML file 'Untitled'.";
		assert btn_salvar != null : "fx:id=\"btn_salvar\" was not injected: check your FXML file 'Untitled'.";
		assert enunciado != null : "fx:id=\"enunciado\" was not injected: check your FXML file 'Untitled'.";
		assert pn_modal != null : "fx:id=\"pn_modal\" was not injected: check your FXML file 'Untitled'.";
		assert tb_temas != null : "fx:id=\"tb_temas\" was not injected: check your FXML file 'Untitled'.";
		assert tbn_cancel != null : "fx:id=\"tbn_cancel\" was not injected: check your FXML file 'Untitled'.";
		assert txf_item_a != null : "fx:id=\"txf_item_a\" was not injected: check your FXML file 'Untitled'.";
		assert txf_item_b != null : "fx:id=\"txf_item_b\" was not injected: check your FXML file 'Untitled'.";
		assert txf_item_c != null : "fx:id=\"txf_item_c\" was not injected: check your FXML file 'Untitled'.";
		assert txf_item_d != null : "fx:id=\"txf_item_d\" was not injected: check your FXML file 'Untitled'.";
		assert txf_resposta != null : "fx:id=\"txf_resposta\" was not injected: check your FXML file 'Untitled'.";
		assert txf_tema1 != null : "fx:id=\"txf_tema1\" was not injected: check your FXML file 'Untitled'.";
		assert txf_tema2 != null : "fx:id=\"txf_tema2\" was not injected: check your FXML file 'Untitled'.";
		
		startTable(questaoService.listar());
		addButtonToTable();
	}

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Button btn_newTema;

	@FXML
	private Button btn_salvar;

	@FXML
	private TextField enunciado;

	@FXML
	private Pane pn_modal;

	@FXML
	private TableView<Questao> tb_temas;
	
	@FXML
    private TableColumn<Questao, String> column_enunciado;

    @FXML
    private TableColumn<Questao, String> column_id;

   // @FXML
    //private TableColumn<?, ?> column_opc;
    
	@FXML
	private Button tbn_cancel;

	@FXML
	private TextField txf_item_a;

	@FXML
	private TextField txf_item_b;

	@FXML
	private TextField txf_item_c;

	@FXML
	private TextField txf_item_d;

	@FXML
	private TextField txf_resposta;

	@FXML
	private TextField txf_tema1;

	@FXML
	private TextField txf_tema2;
	
	//Edicao
	@FXML
    private Button btn_editar;
	@FXML
    private Pane pn_edit_modal;
	@FXML
    private TextField txf_edit_enunciado;

    @FXML
    private TextField txf_edit_item_a;

    @FXML
    private TextField txf_edit_item_b;

    @FXML
    private TextField txf_edit_item_c;

    @FXML
    private TextField txf_edit_item_d;

    @FXML
    private TextField txf_edit_resposta;

    @FXML
    private TextField txf_edit_tema_a;

    @FXML
    private TextField txf_edit_tema_b;

	@FXML
	void cancelModal(ActionEvent event) {
		pn_modal.setVisible(false);
	}
	@FXML
	void cancelEditModal(ActionEvent event) {
		pn_edit_modal.setVisible(false);
    }
	@FXML
	void openModal(ActionEvent event) {
		pn_modal.setVisible(true);
	}
	void openEditModal() {
		pn_edit_modal.setVisible(true);
	}
	@FXML
	void saveTema(ActionEvent event) {
		Questao questao = new Questao();
		Set<Tema> temas = new HashSet<>();
		Set<String> respostas = new HashSet<>();

		temas.add(new Tema(txf_tema1.getText()));
		temas.add(new Tema(txf_tema1.getText()));

		respostas.add(txf_item_a.getText());
		respostas.add(txf_item_b.getText());
		respostas.add(txf_item_c.getText());
		respostas.add(txf_item_d.getText());

		questao.setEnunciado(enunciado.getText());
		questao.setTemas(temas);
		questao.setRespostas(respostas);
		questao.setVisibilidade(true);
		questao.setCorreta(Integer.parseInt(txf_resposta.getText()));
		// questao.setRespondida(11);
		System.out.println(questaoService.cadastrar(questao).toString());
		// System.out.println(questaoService.editar(id, questao).toString());
		pn_modal.setVisible(false);
		startTable(questaoService.listar());
		
	}
	Long selectedItem = (long) 0;
	@FXML
	void editTema(ActionEvent event) {
		Questao questao = new Questao();
		Set<Tema> temas = new HashSet<>();
		Set<String> respostas = new HashSet<>();

		temas.add(new Tema(txf_edit_tema_a.getText()));
		temas.add(new Tema(txf_edit_tema_b.getText()));

		respostas.add(txf_edit_item_a.getText());
		respostas.add(txf_edit_item_a.getText());
		respostas.add(txf_edit_item_a.getText());
		respostas.add(txf_edit_item_a.getText());

		questao.setEnunciado(txf_edit_enunciado.getText());
		questao.setTemas(temas);
		questao.setRespostas(respostas);
		questao.setVisibilidade(true);
		questao.setCorreta(Integer.parseInt(txf_edit_resposta.getText()));
		
		try {
			questaoService.editar(selectedItem, questao);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void cleanFields() {
		
	}
	public void startTable(List<Questao> questoes) {
		column_id.setCellValueFactory(new PropertyValueFactory<>("id"));
		column_enunciado.setCellValueFactory(new PropertyValueFactory<>("enunciado"));
		//column_id.setCellValueFactory(new PropertyValueFactory<>("id_equipamento"));
		ArrayList<Questao> temp= new ArrayList<>();
		for(int i = 0; i < questoes.size();i++) {
			temp.add(questoes.get(i));
		}
		tb_temas.setItems(FXCollections.observableArrayList(temp));
		//tb_temas.setItems(FXCollections.observableArrayList());
		//ObservableList<Questao> obslist = FXCollections.observableArrayList(temp);
		//tb_temas.setItems(obslist);
	}
	private void addButtonToTable() {
        @SuppressWarnings({ "unchecked", "rawtypes" })
		TableColumn<Questao, Void> colBtn = new TableColumn("Opc");

        Callback<TableColumn<Questao, Void>, TableCell<Questao, Void>> cellFactory = new Callback<TableColumn<Questao, Void>, TableCell<Questao, Void>>() {
            @Override
            public TableCell<Questao, Void> call(final TableColumn<Questao, Void> param) {
                final TableCell<Questao, Void> cell = new TableCell<Questao, Void>() {

                    private final Button btn = new Button("Deletar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            Questao data = getTableView().getItems().get(getIndex());
                            
                            System.out.println("Deletado: " + data);
                            try {
								questaoService.deletar(data.getId());
							} catch (Exception e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
                            startTable(questaoService.listar());
                        });
                    }
                    private final Button editBtn = new Button("Editar");

                    {
                    	editBtn.setOnAction((ActionEvent event) -> {
                            Questao data = getTableView().getItems().get(getIndex());
                            openEditModal();
                            txf_edit_tema_a.setText("");
                    		txf_edit_tema_b.setText("");
                   
                    		
                    		txf_edit_item_a.setText("");
                    		txf_edit_item_a.setText("");
                    		txf_edit_item_a.setText("");
                    		txf_edit_item_a.setText("");

                    		txf_edit_enunciado.setText(data.getEnunciado());
                    	
                    		txf_edit_resposta.setText(Integer.toString( data.getRespondida()));
                            //System.out.println("Editado: " + data);
                           
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

        colBtn.setCellFactory(cellFactory);

        tb_temas.getColumns().add(colBtn);

    }
}