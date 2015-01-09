package Model;

import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

/**
 * @author davide on 17/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Tarefa {
    private int id = -1;
    private SimpleStringProperty nome_tarefa;
    private Date data_inicio;
    private Date data_final;
    private SimpleStringProperty encarregado;
    private int projecto_id = -1;

    public Tarefa() {
        this.nome_tarefa = new SimpleStringProperty();
        this.data_inicio = null;
        this.data_final = null;
        this.encarregado = new SimpleStringProperty();
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

    public Date getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Date data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
    }

    public String getEncarregado() {
        return encarregado.get();
    }

    public SimpleStringProperty encarregadoProperty() {
        return encarregado;
    }

    public void setEncarregado(String encarregado) {
        this.encarregado.set(encarregado);
    }

    public int getProjecto_id() {
        return projecto_id;
    }

    public void setProjecto_id(int projecto_id) {
        this.projecto_id = projecto_id;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Tarefa{");
        sb.append("id=").append(id);
        sb.append(", nome_tarefa=").append(nome_tarefa);
        sb.append(", data_inicio=").append(data_inicio);
        sb.append(", data_final=").append(data_final);
        sb.append(", encarregado=").append(encarregado);
        sb.append('}');
        return sb.toString();
    }

    public void camposOK() throws CamposNullException {
        if (this.getNome_tarefa().equals("")) throw new CamposNullException("Campo Nome Tarefa não pode ser vazio");
        if (this.getData_inicio().toString().equals("")) throw new CamposNullException("Campo Data Inicio não pode ser vazio");
        if (this.getData_final().toString().equals("")) throw new CamposNullException("Campo Data Final não pode ser vazio");
        if (this.getEncarregado().equals("")) throw new CamposNullException("Campo Encarregado nao pode ser vazio");
        if (this.getProjecto_id() == -1) throw new CamposNullException("Campo Projecto não pode ser vazio");
    }
}
