package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.util.Collection;

/**
 * @author by Tiago on 03/12/14.
 */
@SuppressWarnings("UnusedDeclaration")
public class Candidatura {

    private long id;
    private SimpleStringProperty nome_candidato;
    private SimpleStringProperty data_nascimento;
    private SimpleStringProperty morada;
    private SimpleStringProperty contacto;
    private SimpleStringProperty estado_civil;
    private SimpleStringProperty escolaridade;
    private SimpleStringProperty profissao;
    private SimpleStringProperty naturalidade;
    private SimpleStringProperty nacionalidade;
    private SimpleBooleanProperty aprovado;
    private Collection<Familiar> agregadofamiliar;

    public Candidatura() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_candidato() {
        return nome_candidato.get();
    }

    public SimpleStringProperty nome_candidatoProperty() {
        return nome_candidato;
    }

    public void setNome_candidato(String nome_candidato) {
        this.nome_candidato.set(nome_candidato);
    }

    public String getData_nascimento() {
        return data_nascimento.get();
    }

    public SimpleStringProperty data_nascimentoProperty() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento.set(data_nascimento);
    }

    public String getMorada() {
        return morada.get();
    }

    public SimpleStringProperty moradaProperty() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada.set(morada);
    }

    public String getContacto() {
        return contacto.get();
    }

    public SimpleStringProperty contactoProperty() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto.set(contacto);
    }

    public String getEstado_civil() {
        return estado_civil.get();
    }

    public SimpleStringProperty estado_civilProperty() {
        return estado_civil;
    }

    public void setEstado_civil(String estado_civil) {
        this.estado_civil.set(estado_civil);
    }

    public String getEscolaridade() {
        return escolaridade.get();
    }

    public SimpleStringProperty escolaridadeProperty() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade.set(escolaridade);
    }

    public String getProfissao() {
        return profissao.get();
    }

    public SimpleStringProperty profissaoProperty() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao.set(profissao);
    }

    public String getNaturalidade() {
        return naturalidade.get();
    }

    public SimpleStringProperty naturalidadeProperty() {
        return naturalidade;
    }

    public void setNaturalidade(String naturalidade) {
        this.naturalidade.set(naturalidade);
    }

    public String getNacionalidade() {
        return nacionalidade.get();
    }

    public SimpleStringProperty nacionalidadeProperty() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade.set(nacionalidade);
    }

    public boolean getAprovado() {
        return aprovado.get();
    }

    public SimpleBooleanProperty aprovadoProperty() {
        return aprovado;
    }

    public void setAprovado(boolean aprovado) {
        this.aprovado.set(aprovado);
    }

    public Collection<Familiar> getAgregadofamiliar() {
        return agregadofamiliar;
    }

    public void setAgregadofamiliar(Collection<Familiar> agregadofamiliar) {
        this.agregadofamiliar = agregadofamiliar;
    }
}
