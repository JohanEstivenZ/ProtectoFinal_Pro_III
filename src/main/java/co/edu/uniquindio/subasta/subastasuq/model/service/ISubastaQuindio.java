package co.edu.uniquindio.subasta.subastasuq.model.service;

import co.edu.uniquindio.subasta.subastasuq.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;

import java.util.ArrayList;

public interface ISubastaQuindio {
    Usuario crearUsuario(String nombreUsuario, String contrasena) throws UsuarioException;

    void agregarEmpleado(Usuario nuevoUsuario) throws UsuarioException;

    boolean verificarUsuarioExistente(String nombreUsuario) throws UsuarioException;

    ArrayList<Usuario> obtenerUsuarios();
}
