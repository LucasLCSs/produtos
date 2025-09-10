package joaolucas.produtos.mapper.produto.usuario;

import joaolucas.produtos.dto.produto.usuario.UsuarioDTO;
import joaolucas.produtos.dto.produto.usuario.UsuarioRequest;
import joaolucas.produtos.dto.produto.usuario.UsuarioResponse;
import joaolucas.produtos.model.Usuario;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    Usuario toEntity(UsuarioDTO dto);

    UsuarioResponse toResponse(Usuario usuario);

    UsuarioResponse toResponseLogin(Usuario usuario, String token);
}
