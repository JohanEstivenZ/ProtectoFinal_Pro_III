package co.edu.uniquindio.subasta.subastasuq.model;

import co.edu.uniquindio.subasta.subastasuq.exceptions.AnuncioException;
import co.edu.uniquindio.subasta.subastasuq.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.subastasuq.model.service.ISubastaQuindio;

import java.util.ArrayList;

public class SubastaQuindio implements ISubastaQuindio {

    ArrayList<Anunciante> listaAnunciantes = new ArrayList<>();
    ArrayList<Comprador> listaCompradores = new ArrayList<>();
    ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public SubastaQuindio() {
    }

    public ArrayList<Anunciante> getListaAnunciantes() {
        return listaAnunciantes;
    }

    public void setListaAnunciantes(ArrayList<Anunciante> listaAnunciantes) {
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
        boolean usuarioExistente = verificarUsuarioExistente(nombreUsuario, cedula);
        if (usuarioExistente) {
            throw new UsuarioException("El usuario: " + nombreUsuario + " o la cedula: " + cedula + " ya existe");
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

    @Override
    public void agregarUsuario(Usuario nuevoUsuario) {
        getListaUsuarios().add(nuevoUsuario);
    }


    @Override
    public boolean verificarUsuarioExistente(String nombreUsuario, String cedula) throws UsuarioException {
        if (usuarioExiste(nombreUsuario, cedula)) {
            throw new UsuarioException("El usuario: " + nombreUsuario + " ya existe");
        } else {
            return false;
        }
    }

    public boolean usuarioExiste(String nombreUsuario, String cedula) {
        boolean usuarioEncontrado = false;
        for (Usuario usuario : getListaUsuarios()) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombreUsuario) || usuario.getCedula().equalsIgnoreCase(cedula)) {
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
}


    /*public Anuncio crearAnuncio( String nombreAnuncio, String codigoAnuncio, String nombreProducto, String tipoProducto) throws UsuarioException, AnuncioException {
        Anuncio nuevoAnuncio = null;
        boolean anuncioExistente = verificarAnuncioExistente(codigoAnuncio, tipoProducto);
        if(anuncioExistente){
            throw new AnuncioException("El producto: "+tipoProducto+" con codigo: "+codigoAnuncio+" ya existe");
        }else{
            nuevoAnuncio = new Anuncio();
            nuevoAnuncio.setNombreAnuncio(nombreAnuncio);
            nuevoAnuncio.setCodigoAnuncio(codigoAnuncio);
            nuevoAnuncio.setNombreProducto(nombreProducto);
            nuevoAnuncio.setTipoProducto(tipoProducto);

            getListaUsuarios().add(nuevoUsuario);
        }
        return nuevoUsuario;
    }
    public boolean verificarAnuncioExistente(String codigoAnuncio, String tipoProducto) throws AnuncioException {
        if(anuncioExistente(codigoAnuncio, tipoProducto)){
            throw new AnuncioException("El producto: "+tipoProducto+" con codigo: "+codigoAnuncio+" ya existe");
        }else{
            return false;
        }
    }
    public boolean anuncioExistente(String codigoAnuncio, String tipoProducto) {
        boolean anuncioEncontrado = false;
        for (Anunciante anuncio : getListaAnunciantes()) {
            if (anuncio.getListaAnuncios())
            //if(Anuncio.getCodigoAnuncio.equalsIgnoreCase(codigoAnuncio)||Anuncio.getCedula().equalsIgnoreCase(cedula)){
                anuncioEncontrado = true;
                break;
            }
        }
        return anuncioEncontrado;
    public ArrayList<Anunciante> obtenerAnuncio() {
        // TODO Auto-generated method stub
        return getListaAnunciantes();
    }
}

     */


