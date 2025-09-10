package joaolucas.produtos.mapper.produto;

import joaolucas.produtos.dto.produto.ProdutoDTO;
import joaolucas.produtos.model.Produto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProdutoMapper {

    Produto toEntity(ProdutoDTO dto);
    ProdutoDTO toDTO(Produto produto);
}
