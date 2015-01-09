package Model;

import Persistence.DoacaoRepository;
import Persistence.ProjectoRepository;
import Persistence.RepositoryFactory;
import javafx.beans.property.SimpleStringProperty;

/**
 * Created by Davide on 30/12/2014.
 */

@SuppressWarnings("UnusedDeclaration")
public class Material {
    private int id_material = -1;
    private SimpleStringProperty descricao;
    private SimpleStringProperty quantidade;
    private SimpleStringProperty motivo;
    private int projecto_id = -1;
    private int stock_id = -1;

    public Material() {
        this.descricao = new SimpleStringProperty();
        this.quantidade = new SimpleStringProperty();
        this.motivo = new SimpleStringProperty();
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
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

    public String getQuantidade() {
        return quantidade.get();
    }

    public SimpleStringProperty quantidadeProperty() {
        return quantidade;
    }

    public void setQuantidade(String quantidade) {
        this.quantidade.set(quantidade);
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

    public int getProjecto_id() {
        return projecto_id;
    }

    public void setProjecto_id(int projecto_id) {
        this.projecto_id = projecto_id;
    }

    public int getStock_id() {
        return stock_id;
    }

    public void setStock_id(int stock_id) {
        this.stock_id = stock_id;
    }

    public void camposOK() throws CamposNullException {

    }
}
