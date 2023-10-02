package co.edu.uniquindio.subasta.subastasuq.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.security.Principal;

public class SubastaQViewController {

    @FXML
    private TextField txtNombre;
    @FXML
    private TextField txtApellido;
    @FXML
    private TextField txtCedula;
    @FXML
    private TextField txtEdad;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtContrasena;
    @FXML
    private Button btnRegistrase;

    @FXML
    private AnchorPane Principal;
    @FXML
    private TextField loginUsuario;
    @FXML
    private PasswordField loginContrasena;
    @FXML
    private CheckBox showContrasena;
    @FXML
    private Button btnAutentificarse;
}
