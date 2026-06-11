package Lista11;

/**
 * Implementação de Árvore Binária simples (sem regras de ordenação).
 * Realiza busca em profundidade (DFS) sem aproveitar nenhuma ordem.
 */
public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    @Override
    public void setRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscaRecursiva(raiz, info);
    }

    private NoArvoreBinaria<T> buscaRecursiva(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        if (no.getInfo().equals(info)) {
            return no;
        }

        NoArvoreBinaria<T> encontrado = buscaRecursiva(no.getEsquerda(), info);
        if (encontrado != null) {
            return encontrado;
        }

        return buscaRecursiva(no.getDireita(), info);
    }
}

