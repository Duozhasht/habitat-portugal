package Persistence;

import Model.Utilizador;

import java.sql.*;
import java.util.*;

/**
 *
 * UtilizadorRepository
 *
 * @author Davide Silva
 *
 */

public class UtilizadorRepository implements Map<Integer,Utilizador> {

    private static final String INSERT_UTILIZADOR = "insert into utilizador (nome_utilizador, password, conta) values (?,?,?)";
    private static final String UPDATE_UTILIZADOR = "update utilizador set nome_utilizador = ?, password = ?, conta = ? where id = ?";

    private static final String SELECT_UTILIZADOR = "select nome_utilizador, password, conta from utilizador where id = ?";
    private static final String SELECT_UTILIZADORES = "select id, nome_utilizador, password, conta from utilizador";

    private static final String DELETE_UTILIZADOR = "delete from utilizador where id = ?";
    private static final String DELETE_UTILIZADORES = "delete from utilizador";

    private static final String COUNT_UTILIZADORES = "select count(*) as n from utilizador";
    private static final String SELECT_IDS = "select id from utilizador";

    private final String url;
    private final String user;
    private final String password;

    public UtilizadorRepository(String url, String user, String password) {
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

            try (ResultSet resultSet = statement.executeQuery(COUNT_UTILIZADORES)) {
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
            PreparedStatement statement = connection.prepareStatement(SELECT_UTILIZADOR);

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
        return containsKey(((Utilizador) value).getId());
    }

    @Override
    public Utilizador get(Object key) {
        Utilizador utilizador = null;
        try {

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_UTILIZADOR);

            statement.setInt(1,(int) key);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    utilizador = new Utilizador();
                    utilizador.setId((int) key);
                    utilizador.setNome(result.getString("nome_utilizador"));
                    utilizador.setPassword(result.getString("password"));
                    utilizador.setConta(result.getInt("conta"));
                }
            } finally {
                statement.close();
                connection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return utilizador;
    }


    // key = value.getID()
    @Override
    public Utilizador put(Integer key, Utilizador value) {
        String query;
        int autoGeneratedKeys;
        boolean isUpdate;
        if (key < 0) {
            isUpdate = false;
            query = INSERT_UTILIZADOR;
            autoGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
        }
        else {
            isUpdate = true;
            query = UPDATE_UTILIZADOR;
            autoGeneratedKeys = Statement.NO_GENERATED_KEYS;
        }

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(query,autoGeneratedKeys);

            statement.setString(1,value.getNome());
            statement.setString(2,value.getPassword());
            statement.setInt(3,value.getConta());

            if (isUpdate) {
                statement.setLong(4,key);
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
    public Utilizador remove(Object key) {
        Utilizador u = get(key);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(DELETE_UTILIZADOR);

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
        return u;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Utilizador> m) {
        for (Utilizador u : m.values()) {
            put(u.getId(),u);
        }
    }

    @Override
    public void clear() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_UTILIZADORES);
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
    public Collection<Utilizador> values() {
        ArrayList<Utilizador> r = new ArrayList<>();
        try {
            Utilizador utilizador;

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_UTILIZADORES);

            try (ResultSet resultSet = statement.executeQuery()) {
                while (resultSet.next()) {
                    utilizador = new Utilizador();
                    utilizador.setId(resultSet.getInt("id"));
                    utilizador.setNome(resultSet.getString("nome_utilizador"));
                    utilizador.setPassword(resultSet.getString("password"));
                    utilizador.setConta(resultSet.getInt("conta"));

                    r.add(utilizador);
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
    public Set<Entry<Integer, Utilizador>> entrySet() {
        return null;
    }
}
