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
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private Button cancelbutton;

    @FXML
    private Button loginbutton;

    @FXML
    private Label loginmessagelabel;

    @FXML
    private ImageView brandimageview;

    @FXML
    private TextField enterusernametextfield;

    @FXML
    private PasswordField enterpasswordtextfield;

    public void loginButtonAction(ActionEvent event){
        if (enterusernametextfield.getText().isBlank() == false && enterpasswordtextfield.getText().isBlank() == false) {
            validateLogin(event);
        } else {
            loginmessagelabel.setText("Please enter username and password!");
        }
    }

    public void cancelButtonAction(ActionEvent event){
        Stage stage = (Stage) cancelbutton.getScene().getWindow();
        stage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File brandFile = new File("/home/tuancd/IdeaProjects/client-sever-chat-app/img/vintagebrand.png");
        Image brandImage = new Image(brandFile.toURI().toString());
        brandimageview.setImage(brandImage);
    }

    public void validateLogin(ActionEvent event){
        ConnectJDBC connectNow = new ConnectJDBC();
        Connection connection = connectNow.connect();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '"+enterusernametextfield.getText()+"' AND password = '"+enterpasswordtextfield.getText()+"' ";

        try{
            Statement statement = connection.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while (queryResult.next()){
                if (queryResult.getInt(1)==1){
                    switchToClient(event);
                } else {
                    loginmessagelabel.setText("@Invalid login, please try again!");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void switchToClient(ActionEvent event) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("/com/example/clientseverchatapp/client/client-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 520, 483);
        Stage stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
