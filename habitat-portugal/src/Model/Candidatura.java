package Model;

import Persistence.FamiliarRepository;
import Persistence.RepositoryFactory;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

import java.text.SimpleDateFormat;
import java.sql.Date;

/**
 * @author by Tiago on 03/12/14.
 */
@SuppressWarnings("UnusedDeclaration")
public class Candidatura {


    private int id = -1;
    private SimpleStringProperty nome_candidato;
    private Date data_nascimento;
    private SimpleStringProperty morada;
    private SimpleStringProperty contacto;
    private SimpleStringProperty estado_civil;
    private SimpleStringProperty escolaridade;
    private SimpleStringProperty profissao;
    private SimpleStringProperty naturalidade;
    private SimpleStringProperty nacionalidade;
    private SimpleBooleanProperty aprovado;
    private FamiliarRepository agregadofamiliar;

    public Candidatura() {
        this.nome_candidato = new SimpleStringProperty();
        this.data_nascimento = null;
        this.morada = new SimpleStringProperty();
        this.contacto = new SimpleStringProperty();
        this.estado_civil = new SimpleStringProperty();
        this.escolaridade = new SimpleStringProperty();
        this.profissao = new SimpleStringProperty();
        this.naturalidade = new SimpleStringProperty();
        this.nacionalidade = new SimpleStringProperty();
        this.aprovado = new SimpleBooleanProperty();
        this.agregadofamiliar = RepositoryFactory.getFamiliarRepository();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public Date getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(Date data_nascimento) {
        this.data_nascimento = data_nascimento;
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

    public FamiliarRepository getAgregadofamiliar() {
        return agregadofamiliar;
    }

    public void setAgregadofamiliar(FamiliarRepository agregadofamiliar) {
        this.agregadofamiliar = agregadofamiliar;
    }

    @Override
    public String toString() {
        return this.getNome_candidato();
    }

    public void camposOK() throws CamposNullException {
        if (this.getNome_candidato().equals("")) throw new CamposNullException("Campo Nome Candidato não pode ser vazio");
        if (this.getData_nascimento() == null) throw new CamposNullException("Campo Data Nascimento não pode ser vazio");
        if (this.getMorada().equals("")) throw new CamposNullException("Campo Morada não pode ser vazio");
        if (this.getContacto().equals("")) throw new CamposNullException("Campo Contacto não pode ser vazio");
        if (this.getEstado_civil().equals("")) throw new CamposNullException("Campo Estado Civil não pode ser vazio");
        if (this.getEscolaridade().equals("")) throw new CamposNullException("Campo Escolaridade não pode ser vazio");
        if (this.getProfissao().equals("")) throw new CamposNullException("Campo Profissão não pode ser vazio");
        if (this.getNaturalidade().equals("")) throw new CamposNullException("Campo Naturalidade não pode ser vazio");
        if (this.getNacionalidade().equals("")) throw new CamposNullException("Campo Nacionalidade não pode ser vazio");
    }

}
