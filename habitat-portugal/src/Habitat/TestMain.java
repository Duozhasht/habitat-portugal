package Habitat;

import Model.Utilizador;
import Persistence.PersistenceException;
import Persistence.RepositoryFactory;
import Persistence.UtilizadorRepository;

/**
 * @author Davide Silva on 04/12/14.
 */
public class TestMain {
    public static void main(String[] args) {
        UtilizadorRepository uRepo = RepositoryFactory.getUtilizadorRepository();

        Utilizador user1 = new Utilizador("davide","123",2);

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

    }
}