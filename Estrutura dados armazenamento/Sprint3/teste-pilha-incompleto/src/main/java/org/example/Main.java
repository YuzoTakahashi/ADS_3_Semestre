package org.example;

public class Main {
    public static void main(String[] args) {
        Pilha pilhaTest = new Pilha(3);

        pilhaTest.push(10);
        pilhaTest.push(20);
        pilhaTest.push(30);

        pilhaTest.exibe();
    }
}