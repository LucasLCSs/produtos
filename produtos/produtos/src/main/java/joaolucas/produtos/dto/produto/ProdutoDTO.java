package joaolucas.produtos.dto.produto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {

    @NotBlank(message = "Campo nome não pode ser vazio.")
    private String nome;

    @NotNull(message = "Campo preço não pode ser vazio.")
    @DecimalMin(value = "0.1", message = "Campo preço tem que ser acima de 0.0")
    private BigDecimal preco;
}
