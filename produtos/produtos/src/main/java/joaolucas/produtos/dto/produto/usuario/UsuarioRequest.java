package joaolucas.produtos.dto.produto.usuario;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioRequest {

    @NotBlank(message = "Campo username não pode ser vazio.")
    private String username;

    @NotBlank(message = "Campo password não pode ser vazio.")
    private String password;
}
