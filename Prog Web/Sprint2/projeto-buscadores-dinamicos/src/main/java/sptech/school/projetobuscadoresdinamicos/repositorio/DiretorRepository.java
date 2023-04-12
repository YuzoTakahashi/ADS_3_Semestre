package sptech.school.projetobuscadoresdinamicos.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import sptech.school.projetobuscadoresdinamicos.dominio.Diretor;


public interface DiretorRepository extends JpaRepository<Diretor, Long> {
}
