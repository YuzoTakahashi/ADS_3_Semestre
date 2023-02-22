package org.example;

public class Professor extends Educador {
    private int qtdAulas;

    public Professor(String nome, double vlrHoraAula, int qtdAulas) {
        super(nome, vlrHoraAula);
        this.qtdAulas = qtdAulas;
    }

    @Override
    public double getValorBonus() {
        return qtdAulas * getVlrHoraAula() * 4.5 * 0.15;
    }

    public int getQtdAulas() {
        return qtdAulas;
    }

    public void setQtdAulas(int qtdAulas) {
        this.qtdAulas = qtdAulas;
    }

    @Override
    public String toString() {
        return "Professor{" +
                "qtdAulas=" + qtdAulas +
                "} " + super.toString();
    }
}
