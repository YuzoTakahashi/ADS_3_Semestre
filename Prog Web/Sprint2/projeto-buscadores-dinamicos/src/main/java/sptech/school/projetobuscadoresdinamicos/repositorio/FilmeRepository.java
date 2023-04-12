package sptech.school.projetobuscadoresdinamicos.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.projetobuscadoresdinamicos.dominio.Filme;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

  Optional<Filme> findByNome(String nome);

  //Contains/Containings = like do SQL
  List<Filme> findByDiretorNomeContainsIgnoreCase(String nome);

  List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);

  List<Filme> findByIndicacaoOscarTrue();

  int countByIndicacaoOscarFalse();

  List<Filme> findByCustoProducaoGreaterThanEqual(double custo);
}
