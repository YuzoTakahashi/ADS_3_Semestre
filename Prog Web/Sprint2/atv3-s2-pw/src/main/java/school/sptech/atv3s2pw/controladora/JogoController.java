package school.sptech.atv3s2pw.controladora;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.TableGenerator;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.atv3s2pw.dominio.Jogo;
import school.sptech.atv3s2pw.repositorio.EmpresaRepository;
import school.sptech.atv3s2pw.repositorio.JogoRepository;

import java.time.LocalDate;
import java.util.List;

@Tag(name = "Jogos", description = "EndPoints da entidade Jogo")
@RequestMapping("/jogos")
@RestController
public class JogoController {
    @Autowired
    private JogoRepository jogoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @PostMapping
    public ResponseEntity<Jogo> cadastrar(@RequestBody Jogo jogo) {
        if (this.empresaRepository.existsById(jogo.getEmpresas().getId())){
            Jogo jogoNovo = this.jogoRepository.save(jogo);
            return ResponseEntity.status(201).body(jogoNovo);
        }

        return ResponseEntity.status(404).build();
    }

    @GetMapping
    public ResponseEntity<List<Jogo>> listar() {
        List<Jogo> jogos = jogoRepository.findAll();

        if (jogos.isEmpty()) {
            return ResponseEntity.status(204).build();
        }

        return ResponseEntity.status(200).body(jogos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Jogo> listarPorId(@PathVariable Long id) {
        return ResponseEntity.of(this.jogoRepository.findById(id));
    }
    @GetMapping("/nome/{nome}")
    public ResponseEntity<Jogo> listarPorNome(@RequestParam String nome){
        return ResponseEntity.of(this.jogoRepository.findByNome(nome));
    }

    @GetMapping("/empresa")
    public ResponseEntity<List<Jogo>> listarPorEmpresa(@RequestParam String nome) {
        List<Jogo> jogosFiltrados = this.jogoRepository.findByEmpresaIgnoreCase(nome);

        if (jogosFiltrados.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(jogosFiltrados);
    }

    @GetMapping("/data/{dataLancamento}")
    public ResponseEntity<List<Jogo>> listarPorData(@PathVariable LocalDate dataLancamento){
        List<Jogo> jogosFiltrados = this.jogoRepository.findByDataLancamentoLessThanEquals(dataLancamento);
        if(jogosFiltrados.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(jogosFiltrados);
    }
    @GetMapping("/genero/{genero}")
    public ResponseEntity<List<Jogo>> listarPorGenero(@RequestParam String genero){
        List<Jogo> jogosFiltrados = this.jogoRepository.findByGeneroIgnoreCase(genero);
        if(jogosFiltrados.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return  ResponseEntity.status(200).body(jogosFiltrados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogo){
        if(this.jogoRepository.existsById(id)){
            jogo.setId(id);
            jogoRepository.save(jogo);
            return  ResponseEntity.status(200).body(jogo);
        }
        return ResponseEntity.status(404).build();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        if(jogoRepository.existsById(id)){
            jogoRepository.deleteById(id);
            return  ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
