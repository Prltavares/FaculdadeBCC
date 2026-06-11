package Lista11;

/**
 * Implementação de Busca Linear usando Generics.
 * Realiza busca sequencial em qualquer tipo de dado.
 * Complexidade: O(n)
 */
public class BuscaLinear<T> extends BuscaAbstract<T> {

    @Override
    public int buscar(T valor) {
        Object[] dados = getInfo();

        if (dados == null || valor == null) {
            return -1;
        }

        for (int i = 0; i < dados.length; i++) {
            if (dados[i] != null && dados[i].equals(valor)) {
                return i;
            }
        }

        return -1;
    }
}

