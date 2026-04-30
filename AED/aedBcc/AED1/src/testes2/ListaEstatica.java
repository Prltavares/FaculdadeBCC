Package testes2;
public class ListaEstatica<T> {

    // "Utiliza um vetor (array) contíguo na memória... Possui tamanho fixo"
    private T[] elementos; 
    private int tamanho; // Controla quantos itens realmente estão guardados

    @SuppressWarnings("unchecked")
    public ListaEstatica(int capacidadeMaxima) {
        // "Dimensionada com um número máximo predefinido"
        this.elementos = (T[]) new Object[capacidadeMaxima]; 
        this.tamanho = 0;
    }

    // ==========================================
    // INSERÇÃO
    // ==========================================

    // 1. Inserção no FIM: O(1)
    // "Quando é no fim da lista é muito rápido O(1) por conta do índice"
    public void adicionarNoFim(T elemento) {
        garantirCapacidade(); // Verifica se precisa redimensionar antes de inserir

        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    // 2. Inserção no MEIO/INÍCIO: O(n)
    // "Inserir um elemento no meio ou começo exige cópia de dados... o que torna o processo O(n)"
    public void adicionarNoMeio(int posicao, T elemento) {
        if (posicao < 0 || posicao > this.tamanho) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        garantirCapacidade();

        // O(n) na prática: O laço (loop) deslocando todos os vizinhos para a direita para abrir um "buraco".
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }

        this.elementos[posicao] = elemento; // Encaixa o item no buraco aberto
        this.tamanho++;
    }

    // 3. O "Pseudo Redimensionamento": O(n)
    // "A alocação é estática, ou seja, requer um pseudo redimensionamento se a capacidade esgotar"
    private void garantirCapacidade() {
        if (this.tamanho == this.elementos.length) {
            // Cria um novo vetor com o DOBRO do tamanho
            @SuppressWarnings("unchecked")
            T[] novoVetor = (T[]) new Object[this.elementos.length * 2];
            
            // O(n): Copia todo mundo do vetor antigo, um por um, para o novo vetor
            for (int i = 0; i < this.elementos.length; i++) {
                novoVetor[i] = this.elementos[i];
            }
            // A lista passa a usar o novo vetor gigante e o antigo é descartado pelo Java
            this.elementos = novoVetor; 
        }
    }

    // ==========================================
    // REMOÇÃO
    // ==========================================

    // 4. Remoção do FIM: O(1)
    // "Se remover do fim O(1)..."
    public void removerDoFim() {
        if (this.tamanho == 0) return;
        
        // Simplesmente diminuímos o tamanho. O elemento fica lá na memória, 
        // mas é ignorado e será sobrescrito na próxima inserção. Zero deslocamentos!
        this.tamanho--; 
    }

    // 5. Remoção do MEIO/INÍCIO: O(n)
    // "Se remover do meio ou do início vai precisar reposicionar os elementos O(n)"
    public void remover(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida!");
        }

        // O(n) na prática: O laço puxando todos os vizinhos da direita para a esquerda, esmagando o item removido.
        for (int i = posicao; i < this.tamanho - 1; i++) {
            this.elementos[i] = this.elementos[i + 1];
        }
        this.tamanho--;
    }

    // ==========================================
    // BUSCA
    // ==========================================

    // 6. Busca por ÍNDICE (Acesso Randômico): O(1)
    // "Busca por acesso direto por índice é O(1)"
    public T buscarPorIndice(int posicao) {
        if (posicao < 0 || posicao >= this.tamanho) {
            throw new IllegalArgumentException("Posição inválida!");
        }
        // Vai direto no endereço de memória, sem laços de repetição.
        return this.elementos[posicao];
    }

    // 7. Busca por VALOR: O(n)
    // "Busca por valor requer uma varredura no array o que torna O(n)"
    public int buscarPorValor(T elemento) {
        // O(n) na prática: O laço varrendo a lista inteira até achar o item (ou chegar no fim).
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equals(elemento)) {
                return i; // Retorna em qual posição achou o item
            }
        }
        return -1; // Retorna -1 se o item não existir na lista
    }

    // Método auxiliar para os testes
    public int getTamanho() { return this.tamanho; }
    public int getCapacidade() { return this.elementos.length; }
}