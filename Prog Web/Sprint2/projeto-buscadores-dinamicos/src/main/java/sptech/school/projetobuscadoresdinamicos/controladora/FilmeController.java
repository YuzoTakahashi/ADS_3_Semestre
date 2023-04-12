package sptech.school.projetobuscadoresdinamicos.controladora;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sptech.school.projetobuscadoresdinamicos.repositorio.DiretorRepository;
import sptech.school.projetobuscadoresdinamicos.repositorio.FilmeRepository;
import sptech.school.projetobuscadoresdinamicos.dominio.Filme;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Filmes", description = "Grupo de requisições entidade Filme")
@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private FilmeRepository filmeRepository;
    @Autowired
    private DiretorRepository diretorRepository;

    @PostMapping
    public ResponseEntity<Filme> cadastrar(@RequestBody Filme filme) {
        if(this.diretorRepository.existsById(filme.getDiretor().getId())) {
            Filme filmeRegistrado = this.filmeRepository.save(filme);
            return ResponseEntity.status(201).body(filmeRegistrado);
        }

        return ResponseEntity.status(404).build();
    }

    @ApiResponses({
            @ApiResponse(responseCode = "204",
                    description = "Não há filmes cadastrados",
                    content = @Content(schema = @Schema(hidden = true))),
            @ApiResponse(responseCode = "200", description = "Filmes encontrados")
            }
    )

    @GetMapping
    public ResponseEntity<List<Filme>> listar() {

        List<Filme> filmes = this.filmeRepository.findAll();

        if (filmes.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Filme> buscarPorId(@PathVariable long id) {
        return ResponseEntity.of(this.filmeRepository.findById(id));
    }

    @GetMapping("/titulo")
    public ResponseEntity<Filme> buscarPorNome
            (@RequestParam String nome) {

        return ResponseEntity.of(this.filmeRepository.findByNome(nome));


//// --
//    List<Filme> filmes = this.filmeRepository.findAll();
//
//    Optional<Filme> filmeProcurado = filmes.stream()
//            .filter(filme -> filme.getNome().equals(nome))
//            .findAny();
//
//    if (filmeProcurado.isPresent()) {
//      return ResponseEntity.status(200).body(filmeProcurado.get());
//    }
//
//    return ResponseEntity.status(404).build();
//// --
    }

    @GetMapping("/diretor")
    public ResponseEntity<List<Filme>> buscarPorDiretor(
            @RequestParam String nome) {

        List<Filme> filmesFiltrados =
                this.filmeRepository.findByDiretorNomeContainsIgnoreCase(nome);

//    List<Filme> filmes = this.filmeRepository.findAll();

//    List<Filme> filmesFiltrados = filmes.stream()
//            .filter(filme -> filme.getDiretor().equalsIgnoreCase(nome))
//            .collect(Collectors.toList());

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/periodo/{data}")
    public ResponseEntity<List<Filme>> buscarPorData(@PathVariable LocalDate data) {

        List<Filme> filmesFiltrados =
                this.filmeRepository.findByDataLancamentoLessThanEqual(data);

//    List<Filme> filmes = this.filmeRepository.findAll();
//
//    List<Filme> filmesFiltrados = filmes.stream()
//            .filter(filme -> filme.getDataLancamento().isBefore(data)
//                    || filme.getDataLancamento().isEqual(data))
//            .collect(Collectors.toList());

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/indicados")
    public ResponseEntity<List<Filme>> buscarSomenteIndicados() {

        List<Filme> filmesFiltrados = this.filmeRepository.findByIndicacaoOscarTrue();

//    List<Filme> filmes = this.filmeRepository.findAll();
//
//    List<Filme> filmesFiltrados = filmes.stream()
//            .filter(Filme::isIndicacaoOscar)
//            .collect(Collectors.toList());

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(filmesFiltrados);
    }

    @GetMapping("/nao-indicados/quantidade")
    public ResponseEntity<Integer> contarSomenteNaoIndicados() {
//    List<Filme> filmes = this.filmeRepository.findAll();
//
//    int contador = (int) filmes.stream()
//            .filter(filme -> !filme.isIndicacaoOscar())
//            .count();

        int contador = this.filmeRepository.countByIndicacaoOscarFalse();
        return ResponseEntity.status(200).body(contador);
    }

    @GetMapping("/custo-producao/{custo}")
    public ResponseEntity<List<Filme>> buscarFilmesComCustoAlto(@PathVariable double custo) {

        List<Filme> filmesFiltrados = this.filmeRepository.findByCustoProducaoGreaterThanEqual(custo);

//    List<Filme> filmes = this.filmeRepository.findAll();
//
//    List<Filme> filmesFiltrados = filmes.stream()
//            .filter(filme -> filme.getCustoProducao() >= custo)
//            .collect(Collectors.toList());

        if (filmesFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(filmesFiltrados);
    }
}
