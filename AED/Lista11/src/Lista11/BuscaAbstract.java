package Lista11;

/**
 * Classe abstrata base para algoritmos de busca.
 * Define a estrutura comum para todas as buscas usando Generics.
 */
public abstract class BuscaAbstract<T> {

    private Object[] info;

    public Object[] getInfo() {
        return info;
    }

    public void setInfo(Object[] info) {
        this.info = info;
    }

    /**
     * Método abstrato para buscar um valor no array.
     */
    public abstract int buscar(T valor);
}

