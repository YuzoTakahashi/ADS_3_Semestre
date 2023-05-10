package school.sptech.marketplace.controladora;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.marketplace.dominio.AvaliacaoCompradorProduto;
import school.sptech.marketplace.dominio.Comprador;
import school.sptech.marketplace.dominio.Produto;
import school.sptech.marketplace.dto.AvaliacaoCompradorProdutoAlteracaoDto;
import school.sptech.marketplace.dto.AvaliacaoCompradorProdutoCriacaoDto;
import school.sptech.marketplace.repositorio.AvaliacaoCompradorProdutoRepository;
import school.sptech.marketplace.repositorio.CompradorRepository;
import school.sptech.marketplace.repositorio.ProdutoRepository;
import school.sptech.marketplace.servico.AvaliacaoCompradorProdutoServico;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoCompradorProdutoController {
    @Autowired
    private AvaliacaoCompradorProdutoServico avaliacaoServico;

    @Autowired
    private AvaliacaoCompradorProdutoRepository avaliacaoRepository;



    @GetMapping
    public ResponseEntity<List<AvaliacaoCompradorProduto>> listarAvaliacoes() {
        List<AvaliacaoCompradorProduto> avaliacoes = avaliacaoServico.listarAvaliacoes();

        if (avaliacoes.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok().body(avaliacoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AvaliacaoCompradorProduto> listarAvaliacaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(avaliacaoServico.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<AvaliacaoCompradorProduto> criarAvaliacao(
            @RequestBody @Valid AvaliacaoCompradorProdutoCriacaoDto novaAvaliacao) {

        return ResponseEntity.created(null).body(avaliacaoServico.criarAvaliacao(novaAvaliacao));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AvaliacaoCompradorProduto> editarAvaliacao(
            @PathVariable Long id,
            @RequestBody @Valid AvaliacaoCompradorProdutoAlteracaoDto avaliacao) {

        return ResponseEntity.ok().body(avaliacaoServico.editarAvaliacao(id, avaliacao));
    }

}
