package co.edu.uniquindio.subasta.subastasuq.controller.service;

import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;

import java.util.List;

public interface IModelFactoryService {

    List<UsuarioDto> obtenerUsuarios();


    boolean agregarUsuario(UsuarioDto usuarioDto);

    boolean eliminarEmpleado(String nombreUsuario);
}
