package Busca;

public class ListaOrdenada<T extends Comparable<T>> extends ListaAbstract<T> {

    public void inserir(T dado){
        Object[] info = getInfo();

        int tamanho = getTamanho();

        if (tamanho == info.length){
            redimensionar();
        }

        int posicao = procurarPosicaoInclusao(dado);

        if (posicao<getTamanho()){
            deslocarDados(posicao);
        }

        info = getInfo(); // por causa do redimensionamento
        info[posicao] = dado;

        this.setTamanho(tamanho + 1);
    }


    private int procurarPosicaoInclusao (T itemAdicionar){

        Object[] info = getInfo();
        int i;

        for (i=0; i<getTamanho(); i++){
            if (itemAdicionar.compareTo((T)info[i])<0)
                break;
        }

        //(((Comparable)info[i]).compareTo(itemAdicionar)>0));

        return i;
    }

    private void deslocarDados(int posicao){
        Object[] info = getInfo();

        for (int j = getTamanho()-1; j >= posicao; j--) {
            info[j+1] = info[j];
                }
    }



    public int buscar(T valor) {
        Object[] info = getInfo();

        int inicio = 0;
        int fim = getTamanho()-1;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            int comparacao = (valor).compareTo((T) info[meio]);

            if (comparacao == 0) {
                return meio;
            } else if (comparacao > 0) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }

        return -1;
    }
}