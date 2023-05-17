package school.sptech.marketplaceresumido.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.marketplaceresumido.service.produto.ProdutoService;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoAtualizacaoDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoConsultaDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoCriacaoDto;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoConsultaDto>> listar() {

        List<ProdutoConsultaDto> produtos = this.produtoService.listar();

        if (produtos.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoConsultaDto> buscarPorId(@PathVariable Long id) {
        ProdutoConsultaDto produto = this.produtoService.buscarPorId(id);
        return ResponseEntity.ok(produto);
    }

    @PostMapping
    public ResponseEntity<ProdutoConsultaDto> criar(@RequestBody @Valid ProdutoCriacaoDto produtoCriacaoDto) {
        ProdutoConsultaDto produto = this.produtoService.criar(produtoCriacaoDto);
        return ResponseEntity.created(null).body(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProdutoConsultaDto> atualizar(@PathVariable Long id, @RequestBody @Valid ProdutoAtualizacaoDto produtoAtualizacaoDto) {
        ProdutoConsultaDto produto = this.produtoService.atualizar(id, produtoAtualizacaoDto);
        return ResponseEntity.ok(produto);
    }
}
