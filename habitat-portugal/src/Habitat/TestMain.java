package Habitat;

import Model.Utilizador;
import Persistence.PersistenceException;
import Persistence.RepositoryFactory;
import Persistence.UtilizadorRepository;

import java.util.Properties;

/**
 * @author Davide Silva on 04/12/14.
 */
public class TestMain {
    public static void main(String[] args) {

        UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();

        Utilizador user1 = new Utilizador("test","olá",2);
        user1.setId(4);

        try {
            uRepo.delete(user1);
            System.out.println("Success");
        } catch (PersistenceException e) {
            e.printStackTrace();
        }





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
}