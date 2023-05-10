package school.sptech.marketplace.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.marketplace.dominio.Comprador;

public interface CompradorRepository extends JpaRepository<Comprador, Long> {
}
