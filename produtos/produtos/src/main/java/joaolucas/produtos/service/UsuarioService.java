package joaolucas.produtos.service;

import joaolucas.produtos.dto.produto.usuario.UsuarioDTO;
import joaolucas.produtos.dto.produto.usuario.UsuarioRequest;
import joaolucas.produtos.dto.produto.usuario.UsuarioResponse;
import joaolucas.produtos.exception.UsuarioNaoEncontrado;
import joaolucas.produtos.mapper.produto.usuario.UsuarioMapper;
import joaolucas.produtos.model.Usuario;
import joaolucas.produtos.repository.UsuarioRepository;
import joaolucas.produtos.security.JwtTokenService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder encoder;
    private final UsuarioMapper usuarioMapper;
    private final JwtTokenService jwtTokenService;

    public UsuarioResponse cadastrarUsuario(UsuarioDTO dto) {

        Usuario usuario = usuarioMapper.toEntity(dto);

        String senhaCriptografada = encoder.encode(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        Usuario usuarioSalvo = usuarioRepository.save(usuario);

        return usuarioMapper.toResponse(usuarioSalvo);
    }

    public UsuarioResponse login(UsuarioRequest request) {

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername());

        if (usuario == null || !encoder.matches(request.getPassword(), usuario.getPassword())) {
            throw new UsuarioNaoEncontrado("Credenciais inválidas.");
        }

        String token = jwtTokenService.gerarToken(usuario.getUsername());

        return usuarioMapper.toResponseLogin(usuario, token);
    }
}
