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
}
