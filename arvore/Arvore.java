public class Arvore<T> {
    private NoArvore<T> raiz;

    // Inicializa a árvore com nenhum nó
    public Arvore() {
        this.raiz = null;
    }

    // Retorna a raiz da árvore [cite: 198]
    public NoArvore<T> getRaiz() {
        return this.raiz;
    }

    // Torna o nó recebido como a nova raiz [cite: 197]
    public void setRaiz(NoArvore<T> raiz) {
        this.raiz = raiz;
    }

    // Retorna a representação textual da árvore [cite: 199]
    @Override
    public String toString() {
        if (this.raiz == null) return "";
        return obterRepresentacaoTextual(this.raiz);
    }

    // Método recursivo para a representação textual [cite: 200]
    private String obterRepresentacaoTextual(NoArvore<T> no) {
        if (no == null) return "";

        StringBuilder sb = new StringBuilder();
        sb.append("<").append(no.getInfo());

        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            sb.append(obterRepresentacaoTextual(filho));
            filho = filho.getProximo();
        }

        sb.append(">");
        return sb.toString();
    }

    // Retorna se a árvore contém um objeto cuja chave de busca seja idêntica [cite: 201]
    public boolean pertence(T info) {
        if (this.raiz == null) return false;
        return pertence(this.raiz, info);
    }

    // Método recursivo auxiliar de busca [cite: 202]
    private boolean pertence(NoArvore<T> no, T info) {
        if (no == null) return false;

        if (no.getInfo().equals(info)) {
            return true;
        }

        NoArvore<T> filho = no.getPrimeiro();
        while (filho != null) {
            if (pertence(filho, info)) {
                return true;
            }
            filho = filho.getProximo();
        }

        return false;
    }

    // Retorna a quantidade de dados armazenados na árvore [cite: 203]
    public int contarNos() {
        if (this.raiz == null) return 0;
        return contarNos(this.raiz);
    }

    // Método recursivo de contagem
    private int contarNos(NoArvore<T> no) {
        if (no == null) return 0;

        int contagem = 1; // Conta o nó atual
        NoArvore<T> filho = no.getPrimeiro();

        while (filho != null) {
            contagem += contarNos(filho); // Soma os nós das sub-árvores
            filho = filho.getProximo();
        }

        return contagem;
    }
}