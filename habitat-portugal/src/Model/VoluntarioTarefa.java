package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author davide on 06/01/15.
 */

@SuppressWarnings("UnusedDeclaration")
public class VoluntarioTarefa {
    private int id_voluntario_tarefa = -1;
    private int id_voluntario = -1;
    private int id_tarefa = -1;
    private SimpleStringProperty nomeVoluntario;
    private SimpleStringProperty descricao;
    private SimpleStringProperty nr_horas;

    public VoluntarioTarefa() {
        this.nomeVoluntario = new SimpleStringProperty();
        this.descricao = new SimpleStringProperty();
        this.nr_horas = new SimpleStringProperty();
    }

    public int getId_voluntario_tarefa() {
        return id_voluntario_tarefa;
    }

    public void setId_voluntario_tarefa(int id_voluntario_tarefa) {
        this.id_voluntario_tarefa = id_voluntario_tarefa;
    }

    public int getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public int getId_tarefa() {
        return id_tarefa;
    }

    public void setId_tarefa(int id_tarefa) {
        this.id_tarefa = id_tarefa;
    }

    public String getNomeVoluntario() {
        return nomeVoluntario.get();
    }

    public SimpleStringProperty nomeVoluntarioProperty() {
        return nomeVoluntario;
    }

    public void setNomeVoluntario(String nomeVoluntario) {
        this.nomeVoluntario.set(nomeVoluntario);
    }

    public String getDescricao() {
        return descricao.get();
    }

    public SimpleStringProperty descricaoProperty() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao.set(descricao);
    }

    public String getNr_horas() {
        return nr_horas.get();
    }

    public SimpleStringProperty nr_horasProperty() {
        return nr_horas;
    }

    public void setNr_horas(String nr_horas) {
        this.nr_horas.set(nr_horas);
    }
}
