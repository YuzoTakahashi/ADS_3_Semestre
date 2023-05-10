package school.sptech.marketplace.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.marketplace.dominio.AvaliacaoCompradorProduto;
import school.sptech.marketplace.dominio.Comprador;
import school.sptech.marketplace.dominio.Produto;
import school.sptech.marketplace.dto.AvaliacaoCompradorProdutoAlteracaoDto;
import school.sptech.marketplace.dto.AvaliacaoCompradorProdutoCriacaoDto;
import school.sptech.marketplace.repositorio.AvaliacaoCompradorProdutoRepository;
import school.sptech.marketplace.repositorio.CompradorRepository;
import school.sptech.marketplace.repositorio.ProdutoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoCompradorProdutoServico {
    @Autowired
    private AvaliacaoCompradorProdutoRepository avaliacaoRepository;

    @Autowired
    private CompradorRepository compradorRepository;

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<AvaliacaoCompradorProduto> listarAvaliacoes(){
        List<AvaliacaoCompradorProduto> avaliacoes = avaliacaoRepository.findAll();
        return avaliacoes;
    }

    public AvaliacaoCompradorProduto buscarPorId(Long id) {
        return avaliacaoRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não existe")
        );
//        Optional<AvaliacaoCompradorProduto> avaliacao = avaliacaoRepository.findById(id);
//
//        if (avaliacao.isPresent()) {
//            return avaliacao.get();
//        }
//
//        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Avaliação não existe");
    }

    public Comprador  buscarCompradorPorId(Long id){
        Optional<Comprador> comprador = compradorRepository.findById(id);
        if (comprador.isPresent()) {
            return comprador.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Comprador não existe");
    }

    public Produto buscarProdutoPorId(Long id){

        Optional<Produto> produto = produtoRepository.findById(id);
        if (produto.isPresent()) {
            return produto.get();
        }

        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Produto não existe");
    }

    public AvaliacaoCompradorProduto criarAvaliacao(AvaliacaoCompradorProdutoCriacaoDto novaAvaliacao){
        Optional<Produto> produto = produtoRepository.findById(novaAvaliacao.getProdutoId());
        Optional<Comprador> comprador = compradorRepository.findById(novaAvaliacao.getCompradorId());

        if (comprador.isPresent() || produto.isPresent()) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Já existe avaliação com esses IDs");
        }

        AvaliacaoCompradorProduto avaliacao = new AvaliacaoCompradorProduto(
                comprador.get(),
                produto.get(),
                novaAvaliacao.getNota(),
                novaAvaliacao.getComentario()
        );
        return avaliacaoRepository.save(avaliacao);
    }

    public AvaliacaoCompradorProduto editarAvaliacao(Long id, AvaliacaoCompradorProdutoAlteracaoDto avaliacao){
        Optional<AvaliacaoCompradorProduto> avaliacaoExistente = avaliacaoRepository.findById(id);

        if(avaliacaoExistente.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Não existe a avaliação solicitada");
        }

        AvaliacaoCompradorProduto avaliacaoEditada = avaliacaoExistente.get();

        if(avaliacao.getComentario() != null){
            avaliacaoEditada.setComentario(avaliacao.getComentario());
        }
        if(avaliacao.getNota() != null){
            avaliacaoEditada.setNota(avaliacao.getNota());
        }

        avaliacaoRepository.save(avaliacaoEditada);

        return avaliacaoEditada;
    }


}
