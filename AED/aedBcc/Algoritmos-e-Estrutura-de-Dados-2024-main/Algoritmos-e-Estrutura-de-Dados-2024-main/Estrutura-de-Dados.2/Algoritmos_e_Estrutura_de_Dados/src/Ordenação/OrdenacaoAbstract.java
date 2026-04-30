package Ordenação;
/**
 * @autor Larissa Zózimo Antunes
 * 
 */

public abstract class OrdenacaoAbstract<T extends Comparable<T>> {

    // Array que armazena os elementos que serão ordenados
    private T[] info;

    // Método getter que retorna o array com elementos a serem ordenados
    public T[] getInfo() {
        return info;
    }

    // Método setter que define o array com elementos a serem ordenados
    public void setInfo(T[] info) {
        this.info = info;
    }

    // Método para trocar a posição de dois elementos no array
    public void trocar(int a, int b) {
        // Armazena temporariamente o elemento na posição 'a'
        T temporario = info[a];
        // Coloca o elemento da posição 'b' na posição 'a'
        info[a] = info[b];
        // Coloca o elemento armazenado temporariamente na posição 'b'
        info[b] = temporario;
    }

    // Método abstrato implementado pelas subclasses para ordenar o array
    public abstract void ordenar();
}
