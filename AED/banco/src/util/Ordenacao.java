package util;

import modelo.RegistroAtendimento;

/**
 * Implementações manuais de algoritmos de ordenação sobre arrays de RegistroAtendimento.
 * Fornece MergeSort e QuickSort para ordenar por diferentes critérios.
 * NÃO utiliza nenhuma classe de Collections ou Arrays.sort do Java.
 */
public class Ordenacao {

    // ═══════════════════════════════════════════════════════════════════════════
    // MERGESORT — estável, O(n log n) garantido
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Ordena o array de atendimentos em ordem crescente de tempo de espera
     * usando MergeSort (algoritmo estável).
     *
     * @param arr   array a ser ordenado
     * @param inicio índice inicial (inclusivo)
     * @param fim    índice final (inclusivo)
     */
    public static void mergeSortPorEspera(RegistroAtendimento[] arr, int inicio, int fim) {
        if (inicio >= fim) return;                  // caso base: 1 elemento

        int meio = (inicio + fim) / 2;
        mergeSortPorEspera(arr, inicio, meio);      // ordena metade esquerda
        mergeSortPorEspera(arr, meio + 1, fim);     // ordena metade direita
        mergeEspera(arr, inicio, meio, fim);        // combina as duas metades
    }

    /** Combina duas sub-arrays ordenadas por tempo de espera. */
    private static void mergeEspera(RegistroAtendimento[] arr,
                                    int inicio, int meio, int fim) {
        int tamEsq = meio - inicio + 1;
        int tamDir = fim - meio;

        // Arrays auxiliares temporários
        RegistroAtendimento[] esq = new RegistroAtendimento[tamEsq];
        RegistroAtendimento[] dir = new RegistroAtendimento[tamDir];

        for (int i = 0; i < tamEsq; i++) esq[i] = arr[inicio + i];
        for (int j = 0; j < tamDir; j++) dir[j] = arr[meio + 1 + j];

        int i = 0, j = 0, k = inicio;
        while (i < tamEsq && j < tamDir) {
            // Ordena crescente por tempo de espera
            if (esq[i].getTempoEspera() <= dir[j].getTempoEspera()) {
                arr[k++] = esq[i++];
            } else {
                arr[k++] = dir[j++];
            }
        }
        while (i < tamEsq) arr[k++] = esq[i++];
        while (j < tamDir) arr[k++] = dir[j++];
    }

    // ═══════════════════════════════════════════════════════════════════════════
    // QUICKSORT — in-place, O(n log n) médio
    // ═══════════════════════════════════════════════════════════════════════════

    /**
     * Ordena o array de atendimentos em ordem cronológica de horário de início
     * de atendimento usando QuickSort.
     *
     * @param arr    array a ser ordenado
     * @param inicio índice inicial (inclusivo)
     * @param fim    índice final (inclusivo)
     */
    public static void quickSortPorHorario(RegistroAtendimento[] arr, int inicio, int fim) {
        if (inicio >= fim) return;                          // caso base

        int indicePivo = particionarPorHorario(arr, inicio, fim);
        quickSortPorHorario(arr, inicio, indicePivo - 1);  // lado esquerdo
        quickSortPorHorario(arr, indicePivo + 1, fim);     // lado direito
    }

    /**
     * Partição do QuickSort usando o último elemento como pivô.
     * Rearranja o array de modo que elementos menores que o pivô fiquem à
     * esquerda e maiores à direita.
     *
     * @return índice final do pivô
     */
    private static int particionarPorHorario(RegistroAtendimento[] arr,
                                             int inicio, int fim) {
        // Pivô: horário de início de atendimento do último elemento
        int valorPivo = arr[fim].getHorarioInicioAtendimento();
        int i = inicio - 1;                     // índice do menor elemento

        for (int j = inicio; j < fim; j++) {
            if (arr[j].getHorarioInicioAtendimento() <= valorPivo) {
                i++;
                trocar(arr, i, j);
            }
        }
        trocar(arr, i + 1, fim);                // coloca pivô na posição correta
        return i + 1;
    }

    /** Troca dois elementos de posição no array. */
    private static void trocar(RegistroAtendimento[] arr, int a, int b) {
        RegistroAtendimento temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
