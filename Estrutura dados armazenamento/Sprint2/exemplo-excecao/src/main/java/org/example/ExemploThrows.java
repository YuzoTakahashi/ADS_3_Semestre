package org.example;

import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ExemploThrows {

    public static int divide(int a, int b) throws ArithmeticException{
        return a/b;
    }

    public static void main(String[] args) {
        Scanner leitor = new Scanner(System.in);

        try{
            System.out.println("Digite um número: ");
            int a = leitor.nextInt();

            System.out.println("Digite outro número: ");
            int b = leitor.nextInt();

            System.out.printf("%d / %d = %d", a, b, divide(a, b));
        }
        catch(ArithmeticException erro){
            System.out.println("Divisão por zero!");
            erro.printStackTrace();
        }
        catch(InputMismatchException erro){
            System.out.println("Digite apenas número");
            erro.printStackTrace();
        }
    }
}
