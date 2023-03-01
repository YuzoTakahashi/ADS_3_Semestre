package org.example;

import java.util.ArrayList;
import java.util.List;

public class Treinador extends Personagem{
    private String descricao;

    private List<Pokemon> pokemonList;

    public Treinador(String nome, String genero, String descricao) {
        super(nome, genero);
        this.descricao = descricao;
        this.pokemonList = new ArrayList<>();
    }

    public void adicionarPokemon(Pokemon p){
        pokemonList.add(p);
    }
    public void falar(String fala){
        System.out.println(fala);
    }

    @Override
    public void atacar() {

    }
}
