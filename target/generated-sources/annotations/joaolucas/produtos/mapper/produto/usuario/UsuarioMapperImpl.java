package joaolucas.produtos.mapper.produto.usuario;

import javax.annotation.processing.Generated;
import joaolucas.produtos.dto.produto.usuario.UsuarioDTO;
import joaolucas.produtos.dto.produto.usuario.UsuarioResponse;
import joaolucas.produtos.model.Usuario;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T18:01:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public Usuario toEntity(UsuarioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setUsername( dto.getUsername() );
        usuario.setEmail( dto.getEmail() );
        usuario.setPassword( dto.getPassword() );

        return usuario;
    }

    @Override
    public UsuarioResponse toResponse(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        usuarioResponse.setUsername( usuario.getUsername() );
        usuarioResponse.setEmail( usuario.getEmail() );

        return usuarioResponse;
    }

    @Override
    public UsuarioResponse toResponseLogin(Usuario usuario, String token) {
        if ( usuario == null && token == null ) {
            return null;
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse();

        if ( usuario != null ) {
            usuarioResponse.setUsername( usuario.getUsername() );
            usuarioResponse.setEmail( usuario.getEmail() );
        }
        usuarioResponse.setToken( token );

        return usuarioResponse;
    }
}
