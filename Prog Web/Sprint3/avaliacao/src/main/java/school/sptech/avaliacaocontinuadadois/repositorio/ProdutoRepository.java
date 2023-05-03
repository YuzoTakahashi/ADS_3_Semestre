package school.sptech.avaliacaocontinuadadois.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.avaliacaocontinuadadois.domain.Produto;

import java.time.LocalDate;
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Produto findByCategoriaTop1LessIgnoreCase(String nome);

    Produto findByCategoriaTop1GreaterIgnoreCase(String nome);

    List<Produto> findAllByCategoriaIgnoreCase(String nome);

    Long countByCategoriaIgnoreCase(String nome);

    Long CountAllByCategoriaPromocaoTrueIgnoreCase(String nome);

    List<Produto> findAllByDataCriacaoGreaterLessThanEqual(LocalDate fim, LocalDate inicio);
}
