package org.example;

import java.util.ArrayList;
import java.util.List;

public class ControleBonus {
    private List<Educador> bonificados;

    public ControleBonus() {
        bonificados = new ArrayList<>();
    }

    public void adicionaBonificado(Educador e) {
        bonificados.add(e);
    }

    public void exibeEducadores() {
        for (Educador e : bonificados) {
            System.out.println(e);
        }
    }

    public double calculaTotalBonus() {
        double totalBonus = 0.0;
        for (Educador e : bonificados) {
            totalBonus += e.getValorBonus();
        }

        return totalBonus;
    }
}
