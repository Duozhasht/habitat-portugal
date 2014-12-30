package Controller.DialogController;

import Habitat.Habitat;
import Model.Candidatura;
import Model.Familiar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.sql.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Tiago on 18/12/14.
 */
public class CandidaturaController {

    private Stage dialogStage;
    private Habitat facade;
    private Candidatura candidatura;
    private boolean okClicked = false;



    //Dados do Candidato -> FXML Components
    @FXML TextField nome_candidato;
    @FXML DatePicker data_nascimento;
    @FXML TextField morada;
    @FXML TextField contacto;
    @FXML TextField escolaridade;
    @FXML TextField profissao;
    @FXML TextField naturalidade;
    @FXML TextField nacionalidade;
    @FXML ToggleGroup estado_civil = new ToggleGroup();
    @FXML RadioButton solteiro;
    @FXML RadioButton casado;
    @FXML RadioButton divorciado;
    @FXML RadioButton viuvo;
    @FXML ToggleGroup aprovacao = new ToggleGroup();
    @FXML RadioButton aprovada;
    @FXML RadioButton nao_aprovada;

    //Dados do Agregado Familiar -> FXML Components
    @FXML TextField nome_familiar;
    @FXML DatePicker data_nascimento_familiar;
    @FXML TextField parentesco;
    @FXML TextField ocupacao;
    @FXML TextField escolaridade_familiar;
    @FXML ToggleGroup estado_civil_familiar = new ToggleGroup();
    @FXML RadioButton solteiro_familiar;
    @FXML RadioButton casado_familiar;
    @FXML RadioButton divorciado_familiar;
    @FXML RadioButton viuvo_familiar;
    //Buttons
    @FXML Button ok;
    @FXML Button adicionar;
    @FXML Button remover;
    @FXML Button editar;


    @FXML TableView<Familiar> afTable = new TableView<>();
    ObservableList<Familiar> afList;




    public void setDialogStage(Stage dialogStage) { this.dialogStage = dialogStage; }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setCandidatura(Candidatura candidatura){this.candidatura=candidatura;}

    public boolean isOkClicked() { return okClicked; }

    public void initializer(){
        this.initComponents();
        if(this.candidatura!=null){
            this.setData();
        }

    }


    public void initComponents(){
        //Handle RadioButton Group - estado_civil_candidato
        this.solteiro.setToggleGroup(estado_civil);
        this.casado.setToggleGroup(estado_civil);
        this.divorciado.setToggleGroup(estado_civil);
        this.viuvo.setToggleGroup(estado_civil);
        //Handle RadioButton Group - Candidatura Aprovada
        this.aprovada.setToggleGroup(aprovacao);
        this.nao_aprovada.setToggleGroup(aprovacao);
        //Handle RadioButton Group - estado_civil_agregado_familiar
        this.solteiro_familiar.setToggleGroup(estado_civil_familiar);
        this.casado_familiar.setToggleGroup(estado_civil_familiar);
        this.divorciado_familiar.setToggleGroup(estado_civil_familiar);
        this.viuvo_familiar.setToggleGroup(estado_civil_familiar);
        this.solteiro.setSelected(true);
        this.nao_aprovada.setSelected(true);
        this.solteiro_familiar.setSelected(true);
        this.afList = FXCollections.observableArrayList();
        this.afTable.setItems(afList);
        this.data_nascimento.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

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
        this.data_nascimento_familiar.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

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
        this.nome_candidato.setText(this.candidatura.getNome_candidato());
        this.data_nascimento.setValue(this.candidatura.getData_nascimento().toLocalDate());
        this.morada.setText(this.candidatura.getMorada());
        this.contacto.setText(this.candidatura.getContacto());
        this.escolaridade.setText(this.candidatura.getEscolaridade());
        this.profissao.setText(this.candidatura.getProfissao());
        this.naturalidade.setText(this.candidatura.getNaturalidade());
        this.nacionalidade.setText(this.candidatura.getNacionalidade());
        switch (this.candidatura.getEstado_civil()){
            case "Solteiro":    this.solteiro.setSelected(true);
                break;
            case "Casado":      this.casado.setSelected(true);
                break;
            case "Divorciado":  this.divorciado.setSelected(true);
                break;
            case "Viuvo":       this.viuvo.setSelected(true);
                break;
        }
        if(this.candidatura.getAprovado())
            this.aprovada.setSelected(true);
        else
            this.nao_aprovada.setSelected(true);

        for(Familiar familiar : this.candidatura.getAgregadofamiliar().findByCandidatura(this.candidatura.getId())){
            this.afList.add(familiar);
        }


    }


    public void lockFxml(){
        this.nome_candidato.setDisable(true);
        this.data_nascimento.setDisable(true);
        this.morada.setDisable(true);
        this.contacto.setDisable(true);
        this.escolaridade.setDisable(true);
        this.profissao.setDisable(true);
        this.naturalidade.setDisable(true);
        this.nacionalidade.setDisable(true);

        this.nome_familiar.setDisable(true);
        this.data_nascimento_familiar.setDisable(true);
        this.parentesco.setDisable(true);
        this.ocupacao.setDisable(true);
        this.escolaridade_familiar.setDisable(true);
        this.ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialogStage.close();
            }
        });
        this.adicionar.setDisable(true);
        this.remover.setDisable(true);
        this.editar.setDisable(true);




    }

    public void clearData(){
        this.nome_familiar.clear();
        this.data_nascimento_familiar.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            @Override
            public String toString(LocalDate object) {
                return "";
            }

            @Override
            public LocalDate fromString(String string) {
                return null;
            }
        });
        this.parentesco.clear();
        this.ocupacao.clear();
        this.escolaridade_familiar.clear();

    }






    //Buttons Actions

   @FXML protected void handleOkAction(){
       RadioButton ec_1 = (RadioButton)this.estado_civil.getSelectedToggle();
       RadioButton a = (RadioButton)this.aprovacao.getSelectedToggle();
       if(this.candidatura == null)
           this.candidatura = new Candidatura();
       this.candidatura.setNome_candidato(this.nome_candidato.getText());
       this.candidatura.setData_nascimento(Date.valueOf(this.data_nascimento.getValue()));
       this.candidatura.setMorada(this.morada.getText());
       this.candidatura.setContacto(this.contacto.getText());
       this.candidatura.setEscolaridade(this.escolaridade.getText());
       this.candidatura.setProfissao(this.profissao.getText());
       this.candidatura.setNaturalidade(this.naturalidade.getText());
       this.candidatura.setNacionalidade(this.nacionalidade.getText());
       this.candidatura.setEstado_civil(ec_1.getText());
       if(a.getText().equals("Aprovada"))
           this.candidatura.setAprovado(true);
       else
           this.candidatura.setAprovado(false);

       if(this.facade.adicionarCandidatura(this.candidatura,this.afList))
           dialogStage.close();
       else
           System.out.println("ERRO");

       }


    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }


    @FXML
    protected void handleAdicionarAction(){
            RadioButton ec_2 = (RadioButton)this.estado_civil_familiar.getSelectedToggle();
            Familiar familiar = new Familiar();
            familiar.setNome(this.nome_familiar.getText());
            familiar.setData_nascimento(Date.valueOf(this.data_nascimento.getValue()));
            familiar.setParentesco(this.parentesco.getText());
            familiar.setOcupacao(this.parentesco.getText());
            familiar.setEscolaridade(this.escolaridade.getText());
            familiar.setEstado_civil(ec_2.getText());

            this.afList.add(familiar);
            this.clearData();

        }

    @FXML
    protected void handleRemoverAction(){
        if(this.candidatura!=null){
            this.facade.removerFamiliarCandidatura(this.afTable.getSelectionModel().getSelectedItem());
        }
        this.afList.remove(this.afTable.getSelectionModel().getSelectedItem());

    }

    @FXML
    protected void handleEditarAction(){

    }

}
