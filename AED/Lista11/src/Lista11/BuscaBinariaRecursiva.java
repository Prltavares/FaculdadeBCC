package Lista11;

/**
 * Busca binária recursiva. Requer array ordenado em ordem crescente.
 */
public class BuscaBinariaRecursiva {

    public static int buscaBinariaRec(int[] arr, int chave) {
        if (arr == null) return -1;
        return busca(arr, 0, arr.length - 1, chave);
    }

    private static int busca(int[] arr, int lo, int hi, int chave) {
        if (lo > hi) return -1;
        int mid = lo + (hi - lo) / 2;
        if (arr[mid] == chave) return mid;
        if (arr[mid] < chave) return busca(arr, mid + 1, hi, chave);
        return busca(arr, lo, mid - 1, chave);
    }
}

