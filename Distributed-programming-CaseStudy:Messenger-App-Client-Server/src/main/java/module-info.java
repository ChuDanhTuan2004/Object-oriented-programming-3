module com.example.clientseverchatapp {
    requires javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.clientseverchatapp to javafx.fxml;
    exports com.example.clientseverchatapp;

    opens com.example.clientseverchatapp.client to javafx.fxml;
    exports com.example.clientseverchatapp.client;

    opens com.example.clientseverchatapp.server to javafx.fxml;
    exports com.example.clientseverchatapp.server;

    opens com.example.clientseverchatapp.loginandregister to javafx.fxml;
    exports com.example.clientseverchatapp.loginandregister;
}