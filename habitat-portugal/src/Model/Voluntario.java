package Model;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Tiago on 18/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Voluntario {
    private int id_voluntario = -1;
    private SimpleStringProperty nome_voluntario;
    private SimpleStringProperty data_nascimento;
    private SimpleStringProperty profissao;
    private SimpleStringProperty morada;
    private SimpleStringProperty contacto;
    private SimpleStringProperty hab_academ;
    private SimpleStringProperty conhec_lingui;
    private SimpleStringProperty exp_voluntariado;
    private SimpleBooleanProperty conhec_constr;
    private SimpleBooleanProperty trabalho_grupo;
    private SimpleBooleanProperty pub;
    private SimpleStringProperty disponi_tempo;
    private SimpleStringProperty cca_habitat;

    public Voluntario(){
        this.nome_voluntario = new SimpleStringProperty();
        this.data_nascimento = new SimpleStringProperty();
        this.profissao = new SimpleStringProperty();
        this.morada = new SimpleStringProperty();
        this.contacto = new SimpleStringProperty();
        this.hab_academ = new SimpleStringProperty();
        this.conhec_lingui = new SimpleStringProperty();
        this.exp_voluntariado = new SimpleStringProperty();
        this.conhec_constr = new SimpleBooleanProperty();
        this.trabalho_grupo = new SimpleBooleanProperty();
        this.pub = new SimpleBooleanProperty();
        this.disponi_tempo = new SimpleStringProperty();
        this.cca_habitat = new SimpleStringProperty();

    }

    public int getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public String getNome_voluntario() {
        return nome_voluntario.get();
    }

    public SimpleStringProperty nome_voluntarioProperty() {
        return nome_voluntario;
    }

    public void setNome_voluntario(String nome_voluntario) {
        this.nome_voluntario.set(nome_voluntario);
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

    public String getProfissao() {
        return profissao.get();
    }

    public SimpleStringProperty profissaoProperty() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao.set(profissao);
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

    public String getHab_academ() {
        return hab_academ.get();
    }

    public SimpleStringProperty hab_academProperty() {
        return hab_academ;
    }

    public void setHab_academ(String hab_academ) {
        this.hab_academ.set(hab_academ);
    }

    public String getConhec_lingui() {
        return conhec_lingui.get();
    }

    public SimpleStringProperty conhec_linguiProperty() {
        return conhec_lingui;
    }

    public void setConhec_lingui(String conhec_lingui) {
        this.conhec_lingui.set(conhec_lingui);
    }

    public String getExp_voluntariado() {
        return exp_voluntariado.get();
    }

    public SimpleStringProperty exp_voluntariadoProperty() {
        return exp_voluntariado;
    }

    public void setExp_voluntariado(String exp_voluntariado) {
        this.exp_voluntariado.set(exp_voluntariado);
    }

    public boolean getConhec_constr() {
        return conhec_constr.get();
    }

    public SimpleBooleanProperty conhec_constrProperty() {
        return conhec_constr;
    }

    public void setConhec_constr(boolean conhec_constr) {
        this.conhec_constr.set(conhec_constr);
    }

    public boolean getTrabalho_grupo() {
        return trabalho_grupo.get();
    }

    public SimpleBooleanProperty trabalho_grupoProperty() {
        return trabalho_grupo;
    }

    public void setTrabalho_grupo(boolean trabalho_grupo) {
        this.trabalho_grupo.set(trabalho_grupo);
    }

    public boolean getPub() {
        return pub.get();
    }

    public SimpleBooleanProperty pubProperty() {
        return pub;
    }

    public void setPub(boolean pub) {
        this.pub.set(pub);
    }

    public String getDisponi_tempo() {
        return disponi_tempo.get();
    }

    public SimpleStringProperty disponi_tempoProperty() {
        return disponi_tempo;
    }

    public void setDisponi_tempo(String disponi_tempo) {
        this.disponi_tempo.set(disponi_tempo);
    }

    public String getCca_habitat() {
        return cca_habitat.get();
    }

    public SimpleStringProperty cca_habitatProperty() {
        return cca_habitat;
    }

    public void setCca_habitat(String cca_habitat) {
        this.cca_habitat.set(cca_habitat);
    }
}
