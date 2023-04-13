package org.example;

import java.util.Scanner;

public class ExemploThrow {
    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try{
            System.out.println("Digite uma nota: ");
            double n1 = leitor.nextDouble();
            if(n1 < 0 || n1 >10){
                throw new Exception("Nota inválida!");
            }

            System.out.println("Digite outra nota: ");
            double n2 = leitor.nextDouble();
            if(n2 <0 || n2 >10){
                throw new Exception(("Nota inválida"));
            }

            System.out.printf("Média = %.1f", (n1+n2)/2);
        }
        catch(Exception erro){
            System.out.println(erro);
            erro.printStackTrace();
        }
    }
}
