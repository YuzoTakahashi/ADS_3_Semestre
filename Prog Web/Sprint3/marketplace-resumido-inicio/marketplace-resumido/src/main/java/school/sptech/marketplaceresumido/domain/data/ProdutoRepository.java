package school.sptech.marketplaceresumido.domain.data;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.marketplaceresumido.domain.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
