package org.example;

import jdk.jshell.Snippet;

import java.util.Scanner;

public class Exercicio4 {

    public static void encontrarRepetido(int[] vetor, int numSolicitado){
        int numRepetido = 0;
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] == numSolicitado){
                numRepetido++ ;
            }
        }
        if(numSolicitado > 0){
            System.out.println(String.format("O número %d ocorre %d vezes", numSolicitado, numRepetido));
        }else{
            System.out.println(String.format("O número %d não ocorre nenhuma vez", numSolicitado));
        }
    }
    public static void main(String[] args) {

        int[] vetor = new int[10];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um número");
            vetor[i] = leitor.nextInt();
        }
        System.out.println("=".repeat(20));
        System.out.println("Digite um número para encontrar");
        int numSolicitado = leitor.nextInt();
        System.out.println("=".repeat(20));
        encontrarRepetido(vetor, numSolicitado);
    }
}
