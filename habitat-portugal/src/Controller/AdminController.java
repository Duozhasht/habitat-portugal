package Controller;

import Controller.DialogController.*;
import Habitat.Habitat;
import Model.*;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Dialog;
import org.controlsfx.dialog.Dialogs;

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
    @FXML  TableView<Candidatura> caTable = new TableView<>();
    @FXML TableView<Candidatura> cnaTable = new TableView<>();
    @FXML TableView<Familiar> fTable = new TableView<>();
    @FXML TableView<Voluntario> vTable = new TableView<>();
    @FXML TableView<Grupo> gTable = new TableView<>();
    @FXML TableView<Evento> eTable = new TableView<>();
    @FXML TableView<Doacao> dcTable = new TableView<>();
    @FXML TableView<Doador> ddTable = new TableView<>();
    @FXML TableView<Projecto> pfTable = new TableView<>();
    @FXML TableView<Projecto> pdTable = new TableView<>();
    @FXML TableView<Projecto> pcTable = new TableView<>();


    //Listas
    private ObservableList<Candidatura> caList;
    private ObservableList<Candidatura> cnaList;
    private ObservableList<Familiar> fList;
    private ObservableList<Voluntario> vList;
    private ObservableList<Grupo> gList;
    private ObservableList<Evento> eList;
    private ObservableList<Doacao> dcList;
    private ObservableList<Doador> ddList;
    private ObservableList<Projecto> pfList;
    private ObservableList<Projecto> pdList;
    private ObservableList<Projecto> pcList;


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
        this.gList = this.facade.getObservableG();
        this.eList = this.facade.getObservableE();
        this.dcList = this.facade.getObservableDC();
        this.ddList = this.facade.getObservableDD();
        this.pfList = this.facade.getObservablePF();
        this.pdList = this.facade.getObservablePD();
        this.pcList = this.facade.getObservablePC();
        this.caTable.setItems(caList);
        this.cnaTable.setItems(cnaList);
        this.fTable.setItems(fList);
        this.vTable.setItems(vList);
        this.gTable.setItems(gList);
        this.eTable.setItems(eList);
        this.dcTable.setItems(dcList);
        this.ddTable.setItems(ddList);
        this.pfTable.setItems(pfList);
        this.pdTable.setItems(pdList);
        this.pcTable.setItems(pcList);
        stage.setTitle("Habitat - Administrador");
        stage.setScene(scene);
        stage.show();
    }


        /*
    ------------------------------------------------------
    ------------------------------------------------------
    Candidatura & Familia TAB
    ------------------------------------------------------
    ------------------------------------------------------

     */

    public void updateTablesCandidatura(){
        this.caList.clear();
        this.caList.addAll(this.facade.getObservableCA());
        this.caTable.setItems(caList);
        this.cnaList.clear();
        this.cnaList.addAll(this.facade.getObservableCNA());
        this.cnaTable.setItems(cnaList);

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




    @FXML
    protected void handleAdicionarCAction() {
        this.showCandidaturaADialog("Adicionar Candidatura");

    }



    @FXML
    protected void handleRemoverCAction() {

        if(this.caTable.getSelectionModel().getSelectedItem()!=null) {
            if (this.facade.getpRepo().findCandidatura(this.caTable.getSelectionModel().getSelectedItem().getId())) {
                return ;
            }
        }

        try{
            if(this.caTable.getSelectionModel().getSelectedItem()!=null)
                this.facade.verificarDependencia(this.caTable.getSelectionModel().getSelectedItem());
        }catch (DependenciaException e){
            Action response = Dialogs.create()
                    .owner(stage)
                    .title("Aviso")
                    .message(e.getMessage())
                    .actions(Dialog.ACTION_OK,Dialog.ACTION_CANCEL)
                    .showConfirm();
            if(response == Dialog.ACTION_OK) {
                if (this.facade.removerCandidatura(this.caTable.getSelectionModel().getSelectedItem()))
                    this.caList.remove(this.caTable.getSelectionModel().getSelectedItem());
                return;
            }
            else
            {System.out.println("ERRO ERRO ERRO");
            return;}
        }
            if (this.facade.removerCandidatura(this.caTable.getSelectionModel().getSelectedItem()))
                this.caList.remove(this.caTable.getSelectionModel().getSelectedItem());
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







    /*
    ------------------------------------------------------
    ------------------------------------------------------
    VOLUNTARIO & GRUPO TAB
    ------------------------------------------------------
    ------------------------------------------------------
     */

    public void updateTablesVoluntario(){
        this.vList.clear();
        this.vList.addAll(this.facade.getObservableV());
        this.vTable.setItems(vList);
    }

    public void updateTablesGrupos(){
        this.gList.clear();
        this.gList.addAll(this.facade.getObservableG());
        this.vTable.setItems(vList);
    }

    private boolean showVoluntarioDialog(String modo){
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

    private boolean showGrupoDialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewGrupo.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            GrupoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Gestão de Grupo"))
                controller.setGrupo(this.gTable.getSelectionModel().getSelectedItem());
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            System.out.println(".");
            this.updateTablesGrupos();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    protected void handleAdicionarVAction() {
        this.showVoluntarioDialog("Adicionar Voluntario");

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
        this.showVoluntarioDialog("Editar Voluntario");

    }

    @FXML
    protected void handleConsultarVAction() {
        this.showVoluntarioDialog("Consultar Voluntario");
    }


    @FXML
    protected void handleAdicionarGAction() {
        this.showGrupoDialog("Adicionar Grupo");

    }




    @FXML
    protected void handleRemoverGAction() {
        try{
            if(this.gTable.getSelectionModel().getSelectedItem()!=null)
                this.facade.verificarDependencia(this.gTable.getSelectionModel().getSelectedItem());
        }catch (DependenciaException e){
            Action response = Dialogs.create()
                    .owner(stage)
                    .title("Aviso")
                    .message(e.getMessage())
                    .actions(Dialog.ACTION_OK,Dialog.ACTION_CANCEL)
                    .showConfirm();
            if(response == Dialog.ACTION_OK){
                if(this.facade.removerGrupo(this.gTable.getSelectionModel().getSelectedItem()))
                    this.gList.remove(this.gTable.getSelectionModel().getSelectedItem());

            }
            else
                return ;
        }
        if(this.gTable.getSelectionModel().getSelectedItem()!=null){
            this.facade.removerGrupo(this.gTable.getSelectionModel().getSelectedItem());
        }
    }


    @FXML
    protected void handleEditarGAction() {
        this.showGrupoDialog("Gestão de Grupo");

    }


        /*
    ------------------------------------------------------
    ------------------------------------------------------
    Eventos e Doacoes TAB
    ------------------------------------------------------
    ------------------------------------------------------
     */

    public void updateTablesEvento(){
        this.eList.clear();
        this.eList.addAll(this.facade.getObservableE());
        this.eTable.setItems(eList);
    }

    public void updateTablesDoacoes(){
        this.dcList.clear();
        this.dcList.addAll(this.facade.getObservableDC());
        this.dcTable.setItems(dcList);
    }

    public void updateTablesDoadores(){
        this.ddList.clear();
        this.ddList.addAll(this.facade.getObservableDD());
        this.ddTable.setItems(ddList);
    }

    private boolean showEventosDialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewEvento.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            EventoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Evento"))
                controller.setEvento(this.eTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Evento")) {
                controller.setEvento(this.eTable.getSelectionModel().getSelectedItem());
                controller.lockFxml();
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            this.updateTablesEvento();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean showDoacaoDialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewDoacao.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            DoacaoController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Doacao"))
                controller.setDoacao(this.dcTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Doacao")) {
                controller.setDoacao(this.dcTable.getSelectionModel().getSelectedItem());
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            this.updateTablesDoacoes();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean showDoadorDialog(String modo){
        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewDoador.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            DoadorController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Doador"))
                controller.setDoador(this.ddTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Doador")) {
                controller.setDoador(this.ddTable.getSelectionModel().getSelectedItem());
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            this.updateTablesDoadores();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }


    @FXML
    protected void handleAdicionarEAction() {
        this.showEventosDialog("Adicionar Evento");

    }




    @FXML
    protected void handleRemoverEAction() {
        if(this.facade.removerEvento(this.eTable.getSelectionModel().getSelectedItem()))
            this.eList.remove(this.eTable.getSelectionModel().getSelectedItem());
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarEAction() {
        this.showEventosDialog("Editar Evento");
    }

    @FXML
    protected void handleAdicionarDCAction() {
        this.showDoacaoDialog("Adicionar Evento");

    }

    @FXML
    protected void handleRemoverDCAction() {
        if(this.facade.removerDoacao(this.dcTable.getSelectionModel().getSelectedItem())){
            this.dcList.remove(this.eTable.getSelectionModel().getSelectedItem());
        }
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarDCAction() {
        this.showDoacaoDialog("Editar Doacao");
    }

    @FXML
    protected void handleAdicionarDDAction() {
        this.showDoadorDialog("Adicionar Doacao");

    }




    @FXML
    protected void handleRemoverDDAction() {
        if(this.facade.removerDoador(this.ddTable.getSelectionModel().getSelectedItem()))
            this.ddList.remove(this.ddTable.getSelectionModel().getSelectedItem());
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarDDAction() {
        this.showDoadorDialog("Editar Doacao");
    }


        /*
    ------------------------------------------------------
    ------------------------------------------------------
    Projectos TAB
    ------------------------------------------------------
    ------------------------------------------------------
     */

    public void updateTablesProjecto() {
        this.pfList.clear();
        this.pfList.addAll(this.facade.getObservablePF());
        this.pfTable.setItems(pfList);
        this.pdList.clear();
        this.pdList.addAll(this.facade.getObservablePD());
        this.pdTable.setItems(pdList);
        this.pcList.clear();
        this.pcList.addAll(this.facade.getObservablePC());
        this.pcTable.setItems(pcList);
    }

    private boolean showProjectFDialog(String modo){

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewProjectoF.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            ProjectoFController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            if(modo.equals("Editar Projecto"))
                controller.setProjecto(this.pfTable.getSelectionModel().getSelectedItem());
            if(modo.equals("Consultar Projecto")) {
                controller.setProjecto(this.pfTable.getSelectionModel().getSelectedItem());
            }
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            this.updateTablesProjecto();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private boolean showMaterialDialog(String modo){

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewMaterial.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            MaterialController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            controller.setProjecto(this.pdTable.getSelectionModel().getSelectedItem());
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            this.updateTablesProjecto();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }

    private boolean showTarefaDialog(String modo){

        try {
            // Load the fxml file and create a new stage for the popup dialog.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(AdminController.class.getResource("/View/DialogView/ViewTarefas.fxml"));
            AnchorPane page = loader.load();

            // Create the dialog Stage.
            Stage dialogStage = new Stage();
            dialogStage.setTitle(modo);
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(this.stage);
            Scene scene = new Scene(page);
            dialogStage.setScene(scene);


            // Set the person into the controller.
            TarefaController controller = loader.getController();
            controller.setDialogStage(dialogStage);
            controller.setFacade(this.facade);
            controller.setProjecto(this.pdTable.getSelectionModel().getSelectedItem());
            controller.initializer();
            // Show the dialog and wait until the user closes it
            dialogStage.showAndWait();
            this.updateTablesProjecto();
            return controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }


    @FXML
    protected void handleAdicionarPFAction() {
        this.showProjectFDialog("Adicionar Projecto");

    }


    @FXML
    protected void handleRemoverPFAction() {
        if(this.facade.removerProjecto(this.pfTable.getSelectionModel().getSelectedItem()))
            this.pfList.remove(this.pfTable.getSelectionModel().getSelectedItem());
        else
            System.out.println("Erro!");
    }


    @FXML
    protected void handleEditarPFAction() {
        this.showProjectFDialog("Editar Projecto");
    }

    @FXML
    protected void handleConsultarPFAction() {
        this.showProjectFDialog("Editar Projecto");
    }


    @FXML
    protected void handleIniciarPFAction(){
        if(this.pfTable.getSelectionModel().getSelectedItem()!=null){
           this.pfTable.getSelectionModel().getSelectedItem().setEstado("Desenvolvimento");
            this.facade.iniciarProjecto(this.pfTable.getSelectionModel().getSelectedItem());
            this.updateTablesProjecto();}
    }

    @FXML
    protected void handleGMAction(){
        this.showMaterialDialog("Gestão de Materiais");
    }

    @FXML
    protected void handleGTAction(){
        this.showTarefaDialog("Gestão de Tarefas");
    }








}
