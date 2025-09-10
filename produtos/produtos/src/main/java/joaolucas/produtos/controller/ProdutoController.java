package joaolucas.produtos.controller;

import jakarta.validation.Valid;
import joaolucas.produtos.dto.produto.ProdutoDTO;
import joaolucas.produtos.service.ProdutoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    private final ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> cadastrar(@RequestBody @Valid ProdutoDTO dto) {
        ProdutoDTO produtoDTO = produtoService.cadastrarProduto(dto);
        return ResponseEntity.ok(produtoDTO);
    }

    @GetMapping
    public ResponseEntity<?> listarTodos() {
        List<ProdutoDTO> listarTodosProdutos = produtoService.listarTodosProdutos();
        return ResponseEntity.ok(listarTodosProdutos);
    }

    @GetMapping("/{nome}")
    public ResponseEntity<?> buscarPorNome(ProdutoDTO dto) {
        ProdutoDTO produtoDTO = produtoService.pesquisarPorNome(dto);
        return ResponseEntity.ok(produtoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody @Valid ProdutoDTO dto,@PathVariable Long id) {
        ProdutoDTO atualizarProduto = produtoService.atualizarProduto(dto, id);
        return ResponseEntity.ok(atualizarProduto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        produtoService.deletarProduto(id);
        return ResponseEntity.noContent().build();
    }
}