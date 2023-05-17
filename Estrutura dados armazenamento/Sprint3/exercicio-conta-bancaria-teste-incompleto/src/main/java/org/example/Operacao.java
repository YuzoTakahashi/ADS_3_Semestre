package org.example;
public class Operacao {

    // Atributos
    private ContaBancaria contaBancaria;
    private String tipoOperacao;
    private Double valor;

    // Construtor
    public Operacao(ContaBancaria contaBancaria, String tipoOperacao, Double valor) {
        this.contaBancaria = contaBancaria;
        this.tipoOperacao = tipoOperacao;
        this.valor = valor;
    }

    // Métodos

    // toString()
    @Override
    public String toString() {
        return String.format("\n----------Operação----------\n" +
                        "Tipo de operação: %s\n" +
                        "Valor da operação: R$%.2f",
                tipoOperacao, valor);
    }

    // Getters
    public ContaBancaria getContaBancaria() {
        return this.contaBancaria;
    }

    public String getTipoOperacao() {
        return this.tipoOperacao;
    }

    public Double getValor() {
        return this.valor;
    }

}
