package Controller.DialogController;

import Habitat.Habitat;
import Model.CamposNullException;
import Model.Doador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Tiago on 30/12/14.
 */
public class DoadorController {

    private Stage dialogStage;
    private Habitat facade;
    private Doador doador;
    private boolean okClicked = false;

    @FXML TextField nome;
    @FXML TextField contacto;
    @FXML TextField telefone;
    @FXML TextField morada;
    @FXML TextField email;
    @FXML TextField site;
    @FXML TextField pessoa_contacto;
    @FXML TextField nif;
    @FXML TextArea notas;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setDoador(Doador doador) {
        this.doador = doador;
    }

    public boolean isOkClicked() { return okClicked; }

    public void initializer(){
        this.initComponents();
        if(this.doador!=null){
            this.setData();
        }

    }

    public void initComponents(){

    }

    public void setData(){
        this.nome.setText(this.doador.getNome());
        this.contacto.setText(this.doador.getContacto());
        this.telefone.setText(this.doador.getTelefone());
        this.morada.setText(this.doador.getMorada());
        this.email.setText(this.doador.getEmail());
        this.site.setText(this.doador.getSite());
        this.pessoa_contacto.setText(this.doador.getPessoa_contacto());
        this.nif.setText(this.doador.getNif());
        this.notas.setText(this.doador.getNotas());
    }

    @FXML protected void handleOkAction(){
        if(this.doador == null) {
            this.doador = new Doador();
            System.out.println("Cheguei ca");
        }

        this.doador.setNome(this.nome.getText());
        this.doador.setContacto(this.contacto.getText());
        this.doador.setTelefone(this.telefone.getText());
        this.doador.setMorada(this.morada.getText());
        this.doador.setEmail(this.email.getText());
        this.doador.setSite(this.site.getText());
        this.doador.setNif(this.nif.getText());
        this.doador.setNotas(this.notas.getText());


        try {
            this.facade.adicionarDoador(this.doador);
            dialogStage.close();
        } catch (CamposNullException e) {
            System.out.println(e.getMessage());
        }

    }


    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }


}
