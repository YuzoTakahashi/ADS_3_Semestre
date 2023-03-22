package org.example;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Exercicio3 {

    public static String encontrarNome(String[] vetor, String nomeSolicitado){
        for (int i = 0; i < vetor.length; i++) {
            if(vetor[i].equals(nomeSolicitado)){
                return "Nome encontrado no índice " + i;
            }
        }
        return "Nome não encontrado";
    }
    public static void main(String[] args) {
        String[] vetor = new String[10];
        Scanner leitor = new Scanner(System.in);
        boolean validado = false;

        for (int i = 0; i < 10; i++) {
            System.out.println("Digite um nome: ");
            vetor[i] = leitor.next();
        }
        System.out.println("=".repeat(20));
        System.out.println("Digite um nome qualquer: ");
        String nomeSolicitado = leitor.next();

        System.out.println(encontrarNome(vetor, nomeSolicitado));
    }
}
