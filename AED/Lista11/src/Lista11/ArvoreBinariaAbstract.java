package Lista11;

/**
 * Classe abstrata base para Árvores Binárias.
 * Define a estrutura comum e métodos abstratos que as implementações devem satisfazer.
 */
public abstract class ArvoreBinariaAbstract<T> {

    protected NoArvoreBinaria<T> raiz;

    public ArvoreBinariaAbstract() {
        this.raiz = null;
    }

    protected void setRaiz(NoArvoreBinaria<T> raiz) {
        this.raiz = raiz;
    }

    public NoArvoreBinaria<T> getRaiz() {
        return raiz;
    }

    public boolean estaVazia() {
        return raiz == null;
    }

    public abstract NoArvoreBinaria<T> buscar(T info);

    public boolean pertence(T info) {
        return buscar(info) != null;
    }

    @Override
    public String toString() {
        return arvorePre(raiz);
    }

    private String arvorePre(NoArvoreBinaria<T> no) {
        if (no == null) {
            return "<>";
        }
        return "<" + no.getInfo() + arvorePre(no.getEsquerda()) + arvorePre(no.getDireita()) + ">";
    }
}

