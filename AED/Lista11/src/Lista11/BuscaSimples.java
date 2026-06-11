package Lista11;

/**
 * Busca linear (simples) em arrays de int.
 */
public class BuscaSimples {

    /**
     * Procura a primeira ocorrência de chave em arr.
     * @param arr array onde buscar
     * @param chave valor a procurar
     * @return índice da primeira ocorrência ou -1 se não encontrado
     */
    public static int buscaLinear(int[] arr, int chave) {
        if (arr == null) return -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == chave) return i;
        }
        return -1;
    }
}

