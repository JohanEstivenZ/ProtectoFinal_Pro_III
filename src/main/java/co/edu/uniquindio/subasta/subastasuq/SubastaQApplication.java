package co.edu.uniquindio.subasta.subastasuq;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class SubastaQApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SubastaQApplication.class.getResource("/co.edu.uniquindio.subas.subastasuq/subastas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 560);
        stage.setTitle("ProtectoFinal_Pro_III");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}