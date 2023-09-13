package com.example.clientseverchatapp.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ServerConnectJDBC {
    private String localHost = "localhost:3306";
    private String dbName = "MessengerAppDatabase";
    private String userName = "root";
    private String passWord = "1";

    private String connect = "jdbc:mysql://" + localHost + "/" + dbName;

    public ServerConnectJDBC() {
    }

    public Connection connect() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(connect, userName, passWord);
            System.out.println("Connect Complete to Database");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}