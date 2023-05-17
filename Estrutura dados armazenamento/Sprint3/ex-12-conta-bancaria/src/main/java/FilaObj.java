public class FilaObj<T> {

    // Atributos
    private int tamanho;
    private T[] fila;

    // Construtor
    public FilaObj(int capacidade) {
        tamanho = 0;
        fila = (T[]) new Object[capacidade];
    }

    // Métodos

    // Retorna true se a fila está vazia e false coso contrário
    public boolean isEmpty() {
        return tamanho == 0;
    }

    // Retorna true se a fila está cheia e false caso contrário
    public boolean isFull() {
        return tamanho == fila.length;
    }

    // Se a fila não estiver cheia, insere info na fila
    // Se a fila estiver cheia, deve lançar IllegalStateException
    public void insert(T info) {
        if (this.isFull())
            throw new IllegalStateException("Fila está cheia");

        fila[tamanho++] = info;
    }

    // Retorna o primeiro da fila
    public T peek() {
        return fila[0];
    }

    // Remove e retorna o primerio elemento da fila
    // Antes de retorna, se a fila não estiver vazia, deve fazer a fila "andar"
    public T poll() {
        T aux = fila[0];
        for (int i = 0; i < tamanho -1; i++) {
            if (i == tamanho - 1) {
                fila[i] = null;
            } else {
                fila[i] = fila[i+ 1];

            }
        }
        tamanho--;
        return aux;
    }

    // Exibe os elementos da fila
    public void exibe() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(fila[i] + " ");
        }
    }

    // Retorna o vetor fila
    public T[] getFila() {
        return this.fila;
    }
}