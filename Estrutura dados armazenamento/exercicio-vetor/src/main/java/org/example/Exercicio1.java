package org.example;

import java.util.Scanner;

public class Exercicio1 {

    public static void main(String[] args) {
        int[] vetor = new int[7];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 7; i++) {
            System.out.println("Digite um valor: ");
            vetor[i] = leitor.nextInt();
        }

        System.out.println("=".repeat(20));
        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        System.out.println("=".repeat(20));
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.println(vetor[i]);
        }

    }
}
