package Model;

import Persistence.CandidaturaRepository;
import Persistence.TarefaRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author davide on 17/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Projecto {
    private int id = -1;
    private SimpleStringProperty nome_projecto;
    private SimpleStringProperty data_inicio;
    private SimpleStringProperty data_final;
    private SimpleIntegerProperty custo_inicio;
    private SimpleIntegerProperty custo_final;
    private SimpleStringProperty classificacao;
    private SimpleStringProperty estado;
    private CandidaturaRepository candidatura;
    private TarefaRepository tarefas;

    public Projecto() {
        this.nome_projecto = new SimpleStringProperty();
        this.data_inicio = new SimpleStringProperty();
        this.data_final = new SimpleStringProperty();
        this.custo_inicio = new SimpleIntegerProperty();
        this.custo_final = new SimpleIntegerProperty();
        this.classificacao = new SimpleStringProperty();
        this.estado = new SimpleStringProperty();
    }

    public Projecto(SimpleStringProperty nome_projecto, SimpleStringProperty data_inicio, SimpleStringProperty data_final,
                    SimpleIntegerProperty custo_inicio, SimpleIntegerProperty custo_final, SimpleStringProperty classificacao, SimpleStringProperty estado) {
        this.nome_projecto = nome_projecto;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.custo_inicio = custo_inicio;
        this.custo_final = custo_final;
        this.classificacao = classificacao;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_projecto() {
        return nome_projecto.get();
    }

    public SimpleStringProperty nome_projectoProperty() {
        return nome_projecto;
    }

    public void setNome_projecto(String nome_projecto) {
        this.nome_projecto.set(nome_projecto);
    }

    public String getData_inicio() {
        return data_inicio.get();
    }

    public SimpleStringProperty data_inicioProperty() {
        return data_inicio;
    }

    public void setData_inicio(String data_inicio) {
        this.data_inicio.set(data_inicio);
    }

    public String getData_final() {
        return data_final.get();
    }

    public SimpleStringProperty data_finalProperty() {
        return data_final;
    }

    public void setData_final(String data_final) {
        this.data_final.set(data_final);
    }

    public int getCusto_inicio() {
        return custo_inicio.get();
    }

    public SimpleIntegerProperty custo_inicioProperty() {
        return custo_inicio;
    }

    public void setCusto_inicio(int custo_inicio) {
        this.custo_inicio.set(custo_inicio);
    }

    public int getCusto_final() {
        return custo_final.get();
    }

    public SimpleIntegerProperty custo_finalProperty() {
        return custo_final;
    }

    public void setCusto_final(int custo_final) {
        this.custo_final.set(custo_final);
    }

    public String getClassificacao() {
        return classificacao.get();
    }

    public SimpleStringProperty classificacaoProperty() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao.set(classificacao);
    }

    public String getEstado() {
        return estado.get();
    }

    public SimpleStringProperty estadoProperty() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado.set(estado);
    }

    public CandidaturaRepository getCandidatura() {
        return candidatura;
    }

    public void setCandidatura(CandidaturaRepository candidatura) {
        this.candidatura = candidatura;
    }

    public TarefaRepository getTarefas() {
        return tarefas;
    }

    public void setTarefas(TarefaRepository tarefas) {
        this.tarefas = tarefas;
    }
}
