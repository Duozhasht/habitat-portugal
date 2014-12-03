package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.HashMap;

/**
 * Created by Tiago on 03/12/14.
 */
public class Candidatura {

    SimpleIntegerProperty id;
    SimpleStringProperty nome_candidato;
    SimpleStringProperty data_nascimento;
    SimpleStringProperty morada;
    SimpleStringProperty contacto;
    SimpleStringProperty estado_civil;
    SimpleStringProperty escolaridade;
    SimpleStringProperty profissao;
    SimpleStringProperty naturalidade;
    SimpleStringProperty nacionalidade;
    SimpleBooleanProperty aprovado;
    HashMap<Integer,Familiar> agregadofamiliar;



}
