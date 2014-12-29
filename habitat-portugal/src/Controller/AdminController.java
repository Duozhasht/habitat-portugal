package Controller;

import Controller.DialogController.CandidaturaController;
import Controller.DialogController.VoluntarioController;
import Habitat.Habitat;
import Model.Candidatura;
import Model.Familiar;
import Model.Voluntario;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * Created by Tiago on 12/12/14.
 */
public class AdminController {

    private Habitat facade;

    private Parent parent;
    private Scene scene;
    private Stage stage;

    //Tabelas
    @FXML TableView<Candidatura> caTable = new TableView<>();
    @FXML TableView<Candidatura> cnaTable = new TableView<>();
    @FXML TableView<Familiar> fTable = new TableView<>();
    @FXML TableView<Voluntario> vTable = new TableView<>();


    //Listas
    ObservableList<Candidatura> caList;
    ObservableList<Candidatura> cnaList;
    ObservableList<Familiar> fList;
    ObservableList<Voluntario> vList;


    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setParent(Parent parent) {
        this.parent = parent;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void launchController(){
        this.caList = this.facade.getObservableCA();
        this.cnaList = this.facade.getObservableCNA();
        this.fList = this.facade.getObservableF();
        this.vList = this.facade.getObservableV();
        this.caTable.setItems(caList);
        this.cnaTable.setItems(cnaList);
        this.fTable.setItems(fList);
        this.vTable.setItems(vList);
        stage.setTitle("Habitat - Administrador");
        stage.setScene(scene);
        stage.show();
    }



    public void updateTablesCandidatura(){
        this.caList.clear();
        this.caList.addAll(this.facade.getObservableCA());
        this.caTable.setItems(caList);
        this.cnaList.clear();
        this.cnaList.addAll(this.facade.getObservableCNA());
        this.cnaTable.setItems(cnaList);

    }



    public void updateTablesVoluntario(){
        this.vList.clear();
        this.vList.addAll(this.facade.getObservableV());
        this.vTable.setItems(vList);
    }

    private boolean showCandidaturaADialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewCandidatura.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            CandidaturaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Candidatura"))
                controller.setCandidatura(this.caTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Candidatura")) {
                controller.setCandidatura(this.caTable.getSelectionModel().getSelectedItem());
                controller.lockFxml();
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            System.out.println("Trolololol");
            this.updateTablesCandidatura();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean showCandidaturaNADialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewCandidatura.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            CandidaturaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Candidatura"))
                controller.setCandidatura(this.cnaTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Candidatura")) {
                controller.setCandidatura(this.cnaTable.getSelectionModel().getSelectedItem());
                controller.lockFxml();
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            System.out.println("asdasda");
            this.updateTablesCandidatura();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean showCandidaturaVDialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewVoluntario.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            VoluntarioController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Voluntario"))
                controller.setVoluntario(this.vTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Voluntario")) {
                controller.setVoluntario(this.vTable.getSelectionModel().getSelectedItem());
                controller.lockFxml();
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            System.out.println(".");
            this.updateTablesVoluntario();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }




    @FXML
    protected void handleAdicionarCAction() {
        this.showCandidaturaADialog("Adicionar Candidatura");

    }



    @FXML
    protected void handleRemoverCAction() {
        if(this.facade.removerCandidatura(this.caTable.getSelectionModel().getSelectedItem()))
            this.caList.remove(this.caTable.getSelectionModel().getSelectedItem());
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarCAction() {
        this.showCandidaturaADialog("Editar Candidatura");

    }

    @FXML
    protected void handleConsultarCAction() {
        this.showCandidaturaADialog("Consultar Candidatura");
    }

    @FXML
    protected void handleAdicionarCNAction() {
        this.showCandidaturaNADialog("Adicionar Candidatura");

    }



    @FXML
    protected void handleRemoverCNAction() {
        if(this.facade.removerCandidatura(this.cnaTable.getSelectionModel().getSelectedItem()))
            this.cnaList.remove(this.cnaTable.getSelectionModel().getSelectedItem());
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarCNAction() {
        this.showCandidaturaNADialog("Editar Candidatura");

    }

    @FXML
    protected void handleConsultarCNAction() {
        this.showCandidaturaNADialog("Consultar Candidatura");
    }

    @FXML
    protected void handleAdicionarVAction() {
        this.showCandidaturaVDialog("Adicionar Voluntario");

    }



    @FXML
    protected void handleRemoverVAction() {
        if(this.facade.removerVoluntario(this.vTable.getSelectionModel().getSelectedItem()))
            this.vList.remove(this.vTable.getSelectionModel().getSelectedItem());
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarVAction() {
        this.showCandidaturaVDialog("Editar Voluntario");

    }

    @FXML
    protected void handleConsultarVAction() {
        this.showCandidaturaVDialog("Consultar Voluntario");
    }

}
