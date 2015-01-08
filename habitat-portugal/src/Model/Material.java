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
    private SimpleStringProperty quant_necessaria;
    private SimpleStringProperty quant_actual;
    private SimpleStringProperty motivo;
    private int projecto_id = -1;
    private int stock_id = -1;

    public Material() {
        this.quant_necessaria = new SimpleStringProperty();
        this.quant_actual = new SimpleStringProperty();
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

    public String getQuant_necessaria() {
        return quant_necessaria.get();
    }

    public SimpleStringProperty quant_necessariaProperty() {
        return quant_necessaria;
    }

    public void setQuant_necessaria(String quant_necessaria) {
        this.quant_necessaria.set(quant_necessaria);
    }

    public String getQuant_actual() {
        return quant_actual.get();
    }

    public SimpleStringProperty quant_actualProperty() {
        return quant_actual;
    }

    public void setQuant_actual(String quant_actual) {
        this.quant_actual.set(quant_actual);
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
