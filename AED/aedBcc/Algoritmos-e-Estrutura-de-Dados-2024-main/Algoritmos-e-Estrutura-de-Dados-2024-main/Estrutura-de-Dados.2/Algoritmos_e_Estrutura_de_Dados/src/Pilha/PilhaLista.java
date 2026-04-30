package Pilha;


public class PilhaLista<T> implements Pilha<T>{
	
	private ListaEncadeada<T> lista =  new ListaEncadeada<>();

	@Override
	public void push(T info) {
		lista.inserir(info);	
	}

	@Override
	public T pop() {
		T valor;
		valor = peek();

		lista.retirar(valor);;
		return valor;
	}

	@Override
	public T peek() {
		if (estaVazia()) {
			 throw new PilhaVaziaException();
		}
		return lista.getPrimeiro().getInfo();
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public void liberar() {
		lista =  new ListaEncadeada<>();
	}
	
	@Override
	public String toString() {
		return lista.toString();
	}
	
	//extra
	public int tamanho() {
	    return lista.tamanho();
	}
	
	public NoLista<T> contem(T elemento) {
	    return lista.buscar(elemento);
	}
	
	public void limpar() {
	    lista.liberar();
	}
	
	public PilhaLista<T> clonar() {
	    PilhaLista<T> novaPilha = new PilhaLista<>();
	    novaPilha.lista = this.lista.clonar(); // Você precisaria implementar o método clonar na classe ListaEncadeada.
	    return novaPilha;
	}
	
	public void inverter1() {
	    ListaEncadeada<T> novaLista = new ListaEncadeada<>();
	    while (!estaVazia()) {
	        novaLista.inserir(pop());
	    }
	    lista = novaLista;
	}
	
	public void inverter() {
	    Pilha<T> auxiliar = new PilhaLista<>();

	    while (!estaVazia()) {
	        auxiliar.push(pop());
	    }

	    while (!auxiliar.estaVazia()) {
	        push(auxiliar.pop());
	    }
	}
	
	public void copiarDe(Pilha<T> outraPilha) {
	    while (!outraPilha.estaVazia()) {
	        push(outraPilha.pop());
	    }
	}
}
