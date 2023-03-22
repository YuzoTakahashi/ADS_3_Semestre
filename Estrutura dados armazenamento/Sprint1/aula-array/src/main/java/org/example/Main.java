package org.example;

import java.util.Scanner;

public class Main {

    public static void somarVetor(int[] vetor){
        int somaTotal = 0;
        for (int i = 0; i < vetor.length; i++) {
            somaTotal += vetor[i];
        }
        System.out.println(somaTotal);
    }

    public static void verPar(int[] vetor){
        int totalPar = 0;
        System.out.println("Desafio 2: ");
        for (int a = 0; a < vetor.length; a++) {
            if(vetor[a] % 2 == 0){
                totalPar++;
            }
        }
        System.out.println(totalPar);
    }

    public static void verDiaSemana(){
        String[] diaSemana = {"Domingo", "Segunda", "Terça", "Quarta", "Quinta", "Sexta", "Sábado"};
        Scanner leitor = new Scanner(System.in);

        System.out.println("Digite um número entre 1 e 7: ");
        int numEscolhido = leitor.nextInt();

        switch(numEscolhido) {
            case 1:
                System.out.println(diaSemana[0]);
                break;
            case 2:
                System.out.println(diaSemana[1]);
                break;
            case 3:
                System.out.println(diaSemana[2]);
                break;
            case 4:
                System.out.println(diaSemana[3]);
                break;
            case 5:
                System.out.println(diaSemana[4]);
                break;
            case 6:
                System.out.println(diaSemana[5]);
                break;
            case 7:
                System.out.println(diaSemana[6]);
                break;
            default:
                verDiaSemana();
        }
    }
    public static void main(String[] args) {

        int[] vetor = {5, 6, 10, 11, 24, 5};

        //DESAFIO 1
        //SOMAR TODOS OS ELEMENTOS
        System.out.println("Desafio 1: ");

        somarVetor(vetor);
        System.out.println("=".repeat(20));

        //DESAFIO 2
        //VERIFICAR PARES
        verPar(vetor);
        System.out.println("=".repeat(20));

        //DESAFIO 3
        //VER DIA DA SEMANA
        verDiaSemana();
        System.out.println("=".repeat(20));

}