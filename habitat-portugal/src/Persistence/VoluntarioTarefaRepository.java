package Persistence;

import Model.VoluntarioTarefa;

import java.sql.*;
import java.util.*;

/**
 * @author davide on 06/01/15.
 */

@SuppressWarnings("UnusedDeclaration")
public class VoluntarioTarefaRepository implements Map<Integer, VoluntarioTarefa> {

    private static final String INSERT_VOLUNTARIO_TAREFA = "INSERT INTO voluntario_tarefa (voluntario_id, tarefa_id, descricao, nr_horas) VALUES (?,?,?,?)";
    private static final String UPDATE_VOLUNTARIO_TAREFA = "UPDATE voluntario_tarefa SET voluntario_id = ?, tarefa_id = ?, descricao = ?, nr_horas = ? where id_voluntario_tarefa = ?";

    private static final String SELECT_VOLUNTARIO_TAREFA = "SELECT id_voluntario_tarefa, voluntario_id, tarefa_id, voluntario.nome_voluntario, descricao, nr_horas FROM voluntario_tarefa INNER JOIN voluntario ON voluntario.id_voluntario = voluntario_tarefa.voluntario_id WHERE id_voluntario_tarefa = ?";
    private static final String SELECT_VOLUNTARIOS_TAREFAS = "SELECT id_voluntario_tarefa, voluntario_id, tarefa_id, voluntario.nome_voluntario, descricao, nr_horas FROM voluntario_tarefa INNER JOIN voluntario ON voluntario.id_voluntario = voluntario_tarefa.voluntario_id";

    private static final String DELETE_VOLUNTARIO_TAREFA = "DELETE FROM voluntario_tarefa WHERE id_voluntario_tarefa = ?";
    private static final String DELETE_VOLUNTARIOS_TAREFAS = "DELETE FROM voluntario_tarefa";

    private static final String COUNT_VOLUNTARIO_TAREFA = "select count(*) as n from voluntario_tarefa";
    private static final String SELECT_IDS = "SELECT id_voluntario_tarefa FROM voluntario_tarefa";
    private static final String SELECT_BY_TAREFA = "select * from voluntario_tarefa where tarefa_id = ?";


    private final String url;
    private final String user;
    private final String password;

    public VoluntarioTarefaRepository(String url, String user, String password) {
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

            try (ResultSet resultSet = statement.executeQuery(COUNT_VOLUNTARIO_TAREFA)) {
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
            PreparedStatement statement = connection.prepareStatement(SELECT_VOLUNTARIO_TAREFA);

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

    public boolean containsValue(Object value) {
        return containsKey(((VoluntarioTarefa) value).getId_voluntario_tarefa());
    }

    @Override
    public VoluntarioTarefa get(Object key) {
        VoluntarioTarefa voluntarioTarefa = null;
        try {

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_VOLUNTARIO_TAREFA);

            statement.setInt(1,(int) key);

            try (ResultSet result = statement.executeQuery()) {
                if (result.next()) {
                    voluntarioTarefa = new VoluntarioTarefa();
                    voluntarioTarefa.setId_voluntario_tarefa(result.getInt("id_voluntario_tarefa"));
                    voluntarioTarefa.setId_voluntario(result.getInt("voluntario_id"));
                    voluntarioTarefa.setId_tarefa(result.getInt("tarefa_id"));
                    voluntarioTarefa.setNomeVoluntario(result.getString("nome_voluntario"));
                    voluntarioTarefa.setDescricao(result.getString("descricao"));
                    voluntarioTarefa.setNr_horas(result.getString("nr_horas"));

                }
            } finally {
                statement.close();
                connection.close();
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return voluntarioTarefa;
    }

    @Override
    public VoluntarioTarefa put(Integer key, VoluntarioTarefa value) {
        String query;
        int autoGeneratedKeys;
        boolean isUpdate;
        if (key < 0) {
            isUpdate = false;
            query = INSERT_VOLUNTARIO_TAREFA;
            autoGeneratedKeys = Statement.RETURN_GENERATED_KEYS;
        }
        else {
            isUpdate = true;
            query = UPDATE_VOLUNTARIO_TAREFA;
            autoGeneratedKeys = Statement.NO_GENERATED_KEYS;
        }

        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(query,autoGeneratedKeys);
            System.out.println(value.toString());
            statement.setInt(1, (value.getId_voluntario()));
            statement.setInt(2, value.getId_tarefa());
            statement.setString(3,(value.getDescricao()));
            statement.setString(4, (value.getNr_horas()));

            if (isUpdate) {
                statement.setLong(5,key);
            }

            statement.executeUpdate();

            try {
                if (autoGeneratedKeys == Statement.RETURN_GENERATED_KEYS) {
                    ResultSet keys = statement.getGeneratedKeys();
                    if (keys != null && keys.next()) {
                        value.setId_voluntario_tarefa(keys.getInt(1));
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
        System.out.println(value.toString());
        return value;
    }

    @Override
    public VoluntarioTarefa remove(Object key) {
        VoluntarioTarefa v = get(key);
        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            PreparedStatement statement = connection.prepareStatement(DELETE_VOLUNTARIO_TAREFA);

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
    public void putAll(Map<? extends Integer, ? extends VoluntarioTarefa> m) {
        for(VoluntarioTarefa v : m.values()) {
            put(v.getId_voluntario_tarefa(),v);
        }
    }

    @Override
    public void clear() {
        try {
            Connection connection = DriverManager.getConnection(url, user, password);

            try (Statement statement = connection.createStatement()) {
                statement.executeUpdate(DELETE_VOLUNTARIOS_TAREFAS);
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
    public Collection<VoluntarioTarefa> values() {
        ArrayList<VoluntarioTarefa> r = new ArrayList<>();
        try {
            VoluntarioTarefa voluntarioTarefa;

            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_VOLUNTARIOS_TAREFAS);

            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    voluntarioTarefa = new VoluntarioTarefa();

                    voluntarioTarefa.setId_voluntario_tarefa(result.getInt("id_voluntario_tarefa"));
                    voluntarioTarefa.setId_voluntario(result.getInt("id_voluntario"));
                    voluntarioTarefa.setId_tarefa(result.getInt("id_tarefa"));
                    voluntarioTarefa.setNomeVoluntario(result.getString("nome_voluntario"));
                    voluntarioTarefa.setDescricao(result.getString("descricao"));
                    voluntarioTarefa.setNr_horas(result.getString("nr_horas"));

                    r.add(voluntarioTarefa);
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
    public Set<Entry<Integer, VoluntarioTarefa>> entrySet() {
        return null;
    }

    public List<VoluntarioTarefa> findByTarefa(int id) {
        List<VoluntarioTarefa> lista = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(url,user,password);
            PreparedStatement statement = connection.prepareStatement(SELECT_BY_TAREFA);

            statement.setInt(1,id);

            try (ResultSet result = statement.executeQuery()) {
                while(result.next()) {
                    if (containsKey(result.getInt("id_voluntario_tarefa"))) {
                        VoluntarioTarefa voluntarioTarefa = get(result.getInt("id_voluntario_tarefa"));
                        System.out.println(voluntarioTarefa.toString());
                        lista.add(voluntarioTarefa);
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