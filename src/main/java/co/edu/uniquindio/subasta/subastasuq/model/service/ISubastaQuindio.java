package co.edu.uniquindio.subasta.subastasuq.model.service;

import co.edu.uniquindio.subasta.subastasuq.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;

import java.util.ArrayList;

public interface ISubastaQuindio {
    
    Usuario crearUsuario(String nombreUsuario, String contrasena, String nombre, String apellido, String cedula, int edad) throws UsuarioException;

    void agregarUsuario(Usuario nuevoUsuario) throws UsuarioException;

    boolean verificarUsuarioExistente(String cedula) throws UsuarioException;

    ArrayList<Usuario> obtenerUsuarios();

    Usuario obtenerUsuario(String nombreUsuario);
}
