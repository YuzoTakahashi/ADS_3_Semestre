package school.sptech.marketplaceresumido.service.produto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import school.sptech.marketplaceresumido.domain.Produto;
import school.sptech.marketplaceresumido.domain.data.ProdutoRepository;
import school.sptech.marketplaceresumido.domain.exception.EntidadeNaoEncontradaException;
import school.sptech.marketplaceresumido.service.produto.builder.ProdutoBuilder;
import school.sptech.marketplaceresumido.service.produto.dto.ProdutoConsultaDto;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProdutoServiceTest {
    @Mock
    private ProdutoRepository produtoRepository;
    @InjectMocks
    private ProdutoService service;

    @Test
    @DisplayName("listar quando acionado deve retornar 3 itens")
    void listarQuandoAcionadoDeveRetornarObjetosValidos(){
        // Given
        int resultadoEsperado = 3;
        List<Produto> produtos = ProdutoBuilder.criarListaProduto();

        //When
        //Mockito serve para alterar comportamento de classes,
        //métodos, coisas que no meio do caminho do objetivo
        Mockito.when(produtoRepository.findAll()).thenReturn(produtos);

        //Then
        List<ProdutoConsultaDto> resultado = service.listar();

        //Assert
        assertEquals(resultadoEsperado, resultado.size());
        assertFalse(resultado.isEmpty());
    }

    @Test
    @DisplayName("Listar quando acionado e nao houver registros deve retornar lista vazia")
    void listarQuandoAcionadoNaoHouverRegistroDeveRetornaListaVazia(){
        //Given
        int resultadoEsperado = 0;

        //when
        Mockito.when(produtoRepository.findAll()).thenReturn(List.of());

        //Then
        List<ProdutoConsultaDto> resultado = service.listar();

        //Asserts
        assertTrue(resultado.isEmpty());
        assertEquals(resultadoEsperado, resultado.size());
    }

    @Test
    @DisplayName("Buscar por id quando acionado com id invalido deve lancar EntidadeNaoEncontradaException")
    void buscarIdQuandoAcionadoIdInvalidoDeveLancarExcecao(){

        //Given
        final String msgEsperada = "Não encontrada!";

        //When
        //utilizar L para Long OU Mockito.anyLong()
//        Mockito.when(produtoRepository.findById(Mockito.anyLong()))
//                .thenReturn(Optional.empty());
        Mockito.when(produtoRepository.findById(1L))
                .thenReturn(Optional.empty());

        // Then / Asserts
        EntidadeNaoEncontradaException exception = assertThrows(EntidadeNaoEncontradaException.class,
                () -> service.buscarPorId(1L)
        );

        assertEquals(msgEsperada, exception.getMessage());
    }
}