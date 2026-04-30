package ArvoreBináriaDeBusca;

/**
 * @autor Larissa Zózimo Antunes
 */
public abstract class ArvoreBinariaAbstract<T> {

    // Nó raiz da árvore
    private NoArvoreBinaria<T> raiz;

    // Construtor que inicializa a árvore vazia
    public ArvoreBinariaAbstract() {
        // Inicializa a raiz como null, indicando que a árvore está vazia
        this.raiz = null;
    }

    // Método para definir a raiz da árvore
    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        // Define o nó dado como a raiz da árvore
        this.raiz = raiz;
    }

    // Método para obter a raiz da árvore
    public NoArvoreBinaria<T> getRaiz() {
        // Retorna o nó raiz da árvore
        return this.raiz;
    }

    // Método para verificar se a árvore está vazia
    public boolean estaVazia() {
        // Retorna true se a raiz for null, indicando que a árvore está vazia
        return (this.raiz == null);
    }

    // Método para verificar se a árvore contém um determinado dado
    public boolean pertence(T info) {
        // Usa o método buscar (implementado nas subclasses) para verificar se o dado está na árvore
        // Retorna true se o dado for encontrado, false caso contrário
        return buscar(info) != null;
    }

    // Método para buscar um dado na árvore
    public abstract NoArvoreBinaria<T> buscar(T info);

    // Método para retornar a representação textual de uma sub-árvore, dado seu nó raiz
    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            // Se o nó é null, retorna a string "<>"
            return "<>";
        } else {
            // Caso contrário, retorna a string com a informação do nó e as representações textuais das sub-árvores esquerda e direita
            return "<" + 
                    no.getInfo() + 
                    arvorePre(no.getEsquerda()) +
                    arvorePre(no.getDireita()) + 
                    ">";
        }
    }

    // Sobrescreve o método toString para retornar a representação textual da árvore
    @Override
    public String toString() {
        // Retorna a representação textual da árvore a partir da raiz
        return arvorePre(this.raiz);
    }

    // Método para calcular a quantidade de nós que existem na árvore
    public int contarNos() {
        // Chama o método auxiliar recursivo para contar os nós a partir da raiz
        return contarNos(this.raiz);
    }

    // Método auxiliar recursivo para contar os nós que existem na árvore
    private int contarNos(NoArvoreBinaria<T> no) {
        if (no == null) {
            // Se o nó é null, retorna 0 (o que significa que não há nós nesta sub-árvore)
            return 0;
        } else {
            // Caso contrário, retorna 1 (para o nó atual) mais a soma dos nós nas sub-árvores esquerda e direita
            return 1 + contarNos(no.getEsquerda()) + contarNos(no.getDireita());
        }
    }
}
