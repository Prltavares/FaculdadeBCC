public class NoArvoreBinaria<T> {
    private T info; //
    private NoArvoreBinaria<T> esquerda; //[cite: 2]
    private NoArvoreBinaria<T> direita; //[cite: 2]

    public NoArvoreBinaria(T info) { //[cite: 2]
        this.info = info;
        this.esquerda = null;
        this.direita = null;
    }

    public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) { //[cite: 2]
        this.info = info;
        this.esquerda = esq;
        this.direita = dir;
    }

    public void setInfo(T info) { this.info = info; } //[cite: 2]
    public T getInfo() { return info; } //[cite: 2]

    public void setEsquerda(NoArvoreBinaria<T> esquerda) { this.esquerda = esquerda; } //[cite: 2]
    public NoArvoreBinaria<T> getEsquerda() { return esquerda; } //[cite: 2]

    public void setDireita(NoArvoreBinaria<T> direita) { this.direita = direita; } //[cite: 2]
    public NoArvoreBinaria<T> getDireita() { return direita; } //[cite: 2]
}