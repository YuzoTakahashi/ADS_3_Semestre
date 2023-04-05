package schoo.sptech.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
@Entity

public class Filme {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String nome;
    @NotBlank
    private String diretor;
    @Past
    private LocalDate data_lancamento;
    @Positive
    private double custo_producao;
    @NotNull
    private boolean indicacao_oscar;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }

    public LocalDate getData_lancamento() {
        return data_lancamento;
    }

    public void setData_lancamento(LocalDate data_lancamento) {
        this.data_lancamento = data_lancamento;
    }

    public double getCusto_producao() {
        return custo_producao;
    }

    public void setCusto_producao(double custo_producao) {
        this.custo_producao = custo_producao;
    }

    public boolean isIndicacao_oscar() {
        return indicacao_oscar;
    }

    public void setIndicacao_oscar(boolean indicacao_oscar) {
        this.indicacao_oscar = indicacao_oscar;
    }
}
