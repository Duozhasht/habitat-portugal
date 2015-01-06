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
    private SimpleStringProperty quant_necessaria;
    private SimpleStringProperty quant_actual;
    private SimpleStringProperty motivo;
    private int projecto_id = -1;
    private DoacaoRepository doacao;

    public Material() {
        this.quant_necessaria = new SimpleStringProperty();
        this.quant_actual = new SimpleStringProperty();
        this.motivo = new SimpleStringProperty();
        this.doacao = RepositoryFactory.getDoacaoRepository();
    }

    public int getId_material() {
        return id_material;
    }

    public void setId_material(int id_material) {
        this.id_material = id_material;
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

    public DoacaoRepository getDoacao() {
        return doacao;
    }

    public void setDoacao(DoacaoRepository doacao) {
        this.doacao = doacao;
    }

    public void camposOK() throws CamposNullException {

    }
}
