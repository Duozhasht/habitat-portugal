package Model;

import Persistence.VoluntarioRepository;
import javafx.beans.property.SimpleStringProperty;

import java.util.ArrayList;
import java.util.List;

/**
 * @author davide on 21/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Grupo {
    private int id_grupo = -1;
    private SimpleStringProperty nome_grupo;
    private SimpleStringProperty motivo;
    private SimpleStringProperty data_criacao;
    private SimpleStringProperty data_final;
    private SimpleStringProperty notas;
    private List<Integer> id_voluntarios;

    public Grupo() {
        this.nome_grupo = new SimpleStringProperty();
        this.motivo = new SimpleStringProperty();
        this.data_criacao = new SimpleStringProperty();
        this.data_final = new SimpleStringProperty();
        this.notas = new SimpleStringProperty();
        this.id_voluntarios = new ArrayList<>();
    }

    public Grupo(SimpleStringProperty nome_grupo, SimpleStringProperty motivo, SimpleStringProperty data_criacao,
                 SimpleStringProperty data_final, SimpleStringProperty notas, List<Integer> id_voluntarios) {
        this.nome_grupo = nome_grupo;
        this.motivo = motivo;
        this.data_criacao = data_criacao;
        this.data_final = data_final;
        this.notas = notas;
        this.id_voluntarios = id_voluntarios;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNome_grupo() {
        return nome_grupo.get();
    }

    public SimpleStringProperty nome_grupoProperty() {
        return nome_grupo;
    }

    public void setNome_grupo(String nome_grupo) {
        this.nome_grupo.set(nome_grupo);
    }

    public String getMotivo() {
        return motivo.get();
    }

    public SimpleStringProperty motivoProperty() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo.set(motivo);
    }

    public String getData_criacao() {
        return data_criacao.get();
    }

    public SimpleStringProperty data_criacaoProperty() {
        return data_criacao;
    }

    public void setData_criacao(String data_criacao) {
        this.data_criacao.set(data_criacao);
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

    public String getNotas() {
        return notas.get();
    }

    public SimpleStringProperty notasProperty() {
        return notas;
    }

    public void setNotas(String notas) {
        this.notas.set(notas);
    }

    public List<Integer> getId_voluntarios() {
        return id_voluntarios;
    }

    public void setId_voluntarios(List<Integer> id_voluntarios) {
        this.id_voluntarios = id_voluntarios;
    }

    @Override
    public String toString() {
        return "Grupo{" +
                "id_grupo=" + id_grupo +
                ", nome_grupo=" + nome_grupo +
                ", motivo=" + motivo +
                ", data_criacao=" + data_criacao +
                ", data_final=" + data_final +
                ", notas=" + notas +
                ", id_voluntarios=" + id_voluntarios +
                '}';
    }
}
