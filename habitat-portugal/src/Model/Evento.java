package Model;

import javafx.beans.property.SimpleStringProperty;
import sun.java2d.pipe.SpanShapeRenderer;

/**
 * Created by PeterO'Daktyl on 17-12-2014.
 */
@SuppressWarnings("UnusedDeclaration")
public class Evento {

    private int id = -1;
    private SimpleStringProperty nome_evento;
    private SimpleStringProperty data_evento;
    private SimpleStringProperty valor_total;
    private SimpleStringProperty organizador;
    private SimpleStringProperty notas;

    public Evento () {
        this.nome_evento = new SimpleStringProperty();
        this.data_evento = new SimpleStringProperty();
        this.valor_total = new SimpleStringProperty();
        this.organizador = new SimpleStringProperty();
        this.notas = new SimpleStringProperty();
    }

    public Evento(SimpleStringProperty nome_evento, SimpleStringProperty data_evento, SimpleStringProperty valor_total,
                  SimpleStringProperty organizador, SimpleStringProperty notas) {
        this.nome_evento = nome_evento;
        this.data_evento = data_evento;
        this.valor_total = valor_total;
        this.organizador = organizador;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome_evento() {
        return nome_evento.get();
    }

    public SimpleStringProperty nome_eventoProperty() {
        return nome_evento;
    }

    public void setNome_evento(String nome_evento) {
        this.nome_evento.set(nome_evento);
    }

    public String getData_evento() {
        return data_evento.get();
    }

    public SimpleStringProperty data_eventoProperty() {
        return data_evento;
    }

    public void setData_evento(String data_evento) {
        this.data_evento.set(data_evento);
    }

    public String getValor_total() {
        return valor_total.get();
    }

    public SimpleStringProperty valor_totalProperty() {
        return valor_total;
    }

    public void setValor_total(String valor_total) {
        this.valor_total.set(valor_total);
    }

    public String getOrganizador() {
        return organizador.get();
    }

    public SimpleStringProperty organizadorProperty() {
        return organizador;
    }

    public void setOrganizador(String organizador) {
        this.organizador.set(organizador);
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
}
