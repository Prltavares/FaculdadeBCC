
// Nó da lista encadeada genérica
class NoLista<T> {
	private T info;
	private NoLista<T> proximo;

	public NoLista(T info) {
		this.info = info;
		this.proximo = null;
	}

	public T getInfo() {
		return info;
	}

	public void setInfo(T info) {
		this.info = info;
	}

	public NoLista<T> getProximo() {
		return proximo;
	}

	public void setProximo(NoLista<T> proximo) {
		this.proximo = proximo;
	}
}

// Lista encadeada genérica
class ListaEncadeada<T> {
	private NoLista<T> primeiro;

	public ListaEncadeada() {
		this.primeiro = null;
	}

	public NoLista<T> getPrimeiro() {
		return primeiro;
	}

	// Insere elemento no final da lista
	public void inserir(T valor) {
		NoLista<T> novo = new NoLista<>(valor);
		if (primeiro == null) {
			primeiro = novo;
		} else {
			NoLista<T> atual = primeiro;
			while (atual.getProximo() != null) {
				atual = atual.getProximo();
			}
			atual.setProximo(novo);
		}
	}

	public boolean estaVazia() {
		return primeiro == null;
	}

	public NoLista<T> buscar(T valor) {
		NoLista<T> atual = primeiro;
		while (atual != null) {
			if (atual.getInfo().equals(valor)) {
				return atual;
			}
			atual = atual.getProximo();
		}
		return null;
	}

	public void retirar(T valor) {
		if (primeiro == null) return;
		if (primeiro.getInfo().equals(valor)) {
			primeiro = primeiro.getProximo();
			return;
		}
		NoLista<T> atual = primeiro;
		while (atual.getProximo() != null) {
			if (atual.getProximo().getInfo().equals(valor)) {
				atual.setProximo(atual.getProximo().getProximo());
				return;
			}
			atual = atual.getProximo();
		}
	}

	public int obterComprimento() {
		int count = 0;
		NoLista<T> atual = primeiro;
		while (atual != null) {
			count++;
			atual = atual.getProximo();
		}
		return count;
	}

	public NoLista<T> obterNo(int idx) {
		int i = 0;
		NoLista<T> atual = primeiro;
		while (atual != null) {
			if (i == idx) return atual;
			i++;
			atual = atual.getProximo();
		}
		return null;
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		NoLista<T> atual = primeiro;
		while (atual != null) {
			sb.append(atual.getInfo());
			if (atual.getProximo() != null) sb.append(" -> ");
			atual = atual.getProximo();
		}
		return sb.toString();
	}
}
