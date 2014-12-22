package Habitat;

import Controller.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {



    private Habitat facade = new Habitat();

    @Override
    public void start(Stage stage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/View/ViewLogin.fxml"));
        Parent login = fxmlLoader.load();
        LoginController controller = fxmlLoader.getController();
        controller.setFacade(facade);
        controller.setParent(login);
        controller.setScene(new Scene(login,400,300));
        controller.setStage(stage);
        controller.launchController();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
