package co.edu.uniquindio.subasta.subastasuq.controller;

import co.edu.uniquindio.subasta.subastasuq.controller.service.IModelFactoryService;
import co.edu.uniquindio.subasta.subastasuq.exceptions.UsuarioException;
import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.subasta.subastasuq.mapping.mappers.SubastaQuindioMapper;
import co.edu.uniquindio.subasta.subastasuq.model.SubastaQuindio;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;
import co.edu.uniquindio.subasta.subastasuq.model.utils.Persistencia;
import co.edu.uniquindio.subasta.subastasuq.model.utils.RegistroUtils;

import java.io.IOException;
import java.util.List;

public class ModelFactoryController implements IModelFactoryService {

    SubastaQuindio subastaQuindio;
    SubastaQuindioMapper mapper = SubastaQuindioMapper.INSTANCE;

    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");
        cargarDatosBase();
        salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
        cargarResourceBinario();
        guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML
        guardarResourceXML();
        cargarResourceXML();

        //Siempre se debe verificar si la raiz del recurso es null

        if(subastaQuindio == null){
            cargarDatosBase();
            guardarResourceXML();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");
    }
    private void cargarDatosDesdeArchivos() {
        subastaQuindio = new SubastaQuindio();
        try {
            Persistencia.cargarDatosArchivos(subastaQuindio);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarUsuarios(getSubastaQuindio().getListaUsuarios());
            Persistencia.guardarAnuncios(getSubastaQuindio().getListaAnunciantes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosBase() {
        subastaQuindio = RegistroUtils.inicializarDatos();
    }
    public SubastaQuindio getSubastaQuindio() {
        return subastaQuindio;
    }

    public void setSubastaQuindio(SubastaQuindio subastaQuindio) {
        this.subastaQuindio = subastaQuindio;
    }


    @Override
    public List<UsuarioDto> obtenerUsuarios() {

        return mapper.getUsuariosDto(subastaQuindio.getListaUsuarios());
    }


    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if(!subastaQuindio.verificarUsuarioExistente(usuarioDto.cedula())) {
                Usuario usuario = mapper.usurioDtoToUsuario(usuarioDto);
                getSubastaQuindio().agregarUsuario(usuario);
                guardarResourceXML();
            }
            return true;
        }catch (UsuarioException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarEmpleado(String nombreUsuario) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubastaQuindio().eliminarEmpleado(nombreUsuario);
        } catch (UsuarioException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    private void cargarResourceXML() {
        subastaQuindio = Persistencia.cargarRecursoSubastasXML();
    }
    private void guardarResourceXML() {
        Persistencia.guardarRecursoSubastasXML(subastaQuindio);
    }
    private void cargarResourceBinario() {
        subastaQuindio = Persistencia.cargarRecursoSubastasBinario();
    }
    private void guardarResourceBinario() {

        Persistencia.guardarRecursoSubastasBinario(subastaQuindio);
    }
    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }







}
