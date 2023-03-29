public class Ordenacao {

    public static void selectionSort(int[] v) {
        int totalComparacao = 0;
        int totalTroca = 0;

        for (int i = 0; i < v.length; i++) {
            for (int l = i + 1; l < v.length; l++) {
                totalComparacao++;
                if (v[i] > v[l]) {
                    totalTroca++;
                    int auxiliar = v[l];
                    v[l] = v[i];
                    v[i] = auxiliar;
                }
            }
        }
        System.out.println("Selection Sort: ");
        System.out.println("Ordem crescente: ");
        for (var item : v) {
            System.out.print(item + "\n");
        }

        System.out.println("Total de comprações: " + totalComparacao);
        System.out.println("Total de trocas: " + totalTroca);
        System.out.println("=".repeat(20));
    }

    public static void selectionSortOtimizado(int[] v) {
        int totalComparacao = 0;
        int totalTroca = 0;

        for (int i = 0; i < v.length; i++) {
            int indiceMenor = i;
            for (int l = i + 1; l < v.length; l++) {
                totalComparacao++;
                if (v[l] < v[indiceMenor]) {
                    totalTroca++;
                    indiceMenor = l;
                }
            }
            var aux = v[i];
            v[i] = v[indiceMenor];
            v[indiceMenor] = aux;
        }


        System.out.println("Selection Sort Otimizado: ");
        System.out.println("Ordem crescente: ");
        for (var item : v) {
            System.out.print(item + "  ");
        }

        System.out.println();
        System.out.println("Total de comprações foram: " + totalComparacao);
        System.out.println("Total de trocas foram: " + totalTroca);
        System.out.println("=".repeat(20));
    }

    public static void bubbleSort(int[] v) {
        int totalComparacao = 0;
        int totalTroca = 0;

        for (int i = 0; i < v.length; i++) {
            for (int l = 1; l < v.length - i; l++) {
                totalComparacao++;
                System.out.println(v[l] + " " + v[l - 1]);

                if (v[l] < v[l - 1]) {
                    totalTroca++;
                    var aux = v[l];
                    v[l] = v[l - 1];
                    v[l - 1] = aux;
                }
            }

        }

        System.out.println("Bubble Sort: ");
        System.out.println("Ordem crescente: ");
        for (var item : v) {
            System.out.print(item + "  ");
        }
        System.out.println();
        System.out.println("Total de comprações: " + totalComparacao);
        System.out.println("Total de trocas: " + totalTroca);
        System.out.println("=".repeat(20));
    }

    public static int binarySort(int[] v, int valor) {
        int inicio = 0;
        int fim = v.length - 1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            if (v[meio] == valor) {
                return meio;
            } else if (valor > v[meio]) {
                inicio = meio + 1;

            } else {
                fim = meio - 1;
            }
        }
        return 0;
    }
}
