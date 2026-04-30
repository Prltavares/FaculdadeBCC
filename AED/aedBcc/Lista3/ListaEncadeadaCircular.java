package ListaEncadeada;

// Define a classe ListaEncadeadaCircular com tipo genérico T
public class ListaEncadeadaCircular<T> {

    // Define a variável de instância que aponta para o primeiro nó da lista
    private NoLista<T> primeiro;

    // Construtor da lista, inicializa a lista vazia
    public ListaEncadeadaCircular() {
        this.primeiro = null;
    }

    // Método getter para obter o primeiro nó da lista
    public NoLista<T> getPrimeiro() {
        return this.primeiro;
    }

    // Método para inserir um novo elemento na lista
    public void inserir(T info) {
        // Cria um novo nó e define sua informação
        NoLista<T> novoNo = new NoLista<T>();
        novoNo.setInfo(info);

        // Se a lista está vazia, o novo nó aponta para si mesmo
        if (estaVazia()) {
            novoNo.setProximo(novoNo);
            this.primeiro = novoNo;
        } else {
            // Caso contrário, encontra o último nó e atualiza os ponteiros
            NoLista<T> ultimo = primeiro;
            while (ultimo.getProximo() != primeiro) {
                ultimo = ultimo.getProximo();
            }
            novoNo.setProximo(primeiro);
            ultimo.setProximo(novoNo);
            this.primeiro = novoNo;
        }
    }

    // Método para verificar se a lista está vazia
    public boolean estaVazia() {
        return primeiro == null;
    }

    // Método para buscar um elemento na lista
    public NoLista<T> buscar(T info) {
        if (estaVazia()) {
            return null;
        }

        // Itera pela lista a partir do primeiro nó
        NoLista<T> no = primeiro;
        do {
            if (no.getInfo().equals(info)) {
                return no;
            }
            no = no.getProximo();
        } while (no != primeiro);

        return null;
    }

    // Método para retirar um elemento da lista
    public void retirar(T info) {
        if (estaVazia()) {
            return;
        }

        NoLista<T> no = primeiro;
        NoLista<T> anterior = null;

        do {
            if (no.getInfo().equals(info)) {
                if (anterior != null) {
                    anterior.setProximo(no.getProximo());
                } else {
                    // Se o nó a ser removido é o primeiro, ajusta o ponteiro do último nó
                    NoLista<T> ultimo = primeiro;
                    while (ultimo.getProximo() != primeiro) {
                        ultimo = ultimo.getProximo();
                    }
                    if (no.getProximo() == primeiro) {
                        primeiro = null;
                    } else {
                        primeiro = no.getProximo();
                        ultimo.setProximo(primeiro);
                    }
                }
                break;
            }
            anterior = no;
            no = no.getProximo();
        } while (no != primeiro);
    }

    // Método para obter o comprimento da lista
    public int obterComprimento() {
        if (estaVazia()) {
            return 0;
        }

        NoLista<T> no = primeiro;
        int tamanho = 0;

        // Conta o número de nós na lista
        do {
            tamanho++;
            no = no.getProximo();
        } while (no != primeiro);

        return tamanho;
    }

    // Método para obter um nó por índice
    public NoLista<T> obterNo(int idx) {
        if (idx < 0 || estaVazia()) {
            throw new IndexOutOfBoundsException();
        }

        NoLista<T> no = primeiro;
        int posicao = 0;

        // Itera até o índice desejado
        do {
            if (posicao == idx) {
                return no;
            }
            posicao++;
            no = no.getProximo();
        } while (no != primeiro);

        throw new IndexOutOfBoundsException();
    }

    // Método para encontrar o primeiro nó duplicado na lista
    public int duplicado() {
        if (estaVazia()) {
            return -1;
        }

        int indice = 0;
        NoLista<T> no1 = primeiro;

        do {
            NoLista<T> no2 = no1.getProximo();
            while (no2 != primeiro) {
                if (no1.getInfo().equals(no2.getInfo())) {
                    return indice;
                }
                no2 = no2.getProximo();
            }
            indice++;
            no1 = no1.getProximo();
        } while (no1 != primeiro);

        return -1;
    }

    // Método para exibir a lista em ordem inversa
    public String exibirInverso() {
        if (estaVazia()) {
            return "";
        }

        NoLista<T> no = primeiro;
        T[] vetor = (T[]) new Object[obterComprimento()];
        int indice = 0;
        String inverso = "";

        // Armazena os elementos da lista em um array
        do {
            vetor[indice] = no.getInfo();
            indice++;
            no = no.getProximo();
        } while (no != primeiro);

        // Constrói a string inversa a partir do array
        for (int i = vetor.length - 1; i >= 0; i--) {
            if (i < vetor.length - 1) {
                inverso += ", ";
            }
            inverso += vetor[i].toString();
        }

        return inverso;
    }

    // Método para liberar a lista
    public void liberar() {
        if (estaVazia()) {
            return;
        }

        NoLista<T> atual = primeiro;
        do {
            NoLista<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual = proximo;
        } while (atual != primeiro);

        primeiro = null;
    }

    // Método para exibir a lista como uma string
    @Override
    public String toString() {
        if (estaVazia()) {
            return "";
        }

        String lista = "";
        NoLista<T> no = primeiro;

        do {
            if (no != primeiro) {
                lista += ", ";
            }
            lista += no.getInfo().toString();
            no = no.getProximo();
        } while (no != primeiro);

        return lista;
    }
}
