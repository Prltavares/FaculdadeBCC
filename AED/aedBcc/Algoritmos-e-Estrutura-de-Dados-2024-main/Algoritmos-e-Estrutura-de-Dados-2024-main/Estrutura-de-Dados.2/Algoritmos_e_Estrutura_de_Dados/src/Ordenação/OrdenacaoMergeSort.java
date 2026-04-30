package Ordenação;

/**
 * @autor Larissa Zózimo Antunes
 */
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    // Array que armazena os elementos que serão ordenados
    public T[] info;

    // Método que inicia a ordenação
    @Override
    public void ordenar() {
        // Obtém o array de elementos a partir da classe base
        info = super.getInfo();
        // Chama o método de ordenação com a posição inicial e final do array
        mergeSorte(0, info.length - 1);
    }

    // Método recursivo para dividir o array e ordenar as partes
    private void mergeSorte(int inicio, int fim) {
        if (inicio < fim) {
            // Calcula o meio do array
            int meio = (inicio + fim) / 2;
            // Ordena a primeira metade
            mergeSorte(inicio, meio);
            // Ordena a segunda metade
            mergeSorte(meio + 1, fim);
            // Mescla as duas metades ordenadas
            merge(inicio, meio, fim);
        }
    }

    // Método que mescla dois subarrays ordenados
    private void merge(int inicio, int meio, int fim) {
        // Cria e preenche o array com os dados que estão à esquerda
        int tamEsq = meio - inicio + 1;
        T[] esquerda = (T[]) new Comparable[tamEsq];
        for (int i = 0; i <= tamEsq - 1; i++) {
            esquerda[i] = info[inicio + i];
        }

        // Cria e preenche o array com os dados que estão à direita
        int tamDir = fim - meio;
        T[] direita = (T[]) new Comparable[tamDir];
        for (int i = 0; i <= tamDir - 1; i++) {
            direita[i] = info[meio + 1 + i];
        }

        // Índices para percorrer os arrays esquerdo e direito
        int cEsq = 0;
        int cDir = 0;
        int i;

        // Mescla os arrays esquerdo e direito de volta ao array original
        for (i = inicio; i <= fim; i++) {
            if (cEsq < tamEsq && cDir < tamDir) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }
        }

        // Copia qualquer elemento restante do array esquerdo
        while (cEsq < tamEsq) {
            info[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }

        // Copia qualquer elemento restante do array direito
        while (cDir < tamDir) {
            info[i] = direita[cDir];
            cDir++;
            i++;
        }
    }
}
