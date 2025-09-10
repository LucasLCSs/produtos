package joaolucas.produtos.service;

import joaolucas.produtos.dto.produto.ProdutoDTO;
import joaolucas.produtos.exception.ProdutoNaoEncontrado;
import joaolucas.produtos.mapper.produto.ProdutoMapper;
import joaolucas.produtos.model.Produto;
import joaolucas.produtos.repository.ProdutoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final ProdutoMapper produtoMapper;

    public ProdutoDTO cadastrarProduto(ProdutoDTO dto) {

        Produto entity = produtoMapper.toEntity(dto);

        Produto produtoCadastrado = produtoRepository.save(entity);

        return produtoMapper.toDTO(produtoCadastrado);
    }

    public List<ProdutoDTO> listarTodosProdutos() {
        return produtoRepository
                .findAll()
                .stream()
                .map(produtoMapper::toDTO)
                .toList();
    }

    public ProdutoDTO pesquisarPorNome(ProdutoDTO dto) {

        Produto nome = produtoRepository.findByNome(dto.getNome());

        if (nome == null) {
            throw new ProdutoNaoEncontrado("Produto com o nome " + nome + " não encontrado.");
        }

        return produtoMapper.toDTO(nome);
    }

    public ProdutoDTO atualizarProduto(ProdutoDTO dto, Long id) {

        Produto produto = produtoRepository.findById(id).orElseThrow(() ->
                new ProdutoNaoEncontrado("Produto com id " + id + " não encontrado."));

        produto.setNome(dto.getNome());
        produto.setPreco(dto.getPreco());

        Produto produtoAtualizado = produtoRepository.save(produto);

        return produtoMapper.toDTO(produtoAtualizado);
    }

    public void deletarProduto(Long id) {

        Produto produto = produtoRepository.findById(id).orElseThrow(() ->
                new ProdutoNaoEncontrado("Produto com id " + id + " não encontrado."));

        produtoRepository.deleteById(produto.getId());
    }
}