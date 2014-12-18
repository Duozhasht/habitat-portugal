package Persistence;

import Model.Evento;

import java.sql.*;
import java.util.*;

/**
 * @author PeterO'Daktyl on 17-12-2014.
 */
@SuppressWarnings("UnusedDeclaration")
public class EventoRepository implements Map<Integer, Evento> {

    private static final String INSERT_EVENTO = "insert into evento (nome_evento, data_evento, valor_total, organizador, notas) values (?,?,?,?,?)";
    private static final String UPDATE_EVENTO = "update evento set nome_evento = ?, data_evento = ?, valor_total = ?, organizador = ?, notas = ? where id = ?";

    private static final String SELECT_EVENTO = "select nome_evento, data_evento, valor_total, organizador, notas from evento where id = ?";
    private static final String SELECT_EVENTOS = "select id, nome_evento, data_evento, valor_total, organizador, notas from evento";

    private static final String DELETE_EVENTO = "delete from evento where id = ?";
    private static final String DELETE_EVENTOS = "delete from evento";

    private static final String COUNT_EVENTOS = "select count(*) as n from evento";
    private static final String SELECT_IDS = "select id from evento";

    private final String url;
    private final String user;
    private final String password;

    public EventoRepository(String url, String user, String password) {
        this.url = url;
        this.user = user;
        this.password = password;
    }

    @Override
    public int size() {
        try {
            int count;

            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            try (ResultSet resultSet = statement.executeQuery(COUNT_EVENTOS)) {
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
    public boolean isEmpty() { return size() == 0; }

    @Override
    public boolean containsKey(Object key) {
        try {

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_EVENTO);

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
    public boolean containsValue(Object value) { return containsKey(((Evento) value).getId()); }

    @Override
    public Evento get(Object key) {
        Evento e = null;
        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(SELECT_EVENTO);

            statement.setInt(1, (int) key);

            try (ResultSet r = statement.executeQuery()) {
                if (r.next()) {
                    e = new Evento();
                    e.setId((int) key);
                    e.setNome_evento(r.getString("nome_evento"));
                    e.setData_evento(r.getString("data_evento"));
                    e.setValor_total(r.getString("valor_total"));
                    e.setOrganizador(r.getString("organizador"));
                    e.setNotas(r.getString("notas"));
                }
            } finally {
                statement.close();
                connection.close();
            }
        }catch (SQLException ex) {
                ex.printStackTrace();
        }
        return e;
    }

    @Override
    public Evento put(Integer key, Evento value) {
        String query;
        int autoGeneratedKeys;
        boolean isUpdate;
        if (key < 0) {
            isUpdate = false;
            query = INSERT_EVENTO;
            autoGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
        }
        else {
            isUpdate = true;
            query = UPDATE_EVENTO;
            autoGeneratedKeys = Statement.NO_GENERATED_KEYS;
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(query,autoGeneratedKeys);

            statement.setString(1,value.getNome_evento());
            statement.setString(2,value.getData_evento());
            statement.setString(3,value.getValor_total());
            statement.setString(4,value.getOrganizador());
            statement.setString(5,value.getNotas());

            if (isUpdate) {
                statement.setInt(6, key);
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
    public Evento remove(Object key) {
        Evento evento = get(key);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(DELETE_EVENTO);

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
        return evento;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Evento> m) {
        for(Evento e : m.values())
            put(e.getId(), e);
    }

    @Override
    public void clear() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_EVENTOS);
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
    public Collection<Evento> values() {
        ArrayList<Evento> r = new ArrayList<>();
        try {
            Evento e;

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_EVENTOS);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    e = new Evento();
                    e.setId(result.getInt("id"));
                    e.setNome_evento(result.getString("nome_evento"));
                    e.setData_evento(result.getString("data_evento"));
                    e.setValor_total(result.getString("valor_total"));
                    e.setOrganizador(result.getString("organizador"));
                    e.setNotas(result.getString("notas"));

                    r.add(e);
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
    public Set<Entry<Integer, Evento>> entrySet() {
        return null;
    }
}
