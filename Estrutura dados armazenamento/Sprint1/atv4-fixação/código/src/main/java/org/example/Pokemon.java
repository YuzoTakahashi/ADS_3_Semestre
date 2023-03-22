package org.example;

import java.util.ArrayList;
import java.util.List;

public class Pokemon extends Personagem{
    private String tipo;
    private double forca;

    private List<Ataque> ataques;

    public Pokemon(String nome, String genero, String tipo, double forca) {
        super(nome, genero);
        this.tipo = tipo;
        this.forca = forca;
        this.ataques = new ArrayList<>();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getForca() {
        return forca;
    }

    public void setForca(double forca) {
        this.forca = forca;
    }

    public void adicionarAtaque(Ataque a){
        ataques.add(a);
    }

    public void removerAtaque(Ataque a){
        ataques.remove(a);
    }

    public void evoluir(Pokemon p, String nomeEvolucao){
        p.setNome(nomeEvolucao);
        System.out.println("Pokemon evoluído com sucesso");
    }


    @Override
    public void atacar() {

    }
}
