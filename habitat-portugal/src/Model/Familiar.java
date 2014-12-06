package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author Tiago on 03/12/14.
 */
@SuppressWarnings("UnusedDeclaration")
public class Familiar {

    private long id = -1;
    private final SimpleStringProperty nome;
    private final SimpleStringProperty parentesco;
    private final SimpleStringProperty data_nascimento;
    private final SimpleStringProperty estado_civil;
    private final SimpleStringProperty ocupacao;
    private final SimpleStringProperty escolaridade;

    public Familiar(SimpleStringProperty nome, SimpleStringProperty parentesco, SimpleStringProperty data_nascimento, SimpleStringProperty estado_civil, SimpleStringProperty ocupacao, SimpleStringProperty escolaridade) {
        this.nome = nome;
        this.parentesco = parentesco;
        this.data_nascimento = data_nascimento;
        this.estado_civil = estado_civil;
        this.ocupacao = ocupacao;
        this.escolaridade = escolaridade;
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

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
    }

    public String getParentesco() {
        return parentesco.get();
    }

    public SimpleStringProperty parentescoProperty() {
        return parentesco;
    }

    public void setParentesco(String parentesco) {
        this.parentesco.set(parentesco);
    }

    public String getData_nascimento() {
        return data_nascimento.get();
    }

    public SimpleStringProperty data_nascimentoProperty() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento.set(data_nascimento);
    }

    public String getEstado_civil() {
        return estado_civil.get();
    }

    public SimpleStringProperty estado_civilProperty() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil.set(estado_civil);
    }

    public String getOcupacao() {
        return ocupacao.get();
    }

    public SimpleStringProperty ocupacaoProperty() {
        return ocupacao;
    }

    public void setOcupacao(String ocupacao) {
        this.ocupacao.set(ocupacao);
    }

    public String getEscolaridade() {
        return escolaridade.get();
    }

    public SimpleStringProperty escolaridadeProperty() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade.set(escolaridade);
    }

    @Override
    public String toString() {
        return "Familiar{" +
                "id=" + id +
                ", nome=" + nome +
                ", parentesco=" + parentesco +
                ", data_nascimento=" + data_nascimento +
                ", estado_civil=" + estado_civil +
                ", ocupacao=" + ocupacao +
                ", escolaridade=" + escolaridade +
                '}';
    }
}
