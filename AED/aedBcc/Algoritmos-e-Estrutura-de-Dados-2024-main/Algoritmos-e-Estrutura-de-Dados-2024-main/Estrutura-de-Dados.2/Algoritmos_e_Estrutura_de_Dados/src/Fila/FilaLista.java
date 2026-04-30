package Fila;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
import Pilha.NoLista;

public class FilaLista<T> implements Fila<T> {

	private ListaEncadeada<T> lista;

	public FilaLista() {
		lista = new ListaEncadeada<>();
	}

	@Override
	public void inserir(T valor) {
		lista.inserirNoFinal(valor);
	}

	@Override
	public boolean estaVazia() {
		return lista.estaVazia();
	}

	@Override
	public T peek() {

		return lista.getPrimeiro().getInfo();
	}

	@Override // Não se escolhe qual deve ser retirado
	public T retirar() {

		T info;
		info = peek();
		lista.retirar(info);

		return info;
	}

	@Override
	public void liberar() {
		
		if (estaVazia()) {
			//tem que lançar excesao
		}

		lista = new ListaEncadeada<>();

	}

	@Override
	public String toString() {/*
		StringBuilder resultado = new StringBuilder();
		NoLista<T> p = lista.getPrimeiro();

		while (p != null) {
			resultado.append(p.getInfo());
			if (p.getProximo() != null) {
				resultado.append(", "); // Separar os elementos por vírgula
			}
			p = p.getProximo();
		}

		return resultado.toString();
	}*/
		return lista.toString();
	}
	
	//extra
	public int tamanho() {
	    return lista.tamanho();
	}
	

	public NoLista<T> contem(T elemento) {
	    return lista.buscar(elemento);
	}
	
	public void esvaziar() {
	    while (!estaVazia()) {
	        retirar();
	    }
	}
	
	public void copiarDe(Fila<T> outraFila) {
	    while (!outraFila.estaVazia()) {
	        inserir(outraFila.retirar());
	    }
	}
	
	public void inverter() {
	    Fila<T> filaAuxiliar = new FilaLista<>();

	    while (!estaVazia()) {
	        filaAuxiliar.inserir(retirar());
	    }

	    while (!filaAuxiliar.estaVazia()) {
	        inserir(filaAuxiliar.retirar());
	    }
	}
}