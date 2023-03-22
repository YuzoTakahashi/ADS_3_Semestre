package org.example;

public abstract class Educador {
    private String nome;
    private double vlrHoraAula;

    public abstract double getValorBonus();

    public Educador(String nome, double vlrHoraAula) {
        this.nome = nome;
        this.vlrHoraAula = vlrHoraAula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getVlrHoraAula() {
        return vlrHoraAula;
    }

    public void setVlrHoraAula(double vlrHoraAula) {
        this.vlrHoraAula = vlrHoraAula;
    }

    @Override
    public String toString() {
        return "Educador{" +
                "nome='" + nome + '\'' +
                ", vlrHoraAula=" + vlrHoraAula +
                ", totalBonus=" + getValorBonus() +
                '}';
    }
}
