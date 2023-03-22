package org.example;

import java.util.Scanner;

public class Exercicio5 {

    public static void verMaiorRedimento(String[] vetorCarro, int[] vetorRendimento){
        int maiorValor = 0;
        int indice = 0;
        for ( ; indice < vetorRendimento.length; indice++) {
            if(maiorValor <= vetorRendimento[indice]){
                maiorValor = vetorRendimento[indice];
            }
        }
        System.out.println(vetorCarro[--indice]);
        System.out.println(maiorValor);
        System.out.println(indice);

    }
    public static void main(String[] args) {

        String[] vetorCarro = new String[5];
        int[] vetorRendimento = new int[5];
        Scanner leitor = new Scanner(System.in);
        Scanner leitorLn = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite o nome de de um carro: ");
            vetorCarro[i] = leitorLn.next();
            System.out.println("Digite o rendimento desse carro(Km/L)");
            vetorRendimento[i] = leitor.nextInt();
        }
        verMaiorRedimento(vetorCarro, vetorRendimento);
    }
}
