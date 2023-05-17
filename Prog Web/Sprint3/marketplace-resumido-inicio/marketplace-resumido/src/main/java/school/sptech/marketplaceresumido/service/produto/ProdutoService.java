package school.sptech.marketplaceresumido.service.produto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.marketplaceresumido.domain.Produto;
import school.sptech.marketplaceresumido.domain.data.ProdutoRepository;
import school.sptech.marketplaceresumido.domain.exception.EntidadeNaoEncontradaException;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoAtualizacaoDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoConsultaDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoCriacaoDto;
import school.sptech.marketplaceresumido.service.produto.dto.mapper.ProdutoMapper;

import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<ProdutoConsultaDto> listar() {

        List<Produto> produtos = this.produtoRepository.findAll();

        // Utilização do for tradicional
//        List<ProdutoConsultaDto> produtosDto = new ArrayList<>();
//        for (Produto produto : produtos) {
//            produtosDto.add(ProdutoMapper.mapProdutoToProdutoConsultaDto(produto));
//        }

        // Mapeamento com stream
//        return produtos.stream()
//                .map(produto -> ProdutoMapper.mapProdutoToProdutoConsultaDto(produto))
//                .toList();

        // Utilização de "referência do método (method reference)"
        return produtos.stream()
                .map(ProdutoMapper::mapProdutoToProdutoConsultaDto)
                .toList();
    }

    public ProdutoConsultaDto buscarPorId(long id) {

        Produto produto = this.produtoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Não encontrada!")
        );

        return ProdutoMapper.mapProdutoToProdutoConsultaDto(produto);
    }

    public ProdutoConsultaDto criar(ProdutoCriacaoDto produtoDto) {

        Produto produto = ProdutoMapper.mapProdutoCriacaoDtoToProduto(produtoDto);

        Produto produtoSalvo = this.produtoRepository.save(produto);

        return ProdutoMapper.mapProdutoToProdutoConsultaDto(produtoSalvo);
    }

    public ProdutoConsultaDto atualizar(long id, ProdutoAtualizacaoDto produtoDto) {

        if (!this.produtoRepository.existsById(id)) {
            throw new EntidadeNaoEncontradaException("Produto nao encontrado");
        }

        Produto produto = ProdutoMapper.mapProdutoAtualizacaoDtoToProduto(id, produtoDto);
        Produto produtoSalvo = this.produtoRepository.save(produto);

        return ProdutoMapper.mapProdutoToProdutoConsultaDto(produtoSalvo);
    }
}
