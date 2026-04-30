package Ordenação;

/**
 * Classe que implementa o algoritmo de ordenação QuickSort.
 * @autor Larissa Zózimo Antunes
 * 
 */
public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    // Array que armazena os elementos que serão ordenados
    public T[] info;

    // Método que inicia a ordenação
    @Override
    public void ordenar() {
        // Obtém o array de elementos a partir da classe base
        info = super.getInfo();
        // Chama o método de ordenação QuickSort com a posição inicial e final do array
        quickSort(0, info.length - 1);
    }

    // Método recursivo para dividir e ordenar o array usando QuickSort
    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            // Particiona o array e obtém o índice do pivô
            int idxPivo = particionar(inicio, fim);
            // Ordena a primeira metade
            quickSort(inicio, idxPivo - 1);
            // Ordena a segunda metade
            quickSort(idxPivo + 1, fim);
        }
    }

    // Método que particiona o array e retorna a posição final do pivô
    private int particionar(int inicio, int fim) {
        int a = inicio; // Índice que avança da esquerda para a direita
        int b = fim + 1; // Índice que avança da direita para a esquerda
        T pivo = info[inicio]; // Escolhe o primeiro elemento como pivô

        while (true) {
            // Procura valor maior que o pivô
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            // Procura valor menor que o pivô
            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            // Se os índices se cruzarem, a partição está completa
            if (a >= b) {
                break;
            }

            // Troca os elementos nas posições a e b
            trocar(a, b);
        }

        // Coloca o pivô na posição correta
        trocar(b, inicio);
        return b; // Retorna a posição do pivô
    }
}
