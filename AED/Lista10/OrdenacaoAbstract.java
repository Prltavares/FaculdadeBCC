
public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

    private T[] info; // O vetor genérico a ser ordenado

    public T[] getInfo() {
        return info;
    }

    public void setInfo(T[] info) {
        this.info = info;
    }

    // Método reutilizável para trocar elementos de posição
    public void trocar(int a, int b) {
        T temp = info[a];
        info[a] = info[b];
        info[b] = temp;
    }

    // Método abstrato que as filhas serão obrigadas a implementar
    public abstract void ordenar();
}