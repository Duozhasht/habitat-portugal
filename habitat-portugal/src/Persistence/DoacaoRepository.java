package Persistence;

import Model.Doacao;

import java.sql.*;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/**
 * @author davide on 20/12/14.
 */

@SuppressWarnings("UnusedDeclaration")
public class DoacaoRepository implements Map<Integer, Doacao> {

    private static final String INSERT_DOACAO = "insert into doacao (descricao, quantidade, tipo, doador_id) values (?,?,?,?)";
    private static final String UPDATE_DOACAO = "update doacao set descricao = ?, quantidade = ?, tipo = ?, doador_id = ? where id_tarefa = ?";

    private static final String SELECT_DOACAO = "select * from doacao where id_doacao = ?";
    private static final String SELECT_DOACOES = "select id_tarefa, nome_tarefa, data_inicio, data_final, id_encarregado from doacao";

    private static final String DELETE_DOACAO = "delete from doacao where id_tarefa = ?";
    private static final String DELETE_DOACOES = "delete from doacao";

    private static final String COUNT_DOACOES = "select count(*) as n from doacao";
    private static final String SELECT_IDS = "select id_tarefa from doacao";

    private final String url;
    private final String user;
    private final String password;

    public DoacaoRepository(String url, String user, String password) {
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

            try (ResultSet resultSet = statement.executeQuery(COUNT_DOACOES)) {
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
            PreparedStatement statement = connection.prepareStatement(SELECT_DOACAO);

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
    public boolean containsValue(Object value) { return containsKey(((Doacao) value).getId_doacao()); }

    @Override
    public Doacao get(Object key) {
        return null;
    }

    @Override
    public Doacao put(Integer key, Doacao value) {
        return null;
    }

    @Override
    public Doacao remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Doacao> m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set<Integer> keySet() {
        return null;
    }

    @Override
    public Collection<Doacao> values() {
        return null;
    }

    @Override
    public Set<Entry<Integer, Doacao>> entrySet() {
        return null;
    }
}
