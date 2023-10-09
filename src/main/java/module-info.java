module application {
    requires javafx.controls;
    requires javafx.fxml;


    exports co.edu.uniquindio.subasta.subastasuq.exceptions;
    opens co.edu.uniquindio.subasta.subastasuq.exceptions to javafx.fxml;
    exports co.edu.uniquindio.subasta.subastasuq.controller;
    opens co.edu.uniquindio.subasta.subastasuq.controller to javafx.fxml;
    exports co.edu.uniquindio.subasta.subastasuq;
    opens co.edu.uniquindio.subasta.subastasuq to javafx.fxml;
    exports co.edu.uniquindio.subasta.subastasuq.viewController;
    opens co.edu.uniquindio.subasta.subastasuq.viewController to javafx.fxml;
    exports co.edu.uniquindio.subasta.subastasuq.controller.service;
    opens co.edu.uniquindio.subasta.subastasuq.controller.service to javafx.fxml;

}