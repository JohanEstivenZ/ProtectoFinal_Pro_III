package co.edu.uniquindio.subasta.subastasuq.controller.service;

import co.edu.uniquindio.subasta.subastasuq.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;

public interface IRegistroService {

    boolean agregarEmpleado(UsuarioDto usuarioDto);

    boolean eliminarEmpleado(String cedula);

    void registrarAcciones(String mensaje, int nivel, String accion);
}
