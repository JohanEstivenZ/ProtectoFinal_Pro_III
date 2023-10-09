package co.edu.uniquindio.subasta.subastasuq.mapping.mappers;

import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

public interface SubastaQuindioMapper {
    SubastaQuindioMapper INSTANCE = Mappers.getMapper(SubastaQuindioMapper.class);

    @Named("usuarioToUsuarioDto")
    UsuarioDto empleadoToEmpleadoDto(Usuario usuario);

    Usuario empleadoDtoToEmpleado(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getEmpleadosDto(List<Usuario> listaUsiarios);

//    @Named("usuarioToUsuarioDto")
//    UsuarioDto mappingToEmpeladoDto(Usuario usuario);


    @Mapping(target = "nombreCliente", source = "cliente.nombre")
//    @IterableMapping(qualifiedByName = "cunetaToCuentaDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

}
