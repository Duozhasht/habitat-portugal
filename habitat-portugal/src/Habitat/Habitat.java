package Habitat;

import Model.Candidatura;
import Model.Familiar;
import Model.Utilizador;
import Persistence.CandidaturaRepository;
import Persistence.FamiliarRepository;
import Persistence.RepositoryFactory;
import Persistence.UtilizadorRepository;
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
