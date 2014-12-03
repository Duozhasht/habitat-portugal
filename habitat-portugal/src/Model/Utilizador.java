package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Tiago on 27/11/14.
 */
public class Utilizador {

    private SimpleStringProperty nome;
    private SimpleStringProperty password;
    private SimpleIntegerProperty conta;


    public Utilizador(SimpleStringProperty nome, SimpleStringProperty password, SimpleIntegerProperty conta) {
        this.nome = nome;
        this.password = password;
        this.conta = conta;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getPassword() {
        return password.get();
    }

    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getConta() {
        return conta.get();
    }

    public SimpleIntegerProperty contaProperty() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta.set(conta);
    }
}
