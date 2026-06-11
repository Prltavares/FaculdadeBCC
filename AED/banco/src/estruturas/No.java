package estruturas;

/**
 * Nó genérico utilizado pelas estruturas de dados encadeadas (Fila e Pilha).
 * Armazena um dado do tipo T e uma referência para o próximo nó.
 *
 * @param <T> tipo do dado armazenado
 */
public class No<T> {

    private T dado;
    private No<T> proximo;

    /**
     * Cria um nó com o dado fornecido e sem próximo nó.
     *
     * @param dado valor a armazenar neste nó
     */
    public No(T dado) {
        this.dado = dado;
        this.proximo = null;
    }

    public T getDado()                { return dado; }
    public No<T> getProximo()         { return proximo; }
    public void setProximo(No<T> no)  { this.proximo = no; }
}
