package com.example.buoi1laptrinhphantan;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AgeCalculatorController {
    @FXML
    TextField year;
    @FXML
    protected void calculateAge() {
        int now = 2023;
        int age = now - Integer.parseInt(year.getText());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Tuổi của bạn là: " + age);
        alert.show();
    }
}
