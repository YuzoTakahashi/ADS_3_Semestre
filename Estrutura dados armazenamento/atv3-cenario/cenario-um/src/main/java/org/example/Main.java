package org.example;

public class Main {
    public static void main(String[] args) {
        Professor p = new Professor("Felix", 3, 6.0);

        Coordenador c = new Coordenador("Rosa", 15, 75.0);

        ControleBonus cb1 = new ControleBonus();

        cb1.adicionarBonificado(p);
        cb1.adicionarBonificado(c);

        System.out.printf("Total de bônus recebidos: %.2f\n", cb1.calculaTotalBonus());

        cb1.exibirBonificados();

    }
}
