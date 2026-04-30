package Busca;

public class ListaEstatica<T> extends ListaAbstract<T> {

    private Object[] info = super.getInfo();

    @Override
    public void inserir(Object valor) {
        if (info.length == getTamanho()) {
            redimensionar();
        }
        info[getTamanho()] = valor;
        setTamanho(getTamanho() + 1);
    }

    @Override
    public int buscar(T valor) {
        for (int i = 0; i < getTamanho(); i++) {
            if (info[i].equals(valor)) {
                return i;
            }
        }
        return -1;
    }
}
