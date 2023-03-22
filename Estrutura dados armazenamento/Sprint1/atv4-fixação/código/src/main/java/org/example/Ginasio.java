package org.example;

import java.util.ArrayList;
import java.util.List;

public class Ginasio {
    private String cidade;
    private String tipo;
    private List<Treinador> treinadores;

    public Ginasio(String cidade, String tipo) {
        this.cidade = cidade;
        this.tipo = tipo;
        treinadores = new ArrayList<>();
    }

    public void adicionarTreinador(Treinador t){
        treinadores.add(t);
    }

    public void removerTreinador(Treinador t){
        treinadores.remove(t);
    }
}
