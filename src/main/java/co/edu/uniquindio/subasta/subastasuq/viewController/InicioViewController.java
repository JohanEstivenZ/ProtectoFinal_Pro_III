package co.edu.uniquindio.subasta.subastasuq.viewController;

import co.edu.uniquindio.subasta.subastasuq.model.Usuario;
import co.edu.uniquindio.subasta.subastasuq.model.service.ISubastaQuindio;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class InicioViewController {
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

    @FXML
    void nuevoUsuario(ActionEvent event){
        Usuario usuarioService = new Usuario();

        // Llamada al método de la clase UsuarioService
        usuarioService.agregarUsuario(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(),
                Integer.parseInt(txtEdad.getText()), txtUsuario.getText(),
                txtContrasena.getText());
    }
}
