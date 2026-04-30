package testes3;

public class ListaEncadeada<T> {

    // "a lista sabe quem é o primeiro nó..."
    private No<T> inicio; 
    
    // "...O tamanho é flexível: a estrutura cresce à medida que os elementos são inseridos"
    private int tamanho; 

    public ListaEncadeada() {
        this.inicio = null; // A lista nasce vazia
        this.tamanho = 0;
    }

    // ==========================================
    // INSERÇÃO NO INÍCIO: O(1)
    // ==========================================
    // "Se aloca o ponteiro do início para o novo elemento, sendo assim imediata O(1)..."
    public void adicionarNoInicio(T elemento) {
        No<T> novoNo = new No<>(elemento);
        
        // "...ajustando apenas o apontamento do primeiro nó para o novo elemento"
        // O novo nó aponta para quem era o antigo primeiro
        novoNo.proximo = this.inicio;
        
        // "enquanto o próximo passa a apontar o antigo primeiro"
        // O Início da lista passa a ser o novo nó
        this.inicio = novoNo;
        
        this.tamanho++;
    }

    

    // ==========================================
    // INSERÇÃO NO FIM: O(n)
    // ==========================================
    // "ATENÇÃO: se quiser inserir no meio ou no fim (se não tiver um ponteiro para o último nó)..."
    // "...você vai precisar percorrer todos os elementos até a posição... processo O(n)"
    public void adicionarNoFim(T elemento) {
        if (this.inicio == null) {
            adicionarNoInicio(elemento);
            return;
        }

        No<T> novoNo = new No<>(elemento);
        No<T> atual = this.inicio;

        // O laço (loop) percorrendo a lista até achar o último nó (que aponta para null)
        while (atual.proximo != null) {
            atual = atual.proximo;
        }
        
        // Achou o último! Agora ajusta a referência dele para apontar para o novo nó
        atual.proximo = novoNo;
        this.tamanho++;
    }

    // ==========================================
    // REMOÇÃO DO INÍCIO: O(1)
    // ==========================================
    // "Para remover o primeiro é imediato pois é o primeiro nó O(1)"
    public void removerDoInicio() {
        if (this.inicio == null) return; // Lista vazia, não faz nada
        
        // A remoção em si é rápida: basta fazer o 'inicio' pular o primeiro nó e apontar para o segundo.
        this.inicio = this.inicio.proximo; 
        this.tamanho--;
    }

    // ==========================================
    // BUSCA / VARREDURA: O(n)
    // ==========================================
    // "Desvantagens: Não permite acesso randômico."
    // "Para chegar a um elemento no meio, é obrigatório percorrer a lista a partir do primeiro nó O(n)."
    public No<T> buscarPorPosicao(int posicaoDesejada) {
        if (posicaoDesejada < 0 || posicaoDesejada >= this.tamanho) {
            return null; 
        }

        No<T> atual = this.inicio; // Começa obrigatoriamente do primeiro
        
        // "Sempre requer varredura na lista (loop)"
        for (int i = 0; i < posicaoDesejada; i++) {
            atual = atual.proximo; // Pula de nó em nó usando as referências
        }
        
        return atual; // Retorna o nó encontrado
    }

    

    // Método extra apenas para visualizarmos a lista no console
    public void imprimirLista() {
        No<T> atual = this.inicio;
        System.out.print("Estado da Memória: ");
        // "...que sabe quem é o segundo nó, que por sua vez sabe quem é o terceiro até o último que é marcado como null"
        while (atual != null) {
            System.out.print("[" + atual.elemento + "] -> ");
            atual = atual.proximo;
        }
        System.out.println("null");
    }
}