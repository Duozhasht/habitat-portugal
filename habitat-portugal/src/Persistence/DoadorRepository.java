package Persistence;

import Model.Doador;

import java.sql.*;
import java.util.*;

/**
 * @author PeterO'Daktyl on 17-12-2014.
 */
@SuppressWarnings("UnusedDeclaration")
public class DoadorRepository implements Map<Integer, Doador> {

    private static final String INSERT_DOADOR = "insert into doador (nome_doador, contacto, telefone, morada, email, site, pessoa_contacto, nif, notas) values (?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_DOADOR = "update doador set nome_doador = ?, contacto = ?, telefone = ?, morada = ?, email = ?, site = ?, pessoa_contacto = ?, nif = ?, notas = ? where id_doador = ?";

    private static final String SELECT_DOADOR = "select nome_doador, contacto, telefone, morada, email, site, pessoa_contacto, nif, notas from doador where id_doador = ?";
    private static final String SELECT_DOADORES = "select id_doador, nome_doador, contacto, telefone, morada, email, site, pessoa_contacto, nif, notas from doador";

    private static final String DELETE_DOADOR = "delete from doador where id_doador = ?";
    private static final String DELETE_DOADORES = "delete from doador";

    private static final String COUNT_DOADORES = "select count(*) as n from doador";
    private static final String SELECT_IDS = "select id_doador from doador";

    private final String url;
    private final String user;
    private final String password;

    public DoadorRepository(String url, String user, String password) {
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

            try (ResultSet resultSet = statement.executeQuery(COUNT_DOADORES)) {
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
            PreparedStatement statement = connection.prepareStatement(SELECT_DOADOR);

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
    public boolean containsValue(Object value) { return containsKey(((Doador) value).getId()); }

    @Override
    public Doador get(Object key) {
        Doador doador = null;
        try {

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_DOADOR);

            statement.setInt(1, (int) key);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    doador = new Doador();
                    doador.setId((int)key);
                    doador.setNome(result.getString("nome_doador"));
                    doador.setContacto(result.getString("contacto"));
                    doador.setTelefone(result.getString("telefone"));
                    doador.setMorada(result.getString("morada"));
                    doador.setEmail(result.getString("email"));
                    doador.setSite(result.getString("site"));
                    doador.setPessoa_contacto(result.getString("pessoa_contacto"));
                    doador.setNif(result.getString("nif"));
                    doador.setNotas(result.getString("notas"));
                }
            } finally {
                statement.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return doador;
    }

    @Override
    public Doador put(Integer key, Doador value) {
        String query;
        int autoGeneratedKeys;
        boolean isUpdate;
        if (key < 0) {
            isUpdate = false;
            query = INSERT_DOADOR;
            autoGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
        }
        else {
            isUpdate = true;
            query = UPDATE_DOADOR;
            autoGeneratedKeys = Statement.NO_GENERATED_KEYS;
        }

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(query,autoGeneratedKeys);

            statement.setString(1,value.getNome());
            statement.setString(2,value.getContacto());
            statement.setString(3,value.getTelefone());
            statement.setString(4,value.getMorada());
            statement.setString(5,value.getEmail());
            statement.setString(6,value.getSite());
            statement.setString(7,value.getPessoa_contacto());
            statement.setString(8,value.getNif());
            statement.setString(9,value.getNotas());

            if (isUpdate) {
                statement.setInt(10, key);
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
    public Doador remove(Object key) {
        Doador doador = get(key);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(DELETE_DOADOR);

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
        return doador;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Doador> m) {
        for(Doador d : m.values())
            put(d.getId(), d);
    }

    @Override
    public void clear() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_DOADORES);
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
    public Collection<Doador> values() {
        ArrayList<Doador> r = new ArrayList<>();
        try {
            Doador d;

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_DOADORES);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    d = new Doador();
                    d.setId(result.getInt("id_doador"));
                    d.setNome(result.getString("nome_doador"));
                    d.setContacto(result.getString("contacto"));
                    d.setTelefone(result.getString("telefone"));
                    d.setMorada(result.getString("morada"));
                    d.setEmail(result.getString("email"));
                    d.setSite(result.getString("site"));
                    d.setPessoa_contacto(result.getString("pessoa_contacto"));
                    d.setNif(result.getString("nif"));
                    d.setNotas(result.getString("notas"));

                    r.add(d);
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
    public Set<Entry<Integer, Doador>> entrySet() {
        return null;
    }
}
