import java.nio.ByteOrder;

public class Main {
    public static void main(String[] args) {
        int[] vetorSelecao = {5, 1, 8, 7, 2, 9, 10, 6, 3, 8};
        int[] vetorOrganizado = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        Ordenacao.selectionSort(vetorSelecao);
        Ordenacao.selectionSortOtimizado(vetorSelecao);
        Ordenacao.bubbleSort(vetorSelecao);

        System.out.println("O indice do valor é v[" +
                Ordenacao.binarySort(vetorOrganizado, 20) + "]");
    }
}
