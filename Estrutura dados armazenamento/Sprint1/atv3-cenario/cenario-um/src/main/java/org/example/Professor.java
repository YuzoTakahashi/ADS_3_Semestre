package org.example;

public class Professor implements IFuncionario{
    private String nome;
    private int qtdAulaSemana;
    private double valorHora;

    public Professor(String nome, int qtdAulaSemana, double valorHora) {
        this.nome = nome;
        this.qtdAulaSemana = qtdAulaSemana;
        this.valorHora = valorHora;
    }

    @Override
    public double getValorBonus() {
        return qtdAulaSemana * valorHora * 4.5 * 0.15;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtdAulaSemana() {
        return qtdAulaSemana;
    }

    public void setQtdAulaSemana(int qtdAulaSemana) {
        this.qtdAulaSemana = qtdAulaSemana;
    }

    public double getValorHora() {
        return valorHora;
    }

    public void setValorHora(double valorHora) {
        this.valorHora = valorHora;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "nome='" + nome + '\'' +
                ", qtdAulaSemana=" + qtdAulaSemana +
                ", valorHora=" + valorHora +
                '}';
    }
}
