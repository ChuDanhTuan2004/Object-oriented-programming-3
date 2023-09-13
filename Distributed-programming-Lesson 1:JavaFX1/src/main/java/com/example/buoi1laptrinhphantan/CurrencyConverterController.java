package com.example.buoi1laptrinhphantan;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CurrencyConverterController {

    @FXML
    private TextField usdTextField;

    @FXML
    private Label vndValueLabel;

    @FXML
    private void convert() {
        try {
            double usd = Double.parseDouble(usdTextField.getText());
            double rate = 23000; // Tỉ giá USD - VND
            double vnd = usd * rate;
            vndValueLabel.setText(String.format("%.2f", vnd));
        } catch (NumberFormatException e) {
            vndValueLabel.setText("Invalid input!");
        }
    }
}
