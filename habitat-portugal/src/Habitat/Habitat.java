package Habitat;

import Model.Candidatura;
import Model.Utilizador;
import Persistence.CandidaturaRepository;
import Persistence.RepositoryFactory;
import Persistence.UtilizadorRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.HashMap;

/**
 * Created by Tiago on 12/12/14.
 */
public class Habitat {


    //Instancias do Programa
    private HashMap<Long, Utilizador> lista_utilizadores = new HashMap<>();
    private HashMap<Long, Candidatura> lista_candidaturas = new HashMap<>();


    //Acesso à camada de Dados
    private UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();
    private CandidaturaRepository cRepo = RepositoryFactory.getCandidaturaRepository();


    public Habitat() {

    }

    public HashMap<Long, Utilizador> getLista_utilizadores() {
        return lista_utilizadores;
    }

    public void setLista_utilizadores(HashMap<Long, Utilizador> lista_utilizadores) {
        this.lista_utilizadores = lista_utilizadores;
    }

    public HashMap<Long, Candidatura> getLista_candidaturas() {
        return lista_candidaturas;
    }

    public void setLista_candidaturas(HashMap<Long, Candidatura> lista_candidaturas) {
        this.lista_candidaturas = lista_candidaturas;
    }

    public ObservableList<Candidatura> getObservableList(){
        ObservableList<Candidatura> res = FXCollections.observableArrayList();
        for(Candidatura cand : this.lista_candidaturas.values()){
            System.out.println("UM");
            res.add(cand);
        }

        return res;
    }


    public int login(String nome, String password) {
        int res = -1;
        for (Utilizador user : this.lista_utilizadores.values()) {
            if (user.getNome().equals(nome) && user.getPassword().equals(password)) {
                res = user.getConta();
                break;
            }
        }
        return res;
    }


}
