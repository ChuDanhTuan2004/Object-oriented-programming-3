package com.example.buoi1laptrinhphantan;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalcController {
    @FXML
    private TextField number1Field;

    @FXML
    private TextField number2Field;

    @FXML
    private Label resultLabel;

    @FXML
    private void add() {
        double number1 = Double.parseDouble(number1Field.getText());
        double number2 = Double.parseDouble(number2Field.getText());

        double result = number1 + number2;

        showResult("Addition", number1 + " + " + number2 + " = " + result);
    }

    @FXML
    private void subtract() {
        double number1 = Double.parseDouble(number1Field.getText());
        double number2 = Double.parseDouble(number2Field.getText());

        double result = number1 - number2;

        showResult("Subtraction", number1 + " - " + number2 + " = " + result);
    }

    @FXML
    private void multiply() {
        double number1 = Double.parseDouble(number1Field.getText());
        double number2 = Double.parseDouble(number2Field.getText());

        double result = number1 * number2;

        showResult("Multiplication", number1 + " * " + number2 + " = " + result);
    }

    @FXML
    private void divide() {
        double number1 = Double.parseDouble(number1Field.getText());
        double number2 = Double.parseDouble(number2Field.getText());

        double result = number1 / number2;

        showResult("Division", number1 + " / " + number2 + " = " + result);
    }

    private void showResult(String operation, String result) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Calculation Result");
        alert.setHeaderText(operation);
        alert.setContentText(result);
        alert.show();

        resultLabel.setText(result);
    }
}
