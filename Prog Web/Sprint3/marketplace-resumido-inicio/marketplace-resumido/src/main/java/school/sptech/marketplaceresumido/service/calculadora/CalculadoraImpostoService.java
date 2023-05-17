package school.sptech.marketplaceresumido.service.calculadora;

import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class CalculadoraImpostoService {
    private final double ICMS = 0.18;
    // Valor de produto nao pode nulo
    // Valor de produto nao pode ser zero
    // Valor d eproduto nao pode ser negativo
    public double calcularImposto(Double valorProduto){
        if(Objects.isNull(valorProduto)) {
            throw new IllegalArgumentException("Valor nao pode ser nulo");
        }
        if(valorProduto < 0) {
            throw new IllegalArgumentException("Valor nao pode ser negativo");
        }

        if(valorProduto == 0){
            throw  new IllegalArgumentException("Valor nao pode ser zero");
        }
        return valorProduto * ICMS;
    }
}
