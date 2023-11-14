package co.edu.uniquindio.subasta.subastasuq.viewController;

import co.edu.uniquindio.subasta.subastasuq.controller.RegistroController;
import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

import java.util.Optional;

public class RegistroViewController {

    RegistroController registroControllerService;

    ObservableList<UsuarioDto> listaUsuariosDto = FXCollections.observableArrayList();
    UsuarioDto usuarioSeleccionado;
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
    private TextField txtContrasena;
    @FXML
    private Button btnRegistrase;

    @FXML
    public void nuevoUsuario(ActionEvent actionEvent) {
        crearUsuario();
    }

    @FXML
    void  initialize (){
        registroControllerService = new RegistroController();
        //intiView();
    }
    private void intiView() {
        initDataBinding();
        obtenerUsuarios();
        //tableEmpleados.getItems().clear();
        //tableEmpleados.setItems(listaEmpleadosDto);
        //listenerSelection();
    }
    private void initDataBinding() {
        //tcNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombre()));
        //tcApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().apellido()));
        //tcCedula.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().cedula()));
        //tcTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().telefono()));
        //tcCorreo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().correo()));
        //tcFechaNacimiento.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().fechaNacimiento()));
        //tcSalario.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().salario())));
        //tcCodigo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigo()));
    }
    private void obtenerUsuarios() {

        listaUsuariosDto.addAll(registroControllerService.obtenerUsuarios());
    }

    private void listenerSelection() {
        //tableEmpleados.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
        //empleadoSeleccionado = newSelection;
        //mostrarInformacionEmpleado(empleadoSeleccionado);
    //}
    }

    private void crearUsuario() {
        //1. Capturar los datos
        UsuarioDto usuarioDto = construirUsuarioDto();
        //2. Validar la información
        if(datosValidos(usuarioDto)){
            if(registroControllerService.agregarUsuario(usuarioDto)){
                listaUsuariosDto.add(usuarioDto);
                mostrarMensaje("Notificación empleado", "Empleado creado", "El empleado se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposUsuario();
                registrarAcciones("Empleado agregado",1, "Agregar empleado");
            }else{
                mostrarMensaje("Notificación empleado", "Empleado no creado", "El empleado no se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("Notificación empleado", "Empleado no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
        }

    }

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        registroControllerService.registrarAcciones(mensaje, nivel, accion);
    }

    private void limpiarCamposUsuario() {
        txtNombre.setText("");
        txtApellido.setText("");
        txtCedula.setText("");
        txtEdad.setText("");
        txtContrasena.setText("");
        txtUsuario.setText("");
    }


    private UsuarioDto construirUsuarioDto() {
        return new UsuarioDto(
                txtUsuario.getText(),
                txtContrasena.getText(),
                txtNombre.getText(),
                txtApellido.getText(),
                txtCedula.getText(),
                txtEdad.getText()
                );
    }

    private boolean datosValidos(UsuarioDto usuarioDto) {
        String mensaje = "";
        if(usuarioDto.nombre() == null || usuarioDto.nombre().equals(""))
            mensaje += "El nombre es invalido \n" ;
        if(usuarioDto.apellido() == null || usuarioDto.apellido() .equals(""))
            mensaje += "El apellido es invalido \n" ;
        if(usuarioDto.cedula() == null || usuarioDto.cedula().equals(""))
            mensaje += "El documento es invalido \n" ;
        if(usuarioDto.nombreUsuario() == null || usuarioDto.nombreUsuario().equals(""))
            mensaje += "El nombre de usuario es invalido \n" ;
        if(usuarioDto.edad() == null || usuarioDto.edad().equals(""))
            mensaje += "La edad del usuario es invalida \n" ;
        if(usuarioDto.contrasena() == null || usuarioDto.contrasena().equals(""))
            mensaje += "La contraseña del usuario es invalida \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente","Datos invalidos",mensaje, Alert.AlertType.WARNING);
            return false;
        }
    }
    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

}
