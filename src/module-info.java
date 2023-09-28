module application {
    requires javafx.controls;
    requires javafx.fxml;




    exports application;
    opens application to javafx.fxml;
    exports Controlador;
    opens Controlador to javafx.fxml;
}