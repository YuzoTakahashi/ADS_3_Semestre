package org.example;

import java.util.Scanner;

public class Exercicio6 {
    public static void main(String[] args) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia: ");
        int dia = scanner.nextInt();

        System.out.print("Digite o numero do mês: ");
        int mes = scanner.nextInt();
        int diasMesAnterior = 0;
        for (int i = 0; i < mes - 1; i++) {
            diasMesAnterior += diasPorMes[i];
        }

        int totalDias = diasMesAnterior + dia;

        System.out.printf("O dia %d/%d corresponde ao dia %d do ano.\n", dia, mes, totalDias);
    }
}
