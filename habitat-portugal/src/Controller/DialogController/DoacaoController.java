package Controller.DialogController;

import Habitat.Habitat;
import Model.Doacao;
import Model.Doador;
import Model.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

/**
 * Created by Tiago on 30/12/14.
 */
public class DoacaoController {

    private Stage dialogStage;
    private Habitat facade;
    private Doacao doacao;
    private boolean okClicked = false;


    @FXML TextArea descricao;
    @FXML TextField quantidade;
    @FXML ToggleGroup tipo = new ToggleGroup();
    @FXML RadioButton servico;
    @FXML RadioButton material;
    @FXML RadioButton monetaria;

    @FXML ComboBox doador;
    @FXML ComboBox evento;


    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setDoacao(Doacao doacao) {
        this.doacao = doacao;
    }

    public boolean isOkClicked() { return okClicked; }

    public void initializer(){
        this.initComponents();
        if(this.doacao!=null){
            this.setData();
        }

    }

    public void initComponents(){
        this.servico.setToggleGroup(tipo);
        this.material.setToggleGroup(tipo);
        this.monetaria.setToggleGroup(tipo);
        this.monetaria.setSelected(true);
    }

    public void setData(){
        this.descricao.setText(this.doacao.getDescricao());
        this.quantidade.setText(this.doacao.getQuantidade());
        if(this.doacao.getTipo().equals("Serviço"))
            this.servico.setSelected(true);
        if(this.doacao.getTipo().equals("Material"))
            this.material.setSelected(true);
        if(this.doacao.getTipo().equals("Monetária"))
            this.monetaria.setSelected(true);


    }

    @FXML protected void handleOkAction(){
        RadioButton rb = (RadioButton)this.tipo.getSelectedToggle();
        Doador dd = (Doador)this.doador.getSelectionModel().getSelectedItem();
        Evento ee = (Evento)this.doador.getSelectionModel().getSelectedItem();
        if(this.doacao == null)
            this.doacao = new Doacao();
        this.doacao.setDescricao(this.descricao.getText());
        this.doacao.setQuantidade(this.quantidade.getText());
        this.doacao.setTipo(rb.getText());
        this.doacao.setDoador(dd.getId());
        this.doacao.setEvento(ee.getId());


        if(this.facade.adicionarDoacao(this.doacao))
            dialogStage.close();
        else
            System.out.println("ERRO");

    }


    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }

}
