package co.edu.uniquindio.subasta.subastasuq.model.utils;

import co.edu.uniquindio.subasta.subastasuq.model.SubastaQuindio;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;

public class RegistroUtils {
    public static SubastaQuindio inicializarDatos() {
        SubastaQuindio subastaQuindio = new SubastaQuindio();

        Usuario usuario = new Usuario();
        usuario.setNombreUsuario("Johan");
        usuario.setContrasena("Johan2108");
        usuario.setNombre("Johan Estiven");
        usuario.setApellido("Zapata");
        usuario.setCedula("10948");
        usuario.setEdad(12454);
        subastaQuindio.getListaUsuarios().add(usuario);

        return subastaQuindio;
    }
}
