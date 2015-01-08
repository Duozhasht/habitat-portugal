package Controller.DialogController;

import Habitat.Habitat;
import Model.Projecto;
import Model.Tarefa;
import Model.Voluntario;
import Model.VoluntarioTarefa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Tiago on 06/01/15.
 */
public class TarefaController {
    private Stage dialogStage;
    private Habitat facade;
    private Projecto projecto;
    private boolean okClicked = false;

    @FXML TextField nome_tarefa;
    @FXML TextField encarregado;
    @FXML DatePicker data_inicio;
    @FXML DatePicker data_final;

    @FXML TextField descricao;
    @FXML TextField nr_horas;
    @FXML ComboBox<Voluntario> voluntario;

    @FXML
    TableView<Tarefa> tTable = new TableView<>();
    @FXML TableView<VoluntarioTarefa> vtTable= new TableView<>();

    ObservableList<Tarefa> tList;
    ObservableList<VoluntarioTarefa> vtList;





    public void setProjecto(Projecto projecto) {
        this.projecto = projecto;
    }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isOkClicked() { return okClicked; }

    public void initializer(){
        initComponents();

    }
    public void initComponents(){
        this.data_final.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            @Override
            public String toString(LocalDate object) {
                if (object != null) {
                    return dateFormatter.format(object);
                } else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else
                    return null;
            }
        });
        this.data_inicio.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            @Override
            public String toString(LocalDate object) {
                if (object != null) {
                    return dateFormatter.format(object);
                } else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else
                    return null;
            }
        });
        this.tList = this.facade.getObservableT(this.projecto.getId());
        this.tTable.setItems(tList);
        this.vtList = FXCollections.observableArrayList();
        this.vtTable.setItems(vtList);
    }

    @FXML
    protected void handleAdicionarTAction(){
        Tarefa tarefa = new Tarefa();
        tarefa.setEncarregado(this.encarregado.getText());
        tarefa.setData_inicio(Date.valueOf(this.data_inicio.getValue()));
        tarefa.setData_final(Date.valueOf(this.data_final.getValue()));
        tarefa.setNome_tarefa(this.nome_tarefa.getText());
        tarefa.setProjecto_id(this.projecto.getId());

    }

    @FXML
    protected void handleRemoverTAction(){


    }

    @FXML
    protected void handleAdicionarVAction(){
        VoluntarioTarefa voluntarioTarefa = new VoluntarioTarefa();
        voluntarioTarefa.setDescricao(this.descricao.getText());
        voluntarioTarefa.setId_tarefa(this.tTable.getSelectionModel().getSelectedItem().getId());
        voluntarioTarefa.setId_voluntario(this.voluntario.getSelectionModel().getSelectedItem().getId_voluntario());
        voluntarioTarefa.setNr_horas(this.nr_horas.getText());

        //////

    }

    @FXML
    protected void handleRemoverVAction(){

    }




}
