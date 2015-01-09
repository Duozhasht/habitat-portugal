package Habitat;

import Model.VoluntarioTarefa;
import Persistence.RepositoryFactory;
import Persistence.VoluntarioTarefaRepository;

import java.util.List;

/**
 * @author davide on 09/01/15.
 */
public class TestMain {
    public static void main(String[] args) {
        VoluntarioTarefaRepository vRepo = RepositoryFactory.getVoluntarioTarefaRepository();
        for (VoluntarioTarefa v: vRepo.findByTarefa(1))
            System.out.println(v.toString());
    }
}