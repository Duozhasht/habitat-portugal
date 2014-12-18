package Controller;


import Habitat.Habitat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {


    private Habitat facade;

    private Parent parent;
    private Scene scene;
    private Stage stage;

    //FXML ELEMENTS
    @FXML
    private TextField nome;
    @FXML
    private PasswordField password;



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
        stage.setTitle("Habitat - Login");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    protected void handleLoginAction(ActionEvent e) throws Exception{
        if(this.nome.getText() != null && this.password.getText() != null){
           switch (this.facade.login(this.nome.getText(),this.password.getText())){
               case 1 : System.out.println("Gestão de Candidatura");
                   break;
               case 2 : System.out.println("Gestão de Projectos");
                   break;
               case 3 : System.out.println("Gestão de Voluntários");
                   break;
               case 0 : this.startAdminController();
                   break;
               default: System.out.println("Erro de Login");
                   break;
           }
        }


    }

    private void startAdminController() throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ViewAdmin.fxml"));
        Parent admin = (Parent)fxmlLoader.load();
        AdminController controller = fxmlLoader.<AdminController>getController();
        controller.setFacade(this.facade);
        controller.setParent(admin);
        controller.setScene(new Scene(admin,1000,600));
        controller.setStage(this.stage);
        controller.launchController();
    }
}
