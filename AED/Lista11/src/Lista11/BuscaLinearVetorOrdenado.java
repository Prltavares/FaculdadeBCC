package Lista11;

/**
 * Implementação de Busca Linear em Vetor Ordenado usando Generics.
 * Realiza busca sequencial que para antecipadamente se encontrar
 * um valor maior que o buscado.
 * Requer: Array ordenado em ordem crescente.
 * Complexidade: O(n) pior caso, mas com otimização por parada antecipada.
 */
public class BuscaLinearVetorOrdenado<T extends Comparable<T>> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        Object[] dados = getInfo();

        if (dados == null || valor == null) {
            return -1;
        }

        for (int i = 0; i < dados.length; i++) {
            @SuppressWarnings("unchecked")
            T elemento = (T) dados[i];

            int comparacao = elemento.compareTo(valor);

            if (comparacao == 0) {
                return i;
            } else if (comparacao > 0) {
                return -1;
            }
        }

        return -1;
    }
}

