package org.example;

public class Coordenador implements IFuncionario {
    private String nome;
    private int qtdHoraCord;
    private double valorHoraCord;

    public Coordenador(String nome, int qtdHoraCord, double valorHoraCord) {
        this.nome = nome;
        this.qtdHoraCord = qtdHoraCord;
        this.valorHoraCord = valorHoraCord;
    }

    @Override
    public double getValorBonus() {
        return qtdHoraCord * valorHoraCord * 4.5 * 0.2;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdHoraCord() {
        return qtdHoraCord;
    }

    public void setQtdHoraCord(int qtdHoraCord) {
        this.qtdHoraCord = qtdHoraCord;
    }

    public double getValorHoraCord() {
        return valorHoraCord;
    }

    public void setValorHoraCord(double valorHoraCord) {
        this.valorHoraCord = valorHoraCord;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "nome='" + nome + '\'' +
                ", qtdHoraCord=" + qtdHoraCord +
                ", valorHoraCord=" + valorHoraCord +
                '}';
    }
}
