package school.sptech.projeto05validations.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;
import java.time.LocalDate;

@Entity
public class Musica{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank
    @Size(min = 3, max = 10)
    private String nome;
    @NotBlank
    @Size(min = 3, max = 10)
    private String album;
    @Past
    private LocalDate dataLancamento;
    @DecimalMin("0.5")
    @DecimalMax("8.0")
    private Double duracao;
    @Positive
    private Integer ranking;
    @Email
    private String contato;
    @Pattern(regexp = "(\\(?\\d{2}\\)?\\s)?(\\d{4,5}\\-\\d{4})", message = "Indice um telefone válido")
    private String telefoneContato;
    @CPF
    @NotBlank
    private String cpfContato;
    @TituloEleitoral
    @PositiveOrZero
    private String tituloEleitorContato;
    @PositiveOrZero
    private String gravadoraCnpj;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public LocalDate getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(LocalDate dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public Double getDuracao() {
        return duracao;
    }

    public void setDuracao(Double duracao) {
        this.duracao = duracao;
    }

    public Integer getRanking() {
        return ranking;
    }

    public void setRanking(Integer ranking) {
        this.ranking = ranking;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getCpfContato() {
        return cpfContato;
    }

    public void setCpfContato(String cpfContato) {
        this.cpfContato = cpfContato;
    }

    public String getTituloEleitorContato() {
        return tituloEleitorContato;
    }

    public void setTituloEleitorContato(String tituloEleitorContato) {
        this.tituloEleitorContato = tituloEleitorContato;
    }

    public String getGravadoraCnpj() {
        return gravadoraCnpj;
    }

    public void setGravadoraCnpj(String gravadoraCnpj) {
        this.gravadoraCnpj = gravadoraCnpj;
    }
}
