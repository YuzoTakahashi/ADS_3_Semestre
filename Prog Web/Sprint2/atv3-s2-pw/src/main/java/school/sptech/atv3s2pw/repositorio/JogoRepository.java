package school.sptech.atv3s2pw.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.ProblemDetail;
import school.sptech.atv3s2pw.dominio.Jogo;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByEmpresaIgnoreCase(String nome);

    List<Jogo> findByDataLancamentoLessThanEquals(LocalDate dataLancamento);

    List<Jogo> findByGeneroIgnoreCase(String genero);

    Optional<Jogo> findByNome(String nome);
}
