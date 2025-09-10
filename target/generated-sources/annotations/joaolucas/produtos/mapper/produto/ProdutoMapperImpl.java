package joaolucas.produtos.mapper.produto;

import javax.annotation.processing.Generated;
import joaolucas.produtos.dto.produto.ProdutoDTO;
import joaolucas.produtos.model.Produto;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-10T18:01:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Oracle Corporation)"
)
@Component
public class ProdutoMapperImpl implements ProdutoMapper {

    @Override
    public Produto toEntity(ProdutoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        Produto produto = new Produto();

        produto.setNome( dto.getNome() );
        produto.setPreco( dto.getPreco() );

        return produto;
    }

    @Override
    public ProdutoDTO toDTO(Produto produto) {
        if ( produto == null ) {
            return null;
        }

        ProdutoDTO produtoDTO = new ProdutoDTO();

        produtoDTO.setNome( produto.getNome() );
        produtoDTO.setPreco( produto.getPreco() );

        return produtoDTO;
    }
}
