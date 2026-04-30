package Ordenação;

/**
 * @autor Larissa Zózimo Antunes
 * 
 */
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T>{

    // Array que armazena os elementos que serão ordenados
    public T[] info;

    // Método que implementa o algoritmo de ordenação bolha
    @Override
    public void ordenar() {
        // Obtém o array de elementos a partir da classe base
        info = super.getInfo();
        // Loop externo que percorre o array de trás para frente
        for (int i = info.length-1; i >= 1; i--) {
            // Loop interno que percorre o array do início até a posição i-1
            for (int j = 0; j <= i-1; j++) {
                // Compara elementos adjacentes e troca-os se estiverem fora de ordem
                if(info[j].compareTo(info[j+1]) > 0){
                    trocar(j, j+1);
                }
            }
        }
    }
}
