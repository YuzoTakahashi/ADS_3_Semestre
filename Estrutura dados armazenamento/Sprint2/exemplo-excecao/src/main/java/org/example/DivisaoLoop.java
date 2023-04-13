package org.example;

import javax.swing.*;

public class DivisaoLoop {
    public static void main(String[] args) {
        Boolean fim = false;

        while (!fim) {

            String sNum1 = JOptionPane.showInputDialog("Digite um número");
            String sNum2 = JOptionPane.showInputDialog("Digite outro número");
            try {
                int num1 = Integer.parseInt(sNum1);
                int num2 = Integer.parseInt(sNum2);

                JOptionPane.showMessageDialog(null,
                        num1 / num2);
                fim = true;
            } catch (ArithmeticException erro) {
                JOptionPane.showMessageDialog(null,
                        "Divisão por zero!\n" + erro,
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException erro) {
                JOptionPane.showMessageDialog(null,
                        "Digite apenas números\n" + erro,
                        "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        }

        System.exit(0);
    }
}