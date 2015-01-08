package Controller.DialogController;

import Habitat.Habitat;
import Model.CamposNullException;
import Model.Material;
import Model.Projecto;
import Model.Stock;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by Tiago on 06/01/15.
 */
@SuppressWarnings("deprecation")
public class MaterialController {

    private Stage dialogStage;
    private Habitat facade;
    private Projecto projecto;
    private boolean okClicked = false;

    @FXML TextField quant_necessaria;
    @FXML TextField quant_actual;
    @FXML ComboBox materiais;

    @FXML
    TableView<Material> mTable = new TableView<>();

    ObservableList<Material> mList;







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
        this.mList = this.facade.getObservableMP(this.projecto.getId());
        this.mTable.setItems(mList);
        this.materiais.setItems(this.facade.getObservableS());

    }

    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }

    @FXML
    protected void handleOkAction(ActionEvent e) {

        dialogStage.close();
    }

    @FXML
    protected void handleAdicionarMAction(){
        Stock mm = (Stock) this.materiais.getSelectionModel().getSelectedItem();

        Material material = new Material();
        material.setDescricao(mm.getDescricao());
        material.setStock_id(mm.getId_stock());
        material.setQuant_actual(this.quant_actual.getText());
        material.setQuant_necessaria(this.quant_necessaria.getText());
        try{
            this.facade.adicionarMaterialProjecto(material,this.projecto);
        }catch (CamposNullException e){
            System.out.println("asdasd");
        }
    }

    @FXML
    protected void handleRemoverMAction(){

    }

    @FXML
    protected void handleActualizarMAction(){

    }






}
