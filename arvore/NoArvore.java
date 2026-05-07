public class NoArvore<T> {
    private T info;
    private NoArvore<T> primeiro;
    private NoArvore<T> proximo;

    // O construtor deve inicializar um nó de árvore com o dado fornecido [cite: 205]
    public NoArvore(T info) {
        this.info = info;
        this.primeiro = null;
        this.proximo = null;
    }

    // Recebe a raiz de uma sub-árvore e estabelece que é filha do nó corrente
    public void inserirFilho(NoArvore<T> sa) {
        if (this.primeiro == null) {
            this.primeiro = sa;
        } else {
            // Se já tem primeiro filho, vai até o último irmão para inserir no final
            NoArvore<T> atual = this.primeiro;
            while (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
            atual.setProximo(sa);
        }
    }

    public void setInfo(T info) { this.info = info; }
    public T getInfo() { return this.info; }

    public NoArvore<T> getPrimeiro() { return this.primeiro; }
    public void setPrimeiro(NoArvore<T> no) { this.primeiro = no; }

    public NoArvore<T> getProximo() { return this.proximo; }
    public void setProximo(NoArvore<T> no) { this.proximo = no; }
}