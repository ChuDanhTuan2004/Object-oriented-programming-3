package com.example.clientseverchatapp.loginandregister;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {

    @FXML
    private Label firstnamelabel;
    @FXML
    private Label lastnamelabel;
    @FXML
    private TextField firstnametextfield;
    @FXML
    private TextField lastnametextfield;
    @FXML
    private Label passwordlabel;
    @FXML
    private PasswordField passwordpwf;
    @FXML
    private Label confirmpasswordlabel;
    @FXML
    private PasswordField confirmpasswordpwf;
    @FXML
    private Label usernamelabel;
    @FXML
    private TextField usernametextfield;
    @FXML
    private Button registerbutton;
    @FXML
    private Button closebutton;
    @FXML
    private ImageView logoregisterimageview;
    @FXML
    private Label registrationmesslabel;
    @FXML
    private Label warningnotmatch;
    private Stage stage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File logoFile = new File("/home/tuancd/IdeaProjects/client-sever-chat-app/img/vintageicon.png");
        Image logoImage = new Image(logoFile.toURI().toString());
        logoregisterimageview.setImage(logoImage);
    }

    public void registerButtonOnAction(ActionEvent event) {
        if (passwordpwf.getText().equals(confirmpasswordpwf.getText())) {
            registerUser();
            warningnotmatch.setText("");
        } else {
            warningnotmatch.setText("!");
        }
    }

    public void closeButtonOnAction(ActionEvent event) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/clientseverchatapp/loginandregister/login.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 520, 323);
            Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void registerUser() {
        ConnectJDBC connectNow = new ConnectJDBC();
        Connection connection = connectNow.connect();

        String firstname = firstnametextfield.getText();
        String lastname = lastnametextfield.getText();
        String username = usernametextfield.getText();
        String password = passwordpwf.getText();

        String insertFields = "INSERT INTO user_account(firstname, lastname, username, password) VALUES ('";
        String insertValues = firstname + "','" + lastname + "','" + username + "','" + password + "')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(insertToRegister);

            registrationmesslabel.setText("Success!");
        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();
        }
    }
}
