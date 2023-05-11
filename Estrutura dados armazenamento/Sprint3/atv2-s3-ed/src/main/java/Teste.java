public class Teste {
    public static void separaPositivoNegativoEmOrder(int[] vetor) {
        FilaObj<Integer> filaPositivo = new FilaObj(5);
        FilaObj<Integer> filaNegativo = new FilaObj(4);
        int countPositivo = 0;
        int countNegativo = 0;
        for (Integer i : vetor) {
            if (i >= 0) {
                countPositivo++;
                filaPositivo.insert(i);
            }else{
                countNegativo++;
                filaNegativo.insert(i);
            }
        }
        for (int i = 0; i < countPositivo; i++) {
            System.out.print(filaPositivo.poll() + " ");
        }
        for (int i = 0; i < countNegativo; i++) {
            System.out.print(filaNegativo.poll() + " ");
        }
    }

    public static void separaPositivoNegativoOrdemDiferente(int[] vetor){
        PilhaObj<Integer> filaPositivo = new PilhaObj(5);
        PilhaObj<Integer> filaNegativo = new PilhaObj(4);
        int countPositivo = 0;
        int countNegativo = 0;
        for (Integer i : vetor) {
            if (i >= 0) {
                countPositivo++;
                filaPositivo.push(i);
            }else{
                countNegativo++;
                filaNegativo.push(i);
            }
        }
        for (int i = 0; i < countPositivo; i++) {
            System.out.print(filaPositivo.pop() + " ");
        }
        for (int i = 0; i < countNegativo; i++) {
            System.out.print(filaNegativo.pop() + " ");
        }
    }

    public static void main(String[] args) {
        int[] vetor = {2, 7,-3,-50,45,-4,30,-21,38};
        System.out.println("Utilizando fila: ");
        separaPositivoNegativoEmOrder(vetor);
        System.out.println("\n");
        System.out.println("Utilizando pilha: ");
        separaPositivoNegativoOrdemDiferente(vetor);
    }
}
