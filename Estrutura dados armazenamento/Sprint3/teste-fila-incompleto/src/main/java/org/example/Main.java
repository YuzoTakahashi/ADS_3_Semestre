package org.example;

public class Main {
    public static void main(String[] args) {
        int capacidade = 5;
        Fila fila = new Fila(capacidade );
        fila.insert("F");
        fila.insert("e");
        fila.insert("l");
        fila.insert("i");
        fila.insert("x");

        fila.peek();

        for (int i = 0; i < capacidade; ++i) {
            System.out.print(fila.poll() + " ");
        }
    }
}