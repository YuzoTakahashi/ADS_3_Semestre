package org.example;

public class Main {
    public static void main(String[] args) {
        ControleBonus cb1 = new ControleBonus();

        Professor p1 = new Professor("Felix", 2.0, 40);
        Coordenador c1 = new Coordenador("Rosa", 4.5, 20, 20, 51.0);

        cb1.adicionaBonificado(p1);
        cb1.adicionaBonificado(c1);

        cb1.exibeEducadores();

        System.out.println("Total de bônus: " + cb1.calculaTotalBonus());
    }
}
