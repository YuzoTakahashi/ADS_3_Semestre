package sptech.school.atv2s3pw.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestBody;
import sptech.school.atv2s3pw.dominio.Pedido;
import sptech.school.atv2s3pw.dto.PedidoDto;

import java.math.BigDecimal;
import java.util.List;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {
    @Query("SELECT COUNT(p) FROM Pedido p")
    int contagemPedido();

    @Query("SELECT AVG(p.valor) FROM Pedido p")
    BigDecimal mediaCusto();

    @Query("SELECT COUNT(p) FROM Pedido p WHERE p.finalizado AND p.cliente.nome ILIKE %:nome%")
    int contagemPedidoFinalizadoPorCliente(String nome);
    @Query("SELECT new sptech.school.atv2s3pw.dto.PedidoDto(p.descricao, p.cliente.nome, p.valor, p.finalizado) FROM Pedido p")
    List<PedidoDto> listagemResumo();

    @Modifying
    @Query("DELETE FROM Pedido p WHERE p.id = :id")
    void deletarPorId(Long id);

    @Modifying
    @Query("UPDATE Pedido p SET p.descricao = :nome WHERE p.id = :id")
    void atualizarDescricaoPedidoPorId(Long id, String descricao);
}
