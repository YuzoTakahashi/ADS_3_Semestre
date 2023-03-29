package school.sptech.atv2s2pw.controller;

import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.atv2s2pw.entity.Carro;
import school.sptech.atv2s2pw.repository.CarroRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("carros")
public class CarroController {
    @Autowired
    private CarroRepository carroRepository;

    @GetMapping
    public ResponseEntity<List<Carro>> listar() {
        List<Carro> carros = carroRepository.findAll();
        if (carros.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(carros);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carro> listarPorId(@PathVariable Long id) {
        Optional<Carro> carroOptional = carroRepository.findById(id);
        return ResponseEntity.of(carroOptional);
    }

    @PostMapping
    public ResponseEntity<Carro> cadastrar(@RequestBody Carro carroNovo) {
        carroRepository.save(carroNovo);
        return ResponseEntity.status(200).body(carroNovo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (carroRepository.existsById(id)) {
            carroRepository.deleteById(id);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}

