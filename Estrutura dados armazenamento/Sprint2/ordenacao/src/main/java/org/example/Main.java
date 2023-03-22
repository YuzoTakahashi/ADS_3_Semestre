package org.example;

public class Main {

    public static void SelectionSort(int[] v) {
        int aux;
        int totalTroca = 0;
        int totalComp = 0;
        for (int i = 0; i < v.length - 1; i++) {
            for (int j = i + 1; j < v.length; j++) {
                totalComp++;
                if (v[i] > v[j]) {
                    aux = v[i];
                    v[i] = v[j];
                    v[j] = aux;
                    totalTroca++;
                }
            }
        }
        for (int vetorNum : v) {
            System.out.println(vetorNum);
        }
        System.out.println("Total de comparações: " + totalComp);

        System.out.println("Total de troca: " + totalTroca);
    }

    public static void main(String[] args) {
        int[] vetor = new int[]{4, 7, 5, 2, 8, 1, 6, 3};

        SelectionSort(vetor);
    }
}