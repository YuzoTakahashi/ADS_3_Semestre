package org.example;

public class Coordenador extends Professor {
    private double qtdHoras;
    private double vlrHoraCoord;

    public Coordenador(String nome, double vlrHoraAula, int qtdAulas, double qtdHoras, double vlrHoraCoord) {
        super(nome, vlrHoraAula, qtdAulas);
        this.qtdHoras = qtdHoras;
        this.vlrHoraCoord = vlrHoraCoord;
    }

    @Override
    public double getValorBonus() {
        return getQtdAulas() * getVlrHoraAula() * 4.5 * 0.15 * 4.5 * 0.2 + qtdHoras * vlrHoraCoord;
    }

    public double getQtdHoras() {
        return qtdHoras;
    }

    public void setQtdHoras(double qtdHoras) {
        this.qtdHoras = qtdHoras;
    }

    public double getVlrHoraCoord() {
        return vlrHoraCoord;
    }

    public void setVlrHoraCoord(double vlrHoraCoord) {
        this.vlrHoraCoord = vlrHoraCoord;
    }

    @Override
    public String toString() {
        return "Coordenador{" +
                "qtdHoras=" + qtdHoras +
                ", vlrHoraCoord=" + vlrHoraCoord +
                "} " + super.toString();
    }
}
