package co.edu.uniquindio.subasta.subastasuq.model.utils;

import co.edu.uniquindio.subasta.subastasuq.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.subastasuq.model.Anuncio;
import co.edu.uniquindio.subasta.subastasuq.model.SubastaQuindio;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class Persistencia {

    //public static final String RUTA_ARCHIVO_CLIENTES = "bancoUq/src/main/resources/persistencia/archivoClientes.txt";
    public static final String RUTA_ARCHIVO_ANUNCIOS = "bancoUq/src/main/resources/persistencia/archivoAnuncios.txt";
    public static final String RUTA_ARCHIVO_USUARIOS = "/src/main/resources/persistencia/archivoUsuarios.txt";
    public static final String RUTA_ARCHIVO_LOG = "bancoUq/src/main/resources/persistencia/log/Subastaslog.txt";
    public static final String RUTA_ARCHIVO_OBJETOS = "co.edu.uniquindio.programacion3/src/main/resources/persistencia/archivoObjetos.txt";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTAS_BINARIO = "bancoUq/src/main/resources/persistencia/model.dat";
    public static final String RUTA_ARCHIVO_MODELO_SUBASTAS_XML = "bancoUq/src/main/resources/persistencia/model.xml";
//	C:\td\persistencia

    public static void guardaRegistroLog(String mensajeLog, int nivel, String accion)
    {
        ArchivoUtil.guardarRegistroLog(mensajeLog, nivel, accion, RUTA_ARCHIVO_LOG);
    }
    public static void cargarDatosArchivos(SubastaQuindio subastaQuindio) throws FileNotFoundException, IOException {
        //cargar archivo de clientes
        ArrayList<Usuario> usuariosCargados = cargarUsuarios();
        if(usuariosCargados.size() > 0)
            subastaQuindio.getListaUsuarios().addAll(usuariosCargados);

        //cargar archivos empleados
        ArrayList<Anuncio> empleadosCargados = cargarAnuncios();
        if(empleadosCargados.size() > 0)
            subastaQuindio.getListaAnunciantes().addAll(empleadosCargados);

        //cargar archivo transcciones

        //cargar archivo empleados

        //cargar archivo prestamo

    }

    private static ArrayList<Anuncio> cargarAnuncios() throws IOException {
        ArrayList<Anuncio> anuncios =new ArrayList<Anuncio>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_ANUNCIOS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Anuncio anuncio = new Anuncio();
            anuncio.setCodigoAnuncio(linea.split(",")[0]);
            anuncio.setNombreAnuncio(linea.split(",")[1]);
            anuncio.setTipoProducto(linea.split(",")[2]);
            anuncio.setNombreProducto(linea.split(",")[3]);
            //cliente.setCorreo(linea.split(",")[4]);
            //cliente.setFechaNacimiento(linea.split(",")[5]);
            //cliente.setTelefono(linea.split(",")[6]);
            anuncios.add(anuncio);
        }
        return anuncios;
    }

    private static ArrayList<Usuario> cargarUsuarios() throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios =new ArrayList<Usuario>();
        ArrayList<String> contenido = ArchivoUtil.leerArchivo(RUTA_ARCHIVO_USUARIOS);
        String linea="";
        for (int i = 0; i < contenido.size(); i++)
        {
            linea = contenido.get(i);//juan,arias,125454,Armenia,uni1@,12454,125444
            Usuario usuario = new Usuario();
            usuario.setNombre(linea.split(",")[0]);
            usuario.setApellido(linea.split(",")[1]);
            usuario.setCedula(linea.split(",")[2]);
            usuario.setEdad(Integer.parseInt(linea.split(",")[3]));
            usuario.setNombreUsuario(linea.split(",")[4]);
            usuario.setContrasena(linea.split(",")[5]);
           // cliente.setTelefono(linea.split(",")[6]);
            usuarios.add(usuario);
        }
        return usuarios;
    }
    public static void guardarUsuarios(ArrayList<Usuario> listaUsuarios) throws IOException {
        // TODO Auto-generated method stub
        String contenido = "";
        for(Usuario usuario:listaUsuarios)
        {
            contenido+= usuario.getNombre()+"@@"+usuario.getApellido()+"@@"+usuario.getCedula()+"@@"+usuario.getEdad()
                    +"@@"+usuario.getNombreUsuario()+"@@"+usuario.getContrasena()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_USUARIOS, contenido, false);
    }
    public static void guardarAnuncios(ArrayList<Anuncio> listaAnuncios) throws IOException {
        String contenido = "";
        for(Anuncio anuncio:listaAnuncios)
        {
            contenido+= anuncio.getCodigoAnuncio()+
                    "@@"+anuncio.getNombreAnuncio()+
                    "@@"+anuncio.getNombreProducto()+
                    "@@"+anuncio.getTipoProducto()+"\n";
        }
        ArchivoUtil.guardarArchivo(RUTA_ARCHIVO_ANUNCIOS, contenido, false);
    }

    public static boolean iniciarSesion(String nombreUsuario, String contrasenia) throws FileNotFoundException, IOException, UsuarioException {

        if(validarUsuario(nombreUsuario,contrasenia)) {
            return true;
        }else {
            throw new UsuarioException("Usuario no existe");
        }

    }
    private static boolean validarUsuario(String nombreUsuario, String contrasena) throws FileNotFoundException, IOException
    {
        ArrayList<Usuario> usuarios = Persistencia.cargarUsuariosRegistro(RUTA_ARCHIVO_USUARIOS);

        for (int indiceUsuario = 0; indiceUsuario < usuarios.size(); indiceUsuario++)
        {
            Usuario usuarioAux = usuarios.get(indiceUsuario);
            if(usuarioAux.getNombreUsuario().equalsIgnoreCase(nombreUsuario) && usuarioAux.getContrasena().equalsIgnoreCase(contrasena)) {
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Usuario> cargarUsuariosRegistro(String ruta) throws FileNotFoundException, IOException {
        ArrayList<Usuario> usuarios =new ArrayList<Usuario>();

        ArrayList<String> contenido = ArchivoUtil.leerArchivo(ruta);
        String linea="";

        for (int i = 0; i < contenido.size(); i++) {
            linea = contenido.get(i);

            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(linea.split(",")[0]);
            usuario.setContrasena(linea.split(",")[1]);

            usuarios.add(usuario);
        }
        return usuarios;
    }

    public static void guardarObjetos(ArrayList<Usuario> listaUsuarios, String ruta) throws IOException  {
        String contenido = "";

        for(Usuario usuarioAux:listaUsuarios) {
            contenido+= usuarioAux.getNombre()+"@@"+usuarioAux.getApellido()+"@@"+usuarioAux.getCedula()+"@@"+usuarioAux.getEdad()
                    +"@@"+usuarioAux.getNombreUsuario()+"@@"+usuarioAux.getContrasena()+"\n";
        }
        ArchivoUtil.guardarArchivo(ruta, contenido, true);
    }
    public static SubastaQuindio cargarRecursoSubastasBinario() {

        SubastaQuindio subastaQuindio = null;

        try {
            subastaQuindio = (SubastaQuindio) ArchivoUtil.cargarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTAS_BINARIO);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastaQuindio;
    }

    public static void guardarRecursoSubastasBinario(SubastaQuindio subastaQuindio) {
        try {
            ArchivoUtil.salvarRecursoSerializado(RUTA_ARCHIVO_MODELO_SUBASTAS_BINARIO, subastaQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    public static SubastaQuindio cargarRecursoSubastasXML() {

        SubastaQuindio subastaQuindio = null;

        try {
            subastaQuindio = (SubastaQuindio) ArchivoUtil.cargarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTAS_XML);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return subastaQuindio;

    }

    public static void guardarRecursoSubastasXML(SubastaQuindio subastaQuindio) {

        try {
            ArchivoUtil.salvarRecursoSerializadoXML(RUTA_ARCHIVO_MODELO_SUBASTAS_XML, subastaQuindio);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
