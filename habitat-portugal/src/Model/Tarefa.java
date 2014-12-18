package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author davide on 17/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Tarefa {
    private int id = -1;
    private SimpleStringProperty nome_tarefa;
    private SimpleStringProperty data_inicio;
    private SimpleStringProperty data_final;
    private SimpleIntegerProperty id_encarregado;

    public Tarefa() {
        this.nome_tarefa = new SimpleStringProperty();
        this.data_inicio = new SimpleStringProperty();
        this.data_final = new SimpleStringProperty();
        this.id_encarregado = new SimpleIntegerProperty();
    }

    public Tarefa(SimpleStringProperty nome_tarefa, SimpleStringProperty data_inicio, SimpleStringProperty data_final, SimpleIntegerProperty id_encarregado) {
        this.nome_tarefa = nome_tarefa;
        this.data_inicio = data_inicio;
        this.data_final = data_final;
        this.id_encarregado = id_encarregado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_tarefa() {
        return nome_tarefa.get();
    }

    public SimpleStringProperty nome_tarefaProperty() {
        return nome_tarefa;
    }

    public void setNome_tarefa(String nome_tarefa) {
        this.nome_tarefa.set(nome_tarefa);
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

    public int getId_encarregado() {
        return id_encarregado.get();
    }

    public SimpleIntegerProperty id_encarregadoProperty() {
        return id_encarregado;
    }

    public void setId_encarregado(int id_encarregado) {
        this.id_encarregado.set(id_encarregado);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tarefa{");
        sb.append("id=").append(id);
        sb.append(", nome_tarefa=").append(nome_tarefa);
        sb.append(", data_inicio=").append(data_inicio);
        sb.append(", data_final=").append(data_final);
        sb.append(", id_encarregado=").append(id_encarregado);
        sb.append('}');
        return sb.toString();
    }
}
