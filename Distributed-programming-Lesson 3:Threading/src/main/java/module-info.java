module com.example.buoi3_laptrinhphantan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buoi3_laptrinhphantan to javafx.fxml;
    exports com.example.buoi3_laptrinhphantan;
    exports com.example.buoi3_laptrinhphantan.enumrunnable;
    opens com.example.buoi3_laptrinhphantan.enumrunnable to javafx.fxml;
    exports com.example.buoi3_laptrinhphantan.enumthread;
    opens com.example.buoi3_laptrinhphantan.enumthread to javafx.fxml;
    exports com.example.buoi3_laptrinhphantan.carthread;
    opens com.example.buoi3_laptrinhphantan.carthread to javafx.fxml;
}