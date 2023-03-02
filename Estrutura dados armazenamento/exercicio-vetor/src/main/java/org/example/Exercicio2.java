package org.example;

import java.util.Scanner;

public class Exercicio2 {

    public static double calcularMedia(int[] vetor){
        double mediaTotal = 0.0;
        for (int i = 0; i < vetor.length; i++) {
            mediaTotal += vetor[i];
        }
        return mediaTotal / vetor.length;
    }

    public static void mostrarAcimaMedia(double media, int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i] >= media){
                System.out.println(vetor[i]);
            }
        }
    }
    public static void main(String[] args) {
        int[] vetor = new int[10];
        Scanner leitor = new Scanner(System.in);

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um número: ");
            vetor[i] = leitor.nextInt();
        }
        System.out.println(String.format("%.1f", calcularMedia(vetor)));
        System.out.println("=".repeat(20));
        mostrarAcimaMedia(calcularMedia(vetor), vetor);
    }
}
