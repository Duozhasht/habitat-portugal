package Habitat;

import Model.*;
import Persistence.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

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
    private ProjectoRepository pRepo = RepositoryFactory.getProjectoRepository();
    private MaterialRepository mRepo = RepositoryFactory.getMaterialRepository();
    private StockRepository sRepo = RepositoryFactory.getStockRepository();
    private TarefaRepository tRepo = RepositoryFactory.getTarefaRepository();
    private VoluntarioTarefaRepository vtRepo = RepositoryFactory.getVoluntarioTarefaRepository();


    public UtilizadorRepository getuRepo() {
        return uRepo;
    }

    public CandidaturaRepository getcRepo() {
        return cRepo;
    }

    public FamiliarRepository getfRepo() {
        return fRepo;
    }

    public VoluntarioRepository getvRepo() {
        return vRepo;
    }

    public GrupoRepository getgRepo() {
        return gRepo;
    }

    public EventoRepository geteRepo() {
        return eRepo;
    }

    public DoacaoRepository getDcRepo() {
        return dcRepo;
    }

    public DoadorRepository getDdRepo() {
        return ddRepo;
    }

    public ProjectoRepository getpRepo() {
        return pRepo;
    }

    public MaterialRepository getmRepo() {
        return mRepo;
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

    public ObservableList<Projecto> getObservablePF(){
        ObservableList<Projecto> res = FXCollections.observableArrayList();
        for(Projecto projecto : this.pRepo.values()){
            if(projecto.getEstado().equals("Financiamento"))
                res.add(projecto);
        }
        return res;
    }

    public ObservableList<Projecto> getObservablePD(){
        ObservableList<Projecto> res = FXCollections.observableArrayList();
        for(Projecto projecto : this.pRepo.values()){
            if(projecto.getEstado().equals("Desenvolvimento"))
                res.add(projecto);
        }
        return res;
    }

    public ObservableList<Projecto> getObservablePC(){
        ObservableList<Projecto> res = FXCollections.observableArrayList();
        for(Projecto projecto : this.pRepo.values()){
            if(projecto.getEstado().equals("Concluido"))
                res.add(projecto);
        }
        return res;
    }

    public ObservableList<Material> getObservableMP(int projecto){
        ObservableList<Material> res = FXCollections.observableArrayList();
        for(Material material : this.mRepo.findByProjecto(projecto)){
            res.add(material);
        }
        return res;
    }

    public ObservableList<Stock> getObservableS(){
        ObservableList<Stock> res = FXCollections.observableArrayList();
        for(Stock stock : this.sRepo.values()){
            res.add(stock);
        }
        return res;
    }

    public ObservableList<Tarefa> getObservableT(int projecto){
        ObservableList<Tarefa> res = FXCollections.observableArrayList();
        for(Tarefa tarefa : this.tRepo.findByProjecto(projecto)){
            res.add(tarefa);
        }
        return res;
    }
    ///////
    public ObservableList<VoluntarioTarefa> getObservableVT(){
        ObservableList<VoluntarioTarefa> res = FXCollections.observableArrayList();
        for(VoluntarioTarefa voluntarioTarefa : this.vtRepo.values()){
            res.add(voluntarioTarefa);
        }
        return res;
    }




    /*
    *
    *
    *  Candidatura Methods
    *
    *
    * */


    public boolean adicionarCandidatura(Candidatura candidatura, ObservableList<Familiar> agregadofamiliar) throws CamposNullException{
        try {
            candidatura.camposOK();
        } catch (CamposNullException e) {
            throw e;
        }

        try{
            Candidatura res = this.cRepo.put(candidatura.getId(), candidatura);
            for(Familiar familiar : agregadofamiliar){
                adicionarFamiliarCandidatura(res,familiar);
                familiar.setCandidatura(res.getId());
                this.fRepo.put(familiar.getId(),familiar);
            }
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }


    public boolean removerCandidatura(Candidatura candidatura) {
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



    public boolean adicionarFamiliarCandidatura(Candidatura res, Familiar familiar) throws CamposNullException {
        try {
            familiar.camposOK();
            familiar.setCandidatura(res.getId());
            this.fRepo.put(familiar.getId(),familiar);
        } catch (CamposNullException e) {
            throw e;
        }
        return true;
    }


    public boolean removerFamiliarCandidatura(Familiar familiar){
        this.getfRepo().remove(familiar.getId());
        return true;
    }


    public boolean verificarDependencia(Candidatura candidatura)throws DependenciaException{
        if(!candidatura.getAgregadofamiliar().findByCandidatura(candidatura.getId()).isEmpty())
            throw new DependenciaException("Existe familiares associados a esta candidatura");

        return true;
    }


    /*
    *
    *
    * Gestão de Voluntários
    *
    *
    * */





    public boolean adicionarVoluntario(Voluntario voluntario) throws CamposNullException{
        try {
            voluntario.camposOK();
        } catch (CamposNullException e) {
            throw e;
        }
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

    public boolean adicionarGrupo(Grupo grupo, ObservableList<Voluntario> lista) throws CamposNullException{
        try {
            grupo.camposOK();
        } catch (CamposNullException e) {
            throw e;
        }
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

    public boolean removerGrupo(Grupo grupo) {
        try{
            this.gRepo.remove(grupo.getId_grupo());
            return true;

        }catch (Exception e){
            e.printStackTrace();
        }

        return false;

    }

    public boolean verificarDependencia(Grupo grupo)throws DependenciaException{
        if(!grupo.getElementos().findByGrupo(grupo.getId_grupo()).isEmpty())
            throw new DependenciaException("Os voluntarios associados a este grupo serão tambem removidos");
        return false;
    }

    /*
    *
    *
    * Gestão de Eventos e Fundos
    *
    *
    * */

    public boolean adicionarEvento(Evento evento) throws CamposNullException
    {
        try {
            evento.camposOK();
        } catch (CamposNullException e) {
            throw e;
        }
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

    public boolean adicionarDoador(Doador doador) throws CamposNullException
    {
        try {
            doador.camposOK();
        } catch (CamposNullException e) {
            throw e;
        }

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

    public boolean adicionarDoacao(Doacao doacao) throws CamposNullException
    {
        try {
            doacao.camposOK();
        } catch (CamposNullException e) {
            throw e;
        }
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
/*
    public boolean verificarDependencia(Doador doador)throws DependenciaException{
        if(!do.getElementos().findByGrupo(grupo.getId_grupo()).isEmpty())
            throw new DependenciaException("Os voluntarios associados a este grupo serão tambem removidos");
        return false;
    }
    */


    /*
    *
    *   TAB PROJECTOS
    *
    * */

    public boolean adicionarProjecto(Projecto projecto) throws CamposNullException
    {
        try{
            projecto.camposOK();
        }catch (CamposNullException e){
            throw e;
        }

        try{
            this.pRepo.put(projecto.getId(),projecto);

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean removerProjecto(Projecto projecto)
    {
        try{
            this.pRepo.remove(projecto.getId());

            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean iniciarProjecto(Projecto projecto){
        try{
            this.pRepo.put(projecto.getId(),projecto);
            return true;
        }catch (Exception e){
            e.printStackTrace();
        }

        return false;
    }

    public boolean adicionarMaterialProjecto(Material material, Projecto projecto) throws CamposNullException
    {
        try{
            material.camposOK();
            this.getmRepo().put(material.getId_material(), material);

            return true;
        }catch (CamposNullException e){
            throw e;
        }

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
