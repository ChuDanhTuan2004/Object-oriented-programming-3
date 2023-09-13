module com.example.buoi1laptrinhphantan {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.buoi1laptrinhphantan to javafx.fxml;
    exports com.example.buoi1laptrinhphantan;
}