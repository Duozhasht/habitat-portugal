package Persistence;

import Model.Voluntario;

import java.sql.*;
import java.util.*;

/**
 * @author davide on 18/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class VoluntarioRepository implements Map<Integer, Voluntario> {
    private static final String INSERT_VOLUNTARIO = "insert into voluntario (nome_voluntario, data_nascimento, profissao, morada, contacto, hab_academ, conhec_lingui, exp_voluntariado, conhec_constr, trabalho_grupo, pub , disponi_tempo, cca_habitat) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_VOLUNTARIO = "update voluntario set nome_voluntario = ?, data_nascimento = ?, profissao = ?, morada = ?, contacto = ?, hab_academ = ?, conhec_lingui = ?, exp_voluntariado = ?, conhec_constr = ?, trabalho_grupo = ?, pub  = ?, disponi_tempo = ?, cca_habitat = ? where id_voluntario = ?";

    private static final String SELECT_VOLUNTARIO = "select * from voluntario where id_voluntario = ?";
    private static final String SELECT_VOLUNTARIOS = "select * from voluntario";
    private static final String SELECT_BY_GRUPO = "select * from grupo_voluntario where id_grupo = ?";

    private static final String DELETE_VOLUNTARIO = "delete from voluntario where id_voluntario = ?";
    private static final String DELETE_VOLUNTARIOS = "delete from voluntario";

    private static final String COUNT_VOLUNTARIOS = "select count(*) as n from voluntario";
    private static final String SELECT_IDS = "select id_voluntario from voluntario";

    private final String url;
    private final String user;
    private final String password;

    public VoluntarioRepository(String url, String user, String password) {
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

            try (ResultSet resultSet = statement.executeQuery(COUNT_VOLUNTARIOS)) {
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
            PreparedStatement statement = connection.prepareStatement(SELECT_VOLUNTARIO);

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
        return containsKey(((Voluntario) value).getId_voluntario());
    }

    @Override
    public Voluntario get(Object key) {
        Voluntario voluntario = null;
        try {

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_VOLUNTARIO);

            statement.setInt(1,(int) key);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    voluntario = new Voluntario();
                    voluntario.setId_voluntario(result.getInt("id_voluntario"));
                    voluntario.setNome_voluntario(result.getString("nome_voluntario"));
                    voluntario.setData_nascimento(result.getDate("data_nascimento"));
                    voluntario.setProfissao(result.getString("profissao"));
                    voluntario.setMorada(result.getString("morada"));
                    voluntario.setContacto(result.getString("contacto"));
                    voluntario.setHab_academ(result.getString("hab_academ"));
                    voluntario.setConhec_lingui(result.getString("conhec_lingui"));
                    voluntario.setExp_voluntariado(result.getString("exp_voluntariado"));
                    voluntario.setConhec_constr(result.getBoolean("conhec_constr"));
                    voluntario.setTrabalho_grupo(result.getBoolean("trabalho_grupo"));
                    voluntario.setPub(result.getBoolean("pub"));
                    voluntario.setDisponi_tempo(result.getString("disponi_tempo"));
                    voluntario.setCca_habitat(result.getString("cca_habitat"));
                }
            } finally {
                statement.close();
                connection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voluntario;
    }

    @Override
    public Voluntario put(Integer key, Voluntario value) {
        String query;
        int autoGeneratedKeys;
        boolean isUpdate;
        if (key < 0) {
            isUpdate = false;
            query = INSERT_VOLUNTARIO;
            autoGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
        }
        else {
            isUpdate = true;
            query = UPDATE_VOLUNTARIO;
            autoGeneratedKeys = Statement.NO_GENERATED_KEYS;
        }

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(query,autoGeneratedKeys);

            statement.setString(1, value.getNome_voluntario());
            statement.setDate(2, value.getData_nascimento());
            statement.setString(3, value.getProfissao());
            statement.setString(4, value.getMorada());
            statement.setString(5, value.getContacto());
            statement.setString(6, value.getHab_academ());
            statement.setString(7, value.getConhec_lingui());
            statement.setString(8, value.getExp_voluntariado());
            statement.setBoolean(9, value.getConhec_constr());
            statement.setBoolean(10, value.getTrabalho_grupo());
            statement.setBoolean(11, value.getPub());
            statement.setString(12, value.getDisponi_tempo());
            statement.setString(13, value.getCca_habitat());

            if (isUpdate) {
                statement.setInt(14,key);
            }

            statement.executeUpdate();

            try {
                if (autoGeneratedKeys == Statement.RETURN_GENERATED_KEYS) {
                    ResultSet keys = statement.getGeneratedKeys();
                    if (keys != null && keys.next()) {
                        value.setId_voluntario(keys.getInt(1));
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
    public Voluntario remove(Object key) {
        Voluntario v = get(key);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(DELETE_VOLUNTARIO);

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
        return v;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Voluntario> m) {
        for (Voluntario v : m.values()) {
            put(v.getId_voluntario(),v);
        }
    }

    @Override
    public void clear() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_VOLUNTARIOS);
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
    public Collection<Voluntario> values() {
        ArrayList<Voluntario> r = new ArrayList<>();
        try {
            Voluntario voluntario;

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(SELECT_VOLUNTARIOS);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    voluntario = new Voluntario();

                    voluntario.setId_voluntario(result.getInt("id_voluntario"));
                    voluntario.setNome_voluntario(result.getString("nome_voluntario"));
                    voluntario.setData_nascimento(result.getDate("data_nascimento"));
                    voluntario.setProfissao(result.getString("profissao"));
                    voluntario.setMorada(result.getString("morada"));
                    voluntario.setContacto(result.getString("contacto"));
                    voluntario.setHab_academ(result.getString("hab_academ"));
                    voluntario.setConhec_lingui(result.getString("conhec_lingui"));
                    voluntario.setExp_voluntariado(result.getString("exp_voluntariado"));
                    voluntario.setConhec_constr(result.getBoolean("conhec_constr"));
                    voluntario.setTrabalho_grupo(result.getBoolean("trabalho_grupo"));
                    voluntario.setPub(result.getBoolean("pub"));
                    voluntario.setDisponi_tempo(result.getString("disponi_tempo"));
                    voluntario.setCca_habitat(result.getString("cca_habitat"));

                    r.add(voluntario);
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
    public Set<Entry<Integer, Voluntario>> entrySet() {
        return null;
    }

    public List<Voluntario> findByGrupo(int id) {
        List<Voluntario> lista = new ArrayList<>();
        try {

            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_GRUPO);

            statement.setInt(1,id);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    if (containsKey(result.getInt("id_voluntario"))) {
                        Voluntario voluntario = get(result.getInt("id_voluntario"));
                        lista.add(voluntario);
                    }
                }
            } finally {
                statement.close();
                connection.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return lista;
    }
}
