package com.company;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MiConexion {
    private Connection con;

    public MiConexion(String ip, String user, String passwd, String db) throws SQLException {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = String.format("jdbc:mariadb://%s:%d/%s",ip,3306,db);
        con = DriverManager.getConnection(url, user, passwd);
    }

    public Connection getCon() {
        return con;
    }



}
