package Model;

import javafx.beans.property.SimpleStringProperty;

/**
 * @author PeterO'Daktyl on 17-12-2014.
 */
@SuppressWarnings("UnusedDeclaration")
public class Doador {

    private int id = -1;
    private SimpleStringProperty nome;
    private SimpleStringProperty contacto;
    private SimpleStringProperty telefone;
    private SimpleStringProperty morada;
    private SimpleStringProperty email;
    private SimpleStringProperty site;
    private SimpleStringProperty pessoa_contacto;
    private SimpleStringProperty nif;
    private SimpleStringProperty notas;

    public Doador (){
        this.nome = new SimpleStringProperty();
        this.contacto = new SimpleStringProperty();
        this.telefone = new SimpleStringProperty();
        this.morada = new SimpleStringProperty();
        this.email = new SimpleStringProperty();
        this.site = new SimpleStringProperty();
        this.pessoa_contacto = new SimpleStringProperty();
        this.nif = new SimpleStringProperty();
        this.notas = new SimpleStringProperty();
    }

    public Doador(SimpleStringProperty nome, SimpleStringProperty contacto, SimpleStringProperty telefone, SimpleStringProperty morada,
                  SimpleStringProperty email, SimpleStringProperty site, SimpleStringProperty pessoa_contacto, SimpleStringProperty nif,
                  SimpleStringProperty notas) {
        this.nome = nome;
        this.contacto = contacto;
        this.telefone = telefone;
        this.morada = morada;
        this.email = email;
        this.site = site;
        this.pessoa_contacto = pessoa_contacto;
        this.nif = nif;
        this.notas = notas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome.get();
    }

    public SimpleStringProperty nomeProperty() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome.set(nome);
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

    public String getTelefone() {
        return telefone.get();
    }

    public SimpleStringProperty telefoneProperty() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone.set(telefone);
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

    public String getEmail() {
        return email.get();
    }

    public SimpleStringProperty emailProperty() {
        return email;
    }

    public void setEmail(String email) {
        this.email.set(email);
    }

    public String getSite() {
        return site.get();
    }

    public SimpleStringProperty siteProperty() {
        return site;
    }

    public void setSite(String site) {
        this.site.set(site);
    }

    public String getPessoa_contacto() {
        return pessoa_contacto.get();
    }

    public SimpleStringProperty pessoa_contactoProperty() {
        return pessoa_contacto;
    }

    public void setPessoa_contacto(String pessoa_contacto) {
        this.pessoa_contacto.set(pessoa_contacto);
    }

    public String getNif() {
        return nif.get();
    }

    public SimpleStringProperty nifProperty() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif.set(nif);
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

