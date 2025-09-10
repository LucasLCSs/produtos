package joaolucas.produtos.dto.produto.usuario;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDTO {

    @NotBlank(message = "Campo username não pode ser vazio.")
    private String username;

    @NotBlank(message = "Campo email não pode ser vazio.")
    @Email(message = "E-mail inválido.")
    private String email;

    @NotBlank(message = "Campo password não pode ser vazio.")
    private String password;
}
