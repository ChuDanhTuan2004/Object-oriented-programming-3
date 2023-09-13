package com.example.buoi4_laptrinhphantan_baitap4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.*;
import java.net.Socket;

public class Client extends Application {
    private BufferedReader reader;
    private PrintWriter writer;
    private TextArea chatTextArea;
    private TextField messageTextField;
    private Button sendButton;
    private String serverHost = "localhost";
    private int serverPort = 8890;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load giao diện người dùng từ file fxml
        FXMLLoader loader = new FXMLLoader(getClass().getResource("client.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("JavaFX Chat Client");
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();

        // Lấy các thành phần trên giao diện
        chatTextArea = (TextArea) loader.getNamespace().get("chatTextArea");
        messageTextField = (TextField) loader.getNamespace().get("messageTextField");
        sendButton = (Button) loader.getNamespace().get("sendButton");

        // Kết nối tới Server
        Socket socket = new Socket(serverHost, serverPort);
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        writer = new PrintWriter(socket.getOutputStream(), true);

        // Bắt đầu một luồng mới để nhận tin nhắn từ Server
        new Thread(() -> {
            try {
                while (true) {
                    String message = reader.readLine();
                    chatTextArea.appendText(message + "\n");
                }
            } catch (IOException e) {
                System.out.println("Server đã ngắt kết nối.");
            }
        }).start();

        // Xử lý sự kiện khi người dùng gửi tin nhắn
        sendButton.setOnAction(event -> {
            String message = messageTextField.getText();
            writer.println(message);
            messageTextField.clear();
        });
    }
}
