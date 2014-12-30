package Habitat;

import Model.*;
import Persistence.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by Tiago on 12/12/14.
 */
public class Habitat {




    //Acesso à camada de Dados
    private UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();
    private CandidaturaRepository cRepo = RepositoryFactory.getCandidaturaRepository();
    private FamiliarRepository fRepo = RepositoryFactory.getFamiliarRepository();
    private VoluntarioRepository vRepo = RepositoryFactory.getVoluntarioRepository();
    private GrupoRepository gRepo = RepositoryFactory.getGrupoRepository();
    private EventoRepository eRepo = RepositoryFactory.getEventoRepository();
    private DoacaoRepository dcRepo = RepositoryFactory.getDoacaoRepository();
    private DoadorRepository ddRepo = RepositoryFactory.getDoadorRepository();




    public UtilizadorRepository getuRepo() {
        return uRepo;
    }

    public void setuRepo(UtilizadorRepository uRepo) {
        this.uRepo = uRepo;
    }

    public CandidaturaRepository getcRepo() {
        return cRepo;
    }

    public void setcRepo(CandidaturaRepository cRepo) {
        this.cRepo = cRepo;
    }

    public FamiliarRepository getfRepo() {return fRepo;}

    public void setfRepo(FamiliarRepository fRepo) {this.fRepo = fRepo;}

    public VoluntarioRepository getvRepo() {
        return vRepo;
    }

    public void setvRepo(VoluntarioRepository vRepo) {
        this.vRepo = vRepo;
    }

    public GrupoRepository getgRepo() {
        return gRepo;
    }

    public void setgRepo(GrupoRepository gRepo) {
        this.gRepo = gRepo;
    }

    public ObservableList<Candidatura> getObservableCA(){
            ObservableList<Candidatura> res = FXCollections.observableArrayList();
            for(Candidatura cand : this.cRepo.values()){
                if(cand.getAprovado()){
                    res.add(cand);
                }
            }

            return res;
        }

    public ObservableList<Candidatura> getObservableCNA(){
            ObservableList<Candidatura> res = FXCollections.observableArrayList();
            for(Candidatura cand : this.cRepo.values()){
                if(!cand.getAprovado()){
                    res.add(cand);
                }
            }

            return res;
        }

    public ObservableList<Familiar> getObservableF(){
        ObservableList<Familiar> res = FXCollections.observableArrayList();
        for(Familiar familiar : this.fRepo.values()){

                res.add(familiar);

        }

        return res;
    }

    public ObservableList<Voluntario> getObservableV(){
        ObservableList<Voluntario> res = FXCollections.observableArrayList();
        for(Voluntario voluntario : this.vRepo.values()){
            System.out.println("ASDASDD");
            res.add(voluntario);

        }

        return res;
    }

    public ObservableList<Grupo> getObservableG(){
        ObservableList<Grupo> res = FXCollections.observableArrayList();
        for(Grupo grupo : this.gRepo.values()){
            System.out.println("ASDASDD");
            res.add(grupo);

        }

        return res;
    }

    public ObservableList<Evento> getObservableE(){
        ObservableList<Evento> res = FXCollections.observableArrayList();
        for(Evento evento : this.eRepo.values()){
            res.add(evento);
        }

        return res;
    }

    public ObservableList<Doacao> getObservableDC(){
        ObservableList<Doacao> res = FXCollections.observableArrayList();
        for(Doacao doacao : this.dcRepo.values()){
            res.add(doacao);
        }
        return res;
    }

    public ObservableList<Doador> getObservableDD(){
        ObservableList<Doador> res = FXCollections.observableArrayList();
        for(Doador doador : this.ddRepo.values()){
            res.add(doador);
        }
        return res;
    }


    public boolean adicionarCandidatura(Candidatura candidatura, ObservableList<Familiar> agregadofamiliar){
        try{
            Candidatura res =this.cRepo.put(candidatura.getId(), candidatura);
            for(Familiar familiar : agregadofamiliar){
                familiar.setCandidatura(res.getId());
                this.fRepo.put(familiar.getId(),familiar);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }

    public boolean removerCandidatura(Candidatura candidatura){
        try{
            for(Familiar familiar : candidatura.getAgregadofamiliar().findByCandidatura(candidatura.getId()) ){
                this.removerFamiliarCandidatura(familiar);
            }
            this.cRepo.remove(candidatura.getId());

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean removerFamiliarCandidatura(Familiar familiar){
        this.getfRepo().remove(familiar.getId());
        return true;
    }





    public boolean adicionarVoluntario(Voluntario voluntario){
        try{
            this.vRepo.put(voluntario.getId_voluntario(), voluntario);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }


    public boolean removerVoluntario(Voluntario voluntario){
        try{

            this.vRepo.remove(voluntario.getId_voluntario());

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean adicionarGrupo(Grupo grupo, ObservableList<Voluntario> lista){
        try{
            this.gRepo.put(grupo.getId_grupo(), grupo);
            for(Voluntario v : lista){
                this.gRepo.insereVoluntarioGrupo(v.getId_voluntario(),grupo.getId_grupo());
            }

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }

    public boolean removerGrupo(Grupo grupo){
        try{
            this.gRepo.remove(grupo.getId_grupo());

            return true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }

    public boolean adicionarEvento(Evento evento)
    {
        try{
            this.eRepo.put(evento.getId(),evento);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean removerEvento(Evento evento)
    {
        try{
            this.eRepo.remove(evento.getId());

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean adicionarDoador(Doador doador)
    {
        try{
            this.ddRepo.put(doador.getId(),doador);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean removerDoador(Doador doador)
    {
        try{
            this.ddRepo.remove(doador.getId());

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean adicionarDoacao(Doacao doacao)
    {
        try{
            this.dcRepo.put(doacao.getId_doacao(),doacao);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean removerDoacao(Doacao doacao)
    {
        try{
            this.dcRepo.remove(doacao.getId_doacao());

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }



    public int login(String nome, String password) {
        int res = -1;
        for (Utilizador user : this.uRepo.values()) {
            if (user.getNome().equals(nome) && user.getPassword().equals(password)) {
                res = user.getConta();
                break;
            }
        }
        return res;
    }


}
