package school.sptech.marketplaceresumido.service.produto.builder;

import school.sptech.marketplaceresumido.domain.Produto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoAtualizacaoDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoConsultaDto;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoCriacaoDto;

import java.util.List;

public class ProdutoBuilder {
    private ProdutoBuilder(){
        throw new IllegalStateException("Classe Utilitária");
    }

    public static Produto criarProduto(){
        return new Produto(1L, "Produto 1", "Descrição do Produto 1", 10.0);
    }

    public static ProdutoConsultaDto criarProdutoConsultaDto(){
        return new ProdutoConsultaDto(1L, "Produto 1", "Descrição do Produto 1", 10.0);
    }

    public static ProdutoCriacaoDto criarProdutoCriacaoDto(){
        return new ProdutoCriacaoDto("Produto 1", "Descrição do Produto 1", 10.0);
    }

    public static ProdutoAtualizacaoDto criarProdutoAtualizacaoDto(){
        return new ProdutoAtualizacaoDto("Produto 1", "Descrição do Produto 1", 10.0);
    }

    public static List<Produto> criarListaProduto(){
        return List.of(
                new Produto(1L, "Produto 1", "Descrição do Produto 1", 10.0),
                new Produto(2L, "Produto 2", "Descrição do Produto 2", 20.0),
                new Produto(3L, "Produto 3", "Descrição do Produto 3", 30.0)
        );
    }

    public static List<ProdutoConsultaDto> criarListaProdutoConsultaDto(){
        return List.of(
                new ProdutoConsultaDto(1L, "Produto 1", "Descrição do Produto 1", 10.0),
                new ProdutoConsultaDto(2L, "Produto 2", "Descrição do Produto 2", 20.0),
                new ProdutoConsultaDto(3L, "Produto 3", "Descrição do Produto 3", 30.0)
        );
    }
}
