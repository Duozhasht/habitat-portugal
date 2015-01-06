package Model;

import Persistence.DoadorRepository;
import Persistence.EventoRepository;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author davide on 20/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Doacao {
    private int id_doacao = -1;
    private SimpleStringProperty descricao;
    private SimpleStringProperty quantidade;
    private SimpleStringProperty tipo;
    private int doador = -1;
    private int evento = -1;

    public Doacao() {
        this.descricao = new SimpleStringProperty();
        this.quantidade = new SimpleStringProperty();
        this.tipo = new SimpleStringProperty();
    }

    public Doacao(int id_doacao, SimpleStringProperty descricao, SimpleStringProperty quantidade, SimpleStringProperty tipo, int doador_id, int evento_id) {
        this.id_doacao = id_doacao;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.tipo = tipo;
    }

    public int getId_doacao() {
        return id_doacao;
    }

    public void setId_doacao(int id_doacao) {
        this.id_doacao = id_doacao;
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

    public String getTipo() {
        return tipo.get();
    }

    public SimpleStringProperty tipoProperty() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo.set(tipo);
    }

    public int getDoador() {
        return doador;
    }

    public void setDoador(int doador) {
        this.doador = doador;
    }

    public int getEvento() {
        return evento;
    }

    public void setEvento(int evento) {
        this.evento = evento;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Doacao{");
        sb.append("id_doacao=").append(id_doacao);
        sb.append(", descricao=").append(descricao);
        sb.append(", quantidade=").append(quantidade);
        sb.append(", tipo=").append(tipo);
        sb.append('}');
        return sb.toString();
    }

    public void camposOK() throws CamposNullException {
        if (this.getDescricao().equals("")) throw new CamposNullException("Campo Descrição não pode ser vazio");
        if (this.getTipo().equals("")) throw new CamposNullException("Campo Tipo não pode ser vazio");
        if (this.getDoador() == -1) throw new CamposNullException("Campo Doador não pode ser vazio");
    }
}
