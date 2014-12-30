package Controller.DialogController;

import Habitat.Habitat;
import Model.Evento;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Created by Tiago on 30/12/14.
 */
public class EventoController {
    private Stage dialogStage;
    private Habitat facade;
    private Evento evento;
    private boolean okClicked = false;

    @FXML TextField nome_evento;
    @FXML TextField valor_total;
    @FXML TextField organizador;
    @FXML DatePicker data_evento;
    @FXML TextArea notas;

    @FXML Button ok;

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public void setFacade(Habitat facade) {
        this.facade = facade;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public boolean isOkClicked() { return okClicked; }

    public void initializer(){
        this.initComponents();
        if(this.evento!=null)
            this.setData();
    }

    public void initComponents(){
        this.data_evento.setConverter(new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

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
        this.nome_evento.setText(this.evento.getNome_evento());
        this.valor_total.setText(this.evento.getValor_total());
        this.organizador.setText(this.evento.getOrganizador());
        this.notas.setText(this.evento.getNotas());
        this.data_evento.setValue(this.evento.getData_evento().toLocalDate());
    }

    public void lockFxml(){
        this.nome_evento.setDisable(true);
        this.data_evento.setDisable(true);
        this.organizador.setDisable(true);
        this.valor_total.setDisable(true);
        this.notas.setDisable(true);
    }

    @FXML
    protected void handleOkAction(){
        if(this.evento==null)
            this.evento = new Evento();
        this.evento.setNome_evento(this.nome_evento.getText());
        this.evento.setValor_total(this.valor_total.getText());
        this.evento.setNotas(this.notas.getText());
        this.evento.setOrganizador(this.organizador.getText());
        this.evento.setData_evento(Date.valueOf(this.data_evento.getValue()));
        if(this.facade.adicionarEvento(this.evento))
            dialogStage.close();
        else
            System.out.println("Erro");

    }

    @FXML
    protected void handleCancelarAction(ActionEvent e) {

        dialogStage.close();
    }


}
