package estruturas;

/**
 * Implementação manual de Pilha (Stack) genérica usando lista encadeada.
 * Segue o princípio LIFO (Last In, First Out).
 * NÃO utiliza nenhuma coleção pronta do Java.
 *
 * @param <T> tipo dos elementos armazenados
 */
public class Pilha<T> {

    private No<T> topo;     // referência para o topo da pilha
    private int tamanho;

    /** Cria uma pilha vazia. */
    public Pilha() {
        this.topo = null;
        this.tamanho = 0;
    }

    /**
     * Insere um elemento no topo da pilha (push).
     *
     * @param dado elemento a ser empilhado
     */
    public void push(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.setProximo(topo);
        topo = novoNo;
        tamanho++;
    }

    /**
     * Remove e retorna o elemento do topo da pilha (pop).
     *
     * @return elemento removido
     * @throws RuntimeException se a pilha estiver vazia
     */
    public T pop() {
        if (vazia()) {
            throw new RuntimeException("Pilha vazia: impossível remover elemento.");
        }
        T dado = topo.getDado();
        topo = topo.getProximo();
        tamanho--;
        return dado;
    }

    /**
     * Retorna o elemento do topo sem removê-lo (peek).
     *
     * @return elemento do topo
     * @throws RuntimeException se a pilha estiver vazia
     */
    public T peek() {
        if (vazia()) {
            throw new RuntimeException("Pilha vazia: impossível consultar elemento.");
        }
        return topo.getDado();
    }

    /** @return true se a pilha não contiver elementos */
    public boolean vazia() {
        return tamanho == 0;
    }

    /** @return quantidade de elementos na pilha */
    public int tamanho() {
        return tamanho;
    }

    /**
     * Retorna todos os elementos da pilha em um array (do topo para a base).
     * Útil para exibir o histórico de atendimentos de um guichê.
     *
     * @return array com todos os elementos, ou array vazio se pilha vazia
     */
    public Object[] toArray() {
        Object[] arr = new Object[tamanho];
        copiarElementos(arr);
        return arr;
    }

    public T[] toArray(T[] destino) {
        if (destino.length < tamanho) {
            throw new IllegalArgumentException("Array destino menor que o tamanho da pilha.");
        }
        copiarElementos(destino);
        if (destino.length > tamanho) {
            destino[tamanho] = null;
        }
        return destino;
    }

    private void copiarElementos(Object[] destino) {
        No<T> atual = topo;
        for (int i = 0; i < tamanho; i++) {
            destino[i] = atual.getDado();
            atual = atual.getProximo();
        }
    }

    @Override
    public String toString() {
        if (vazia()) return "[Pilha vazia]";
        StringBuilder sb = new StringBuilder("[Topo -> ");
        No<T> atual = topo;
        while (atual != null) {
            sb.append(atual.getDado());
            if (atual.getProximo() != null) sb.append(" | ");
            atual = atual.getProximo();
        }
        sb.append("]");
        return sb.toString();
    }
}
