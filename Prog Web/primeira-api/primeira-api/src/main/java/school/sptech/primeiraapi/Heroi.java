package school.sptech.primeiraapi;

public class Heroi {
    private String nome;
    private int idade;
    private String habilidade;
    private double forca;
    private boolean vivo;
    private int hp;

    public Heroi() {
    }

    public Heroi(String nome, int idade, String habilidade, double forca, boolean vivo, int hp) {
        this.nome = nome;
        this.idade = idade;
        this.habilidade = habilidade;
        this.forca = forca;
        this.vivo = vivo;
        this.hp = hp;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public String getHabilidade() {
        return habilidade;
    }

    public double getForca() {
        return forca;
    }

    public boolean isVivo() {
        return vivo;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}
