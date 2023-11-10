package co.edu.uniquindio.subasta.subastasuq.mapping.mapper;

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
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    Usuario usuarioToUsuarioDto(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsuarios);

    //@Named("mappingToUsuarioDto")
    //UsuarioDto mappingToUsuarioDto(Usuario usuario);

    @Mapping(target = "nombreUsuario", source = "usuario.nombre")
    @IterableMapping(qualifiedByName = "cuentaToUsuarioDto")
    UsuarioDto usuarioTousuarioDtoo(Usuario usuario);

}
