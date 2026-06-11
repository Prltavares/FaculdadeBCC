package estruturas;

/**
 * Implementação manual de Fila (Queue) genérica usando lista encadeada.
 * Segue o princípio FIFO (First In, First Out).
 * NÃO utiliza nenhuma coleção pronta do Java.
 *
 * @param <T> tipo dos elementos armazenados
 */
public class Fila<T> {

    private No<T> inicio;   // primeiro da fila (próximo a ser removido)
    private No<T> fim;      // último da fila (onde novas inserções ocorrem)
    private int tamanho;

    /** Cria uma fila vazia. */
    public Fila() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    /**
     * Insere um elemento no final da fila (enqueue).
     *
     * @param dado elemento a ser inserido
     */
    public void enqueue(T dado) {
        No<T> novoNo = new No<>(dado);
        if (vazia()) {
            inicio = novoNo;
            fim = novoNo;
        } else {
            fim.setProximo(novoNo);
            fim = novoNo;
        }
        tamanho++;
    }

    /**
     * Remove e retorna o elemento do início da fila (dequeue).
     *
     * @return elemento removido
     * @throws RuntimeException se a fila estiver vazia
     */
    public T dequeue() {
        if (vazia()) {
            throw new RuntimeException("Fila vazia: impossível remover elemento.");
        }
        T dado = inicio.getDado();
        inicio = inicio.getProximo();
        if (inicio == null) {
            fim = null;  // fila ficou vazia
        }
        tamanho--;
        return dado;
    }

    /**
     * Retorna o elemento do início sem removê-lo (peek).
     *
     * @return primeiro elemento da fila
     * @throws RuntimeException se a fila estiver vazia
     */
    public T peek() {
        if (vazia()) {
            throw new RuntimeException("Fila vazia: impossível consultar elemento.");
        }
        return inicio.getDado();
    }

    /** @return true se a fila não contiver elementos */
    public boolean vazia() {
        return tamanho == 0;
    }

    /** @return quantidade de elementos na fila */
    public int tamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        if (vazia()) return "[Fila vazia]";
        StringBuilder sb = new StringBuilder("[Frente -> ");
        No<T> atual = inicio;
        while (atual != null) {
            sb.append(atual.getDado());
            if (atual.getProximo() != null) sb.append(" | ");
            atual = atual.getProximo();
        }
        sb.append(" <- Fim]");
        return sb.toString();
    }
}
