package org.yltech.logindb.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private String URL ="jdbc:mysql://localhost:3306/LoginDB";
    private String User ="root";
    private String pass = "";

    private Connection connection;

    public Database() {
    }

    public Connection getConnection() throws SQLException {
        if (connection==null || connection.isClosed()){
            connection = DriverManager.getConnection(URL,User,pass);
        }
        return connection;
    }

    public boolean isConnected(){
        return connection != null;
    }
}
