package org.example;

public class Aluno {

    // Atributos
    private String ra;
    private String nome;
    private String curso;
    private String disciplina;
    private Double media;
    private int qtdFalta;

    // Construtor

    public Aluno(String ra, String nome, String curso, String disciplina, Double media, int qtdFalta) {
        this.ra = ra;
        this.nome = nome;
        this.curso = curso;
        this.disciplina = disciplina;
        this.media = media;
        this.qtdFalta = qtdFalta;
    }

    // toString()

    @Override
    public String toString() {
        return "Aluno{" +
                "ra='" + ra + '\'' +
                ", nome='" + nome + '\'' +
                ", curso='" + curso + '\'' +
                ", disciplina='" + disciplina + '\'' +
                ", media=" + media +
                ", qtdFalta=" + qtdFalta +
                '}';
    }

    // Getters e Setters

    public String getRa() {
        return ra;
    }

    public void setRa(String ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public Double getMedia() {
        return media;
    }

    public void setMedia(Double media) {
        this.media = media;
    }

    public int getQtdFalta() {
        return qtdFalta;
    }

    public void setQtdFalta(int qtdFalta) {
        this.qtdFalta = qtdFalta;
    }
}
