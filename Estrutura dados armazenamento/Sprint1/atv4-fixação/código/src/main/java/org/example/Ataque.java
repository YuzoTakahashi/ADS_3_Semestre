package org.example;

public class Ataque {
    private String nome;
    private String descricao;
    private int dano;

    public Ataque(String nome, String descricao, int dano) {
        this.nome = nome;
        this.descricao = descricao;
        this.dano = dano;
    }

    @Override
    public String toString() {
        return "Ataque{" +
                "nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dano=" + dano +
                '}';
    }
}
