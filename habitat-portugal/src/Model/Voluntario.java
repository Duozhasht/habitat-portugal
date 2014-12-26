package Model;

import Persistence.TarefaRepository;

/**
 * @author davide on 18/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class Voluntario {
    private int id_voluntario = -1;
    private String nome_voluntario;
    private String data_nascimento;
    private String profissao;
    private String morada;
    private String codigo_postal;
    private String localidade;
    private String telefone;
    private String telemovel;
    private String email;
    private String hab_academ;
    private String conhec_lingui;
    private String form_compl;
    private String exp_voluntariado;
    private String conhec_constr;
    private String trabalho_grupo;
    private String pub;
    private String disponi_tempo;
    private String cca_habitat;
    private TarefaRepository lista_tarefas;

    public Voluntario() {
        this.nome_voluntario = "";
        this.data_nascimento = "";
        this.profissao = "";
        this.morada = "";
        this.codigo_postal = "";
        this.localidade = "";
        this.telefone = "";
        this.telemovel = "";
        this.email = "";
        this.hab_academ = "";
        this.conhec_lingui = "";
        this.form_compl = "";
        this.exp_voluntariado = "";
        this.conhec_constr = "";
        this.trabalho_grupo = "";
        this.pub = "";
        this.disponi_tempo = "";
        this.cca_habitat = "";
    }

    public Voluntario(String nome_voluntario, String data_nascimento, String profissao, String morada,
                      String codigo_postal, String localidade, String telefone, String telemovel, String email,
                      String hab_academ, String conhec_lingui, String form_compl, String exp_voluntariado,
                      String conhec_constr, String trabalho_grupo, String pub, String disponi_tempo, String cca_habitat) {
        this.nome_voluntario = nome_voluntario;
        this.data_nascimento = data_nascimento;
        this.profissao = profissao;
        this.morada = morada;
        this.codigo_postal = codigo_postal;
        this.localidade = localidade;
        this.telefone = telefone;
        this.telemovel = telemovel;
        this.email = email;
        this.hab_academ = hab_academ;
        this.conhec_lingui = conhec_lingui;
        this.form_compl = form_compl;
        this.exp_voluntariado = exp_voluntariado;
        this.conhec_constr = conhec_constr;
        this.trabalho_grupo = trabalho_grupo;
        this.pub = pub;
        this.disponi_tempo = disponi_tempo;
        this.cca_habitat = cca_habitat;
    }

    public int getId_voluntario() {
        return id_voluntario;
    }

    public void setId_voluntario(int id_voluntario) {
        this.id_voluntario = id_voluntario;
    }

    public String getNome_voluntario() {
        return nome_voluntario;
    }

    public void setNome_voluntario(String nome_voluntario) {
        this.nome_voluntario = nome_voluntario;
    }

    public String getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(String data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getTelemovel() {
        return telemovel;
    }

    public void setTelemovel(String telemovel) {
        this.telemovel = telemovel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHab_academ() {
        return hab_academ;
    }

    public void setHab_academ(String hab_academ) {
        this.hab_academ = hab_academ;
    }

    public String getConhec_lingui() {
        return conhec_lingui;
    }

    public void setConhec_lingui(String conhec_lingui) {
        this.conhec_lingui = conhec_lingui;
    }

    public String getForm_compl() {
        return form_compl;
    }

    public void setForm_compl(String form_compl) {
        this.form_compl = form_compl;
    }

    public String getExp_voluntariado() {
        return exp_voluntariado;
    }

    public void setExp_voluntariado(String exp_voluntariado) {
        this.exp_voluntariado = exp_voluntariado;
    }

    public String getConhec_constr() {
        return conhec_constr;
    }

    public void setConhec_constr(String conhec_constr) {
        this.conhec_constr = conhec_constr;
    }

    public String getTrabalho_grupo() {
        return trabalho_grupo;
    }

    public void setTrabalho_grupo(String trabalho_grupo) {
        this.trabalho_grupo = trabalho_grupo;
    }

    public String getPub() {
        return pub;
    }

    public void setPub(String pub) {
        this.pub = pub;
    }

    public String getDisponi_tempo() {
        return disponi_tempo;
    }

    public void setDisponi_tempo(String disponi_tempo) {
        this.disponi_tempo = disponi_tempo;
    }

    public String getCca_habitat() {
        return cca_habitat;
    }

    public void setCca_habitat(String cca_habitat) {
        this.cca_habitat = cca_habitat;
    }

    public TarefaRepository getLista_tarefas() {
        return lista_tarefas;
    }

    public void setLista_tarefas(TarefaRepository lista_tarefas) {
        this.lista_tarefas = lista_tarefas;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Voluntario{");
        sb.append("id_voluntario=").append(id_voluntario);
        sb.append(", nome_voluntario='").append(nome_voluntario).append('\'');
        sb.append(", data_nascimento='").append(data_nascimento).append('\'');
        sb.append(", profissao='").append(profissao).append('\'');
        sb.append(", morada='").append(morada).append('\'');
        sb.append(", codigo_postal='").append(codigo_postal).append('\'');
        sb.append(", localidade='").append(localidade).append('\'');
        sb.append(", telefone='").append(telefone).append('\'');
        sb.append(", telemovel='").append(telemovel).append('\'');
        sb.append(", email='").append(email).append('\'');
        sb.append(", hab_academ='").append(hab_academ).append('\'');
        sb.append(", conhec_lingui='").append(conhec_lingui).append('\'');
        sb.append(", form_compl='").append(form_compl).append('\'');
        sb.append(", exp_voluntariado='").append(exp_voluntariado).append('\'');
        sb.append(", conhec_constr='").append(conhec_constr).append('\'');
        sb.append(", trabalho_grupo='").append(trabalho_grupo).append('\'');
        sb.append(", pub='").append(pub).append('\'');
        sb.append(", disponi_tempo='").append(disponi_tempo).append('\'');
        sb.append(", cca_habitat='").append(cca_habitat).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
