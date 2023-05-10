package school.sptech.marketplace.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.marketplace.dominio.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
