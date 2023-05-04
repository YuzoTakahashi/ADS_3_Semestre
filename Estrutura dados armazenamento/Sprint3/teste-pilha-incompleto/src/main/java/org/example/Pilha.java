package org.example;

public class Pilha {

    // 01) Atributos
    private int[] pilha;
    private int topo;

    // 02) Construtor
    public Pilha(int capacidade) {
        pilha = new int[capacidade];
        topo = -1;
    }

    // 03) MÃ©todo isEmpty
    public Boolean isEmpty() {
        if(topo == -1) {
            return true;
        }
        else{
            return false;
        }
    }

    // 04) MÃ©todo isFull
    public Boolean isFull() {
        if(topo == pilha.length -1){
            return true;
        }
        else{
            return false;
        }
    }

    // 05) MÃ©todo push
    public void push(int info) {
        if(this.isFull()){
            throw new IllegalStateException("Pilha cheia!");
        }
        else{
            pilha[++topo] = info;
        }
    }

    // 06) MÃ©todo pop
    public int pop() {
        return pilha[topo--];
    }

    // 07) MÃ©todo peek
    public int peek() {
        if (this.isEmpty()) {
            return -1;
        } else {
            return pilha[topo];
        }
    }

    public Boolean isPalindromo(){
        Boolean isPalindromo = false;
        for (int i = 0; i < pilha.length; i++) {
            if(pilha[i] == this.pop()){
                isPalindromo = true;
            }
            else{
                isPalindromo = false;
            }
        }
        return isPalindromo;
    }

    public void converteParaBinario(int decimal){
        for (int i = 0; i < 9; i++) {

        }
    }

    // 08) MÃ©todo exibe
    public void exibe() {
        for (int i = 0; i < pilha.length; i++) {
            System.out.println(pilha[i]);
        }
    }


    //Getters & Setters (manter)
    public int getTopo() {
        return topo;
    }
}