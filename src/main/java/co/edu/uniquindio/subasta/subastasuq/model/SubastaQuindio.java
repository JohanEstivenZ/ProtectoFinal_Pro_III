package co.edu.uniquindio.subasta.subastasuq.model;

import co.edu.uniquindio.subasta.subastasuq.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.subastasuq.model.service.ISubastaQuindio;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class SubastaQuindio implements ISubastaQuindio, Serializable {

    private static final long serialVersionUID = 1L;
    ArrayList<Anuncio> listaAnunciantes = new ArrayList<>();
    ArrayList<Comprador> listaCompradores = new ArrayList<>();
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public SubastaQuindio() {
    }

    public ArrayList<Anuncio> getListaAnunciantes() {

        return listaAnunciantes;
    }



    public void setListaAnunciantes(ArrayList<Anuncio> listaAnunciantes) {
        this.listaAnunciantes = listaAnunciantes;
    }

    public ArrayList<Comprador> getListaCompradores() {
        return listaCompradores;
    }

    public void setListaCompradores(ArrayList<Comprador> listaCompradores) {
        this.listaCompradores = listaCompradores;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }



    @Override
    public Usuario crearUsuario(String nombreUsuario, String contrasena, String nombre, String apellido, String cedula, int edad) throws UsuarioException {
        Usuario nuevoUsuario = null;
        boolean usuarioExistente = verificarUsuarioExistente(cedula);
        if (usuarioExistente) {
            throw new UsuarioException("El usuario con la cedula: " + cedula + " ya existe");
        } else {
            nuevoUsuario = new Usuario();
            nuevoUsuario.setNombreUsuario(nombreUsuario);
            nuevoUsuario.setContrasena(contrasena);
            nuevoUsuario.setNombre(nombre);
            nuevoUsuario.setApellido(apellido);
            nuevoUsuario.setCedula(cedula);
            nuevoUsuario.setEdad(edad);
            getListaUsuarios().add(nuevoUsuario);
        }
        return nuevoUsuario;
    }
    public void agregarUsuario(Usuario nuevoUsuario) throws UsuarioException{
        getListaUsuarios().add(nuevoUsuario);
    }


    @Override
    public boolean verificarUsuarioExistente(String cedula) throws UsuarioException {
        if (usuarioExiste(cedula)) {
            throw new UsuarioException("El usuario: " + cedula + " ya existe");
        } else {
            return false;
        }
    }

    public boolean usuarioExiste(String cedula) {
        boolean usuarioEncontrado = false;
        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(cedula)) {
                usuarioEncontrado = true;
                break;
            }
        }
        return usuarioEncontrado;
    }

    @Override
    public ArrayList<Usuario> obtenerUsuarios() {
        // TODO Auto-generated method stub
        return getListaUsuarios();
    }
    @Override
    public Usuario obtenerUsuario(String nombreUsuario) {
        Usuario usuarioEncontrado = null;
        for (Usuario usuario : getListaUsuarios()) {
            if(usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario)){
                usuarioEncontrado = usuario;
                break;
            }
        }
        return usuarioEncontrado;
    }



    public Anuncio crearAnuncio( String nombreAnuncio, String codigoAnuncio, String nombreProducto, String tipoProducto) {
        Anuncio nuevoAnuncio = null;
            nuevoAnuncio = new Anuncio();
            nuevoAnuncio.setNombreAnuncio(nombreAnuncio);
            nuevoAnuncio.setCodigoAnuncio(codigoAnuncio);
            nuevoAnuncio.setNombreProducto(nombreProducto);
            nuevoAnuncio.setTipoProducto(tipoProducto);

            getListaAnunciantes().add(nuevoAnuncio);

        return nuevoAnuncio;
    }

    public void agregarAnuncio(Anuncio nuevoAnuncio) {
        getListaAnuncios().add(nuevoAnuncio);
    }

    private Collection<Anuncio> getListaAnuncios() {
        Anunciante anunciante = new Anunciante(); // Crear una instancia de la clase Anunciante
        ArrayList<Anuncio> listaAnuncios = Anunciante.getListaAnuncios(); // Obtener la lista de anuncios desde la instancia
        return listaAnuncios; // Devolver la lista de anuncios
    }

    public Boolean eliminarEmpleado(String nombreUsuario) throws UsuarioException {
        Usuario usuario = null;
        boolean flagExiste = false;
        usuario = obtenerUsuario(nombreUsuario);
        if(usuario == null)
            throw new UsuarioException("El usuario a eliminar no existe");
        else{
            getListaUsuarios().remove(usuario);
            flagExiste = true;
        }
        return flagExiste;
    }
}




