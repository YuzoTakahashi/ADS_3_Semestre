package school.sptech.atv1;

public class Heroi {
    private String nome;
    private String habilidade;
    private int idade;
    private double forca;
    private boolean vivo;

    public Heroi() {
    }

    public Heroi(String nome, String habilidade, int idade, double forca, boolean vivo) {
        this.nome = nome;
        this.habilidade = habilidade;
        this.idade = idade;
        this.forca = forca;
        this.vivo = vivo;
    }

    public String getNome() {
        return nome;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public int getIdade() {
        return idade;
    }

    public double getForca() {
        return forca;
    }

    public boolean isVivo() {
        return vivo;
    }

    @Override
    public String toString() {
        return "Heroi{" +
                "nome='" + nome + '\'' +
                ", habilidade='" + habilidade + '\'' +
                ", idade=" + idade +
                ", forca=" + forca +
                ", vivo=" + vivo +
                '}';
    }
}
