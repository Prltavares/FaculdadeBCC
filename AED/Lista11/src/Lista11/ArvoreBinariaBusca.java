package Lista11;

/**
 * Implementação de Árvore Binária de Busca (BST).
 * Mantém a propriedade: esquerda < raiz < direita
 * Permite inserção, busca e remoção com eficiência O(log n) em média.
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {

    public void inserir(T info) {
        raiz = inserirRecursivo(raiz, info);
    }

    private NoArvoreBinaria<T> inserirRecursivo(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return new NoArvoreBinaria<>(info);
        }

        int comparacao = info.compareTo(no.getInfo());

        if (comparacao < 0) {
            no.setEsquerda(inserirRecursivo(no.getEsquerda(), info));
        } else if (comparacao > 0) {
            no.setDireita(inserirRecursivo(no.getDireita(), info));
        }

        return no;
    }

    @Override
    public NoArvoreBinaria<T> buscar(T info) {
        return buscaRecursiva(raiz, info);
    }

    private NoArvoreBinaria<T> buscaRecursiva(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        int comparacao = info.compareTo(no.getInfo());

        if (comparacao == 0) {
            return no;
        } else if (comparacao < 0) {
            return buscaRecursiva(no.getEsquerda(), info);
        } else {
            return buscaRecursiva(no.getDireita(), info);
        }
    }

    public void remover(T info) {
        raiz = removerRecursivo(raiz, info);
    }

    private NoArvoreBinaria<T> removerRecursivo(NoArvoreBinaria<T> no, T info) {
        if (no == null) {
            return null;
        }

        int comparacao = info.compareTo(no.getInfo());

        if (comparacao < 0) {
            no.setEsquerda(removerRecursivo(no.getEsquerda(), info));
        } else if (comparacao > 0) {
            no.setDireita(removerRecursivo(no.getDireita(), info));
        } else {
            if (no.getEsquerda() == null && no.getDireita() == null) {
                return null;
            }

            if (no.getEsquerda() == null) {
                return no.getDireita();
            }

            if (no.getDireita() == null) {
                return no.getEsquerda();
            }

            NoArvoreBinaria<T> sucessor = encontrarMenor(no.getDireita());
            T infoSucessor = sucessor.getInfo();

            no.setInfo(infoSucessor);
            no.setDireita(removerRecursivo(no.getDireita(), infoSucessor));
        }

        return no;
    }

    private NoArvoreBinaria<T> encontrarMenor(NoArvoreBinaria<T> no) {
        while (no.getEsquerda() != null) {
            no = no.getEsquerda();
        }
        return no;
    }
}

