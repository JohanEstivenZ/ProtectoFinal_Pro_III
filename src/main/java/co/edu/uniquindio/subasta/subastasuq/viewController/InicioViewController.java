package co.edu.uniquindio.subasta.subastasuq.viewController;

import co.edu.uniquindio.subasta.subastasuq.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
public class InicioViewController {

    @FXML
    private AnchorPane Principal;
    @FXML
    private AutentificacionViewController nullController;

    @Deprecated
    void nuevoUsuario (ActionEvent event) {
        Usuario usuarioService = new Usuario();

        // Llamada al método de la clase UsuarioService
     /*   usuarioService.agregarUsuario(txtNombre.getText(), txtApellido.getText(), txtCedula.getText(),
                Integer.parseInt(txtEdad.getText()), txtUsuario.getText(),
                txtContrasena.getText());
    }*/

    }
   /* private void obtenerUsiario() {
        listaUsuariosDto
        listaEmpleadosDto.addAll(empleadoControllerService.obtenerEmpleados());
    }*/
}
