package school.sptech.projeto05validations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projeto05validations.repository.MusicaRepository;
import school.sptech.projeto05validations.entity.Musica;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("musicas")
public class MusicaController {
    @Autowired
    private MusicaRepository musicaRepository;

    @GetMapping
    public ResponseEntity<List<Musica>> listar(){
        List<Musica> musicas = musicaRepository.findAll();
        if(musicas.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(musicas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Musica> listarPorId(@PathVariable Integer id){
        Optional<Musica> musicaOptional = musicaRepository.findById(id);
//        if (musicaOptional.isPresent()) {
//            return ResponseEntity.status(200).body(musicaOptional.get());
//        }
//        return ResponseEntity.status(404).build();
        return ResponseEntity.of(musicaOptional);
    }

    @PostMapping
    public ResponseEntity<Musica> cadastrar(@RequestBody Musica musicaNova){
        musicaRepository.save(musicaNova);
        return ResponseEntity.status(200).body(musicaNova);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Musica> atualizar(@PathVariable Integer id, @RequestBody Musica musicaAtualizada){
        if (musicaRepository.existsById(id)) {
            musicaAtualizada.setId(id);
            musicaRepository.save(musicaAtualizada);
            return ResponseEntity.status(200).body(musicaAtualizada);
        }
        return ResponseEntity.status(404).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        if(musicaRepository.existsById(id)){
            musicaRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
