package schoo.sptech.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ProblemDetail;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {
    Optional<Filme> findByNome(String nome);

    List<Filme> findByDiretorIgnoreCase(String nome);

    @Query("SELECT F FROM FILME F WHERE NOME = :NOME")
    List<Filme> buscarPorDiretor(@Param("nome") String nome);

    List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);
}
