package Persistence;

import Model.Candidatura;

import java.sql.*;
import java.util.*;

/**
 * @author davide on 08/12/14.
 */
public class CandidaturaRepository implements Map<Integer,Candidatura> {

    private static final String INSERT_CANDIDATURA = "INSERT INTO candidatura (nome_candidato, data_nascimento, morada, contacto, estado_civil, escolaridade, profissao, naturalidade, nacionalidade, aprovado) VALUES (?,?,?,?,?,?,?,?,?,?)";

    private static final String UPDATE_CANDIDATURA = "update candidatura set nome_candidato = ?, data_nascimento = ?, morada = ?, contacto = ?, estado_civil = ?, escolaridade = ?, profissao = ?, naturalidade = ?, nacionalidade = ?, aprovado = ? where id_candidatura = ?";

    private static final String SELECT_CANDIDATURA = "select nome_candidato, data_nascimento, morada, contacto, estado_civil, escolaridade, profissao, naturalidade, nacionalidade, aprovado from candidatura where id_candidatura = ?";
    private static final String SELECT_CANDIDATURAS = "select id_candidatura, nome_candidato, data_nascimento, morada, contacto, estado_civil, escolaridade, profissao, naturalidade, nacionalidade, aprovado from candidatura";


    private static final String DELETE_CANDIDATURA = "delete from candidatura where id_candidatura = ?";
    private static final String DELETE_CANDIDATURAS = "delete from candidatura";

    private static final String COUNT_FAMILIARES = "select count(*) as n from candidatura";
    private static final String SELECT_IDS = "select id_candidatura from candidatura";

    private final String url;
    private final String user;
    private final String password;

    public CandidaturaRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public int size() {
        try {
            int count;

            Connection connection = DriverManager.getConnection(url,user,password);
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(COUNT_FAMILIARES)) {
                if (resultSet.next())
                    count = resultSet.getInt("n");
                else
                    count = -1;
            } finally {
                statement.close();
                connection.close();
            }

            return count;

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return -1;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_CANDIDATURA);

            statement.setInt(1, (int) key);

            try (ResultSet result = statement.executeQuery()) {
                return result.next();
            } finally {
                statement.close();
                connection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return containsKey(((Candidatura) value).getId());
    }

    @Override
    public Candidatura get(Object key) {
        Candidatura candidatura = null;
        try {

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_CANDIDATURA);

            statement.setInt(1,(int) key);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    candidatura = new Candidatura();
                    candidatura.setId((int) key);
                    candidatura.setNome_candidato(result.getString("nome_candidato"));
                    candidatura.setData_nascimento(result.getString("data_nascimento"));
                    candidatura.setMorada(result.getString("morada"));
                    candidatura.setContacto(result.getString("contacto"));
                    candidatura.setEstado_civil(result.getString("estado_civil"));
                    candidatura.setEscolaridade(result.getString("escolaridade"));
                    candidatura.setProfissao(result.getString("profissao"));
                    candidatura.setNaturalidade(result.getString("naturalidade"));
                    candidatura.setNacionalidade(result.getString("nacionalidade"));
                    candidatura.setAprovado(result.getBoolean("aprovado"));
                    candidatura.setAgregadofamiliar(null);
                }
            } finally {
                statement.close();
                connection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return candidatura;
    }

    @Override
    public Candidatura put(Integer key, Candidatura value) {
        String query;
        int autoGeneratedKeys;
        boolean isUpdate;
        if (key < 0) {
            isUpdate = false;
            query = INSERT_CANDIDATURA;
            autoGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
        }
        else {
            isUpdate = true;
            query = UPDATE_CANDIDATURA;
            autoGeneratedKeys = Statement.NO_GENERATED_KEYS;
        }

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(query,autoGeneratedKeys);

            statement.setString(1,(value.getNome_candidato()));
            statement.setString(2,(value.getData_nascimento()));
            statement.setString(3,(value.getMorada()));
            statement.setString(4,(value.getContacto()));
            statement.setString(5,(value.getEstado_civil()));
            statement.setString(6,(value.getEscolaridade()));
            statement.setString(7,(value.getProfissao()));
            statement.setString(8,(value.getNaturalidade()));
            statement.setString(9,(value.getNacionalidade()));
            statement.setBoolean(10, (value.getAprovado()));

            if (isUpdate) {
                statement.setLong(11,key);
            }

            statement.executeUpdate();

            try {
                if (autoGeneratedKeys == Statement.RETURN_GENERATED_KEYS) {
                    ResultSet keys = statement.getGeneratedKeys();
                    if (keys != null && keys.next()) {
                        value.setId(keys.getInt(1));
                    }
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                statement.close();
                connection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return value;
    }

    @Override
    public Candidatura remove(Object key) {
        Candidatura c = get(key);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(DELETE_CANDIDATURA);

            statement.setInt(1, (int) key);

            try {
                statement.executeUpdate();
            } finally {
                statement.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return c;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Candidatura> m) {
        for(Candidatura c : m.values()) {
            put(c.getId(),c);
        }
    }

    @Override
    public void clear() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_CANDIDATURAS);
            } finally {
                connection.close();
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public Set<Integer> keySet() {
        Set<Integer> s = new HashSet<>();

        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(SELECT_IDS);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    s.add(result.getInt(1));
                }
            } finally {
                statement.close();
                connection.close();
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return s;
    }

    @Override
    public Collection<Candidatura> values() {
        ArrayList<Candidatura> r = new ArrayList<>();
        try {
            Candidatura candidatura;

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_CANDIDATURAS);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    candidatura = new Candidatura();

                    candidatura.setId(result.getInt("id_candidatura"));
                    candidatura.setNome_candidato(result.getString("nome_candidato"));
                    candidatura.setData_nascimento(result.getString("data_nascimento"));
                    candidatura.setMorada(result.getString("morada"));
                    candidatura.setContacto(result.getString("contacto"));
                    candidatura.setEstado_civil(result.getString("estado_civil"));
                    candidatura.setEscolaridade(result.getString("escolaridade"));
                    candidatura.setProfissao(result.getString("profissao"));
                    candidatura.setNaturalidade(result.getString("naturalidade"));
                    candidatura.setNacionalidade(result.getString("nacionalidade"));
                    candidatura.setAprovado(result.getBoolean("aprovado"));

                    r.add(candidatura);
                }
            }  finally {
                statement.close();
                connection.close();
            }

        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }

        return r;
    }

    @Override
    public Set<Entry<Integer, Candidatura>> entrySet() {
        return null;
    }

}
