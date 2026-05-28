
public class OrdenacaoMergeSort<T extends Comparable<T>> extends OrdenacaoAbstract<T> {

    @Override
    public void ordenar() {
        T[] info = getInfo();
        if (info == null || info.length <= 1) return;

        int n = info.length - 1;
        mergeSort(0, n);
    }

    private void mergeSort(int inicio, int fim) {
        if (inicio < fim) {
            int meio = (inicio + fim) / 2; // O Java já faz a divisão inteira (floor)
            mergeSort(inicio, meio);
            mergeSort(meio + 1, fim);
            merge(inicio, fim, meio);
        }
    }

    @SuppressWarnings("unchecked")
    private void merge(int inicio, int fim, int meio) {
        T[] info = getInfo();

        int tamEsquerda = meio - inicio + 1;
        // Instanciando vetor genérico conforme orientação do material
        T[] esquerda = (T[]) new Comparable[tamEsquerda];
        for (int i = 0; i <= tamEsquerda - 1; i++) {
            esquerda[i] = info[inicio + i];
        }

        int tamDireita = fim - meio;
        T[] direita = (T[]) new Comparable[tamDireita];
        for (int i = 0; i <= tamDireita - 1; i++) {
            direita[i] = info[meio + 1 + i];
        }

        int cEsq = 0;
        int cDir = 0;
        int i;

        for (i = inicio; i <= fim; i++) {
            if ((cEsq < tamEsquerda) && (cDir < tamDireita)) {
                if (esquerda[cEsq].compareTo(direita[cDir]) < 0) {
                    info[i] = esquerda[cEsq];
                    cEsq++;
                } else {
                    info[i] = direita[cDir];
                    cDir++;
                }
            } else {
                break;
            }
        }

        // Despeja o que sobrou na esquerda
        while (cEsq < tamEsquerda) {
            info[i] = esquerda[cEsq];
            cEsq++;
            i++;
        }

        // Despeja o que sobrou na direita
        while (cDir < tamDireita) {
            info[i] = direita[cDir];
            cDir++;
            i++;
        }
    }
}