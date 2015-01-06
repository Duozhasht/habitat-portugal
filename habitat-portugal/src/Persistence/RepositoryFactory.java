/*
 * Copyright (c) 2014 Benjamim Sonntag
 * 
 * Permission is hereby granted, free of charge,
 * to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use, copy,
 * modify, merge, publish, distribute, sublicense, and/or sell copies
 * of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
 * CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
 * TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package Persistence;

import Model.Doacao;
import Model.Voluntario;

import java.util.Properties;

/**
 * RepositoryFactory
 *
 * @author Benjamim Sonntag
 */
@SuppressWarnings("UnusedDeclaration")
public final class RepositoryFactory {

    private static String DB_TYPE = "mysql";
    private static String HOST = "banze.com.pt";
    private static String PORT = "3306";
    private static String USER = "banzeco_habitat";
    private static String PASSWORD = "habitatmysql";
    private static String DATABASE = "banzeco_habitat";
    
    private static UtilizadorRepository utilizadorRepository;
    private static FamiliarRepository familiarRepository;
    private static CandidaturaRepository candidaturaRepository;
    private static DoadorRepository doadorRepository;
    private static EventoRepository eventoRepository;
    private static TarefaRepository tarefaRepository;
    private static ProjectoRepository projectoRepository;
    private static VoluntarioRepository voluntarioRepository;
    private static GrupoRepository grupoRepository;
    private static DoacaoRepository doacaoRepository;
    private static MaterialRepository materialRepository;
    private static StockRepository stockRepository;


    private RepositoryFactory() { }

    public static UtilizadorRepository getUtilizadorRepository() {
        if (utilizadorRepository == null) {
            utilizadorRepository = new UtilizadorRepository(getURL(),USER,PASSWORD);
        }
        return utilizadorRepository;
    }

    public static FamiliarRepository getFamiliarRepository() {
        if (familiarRepository == null) {
            familiarRepository = new FamiliarRepository(getURL(),USER,PASSWORD);
        }
        return familiarRepository;
    }

    public static CandidaturaRepository getCandidaturaRepository() {
        if (candidaturaRepository == null) {
            candidaturaRepository = new CandidaturaRepository(getURL(),USER,PASSWORD);
        }
        return candidaturaRepository;
    }

    public static DoadorRepository getDoadorRepository() {
        if (doadorRepository == null) {
            doadorRepository = new DoadorRepository(getURL(),USER,PASSWORD);
        }
        return doadorRepository;
    }

    public static EventoRepository getEventoRepository() {
        if (eventoRepository == null) {
            eventoRepository = new EventoRepository(getURL(),USER,PASSWORD);
        }
        return eventoRepository;
    }

    public static TarefaRepository getTarefaRepository() {
        if (tarefaRepository == null) {
            tarefaRepository = new TarefaRepository(getURL(),USER,PASSWORD);
        }
        return tarefaRepository;
    }

    public static ProjectoRepository getProjectoRepository() {
        if (projectoRepository == null) {
            projectoRepository = new ProjectoRepository(getURL(),USER,PASSWORD);
        }
        return projectoRepository;
    }

    public static VoluntarioRepository getVoluntarioRepository(){
        if(voluntarioRepository == null){
            voluntarioRepository = new VoluntarioRepository(getURL(),USER,PASSWORD);
        }
        return voluntarioRepository;
    }

    public static GrupoRepository getGrupoRepository() {
        if (grupoRepository == null) {
            grupoRepository = new GrupoRepository(getURL(),USER,PASSWORD);
        }
        return grupoRepository;
    }

    public static DoacaoRepository getDoacaoRepository() {
        if (doacaoRepository == null) {
            doacaoRepository = new DoacaoRepository(getURL(),USER,PASSWORD);
        }
        return doacaoRepository;
    }

    public static MaterialRepository getMaterialRepository() {
        if (materialRepository == null) {
            materialRepository = new MaterialRepository(getURL(),USER,PASSWORD);
        }
        return materialRepository;
    }

    public static StockRepository getStockRepository() {
        if (stockRepository == null) {
            stockRepository = new StockRepository(getURL(),USER,PASSWORD);
        }
        return stockRepository;
    }

    public static void setProperties(Properties props) {
        DB_TYPE = props.getOrDefault("db_type", DB_TYPE).toString();
        HOST = props.getOrDefault("host", HOST).toString();
        PORT = props.getOrDefault("port", PORT).toString();
        USER = props.getOrDefault("user", USER).toString();
        PASSWORD = props.getOrDefault("password", PASSWORD).toString();
        DATABASE = props.getOrDefault("database", DATABASE).toString();
    }
    
    private static String getURL() {
        return "jdbc:" + DB_TYPE + "://" + HOST + ":" + PORT + "/" + DATABASE;
    }
    
}
