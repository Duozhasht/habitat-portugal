package Model;

import Persistence.CandidaturaRepository;
import Persistence.MaterialRepository;
import Persistence.TarefaRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

/**
 * @author davide on 17/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Projecto {
    private int id = -1;
    private SimpleStringProperty nome_projecto;
    private Date data_inicio;
    private Date data_final;
    private SimpleIntegerProperty custo_inicio;
    private SimpleIntegerProperty custo_final;
    private SimpleStringProperty classificacao;
    private SimpleStringProperty estado;
    private int candidatura = -1;
    private TarefaRepository tarefas;
    private MaterialRepository material;

    public Projecto() {
        this.nome_projecto = new SimpleStringProperty();
        this.data_inicio = null;
        this.data_final = null;
        this.custo_inicio = new SimpleIntegerProperty();
        this.custo_final = new SimpleIntegerProperty();
        this.classificacao = new SimpleStringProperty();
        this.estado = new SimpleStringProperty("Financiamento");
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

    public int getCandidatura() {
        return candidatura;
    }

    public void setCandidatura(int candidatura) {
        this.candidatura = candidatura;
    }

    public TarefaRepository getTarefas() {
        return tarefas;
    }

    public void setTarefas(TarefaRepository tarefas) {
        this.tarefas = tarefas;
    }

    public MaterialRepository getMaterial() {
        return material;
    }

    public void setMaterial(MaterialRepository material) {
        this.material = material;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Projecto{");
        sb.append("id=").append(id);
        sb.append(", nome_projecto=").append(nome_projecto);
        sb.append(", data_inicio=").append(data_inicio);
        sb.append(", data_final=").append(data_final);
        sb.append(", custo_inicio=").append(custo_inicio);
        sb.append(", custo_final=").append(custo_final);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", estado=").append(estado);
        sb.append(", candidatura=").append(candidatura);
        sb.append(", tarefas=").append(tarefas);
        sb.append('}');
        return sb.toString();
    }

    public void camposOK() throws CamposNullException {
        if (this.getNome_projecto().equals("")) throw new CamposNullException("Campo Nome Projecto não pode ser vazio");
        if (this.getData_inicio() == null) throw new CamposNullException("Campo Data Início não pode ser vazio");
        if ((Integer.toString(this.getCusto_inicio())).equals("")) throw new CamposNullException("Campo Custo Início não pode ser vazio");
        if (this.getClassificacao().equals("")) throw new CamposNullException("Campo Classificação não pode ser vazio");
        if (this.getEstado().equals("")) throw new CamposNullException("Campo Estado não pode ser vazio");
        if (this.getCandidatura() == -1) throw new CamposNullException("Campo Candidatura não pode ser vazio");
    }
}
