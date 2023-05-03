public class Pokemon {
    private int ID;
    private String nome;
    private int numEvolucao;
    private double poder;
    private String tipo;
    private double exp;
    private String raridade;

    public Pokemon(int ID, String nome, int numEvolucao, double poder, String tipo, double exp, String raridade) {
        this.ID = ID;
        this.nome = nome;
        this.numEvolucao = numEvolucao;
        this.poder = poder;
        this.tipo = tipo;
        this.exp = exp;
        this.raridade = raridade;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumEvolucao() {
        return numEvolucao;
    }

    public void setNumEvolucao(int numEvolucao) {
        this.numEvolucao = numEvolucao;
    }

    public double getPoder() {
        return poder;
    }

    public void setPoder(double poder) {
        this.poder = poder;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public String getRaridade() {
        return raridade;
    }

    public void setRaridade(String raridade) {
        this.raridade = raridade;
    }

    @Override
    public String toString() {
        return "Pokemon{" +
                "ID=" + ID +
                ", nome='" + nome + '\'' +
                ", numEvolucao=" + numEvolucao +
                ", poder=" + poder +
                ", tipo='" + tipo + '\'' +
                ", exp=" + exp +
                ", raridade='" + raridade + '\'' +
                '}';
    }
}
