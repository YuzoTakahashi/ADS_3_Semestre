package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner leitor = new Scanner(System.in);

        String[] turma1 = new String[10];
        String[] turma2 = new String[10];
        String nome, turma;
        int indT1 = 0;
        int indT2 = 0;

        for (int i=0; i < turma1.length; i++) {
            System.out.println("Digite o nome de um aluno");
            nome = leitor.next();

            do {
                System.out.println("Digite a turma (T1 ou T2)");
                turma = leitor.next();
            } while (!turma.equalsIgnoreCase("T1") &&
                     !turma.equalsIgnoreCase("T2"));

            if (turma.equalsIgnoreCase("T1")) {
                turma1[indT1++] = nome;
            }
            else {
                turma2[indT2++] = nome;
            }
        }

        if (indT1 == 0) {
            System.out.println("Não há alunos na Turma T1");
        }
        else {
            System.out.println("Há " + indT1 + " alunos na Turma T1");
            for (int i = 0; i < indT1; i++) {
                System.out.println(turma1[i]);
            }
        }
        System.out.println();
        if (indT2 == 0) {
            System.out.println("Não há alunos na Turma T2");
        }
        else {
            System.out.println("Há " + indT2 + " alunos na Turma T2");
            for (int i = 0; i < indT2; i++) {
                System.out.println(turma2[i]);
            }
        }

    }
}