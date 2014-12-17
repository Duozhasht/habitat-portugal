package Controller;

import Habitat.Habitat;
import Model.Candidatura;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

/**
 * @author Tiago on 12/12/14.
 */
public class AdminController {

    private Habitat facade;

    private Parent parent;
    private Scene scene;
    private Stage stage;

    //Listas
    @FXML
    TableView<Candidatura> CandidaturaTable = new TableView<>();

    ObservableList<Candidatura> CandidaturaList;



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
        this.CandidaturaList = this.facade.getObservableList();
        this.CandidaturaTable.setItems(CandidaturaList);
        stage.setTitle("Habitat - Administrador");
        stage.setScene(scene);
        stage.show();
    }
}
