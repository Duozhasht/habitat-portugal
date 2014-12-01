package Controller;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;

public class ControllerLogin {

    @FXML
    protected void login(ActionEvent e) throws IOException{

        int op = 1;
        int funcao;
        switch (op) {
            case 1:
                funcao = 1;
                break;
            case 2:
                funcao = 2;
                break;
            case 3:
                funcao = 3;
                break;
            default:
                funcao = 0;
                break;
        }

    }
}
