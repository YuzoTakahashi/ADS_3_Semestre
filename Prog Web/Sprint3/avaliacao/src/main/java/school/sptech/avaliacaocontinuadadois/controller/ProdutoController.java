package school.sptech.avaliacaocontinuadadois.controller;

import org.apache.catalina.valves.rewrite.ResolverImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import school.sptech.avaliacaocontinuadadois.domain.Produto;
import school.sptech.avaliacaocontinuadadois.repositorio.ProdutoRepository;

import java.time.LocalDate;
import java.util.List;

/*
    TODO:
     - A equipe relatou ter dificuldades em utilizar ORM e Dynamic finders, Você poderia ajudá-los?
*/
@RequestMapping("produtos")
@RestController
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/contagem")
    public ResponseEntity<Long> contagemGeral() {
        Long contagem = produtoRepository.count();
        return ResponseEntity.status(200).body(contagem);
    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/contagem")
    public ResponseEntity<Long> contagemPorCategoria(@RequestParam String nome) {
        Long contagem = produtoRepository.countByCategoriaIgnoreCase(nome);
        return ResponseEntity.status(200).body(contagem);
    }

    // Deve ser resolvido apenas com dynamic finder e checagem de lista vazia
    @GetMapping("/categorias")
    public ResponseEntity<List<Produto>> buscarPorCategoria(@RequestParam String nome) {
        List<Produto> produtos = produtoRepository.findAllByCategoriaIgnoreCase(nome);
        if(produtos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(produtos);
    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/maior-preco")
    public ResponseEntity<Produto> buscarPorCategoriaMaiorPreco(@RequestParam String nome) {
        Produto produto = produtoRepository.findByCategoriaTop1GreaterIgnoreCase(nome);
        return ResponseEntity.status(200).body(produto);
    }

    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/menor-preco")
    public ResponseEntity<Produto> buscarPorCategoriaMenorPreco(@RequestParam String nome) {
        Produto produto = produtoRepository.findByCategoriaTop1LessIgnoreCase(nome);
        return ResponseEntity.status(200).body(produto);
    }


    // Deve ser resolvido apenas com dynamic finder
    @GetMapping("/categorias/contagem/promocoes")
    public ResponseEntity<Long> contarPorCategoriaPromocao(@RequestParam String nome) {
        Long contagem = produtoRepository.CountAllByCategoriaPromocaoTrueIgnoreCase(nome);
        return ResponseEntity.status(200).body(contagem);
    }

    // Esse endpoint exige dynamic finder + uso de laco de repeticao ou uso de stream para cálculo
    @GetMapping("/total-estoque/data")
    public ResponseEntity<Double> buscarTotalEstoquePorPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim
    ) {
        List<Produto> produtos = produtoRepository.findAllByDataCriacaoGreaterLessThanEqual(fim, inicio);
        double valorTotal = 0.0;
        for (Produto p : produtos){
            valorTotal += p.getPreco() * p.getQuantidade();
        }
        return ResponseEntity.status(200).body(valorTotal);
    }
}
