package Lista11;

/**
 * Implementação de Busca Binária usando Generics.
 * Realiza busca binária clássica em arrays ordenados.
 * Requer: Array ordenado em ordem crescente.
 * Complexidade: O(log n)
 */
public class BuscaBinaria<T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        Object[] dados = getInfo();

        if (dados == null || valor == null) {
            return -1;
        }

        int esquerda = 0;
        int direita = dados.length - 1;

        while (esquerda <= direita) {
            int meio = esquerda + (direita - esquerda) / 2;

            @SuppressWarnings("unchecked")
            T elemento = (T) dados[meio];

            int comparacao = elemento.compareTo(valor);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao < 0) {
                esquerda = meio + 1;
            } else {
                direita = meio - 1;
            }
        }

        return -1;
    }
}

