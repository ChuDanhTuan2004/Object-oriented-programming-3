module com.example.buoi2_laptrinhphantan {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.buoi2_laptrinhphantan to javafx.fxml;
    exports com.example.buoi2_laptrinhphantan;

    exports com.example.buoi2_laptrinhphantan.danhsachsinhvien;
    opens com.example.buoi2_laptrinhphantan.danhsachsinhvien to javafx.fxml;

    exports com.example.buoi2_laptrinhphantan.tracnghiem;
    opens com.example.buoi2_laptrinhphantan.tracnghiem to javafx.fxml;

    exports com.example.buoi2_laptrinhphantan.khaosat;
    opens com.example.buoi2_laptrinhphantan.khaosat to javafx.fxml;

    exports com.example.buoi2_laptrinhphantan.quanlydiemso;
    opens com.example.buoi2_laptrinhphantan.quanlydiemso to javafx.fxml;
}