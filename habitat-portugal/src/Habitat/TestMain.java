package Habitat;

import Model.Utilizador;
import Persistence.PersistenceException;
import Persistence.RepositoryFactory;
import Persistence.UtilizadorRepository;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Davide Silva on 04/12/14.
 */
public class TestMain {
    public static void main(String[] args) {

        UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();

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