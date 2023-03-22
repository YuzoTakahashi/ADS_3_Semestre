package org.example;

import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private List<Vendavel> vendaveis;

    public Carrinho() {
        this.vendaveis = new ArrayList<Vendavel>();
    }

    public void adicionaVendavel(Vendavel v) {
        vendaveis.add(v);
    }

    public double calculaTotalVenda() {
        double total = 0.0;
        for (Vendavel v : vendaveis) {
            total += v.getValorVenda();
        }
        return total;
    }

    public void exibeItensCarrinho() {
        for (Vendavel v : vendaveis) {
            System.out.println(String.format("Exibindo item: %s", v.toString()));
        }
    }
}
