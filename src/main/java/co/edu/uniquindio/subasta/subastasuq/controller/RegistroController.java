package co.edu.uniquindio.subasta.subastasuq.controller;

import co.edu.uniquindio.subasta.subastasuq.controller.service.IRegistroService;
import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;

import java.util.List;

public class RegistroController implements IRegistroService {
    ModelFactoryController modelFactoryController;

    public void UsuarioController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<UsuarioDto> obtenerUsuarios() {
        return modelFactoryController.obtenerUsuarios();
    }

    @Override
    public boolean agregarEmpleado(UsuarioDto usuarioDto) {
        return modelFactoryController.agregarUsuario(usuarioDto);
    }

    @Override
    public boolean eliminarEmpleado(String cedula) {
        return modelFactoryController.eliminarEmpleado(cedula);
    }

    //@Override
    //public boolean actualizarEmpleado(String cedulaActual, UsuarioDto usuarioDto) {
    //    return modelFactoryController.actualizarEmpleado(cedulaActual, usuarioDto);
    //}

    @Override
    public void registrarAcciones(String mensaje, int nivel, String accion) {
        modelFactoryController.registrarAccionesSistema(mensaje, nivel, accion);
    }
}
