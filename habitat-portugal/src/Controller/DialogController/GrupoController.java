package Controller.DialogController;

import Habitat.Habitat;
import Model.CamposNullException;
import Model.Candidatura;
import Model.Grupo;
import Model.Voluntario;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.dialog.Dialogs;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Tiago on 29/12/14.
 */
@SuppressWarnings("deprecation")
public class GrupoController {

    private Stage dialogStage;
    private Habitat facade;
    private Grupo grupo;
    private boolean okClicked = false;

    @FXML TextField nome_grupo;
    @FXML TextField motivo;
    @FXML DatePicker data_criacao;
    @FXML DatePicker data_final;
    @FXML TextArea notas;

    @FXML ComboBox voluntario;

    @FXML Button ok;
    @FXML Button adicionar;
    @FXML Button remover;
    @FXML Button criar;

    @FXML TableView<Voluntario> vTable = new TableView<>();
    ObservableList<Voluntario> vList;

    ObservableList<Voluntario> vauxList;



    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public boolean isOkClicked(){ return okClicked; }

    public void initializer(){
        this.initComponents();
        if(this.grupo!=null)
            this.setData();
    }

    public void initComponents(){

        this.vList = FXCollections.observableArrayList();
        this.vTable.setItems(vList);
        this.voluntario.setItems(this.facade.getObservableV());

        this.data_criacao.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate object) {
                if(object != null){
                    return dateFormatter.format(object);
                }else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()){
                    return LocalDate.parse(string,dateFormatter);
                }
                else
                    return null;
            }
        });
        this.data_final.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            @Override
            public String toString(LocalDate object) {
                if(object != null){
                    return dateFormatter.format(object);
                }else
                    return "";
            }

            @Override
            public LocalDate fromString(String string) {
                if(string != null && !string.isEmpty()){
                    return LocalDate.parse(string,dateFormatter);
                }
                else
                    return null;
            }
        });
    }

    public void setData(){
        this.nome_grupo.setText(this.grupo.getNome_grupo());
        this.motivo.setText(this.grupo.getMotivo());
        this.data_criacao.setValue(this.grupo.getData_criacao().toLocalDate());
        if(this.grupo.getData_final() != null)
            this.data_final.setValue(this.grupo.getData_final().toLocalDate());
        this.notas.setText(this.grupo.getNotas());
        if(this.grupo.getElementos().findByGrupo(this.grupo.getId_grupo()) != null) {
            for (Voluntario voluntario : this.grupo.getElementos().findByGrupo(this.grupo.getId_grupo())) {
                this.vList.add(voluntario);
            }
        }
    }



    @FXML
    protected  void handleOkAction(){
        if(this.grupo == null){
            this.grupo = new Grupo();
        }

        this.grupo.setNome_grupo(this.nome_grupo.getText());
        this.grupo.setMotivo(this.motivo.getText());
        if(this.data_criacao.getValue()!=null)
            this.grupo.setData_criacao(Date.valueOf(this.data_criacao.getValue()));
        if(this.data_final.getValue()!=null)
            this.grupo.setData_final(Date.valueOf(this.data_final.getValue()));
        this.grupo.setNotas(this.notas.getText());

        try {
            this.facade.adicionarGrupo(this.grupo, this.vList);
                    dialogStage.close();
        } catch (CamposNullException e) {
            Dialogs.create()
                    .owner(dialogStage)
                    .title("Erro")
                    .masthead(null)
                    .message(e.getMessage())
                    .showInformation();
        }

    }

    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }

    @FXML
    protected void handleAdicionarAction(){
        Voluntario aux = (Voluntario)this.voluntario.getSelectionModel().getSelectedItem();
        System.out.println("Aqui");
        System.out.println(aux.toString());
        this.vList.add(aux);
    }

    @FXML
    protected void handleRemoverAction(){
        if(this.grupo!=null)
            this.facade.getgRepo().removeVoluntarioGrupo(this.vTable.getSelectionModel().getSelectedItem().getId_voluntario(),this.grupo.getId_grupo());
        this.vList.remove(this.vTable.getSelectionModel().getSelectedItem());

    }

    @FXML
    protected void handleCriarAction(){}
}
