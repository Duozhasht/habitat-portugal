package Habitat;



import Model.Utilizador;
import Persistence.*;

/**
 * @author Davide Silva on 04/12/14.
 */
public class TestMain {

    public static void main(String[] args) {

        UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();


    }


/*    public static void insereAgregado(long id) {
        FamiliarRepository fRepo = RepositoryFactory.getFamiliarRepository();

        try {
            Familiar f = new Familiar();
            f.setNome("a");
            f.setParentesco("irmao");
            f.setData_nascimento("j");
            f.setEstado_civil("s");
            f.setOcupacao("est");
            f.setEscolaridade("12");
            f.setCandidatura_id(id);

            fRepo.save(f);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
    }*/

/*    public static void main(String[] args) {

        System.out.println("HELLO");

        Habitat exemplo = new Habitat();
        for(Utilizador user : exemplo.getLista_utilizadores().values())
        {
            System.out.println(user.getId());
            System.out.println(user.getNome());
        }*/
/*

        try {
            Candidatura c = cRepo.find(6);
            System.out.println(c.getNome_candidato());
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
*/


/*        try {
            for (Familiar f: fRepo.findByCandidatura(6)) {
                System.out.println(f.getNome());
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }*/



        /*insereAgregado(6);*/

/*        UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();
        FamiliarRepository fRepo = RepositoryFactory.getFamiliarRepository();
        CandidaturaRepository cRepo = RepositoryFactory.getCandidaturaRepository();

        Candidatura c = new Candidatura();
        c.setNome_candidato("david");
        c.setData_nascimento("dez");
        c.setMorada("Braga");
        c.setContacto("96*******");
        c.setEstado_civil("S");
        c.setEscolaridade("Univ");
        c.setProfissao("Est");
        c.setNaturalidade("Porto");
        c.setNacionalidade("Portugal");
        c.setAprovado(true);

        Candidatura c1;

        try {
            c1 = cRepo.find(6);
            c1.setData_nascimento("10-Dez-1991");
            cRepo.save(c1);
            System.out.println(c1.getNome_candidato());
        } catch (PersistenceException e) {
            e.printStackTrace();
        }*/
/*


        SimpleStringProperty nome = new SimpleStringProperty("test");
        SimpleStringProperty pass = new SimpleStringProperty("1234");
        SimpleIntegerProperty tipo = new SimpleIntegerProperty(1);


        Utilizador user1 = new Utilizador(nome,pass,tipo);

        try {
            System.out.println(uRepo.count());
            uRepo.save(user1);
            System.out.println(uRepo.count());
        } catch (PersistenceException e) {
            e.printStackTrace();
        }
*/

/*
        Utilizador u = new Utilizador("test","olá",2);
        try {
            uRepo.save(u);
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        Utilizador user1 = new Utilizador("davide","password",1);

        try {
            uRepo.save(user1);
            System.out.println("Success!");
        }
        catch (PersistenceException ex) {
            ex.printStackTrace();
        }

        try {
            System.out.println(uRepo.find(1).toString());
        } catch (PersistenceException ex) {
            ex.printStackTrace();
        }


        try {
            for (Utilizador u: uRepo.findAll()) {
                System.out.println(u.toString());
            }
        } catch (PersistenceException e) {
            e.printStackTrace();
        }*/


}