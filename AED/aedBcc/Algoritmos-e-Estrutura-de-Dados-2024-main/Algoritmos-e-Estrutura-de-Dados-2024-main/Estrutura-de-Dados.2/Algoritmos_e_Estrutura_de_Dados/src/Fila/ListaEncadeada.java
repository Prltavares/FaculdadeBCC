package Fila;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
import Pilha.NoLista;

public class ListaEncadeada <T>{
	private NoLista<T> primeiro;
	private NoLista<T> ultimo;
	
	public ListaEncadeada() {
		this.primeiro = null;
	}

	public int tamanho() {
		int tamanho = 0;
		NoLista<T> atual = primeiro;

		while (atual != null) {
			tamanho++;
			atual = atual.getProximo();
		}

		return tamanho;
	}

	public NoLista<T> getPrimeiro() {
		return this.primeiro;
	}
	
	public boolean estaVazia() {
		return primeiro==null;
	}
	
	public void inserirNoFinal(T valor) {
		NoLista<T> novo = new NoLista<T>();
		novo.setInfo(valor);
		novo.setProximo(null);
		
		if(estaVazia())
			primeiro = novo;
		else
			ultimo.setProximo(novo);
		
		ultimo = novo;
	}
	
	public NoLista<T> buscar(T info){
		NoLista<T> no = getPrimeiro();
		
		while (no != null) {
			if(no.getInfo().equals(info)) {
				return no;
			}
			no = no.getProximo();
		}		
		return null;	
	}

	
	
	//método retirar do prof
	 
		public void retirar(T info) {
		NoLista<T> anterior = null;
		NoLista<T> p = getPrimeiro();

		while ((p != null) && (!p.getInfo().equals(info))) {
			anterior = p;
			p = p.getProximo();
		}

		if (p != null) {
			if (anterior == null) {
				primeiro = primeiro.getProximo();
			} else
				anterior.setProximo(p.getProximo());
			
			if(p == ultimo) {
				ultimo = anterior;
			}
		}
	}
	  
	 
	 
	
	
	public int obterComprimento() {
		NoLista<T> no = getPrimeiro();
		int tamanho = 0;
		
		while(no != null) {
			tamanho++;
			no=no.getProximo();
		}
		return tamanho;
	}
	
	public NoLista<T> obterNo(int idx){
		NoLista<T> no = primeiro;
		int posicao = 0;
		while(no != null) {
			if (posicao == idx) {
				return no;
			} 
			posicao++;
			no=no.getProximo();
		}
		throw new IndexOutOfBoundsException();
	}
	
	/*public NoLista<T> obterNo(int idx) {
		if (idx < 0) {
			throw new IndexOutofBoundsException();
		}
		
		NoLista<T> p = getPrimeiro();
		while ((p!= null) 6& (idx > 0)) {
			idx--:
			p = P. getProximo();
		}
		
      	*int x=0.
		*while ((p!= null) && (x < idx)) {
		*	p = p.getProximo();
		*	x++;
		*}
		
		if(p == null){
			throw new IndexOutOfBoundsException();
		}
		
		return p;
	}*/
	
	/*
	  public void exibir() {
		Nolista<T> p = getPrimeiro ();
		while (p != null) {
			System.out.println(p.getInfo());
			p = p. getProximo ();
		}
	}
	 */
	
	//extra
	public int duplicado() {
		int indice = 0;
		NoLista<T> no1 = getPrimeiro();
		while(no1 != null) {
			NoLista<T> no2 = no1.getProximo();
			while(no2 != null ) {
				
				if(no1.getInfo().equals(no2.getInfo())) {
					return indice;
				}
				no2 = no2.getProximo();
			}
			indice ++;
			no1 = no1.getProximo();	
		}
		return -1;
	}
	
	//extra
	public String exibirInverso() {
		NoLista<T> no = getPrimeiro();
		@SuppressWarnings("unchecked")
		T[] vetor = (T[]) new Object[obterComprimento()];
		int indice = 0;
		String inverso = "";
		
	        while (no != null ) {
	        	vetor[indice] = no.getInfo();
	        	indice ++;
	        	no = no.getProximo();
	        }
	        
	        indice = obterComprimento() - 1;
	        
	        while(indice >= 0) {		
				//if(vetor[indice] != getPrimeiro().getInfo())
					inverso += ", ";
				
				inverso += vetor[indice].toString();
				indice--;
			}
	        
	        return inverso;
	}
	
	// Método para liberar a memória dos nós da lista
    public void liberar() {
        NoLista<T> atual = primeiro;

        while (atual != null) {
            NoLista<T> proximo = atual.getProximo();
            atual.setProximo(null);
            atual = proximo;
        }

        primeiro = null;
    }
	
	@Override
	public String toString() {
		String lista = "";
		NoLista<T> no = getPrimeiro();
			
			while(no != null) {		
				if(no != getPrimeiro())
					lista += ", ";
				
				lista += no.getInfo().toString();
				no = no.getProximo();
			}
		
		return lista;
	}
}
