package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("filmes")
public class FilmeController {
    List<Filme> filmes = new ArrayList<>();

    @GetMapping
    public ResponseEntity<List<Filme>> listarFilme() {
        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/{indice}")
    public ResponseEntity<Filme> listarPorIndice(@PathVariable int indice) {
        if (indice >= 0 && indice < filmes.size()) {
            return ResponseEntity.status(200).body(filmes.get(indice));
        }
        return ResponseEntity.status(404).build();
    }

    @PostMapping
    public ResponseEntity<Filme> criarFilme(@RequestBody Filme filmeNovo) {
        if (filmeNovo.getNome().length() >= 2 && filmeNovo.getAnoLancamento() > 1895) {
            filmes.add(filmeNovo);
            return ResponseEntity.status(201).body(filmeNovo);
        }
        return ResponseEntity.status(406).build();
    }

    @PutMapping("/{indice}")
    public ResponseEntity<Filme> atualizarFilme(@PathVariable int indice, @RequestBody Filme filmeAtualizado) {
        if (indice >= 0 && indice < filmes.size()) {
            filmes.set(indice, filmeAtualizado);
            return ResponseEntity.status(200).body(filmeAtualizado);
        }
        return ResponseEntity.status(404).build();
    }

    @PatchMapping("{indice}/oscars")
    //Não consegui fazer essa parte, tentei de várias formas diferentes, mas sempre dava erro 405
    public ResponseEntity<Filme> atualizarOscar(@PathVariable int indice, @RequestBody FilmeOscar filmeAtualizado) {
        if (indice >= 0 && indice < filmes.size()) {
            filmes.get(indice).setQtdOscar(filmeAtualizado.getQtdOscar());
            return ResponseEntity.status(200).body(filmes.get(indice));
        }
        return ResponseEntity.status(404).build();
    }
}
