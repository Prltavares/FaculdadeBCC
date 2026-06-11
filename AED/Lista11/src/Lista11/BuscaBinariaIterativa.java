package Lista11;

/**
 * Busca binária iterativa. Requer array ordenado em ordem crescente.
 */
public class BuscaBinariaIterativa {

    /**
     * Retorna índice de chave em arr ou -1 se não encontrado.
     */
    public static int buscaBinaria(int[] arr, int chave) {
        if (arr == null) return -1;
        int lo = 0, hi = arr.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (arr[mid] == chave) return mid;
            if (arr[mid] < chave) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }
}

