package co.edu.uniquindio.subasta.subastasuq;

import co.edu.uniquindio.subasta.subastasuq.controller.ModelFactoryController;
import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;

import java.util.List;

public class MainSubastas {

    public static void main(String[] args) {
        ModelFactoryController modelFactoryController = ModelFactoryController.getInstance();

        UsuarioDto usuarioDto = new UsuarioDto(
                "johanestiven",
                "johan10",
                "johan estiven",
                "zapata",
                "1094",
                "18"
        );

        if(modelFactoryController.agregarUsuario(usuarioDto)){
            System.out.println("No existe se agrgeo correctamente");
        }else{
            System.out.println("Ya existe");
        }

        List<UsuarioDto> usuarioDtoList = modelFactoryController.obtenerUsuarios();
        usuarioDtoList.forEach(System.out::println);
    }



}
