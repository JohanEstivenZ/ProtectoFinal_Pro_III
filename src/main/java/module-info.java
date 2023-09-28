module com.example.protectofinal_pro_iii {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.protectofinal_pro_iii to javafx.fxml;
    exports com.example.protectofinal_pro_iii;
}