package Controller.DialogController;

import Habitat.Habitat;
import Model.*;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.controlsfx.dialog.Dialogs;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Tiago on 06/01/15.
 */
public class ProjectoFController {

    private Stage dialogStage;
    private Habitat facade;
    private Projecto projecto;
    private boolean okClicked = false;


    @FXML TextField nome_projecto;
    @FXML DatePicker data_inicio;
    @FXML DatePicker data_final;
    @FXML TextField  custo_inicio;
    @FXML TextField  custo_final;
    @FXML TextField classificacao;
    @FXML ComboBox<Candidatura> candidato;

    @FXML Button ok;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setProjecto(Projecto projecto) { this.projecto = projecto; }
    public boolean isOkClicked() { return okClicked; }

    public void initializer(){
        this.initComponents();
        if(this.projecto!=null)
            this.setData();

    }

    public void initComponents(){
        this.candidato.setItems(this.facade.getObservableCA());
        this.data_inicio.setConverter(new StringConverter<LocalDate>() {
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
        this.nome_projecto.setText(this.projecto.getNome_projecto());
        this.data_inicio.setValue(this.projecto.getData_inicio().toLocalDate());
        this.data_final.setValue(this.projecto.getData_final().toLocalDate());
        this.custo_inicio.setText(Integer.toString(this.projecto.getCusto_inicio()));
        this.custo_final.setText(Integer.toString(this.projecto.getCusto_final()));
        this.classificacao.setText(this.projecto.getClassificacao());
        ObservableList<Candidatura> candidaturas = this.candidato.getItems();
        for(Candidatura c : candidaturas){
            if(c.getId() == this.projecto.getCandidatura()){
                this.candidato.getSelectionModel().select(c);
            }
        }



    }

    @FXML
    protected void handleOkAction(){
        Candidatura cc = (Candidatura)this.candidato.getSelectionModel().getSelectedItem();

        if(this.projecto == null)
            this.projecto = new Projecto();

            this.projecto.setNome_projecto(this.nome_projecto.getText());
            if(this.data_inicio.getValue() != null)
                this.projecto.setData_inicio(Date.valueOf(this.data_inicio.getValue()));
            if(this.data_final.getValue() != null)
                this.projecto.setData_inicio(Date.valueOf(this.data_final.getValue()));

            if(!this.custo_inicio.getText().equals(""))
                this.projecto.setCusto_inicio(Integer.parseInt(this.custo_inicio.getText()));
            if(!this.custo_final.getText().equals(""))
                this.projecto.setCusto_final(Integer.parseInt(this.custo_final.getText()));
            this.projecto.setClassificacao(this.classificacao.getText());
            if(this.candidato.getSelectionModel().getSelectedItem() != null)
                this.projecto.setCandidatura(cc.getId());

        try{
            this.facade.adicionarProjecto(projecto);
        }catch (CamposNullException e){
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

}
