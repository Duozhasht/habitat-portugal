package Model;

import Persistence.RepositoryFactory;
import Persistence.VoluntarioRepository;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;
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
    private Date data_criacao;
    private Date data_final;
    private SimpleStringProperty notas;
    private VoluntarioRepository elementos;

    public Grupo() {
        this.nome_grupo = new SimpleStringProperty();
        this.motivo = new SimpleStringProperty();
        this.data_criacao = null;
        this.data_final = null;
        this.notas = new SimpleStringProperty();
        this.elementos = RepositoryFactory.getVoluntarioRepository();

    }

    public Grupo(SimpleStringProperty nome_grupo, SimpleStringProperty motivo, SimpleStringProperty data_criacao,
                 SimpleStringProperty data_final, SimpleStringProperty notas, List<Integer> id_voluntarios) {
        this.nome_grupo = nome_grupo;
        this.motivo = motivo;
        this.data_criacao = null;
        this.data_final = null;
        this.notas = notas;

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

    public Date getData_criacao() {
        return data_criacao;
    }

    public void setData_criacao(Date data_criacao) {
        this.data_criacao = data_criacao;
    }

    public Date getData_final() {
        return data_final;
    }

    public void setData_final(Date data_final) {
        this.data_final = data_final;
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

    public VoluntarioRepository getElementos() {
        return elementos;
    }

    public void setElementos(VoluntarioRepository elementos) {
        this.elementos = elementos;
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
                '}';
    }

    public void camposOK() throws CamposNullException {
        if (this.getNome_grupo().equals("")) throw new CamposNullException("Campo Nome Grupo não pode ser vazio");
        if (this.getMotivo().equals("")) throw new CamposNullException("Campo Motivo não pode ser vazio");
        if (this.getData_criacao().toString().equals("")) throw new CamposNullException("Campo Data Criação não pode ser vazio");
    }
}
