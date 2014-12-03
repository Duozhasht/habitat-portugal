package Persistence;

import java.sql.*;

/**
 * Created by Tiago on 03/12/14.
 */
public class DefaultConnection {

    private Connection connection;
    private Statement statement;
    private ResultSet  resultset;

    private String url;
    private String user;
    private String password;


    public DefaultConnection(String url, String user, String password){
        this.connection = null;
        this.statement = null;
        this.resultset = null;

        this.url = "jdbc:mysql://banze.com.pt:3306/banzeco/banze_habitat";
        this.user="banzeco_habitat";
        this.password="habitatmysql";


    }


}
