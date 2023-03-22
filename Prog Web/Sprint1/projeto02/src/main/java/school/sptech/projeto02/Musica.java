package school.sptech.projeto02;

public class Musica {
    private String nome;
    private String artista;
    private int anoLancamento;

    public Musica() {
    }

    public Musica(String nome, String artista, int anoLancamento) {
        this.nome = nome;
        this.artista = artista;
        this.anoLancamento = anoLancamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }
}
