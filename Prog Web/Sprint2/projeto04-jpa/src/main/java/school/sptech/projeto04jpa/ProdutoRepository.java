package school.sptech.projeto04jpa;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository é do tipo Produto e identifica pelo Long
public interface ProdutoRepository extends JpaRepository<Produto, Long>{
}
