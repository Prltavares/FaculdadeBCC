// Lista duplamente encadeada
public class ListaDupla<T> {
    private NoListaDupla<T> primeiro;

    public ListaDupla() {
        primeiro = null;
    }

    public NoListaDupla<T> getPrimeiro() {
        return primeiro;
    }

    public void inserir(T valor) {
        NoListaDupla<T> novo = new NoListaDupla<>(valor);
        novo.setProximo(primeiro);
        if (primeiro != null) {
            primeiro.setAnterior(novo);
        }
        primeiro = novo;
    }

    public NoListaDupla<T> buscar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                return atual;
            }
            atual = atual.getProximo();
        }
        return null;
    }

    public void retirar(T valor) {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            if (atual.getInfo().equals(valor)) {
                if (atual.getAnterior() != null) {
                    atual.getAnterior().setProximo(atual.getProximo());
                } else {
                    primeiro = atual.getProximo();
                }
                if (atual.getProximo() != null) {
                    atual.getProximo().setAnterior(atual.getAnterior());
                }
                return;
            }
            atual = atual.getProximo();
        }
    }

    public void exibirOrdemInversa() {
        NoListaDupla<T> atual = primeiro;
        NoListaDupla<T> ultimo = null;
        while (atual != null) {
            ultimo = atual;
            atual = atual.getProximo();
        }
        while (ultimo != null) {
            System.out.print(ultimo.getInfo());
            if (ultimo.getAnterior() != null) System.out.print(", ");
            ultimo = ultimo.getAnterior();
        }
        System.out.println();
    }

    public void liberar() {
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            NoListaDupla<T> prox = atual.getProximo();
            atual.setAnterior(null);
            atual.setProximo(null);
            atual = prox;
        }
        primeiro = null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        NoListaDupla<T> atual = primeiro;
        while (atual != null) {
            sb.append(atual.getInfo());
            if (atual.getProximo() != null) sb.append(", ");
            atual = atual.getProximo();
        }
        return sb.toString();
    }
}
