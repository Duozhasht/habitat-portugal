package Model;


import javafx.beans.property.SimpleStringProperty;

/**
 * @author davide on 06/01/15.
 */

@SuppressWarnings("UnusedDeclaration")
public class Stock {
    private int id_stock = -1;
    private SimpleStringProperty descricao;
    private SimpleStringProperty quantidade;
    private int doacao_id = -1;

    public Stock() {
        this.descricao = new SimpleStringProperty();
        this.quantidade = new SimpleStringProperty();
    }

    public int getId_stock() {
        return id_stock;
    }

    public void setId_stock(int id_stock) {
        this.id_stock = id_stock;
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

    public int getDoacao_id() {
        return doacao_id;
    }

    public void setDoacao_id(int doacao_id) {
        this.doacao_id = doacao_id;
    }

    @Override
    public String toString() {
        return this.getDescricao();
    }

    public void camposOK() throws CamposNullException {
        if (this.getDescricao().equals("")) throw new CamposNullException("Campo Descrição não pode ser vazio");
        if (this.getQuantidade().equals("")) throw new CamposNullException("Campo Quantidade não pode ser vazio");
        if (this.getDoacao_id() == -1) throw new CamposNullException("Campo Doação não pode ser vazio");
    }
}
