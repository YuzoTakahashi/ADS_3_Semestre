package school.sptech.atv3s2pw.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import school.sptech.atv3s2pw.dominio.Empresa;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
}
