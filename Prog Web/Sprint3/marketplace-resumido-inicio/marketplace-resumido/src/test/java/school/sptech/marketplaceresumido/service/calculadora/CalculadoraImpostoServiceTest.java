package school.sptech.marketplaceresumido.service.calculadora;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

class CalculadoraImpostoServiceTest {
    @Test
    @DisplayName("Calcular imposto quando acionado com 100 deve retornar valor correto")
    void calcularImpostoQuandoAcionadoDeveRetornarCorretamente(){
        CalculadoraImpostoService service = new CalculadoraImpostoService();
        double resultadoEsperado = 18.0;
        double valorProtduto = 100.0;

        assertEquals(resultadoEsperado, service.calcularImposto(valorProtduto));

        // Teste tem 3 estados(Falha | Passo | Erro)
        // Erro = mal programado
    }

    @Test
    @DisplayName("Quando acionado com valor nulo deveria lancar IllegarArumentException")
    void quandoAcionadoValorNuloDeveLancarExcecao(){
        CalculadoraImpostoService service = new CalculadoraImpostoService();
        String msgEsperada = "Valor nao pode ser nulo";

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.calcularImposto(null));

        assertEquals(msgEsperada, exception.getMessage());
    }

    @Test
    @DisplayName("Quando acionado com valor negativo deveria lancar IllegarArumentException")
    void quandoAcionadoValorNegativoDeveLancarExcecao(){
        CalculadoraImpostoService service = new CalculadoraImpostoService();
        String msgEsperada = "Valor nao pode ser negativo";
        double valorProduto = -10.0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.calcularImposto(valorProduto));

        assertEquals(msgEsperada, exception.getMessage());
    }
    @Test
    @DisplayName("Quando acionado com valor zero deveria lancar IllegarArumentException")
    void quandoAcionadoValorZeroDeveLancarExcecao(){
        CalculadoraImpostoService service = new CalculadoraImpostoService();
        String msgEsperada = "Valor nao pode ser zero";
        double valorProduto = 0.0;
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.calcularImposto(valorProduto));

        assertEquals(msgEsperada, exception.getMessage());
    }
}