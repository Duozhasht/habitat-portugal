package Model;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

/**
 * @author Tiago on 03/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Familiar {

    private int id = -1;
    private SimpleStringProperty nome;
    private SimpleStringProperty parentesco;
    private Date data_nascimento;
    private SimpleStringProperty estado_civil;
    private SimpleStringProperty ocupacao;
    private SimpleStringProperty escolaridade;
    private int candidatura = -1;

    public Familiar() {
        this.nome = new SimpleStringProperty();
        this.parentesco = new SimpleStringProperty();
        this.data_nascimento = null;
        this.estado_civil = new SimpleStringProperty();
        this.ocupacao = new SimpleStringProperty();
        this.escolaridade = new SimpleStringProperty();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public int getCandidatura() {
        return candidatura;
    }

    public void setCandidatura(int candidatura) {
        this.candidatura = candidatura;
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
                ", candidatura=" + candidatura +
                '}';
    }

    public void camposOK() throws CamposNullException {
        if (this.getNome().equals("")) throw new CamposNullException("Campo Nome não pode ser vazio");
        if (this.getParentesco().equals("")) throw new CamposNullException("Campo Parentesco não pode ser vazio");
        if (this.getData_nascimento().toString().equals("")) throw new CamposNullException("Campo Data Nascimento não pode ser vazio");
        if (this.getEstado_civil().equals("")) throw new CamposNullException("Campo Estado Civil não pode ser vazio");
        if (this.getOcupacao().equals("")) throw new CamposNullException("Campo Ocupação não pode ser vazio");
        if (this.getEscolaridade().equals("")) throw new CamposNullException("Campo Escolaridade não pode ser vazio");
    }
}
