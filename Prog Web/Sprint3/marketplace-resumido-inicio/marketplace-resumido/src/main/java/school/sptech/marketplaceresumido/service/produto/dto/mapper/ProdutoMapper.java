package school.sptech.marketplaceresumido.service.produto.dto.mapper;

import school.sptech.marketplaceresumido.domain.Produto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoAtualizacaoDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoConsultaDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoCriacaoDto;

import java.util.Objects;

public class ProdutoMapper {

    private ProdutoMapper() {
        throw new IllegalStateException("Classe utilitária");
    }

    public static ProdutoConsultaDto mapProdutoToProdutoConsultaDto(Produto produto) {

        if (Objects.isNull(produto)) {
            return null;
        }

        return new ProdutoConsultaDto(
                produto.getId(),
                produto.getNome(),
                produto.getDescricao(),
                produto.getPreco()
        );
    }

    public static Produto mapProdutoCriacaoDtoToProduto(ProdutoCriacaoDto produtoCriacaoDto) {

        if (Objects.isNull(produtoCriacaoDto)) {
            return null;
        }

        return new Produto(
                null,
                produtoCriacaoDto.getNome(),
                produtoCriacaoDto.getDescricao(),
                produtoCriacaoDto.getPreco()
        );
    }

    public static Produto mapProdutoAtualizacaoDtoToProduto(Long id, ProdutoAtualizacaoDto produtoAtualizacaoDto) {

        if (Objects.isNull(produtoAtualizacaoDto)) {
            return null;
        }

        return new Produto(
                id,
                produtoAtualizacaoDto.getNome(),
                produtoAtualizacaoDto.getDescricao(),
                produtoAtualizacaoDto.getPreco()
        );
    }
}
