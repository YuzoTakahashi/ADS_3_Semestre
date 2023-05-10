package school.sptech.marketplace.dominio;

import jakarta.persistence.*;

@Entity
public class AvaliacaoCompradorProduto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Comprador comprador;

    @ManyToOne
    private Produto produto;

    private Integer nota;
    private String comentario;

    public AvaliacaoCompradorProduto() {
    }

    public AvaliacaoCompradorProduto(Comprador comprador, Produto produto, Integer nota, String comentario) {
        this.comprador = comprador;
        this.produto = produto;
        this.nota = nota;
        this.comentario = comentario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Comprador getComprador() {
        return comprador;
    }

    public void setComprador(Comprador comprador) {
        this.comprador = comprador;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
}
