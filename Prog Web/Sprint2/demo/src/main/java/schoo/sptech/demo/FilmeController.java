package schoo.sptech.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@RestController
@RequestMapping("filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filmeNovo) {
        filmeRepository.save(filmeNovo);
        return ResponseEntity.status(201).body(filmeNovo);
    }

    @GetMapping
    public ResponseEntity<List<Filme>> listar() {
        List<Filme> filmes = filmeRepository.findAll();
        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/{id]")
    public ResponseEntity<Filme> listarPorId(@PathVariable Long Id) {
        Optional<Filme> filmeOptional = filmeRepository.findById(Id);
        return ResponseEntity.of(filmeOptional);
    }

    @GetMapping("/titulo/{nome}")
    public ResponseEntity<Filme> listarPorNome(@PathVariable String nome) {
        List<Filme> filmes = filmeRepository.findAll();
        Optional<Filme> filmeProcurado = filmes.stream().filter(filme -> filme.getNome().equals(nome)).findAny();
        if (filmeProcurado.isPresent()) {
            return ResponseEntity.status(200).body(filmeProcurado.get());
        }
        return ResponseEntity.status(204).build();

        return ResponseEntity.of(this.filmeRepository.findByNome(nome));
    }

    @GetMapping("/diretor/{nome}")
    public ResponseEntity<List<Filme>> listarPorDiretor(@RequestParam String nome) {
        List<Filme> filmesFiltrados = this.filmeRepository.findByDiretorIgnoreCase(nome);
        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/periodo/{data}")
    public ResponseEntity<List<Filme>> listarPorData(@PathVariable LocalDate data) {
        List<Filme> filmesFiltrados = this.filmeRepository.findByDataLancamentoLessThanEqual(data);
        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/indicados")
    public ResponseEntity<List<Filme>> listarPorIndicacao() {
        List<Filme> filmes = filmeRepository.findAll();
        return null;
    }

    @GetMapping("/indicados/nao-indicados/quantidade")
    public ResponseEntity<Integer> contarFilmesNaoIndicados() {
        List<Filme> filmes = filmeRepository.findAll();
        Integer qtdFilmesNaoIndicados = 0;
        for (Filme f : filmes) {
            if (!f.isIndicacaoOscar()) {
                qtdFilmesNaoIndicados++;
            }
        }
        return ResponseEntity.status(200).body(qtdFilmesNaoIndicados);
    }

    @GetMapping("/custo-producao/{custo}")
    public ResponseEntity<List<Filme>> listarFilmesPorCusto(@PathVariable double custo) {
        List<Filme> filmes = filmeRepository.findAll();
        List<Filme> filmesFiltrados = new ArrayList<Filme>();
        for (Filme f : filmes) {
            if (f.getCustoProducao() >= custo) {
                filmesFiltrados.add(f);
            }
        }
        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmesFiltrados);
    }
}
