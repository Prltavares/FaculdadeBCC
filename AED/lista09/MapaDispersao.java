public class MapaDispersao<T> {

    private ListaEncadeada<NoMapa<T>>[] info;

    @SuppressWarnings("unchecked")
    public MapaDispersao(int tamanho) {
        // Cria o vetor encapsulado com o tamanho fornecido
        info = new ListaEncadeada[tamanho];

        // É vital inicializar uma lista encadeada vazia em cada posição do vetor
        for (int i = 0; i < tamanho; i++) {
            info[i] = new ListaEncadeada<>();
        }
    }

    public int calcularHash(int chave) {
        // Compacta o valor usando o resto da divisão
        return chave % info.length;
    }

    public void inserir(int chave, T dado) {
        int hash = calcularHash(chave);

        NoMapa<T> novoNo = new NoMapa<>();
        novoNo.setChave(chave);
        novoNo.setValor(dado);

        // Armazena na lista encadeada correspondente ao índice (hash)
        info[hash].inserir(novoNo);
    }

    public void remover(int chave) {
        int hash = calcularHash(chave);

        // Cria um nó falso apenas com a chave para usar o método equals na remoção
        NoMapa<T> dummy = new NoMapa<>();
        dummy.setChave(chave);

        info[hash].retirar(dummy);
    }

    public T buscar(int chave) {
        int hash = calcularHash(chave);

        NoMapa<T> dummy = new NoMapa<>();
        dummy.setChave(chave);

        // Busca o nó na lista correspondente
        NoMapa<T> resultado = info[hash].buscar(dummy);

        if (resultado != null) {
            return resultado.getValor(); // Retorna o objeto localizado
        }
        return null;
    }

    public double calcularFatorCarga() {
        int quantidadeElementos = 0;

        // Conta todos os elementos guardados em todas as listas
        for (int i = 0; i < info.length; i++) {
            quantidadeElementos += info[i].getTamanho();
        }

        return (double) quantidadeElementos / info.length;
    }
}