package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Tiago on 27/11/14.
 */

public class Utilizador {

    private long id = -1;
    private SimpleStringProperty nome;
    private SimpleStringProperty password;
    private SimpleIntegerProperty conta;

    public Utilizador() {
        this.nome = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.conta = new SimpleIntegerProperty();

    }

    public Utilizador(SimpleStringProperty nome, SimpleStringProperty password, SimpleIntegerProperty conta) {
        this.nome = nome;
        this.password = password;
        this.conta = conta;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome.get();
    }

    @SuppressWarnings("UnusedDeclaration")
    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getPassword() {
        return password.get();
    }

    @SuppressWarnings("UnusedDeclaration")
    public SimpleStringProperty passwordProperty() {
        return password;
    }

    public void setPassword(String password) {
        this.password.set(password);
    }

    public int getConta() {
        return conta.get();
    }

    @SuppressWarnings("UnusedDeclaration")
    public SimpleIntegerProperty contaProperty() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta.set(conta);
    }

    @Override
    public String toString() {
        return "Utilizador{" +
                "id=" + id +
                ", nome=" + nome +
                ", password=" + password +
                ", conta=" + conta +
                '}';
    }
}
