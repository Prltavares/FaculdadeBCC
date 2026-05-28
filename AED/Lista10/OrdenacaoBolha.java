
public class OrdenacaoBolha<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = getInfo();
        if (info == null) return;

        int n = info.length;

        // Laço decrescente que controla a quantidade de passagens
        for (int i = n - 1; i >= 1; i--) {
            // Executa uma passagem comparando vizinhos
            for (int j = 0; j <= i - 1; j++) {
                // info[j] > info[j+1] usando compareTo
                if (info[j].compareTo(info[j + 1]) > 0) {
                    trocar(j, j + 1);
                }
            }
        }
    }
}