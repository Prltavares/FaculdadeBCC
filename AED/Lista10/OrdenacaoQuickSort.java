
public class OrdenacaoQuickSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = getInfo();
        if (info == null || info.length <= 1) return;

        int n = info.length - 1;
        quickSort(0, n);
    }

    private void quickSort(int inicio, int fim) {
        if (inicio < fim) {
            int idxPivo = particionar(inicio, fim);
            quickSort(inicio, idxPivo - 1);
            quickSort(idxPivo + 1, fim);
        }
    }

    private int particionar(int inicio, int fim) {
        T[] info = getInfo();
        int a = inicio;
        int b = fim + 1;
        T pivo = info[inicio];

        while (true) {
            // Procura alguém maior que o pivô à esquerda
            do {
                a++;
            } while (a <= fim && info[a].compareTo(pivo) < 0);

            // Procura alguém menor que o pivô à direita
            do {
                b--;
            } while (b >= inicio && info[b].compareTo(pivo) > 0);

            if (a >= b) {
                break;
            }
            trocar(a, b);
        }

        trocar(b, inicio); // Coloca o pivô no lugar definitivo
        return b;
    }
}