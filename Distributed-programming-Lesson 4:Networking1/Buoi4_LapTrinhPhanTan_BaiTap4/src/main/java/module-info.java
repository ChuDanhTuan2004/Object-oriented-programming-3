module com.example.buoi4_laptrinhphantan_baitap4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buoi4_laptrinhphantan_baitap4 to javafx.fxml;
    exports com.example.buoi4_laptrinhphantan_baitap4;
}