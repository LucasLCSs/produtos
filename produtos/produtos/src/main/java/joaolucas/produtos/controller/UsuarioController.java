package joaolucas.produtos.controller;

import jakarta.validation.Valid;
import joaolucas.produtos.dto.produto.usuario.UsuarioDTO;
import joaolucas.produtos.dto.produto.usuario.UsuarioRequest;
import joaolucas.produtos.dto.produto.usuario.UsuarioResponse;
import joaolucas.produtos.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping("/cadastrar")
    public ResponseEntity<?> cadastrar(@RequestBody @Valid UsuarioDTO dto) {
        UsuarioResponse usuarioResponse = usuarioService.cadastrarUsuario(dto);
        return ResponseEntity.ok(usuarioResponse);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioRequest request) {
        UsuarioResponse login = usuarioService.login(request);
        return ResponseEntity.ok(login);
    }
}
