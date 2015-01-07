package Controller.DialogController;

import Habitat.Habitat;
import Model.CamposNullException;
import Model.Voluntario;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import org.controlsfx.dialog.Dialogs;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Tiago on 23/12/14.
 */
public class VoluntarioController {


    private Stage dialogStage;
    private Habitat facade;
    private Voluntario voluntario;
    private boolean okClicked = false;


    @FXML TextField nome_voluntario;
    @FXML TextField profissao;
    @FXML TextField morada;
    @FXML TextField contacto;
    @FXML TextField hab_academ;
    @FXML TextField conhec_lingui;
    @FXML TextField exp_voluntariado;
    @FXML TextField disponi_tempo;
    @FXML TextField cca_habitat;

    @FXML DatePicker data_nascimento;
    @FXML ToggleGroup conhec_constr = new ToggleGroup();
    @FXML RadioButton sim_cc;
    @FXML RadioButton nao_cc;
    @FXML ToggleGroup trabalho_grupo = new ToggleGroup();
    @FXML RadioButton sim_tg;
    @FXML RadioButton nao_tg;
    @FXML ToggleGroup pub = new ToggleGroup();
    @FXML RadioButton sim_ri;
    @FXML RadioButton nao_ri;

    @FXML Button ok;



    public void setDialogStage(Stage dialogStage) { this.dialogStage = dialogStage; }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setVoluntario(Voluntario voluntario) { this.voluntario = voluntario; }

    public boolean isOkClicked() { return okClicked; }


    public void initializer(){
        this.initComponents();
        if(this.voluntario!=null){
            this.setData();
        }

    }

    public void initComponents(){
        //Toggle Group for Radio Buttons
        this.sim_cc.setToggleGroup(conhec_constr);
        this.nao_cc.setToggleGroup(conhec_constr);
        this.sim_tg.setToggleGroup(trabalho_grupo);
        this.nao_tg.setToggleGroup(trabalho_grupo);
        this.sim_ri.setToggleGroup(pub);
        this.nao_ri.setToggleGroup(pub);
        this.nao_cc.setSelected(true);
        this.nao_tg.setSelected(true);
        this.nao_ri.setSelected(true);

        this.data_nascimento.setConverter(new StringConverter<LocalDate>() {
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
        this.nome_voluntario.setText(this.voluntario.getNome_voluntario());
        this.data_nascimento.setValue(this.voluntario.getData_nascimento().toLocalDate());
        this.profissao.setText(this.voluntario.getProfissao());
        this.morada.setText(this.voluntario.getMorada());
        this.contacto.setText(this.voluntario.getContacto());
        this.hab_academ.setText(this.voluntario.getHab_academ());
        this.conhec_lingui.setText(this.voluntario.getConhec_lingui());
        this.exp_voluntariado.setText(this.voluntario.getExp_voluntariado());
        this.disponi_tempo.setText(this.voluntario.getDisponi_tempo());
        this.cca_habitat.setText(this.voluntario.getCca_habitat());
        if(this.voluntario.getConhec_constr())
            this.sim_cc.setSelected(true);
        else
            this.nao_cc.setSelected(true);
        if(this.voluntario.getPub())
            this.sim_ri.setSelected(true);
        else
            this.nao_ri.setSelected(true);
        if(this.voluntario.getTrabalho_grupo())
            this.sim_tg.setSelected(true);
        else
            this.nao_tg.setSelected(true);

    }

    public void lockFxml(){
        this.nome_voluntario.setDisable(true);
        this.profissao.setDisable(true);
        this.morada.setDisable(true);
        this.contacto.setDisable(true);
        this.hab_academ.setDisable(true);
        this.conhec_lingui.setDisable(true);
        this.exp_voluntariado.setDisable(true);
        this.disponi_tempo.setDisable(true);
        this.cca_habitat.setDisable(true);
        this.ok.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                dialogStage.close();
            }
        });
    }



    //Button Handlers

    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }

   @FXML
    protected void handleOkAction() {
       RadioButton cc = (RadioButton) this.conhec_constr.getSelectedToggle();
       RadioButton tg = (RadioButton) this.trabalho_grupo.getSelectedToggle();
       RadioButton ri = (RadioButton) this.pub.getSelectedToggle();
       if(this.voluntario == null)
           this.voluntario = new Voluntario();
       this.voluntario.setNome_voluntario(this.nome_voluntario.getText());
       this.voluntario.setData_nascimento(Date.valueOf(this.data_nascimento.getValue()));
       this.voluntario.setProfissao(this.profissao.getText());
       this.voluntario.setMorada(this.morada.getText());
       this.voluntario.setContacto(this.contacto.getText());
       this.voluntario.setHab_academ(this.hab_academ.getText());
       this.voluntario.setConhec_lingui(this.conhec_lingui.getText());
       this.voluntario.setExp_voluntariado(this.exp_voluntariado.getText());
       this.voluntario.setDisponi_tempo(this.disponi_tempo.getText());
       this.voluntario.setCca_habitat(this.cca_habitat.getText());
       if(cc.getText().equals("Sim"))
           this.voluntario.setConhec_constr(true);
       else
           this.voluntario.setConhec_constr(false);
       if(tg.getText().equals("Sim"))
           this.voluntario.setConhec_constr(true);
       else
           this.voluntario.setConhec_constr(false);
       if(ri.getText().equals("Sim"))
           this.voluntario.setConhec_constr(true);
       else
           this.voluntario.setConhec_constr(false);

       try {
           this.facade.adicionarVoluntario(voluntario);
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





}
