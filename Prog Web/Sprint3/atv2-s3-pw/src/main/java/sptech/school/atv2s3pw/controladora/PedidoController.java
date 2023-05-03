package sptech.school.atv2s3pw.controladora;

import jakarta.transaction.Transactional;
import org.aspectj.weaver.ResolvedPointcutDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sptech.school.atv2s3pw.dominio.Pedido;
import sptech.school.atv2s3pw.dto.PedidoDto;
import sptech.school.atv2s3pw.repositorio.PedidoRepository;

import java.math.BigDecimal;
import java.util.List;

@RequestMapping("/pedidos")
@RestController
public class PedidoController {
    @Autowired
    private PedidoRepository pedidoRepository;

    @PostMapping
    public ResponseEntity<Pedido> cadastrar(@RequestBody Pedido pedido){
        Pedido pedidoRegistrado = this.pedidoRepository.save(pedido);
        return ResponseEntity.status(201).body(pedidoRegistrado);
    }

    @GetMapping
    public ResponseEntity<List<Pedido>> listar(){
        List<Pedido> pedidos = this.pedidoRepository.findAll();
        if(pedidos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(pedidos);
    }

    @GetMapping("/contagem")
    public ResponseEntity<Integer> contagemPedidos(){
        return ResponseEntity.status(200).body(this.pedidoRepository.contagemPedido());
    }

    @GetMapping("/media-custo")
    public ResponseEntity<BigDecimal> mediaCusto(){
        return ResponseEntity.status(200).body(this.pedidoRepository.mediaCusto());
    }

    @GetMapping("/finalizados/cliente")
    public ResponseEntity<Integer> finalizadosPorCliente(@RequestParam String nome){
        int contagem = this.pedidoRepository.contagemPedidoFinalizadoPorCliente(nome);
        return ResponseEntity.status(200).body(contagem);
    }

    @GetMapping("/resumo")
    public ResponseEntity<List<PedidoDto>> resumoPedido(){
        List<PedidoDto> pedidos = this.pedidoRepository.listagemResumo();
        if(pedidos.isEmpty()){
            return ResponseEntity.status(204).build();
        }
        return  ResponseEntity.status(200).body(pedidos);
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarPorId(@PathVariable Long id){
        if(this.pedidoRepository.existsById(id)){
            this.pedidoRepository.deletarPorId(id);
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @Transactional
    @PatchMapping("/{id}")
    public ResponseEntity<Void> atualizarDescricaoPedido(@PathVariable Long id, @RequestParam String descricao){
        if(this.pedidoRepository.existsById(id)){
            this.pedidoRepository.atualizarDescricaoPedidoPorId(id, descricao);
            return ResponseEntity.status(200).build();
        }
        return ResponseEntity.status(404).build();
    }
}
