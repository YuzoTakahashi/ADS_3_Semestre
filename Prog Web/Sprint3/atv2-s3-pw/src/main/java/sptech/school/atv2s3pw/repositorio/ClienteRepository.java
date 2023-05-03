package sptech.school.atv2s3pw.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.atv2s3pw.dominio.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
