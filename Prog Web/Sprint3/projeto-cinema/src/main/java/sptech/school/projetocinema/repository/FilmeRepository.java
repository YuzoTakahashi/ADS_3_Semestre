package sptech.school.projetocinema.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import sptech.school.dto.FilmeResumeDto;
import sptech.school.projetocinema.domain.Filme;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface FilmeRepository extends JpaRepository<Filme, Long> {

    Optional<Filme> findByNome(String nome);

    List<Filme> findByDiretorNomeContainsIgnoreCase(String nome);

    List<Filme> findByDataLancamentoLessThanEqual(LocalDate data);

    List<Filme> findByIndicacaoOscarTrue();

    int countByIndicacaoOscarFalse();

    List<Filme> findByCustoProducaoGreaterThan(double custo);
    List<Filme> findTop5ByOrderByIdDesc();

    @Query("SELECT COUNT(f) FROM Filme f WHERE f.indicacaoOscar")
    int contagemFilmeIndicados();

    @Query("SELECT AVG(f.custoProducao) FROM Filme f")
    BigDecimal mediaCustoProducao();

//    pode utilizar ?1(o 1 representam qual parametro está utilizando)
//    :nome utiliza o nome do parametro
//    usar o I antes do Like = IgnoreCase
    @Query("SELECT COUNT(f) FROM Filme f WHERE f.indicacaoOscar AND f.diretor.nome ILIKE :diretor")
    int contagemFilmeIndicadosPorDiretor(String diretor);

    @Query("SELECT new sptech.school.dto.FilmeResumeDto(f.nome, f.diretor.nome) FROM Filme f")
    List<FilmeResumeDto> listagemResumo();

    @Modifying
    @Query("DELETE FROM Filme f WHERE f.id = :id")
    void deletarPorId(Long id);

    @Modifying
    @Query("UPDATE Filme f SET f.nome = :nome WHERE f.id = :id")
    void atualizarNomePorId(Long id, String nome);
}
