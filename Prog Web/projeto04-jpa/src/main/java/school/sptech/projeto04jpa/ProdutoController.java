package school.sptech.projeto04jpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    //Implementa a interface
    @Autowired
    private ProdutoRepository produtoRepository;

    //  aqui tem algumas query já feitas
    @PostMapping
    public ResponseEntity<Produto> criar(@RequestBody Produto produtoNovo) {
//        carrinho.add(produtoNovo);
        Produto produtobanco = produtoRepository.save(produtoNovo);
        return ResponseEntity.status(201).body(produtobanco);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> carrinho = produtoRepository.findAll();
        if (carrinho.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(carrinho);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> listarPorIndice(@PathVariable long id) {
        Optional<Produto> produtoOptional = produtoRepository.findById(id);
        if (produtoOptional.isPresent()) {
            return ResponseEntity.status(200).body(produtoOptional.get());
        }
        // return ResponseEntity.of(produtoOptional);
        return ResponseEntity.status(404).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable long id, @RequestBody Produto produtoAtualizado) {
        if (produtoRepository.existsById(id)) {
            produtoAtualizado.setId(id);
            produtoRepository.save(produtoAtualizado);
            return ResponseEntity.status(200).body(produtoAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id]")
    public ResponseEntity<Void> deletar(@PathVariable long id) {
        if (produtoRepository.existsById(id)) {
            produtoRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
