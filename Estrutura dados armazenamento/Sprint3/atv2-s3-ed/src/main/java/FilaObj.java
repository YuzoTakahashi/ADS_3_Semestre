public class FilaObj<T> {
    private int tamanho;
    private T[] fila;

    public FilaObj(int capacidade) {
        fila = (T[]) new Object[capacidade];
        tamanho = 0;
    }
    public boolean isEmpty() {
        return tamanho == 0;
    }

    public boolean isFull() {
        return tamanho == fila.length;
    }

    public void insert(T info) {
        if (!this.isFull()) {
            fila[tamanho++] = info;
        } else {
            throw new IllegalStateException("Fila cheia!");
        }
    }

    public T peek() {
        return fila[0];
    }


    public T poll() {
        T aux = fila[0];
        for (int i = 0; i < tamanho - 1; i++) {
            if (i == tamanho - 1) {
                fila[i] = null;
            } else {
                fila[i] = fila[i + 1];
            }
        }
        tamanho--;
        return aux;
    }

    public void exibe() {
        if(!this.isEmpty()){
            for (int i = 0; i < tamanho; i++) {
                System.out.println(fila[i] + " ");
            }
        }else{
            throw new IllegalStateException("Fila vazia!");
        }
    }

    public int getTamanho() {
        return tamanho;
    }
}
