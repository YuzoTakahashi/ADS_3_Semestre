package com.example.demo;

public class Filme {
    private String nome;
    private int anoLancamento;
    private int qtdOscar;

    public Filme(String nome, int anoLancamento, int qtdOscar) {
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.qtdOscar = qtdOscar;
    }

    public Filme() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public int getQtdOscar() {
        return qtdOscar;
    }

    public void setQtdOscar(int qtdOscar) {
        this.qtdOscar = qtdOscar;
    }
}
