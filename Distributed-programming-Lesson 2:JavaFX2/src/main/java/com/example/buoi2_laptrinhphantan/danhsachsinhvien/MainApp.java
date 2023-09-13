package com.example.buoi2_laptrinhphantan.danhsachsinhvien;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
//        System.out.println(getClass().getResource("com/example/buoi2_laptrinhphantan/student_list.fxml"));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("student_list.fxml"));
        VBox root = loader.load();
        StudentListController controller = loader.getController();

        // Add sample data
        controller.getListView().getItems().addAll(
                new Student1(1, "John Doe", 20),
                new Student1(2, "Jane Smith", 22),
                new Student1(3, "David Johnson", 19)
        );

        primaryStage.setTitle("Student List");
        primaryStage.setScene(new Scene(root, 200, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

