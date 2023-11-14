package co.edu.uniquindio.subasta.subastasuq.mapping.mappers;

import co.edu.uniquindio.subasta.subastasuq.mapping.dto.UsuarioDto;
import co.edu.uniquindio.subasta.subastasuq.model.Usuario;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
@Mapper
public interface SubastaQuindioMapper {
    SubastaQuindioMapper INSTANCE = Mappers.getMapper(SubastaQuindioMapper.class);

    @Named("usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDto(Usuario usuario);

    Usuario usurioDtoToUsuario(UsuarioDto usuarioDto);

    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    List<UsuarioDto> getUsuariosDto(List<Usuario> listaUsiarios);

//    @Named("usuarioToUsuarioDto")
//    UsuarioDto mappingToEmpeladoDto(Usuario usuario);


    @Mapping(target = "nombreUsuarioa", source = "usuario.nombre")
    @IterableMapping(qualifiedByName = "usuarioToUsuarioDto")
    UsuarioDto usuarioToUsuarioDtoWithMapping(Usuario usuario);

}
