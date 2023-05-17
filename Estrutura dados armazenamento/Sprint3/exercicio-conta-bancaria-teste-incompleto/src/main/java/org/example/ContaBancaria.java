package org.example;

import java.util.Objects;

public class ContaBancaria {

    // Atributos
    private Integer numero;
    private Double saldo;

    // Construtor
    public ContaBancaria(Integer numero, Double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    // Métodos

    /* Método debitar - recebe o valor a ser debitado
       Se o valor for inválido, deve lançar IllegalArgumentException
       Se o saldo for insuficiente para o débito, retorna false
       Senão, atualiza o saldo e retorna true
     */
    public Boolean debitar(Double valor){
        if (valor == null) {
            throw new IllegalArgumentException();
        }
        if (valor <= 0) {
            throw new IllegalArgumentException();
        }
        if (valor <= saldo) {
            saldo -= valor;
            return true;
        }
        return false;
    }

    /* Método creditar - recebe o valor a ser depositado
       Se o valor for inválido, deve lançar IllegalArgumentException
       Senão, atualiza o saldo
     */
    public void creditar(Double valor){
        if (valor == null) {
            throw new IllegalArgumentException();
        }
        if (valor <= 0) {
            throw new IllegalArgumentException();
        }

        saldo += valor;
    }


    /* Método toString() - retorna uma String formatada com o número e o saldo da conta. */
    @Override
    public String toString() {
        return String.format("Número: %.d \n Saldo: R$ %.2", this.numero, this.saldo);
    }

    // Getters
    public Integer getNumero() {
        return this.numero;
    }

    public Double getSaldo() {
        return this.saldo;
    }

}
