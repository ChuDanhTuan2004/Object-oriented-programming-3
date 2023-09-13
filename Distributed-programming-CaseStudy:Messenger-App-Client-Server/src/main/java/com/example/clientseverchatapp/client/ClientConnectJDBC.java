package com.example.clientseverchatapp.client;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ClientConnectJDBC {
    private String localhost = "localhost:3306";
    private String dbName = "MessengerAppDatabase";
    private String userName = "root";
    private String password = "1";
    private String connect = "jdbc:mysql://" + localhost + "/" + dbName;

    public ClientConnectJDBC() {
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connect, userName, password);
            System.out.println("Connect complete to database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
