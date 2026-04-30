package ListaDuplamenteEncadeada;

/**
 * 
 * @autor Larissa Zózimo Antunes
 */
public class ListaDupla <T>{
	
	private NoListaDupla<T> primeiro;
	
	
	
	public ListaDupla(){
		primeiro = null;
	}
	
	//prova
	public ListaDupla<T> clonar() {
        ListaDupla<T> novaLista = new ListaDupla<>();
        
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            novaLista.inserir(atual.getInfo());
            atual = atual.getProximo();
        }

        return novaLista;
    }
	
	
	public NoListaDupla<T> getPrimeiro() {
		return primeiro;
	}
	
	public void inserir(T valor) {
		NoListaDupla<T> novo = new NoListaDupla<>();
        novo.setInfo(valor);
        novo.setProximo(primeiro);
        novo.setAnterior(null);

        if (this.primeiro != null) {
            this.primeiro.setAnterior(novo);
        }

        this.primeiro = novo;
	}
	
	public NoListaDupla<T> buscar(T valor){
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
		NoListaDupla<T> p = buscar(valor);

        if (p != null) { // Achou o elemento
            if (primeiro == p) { // Primeiro elemento?
                primeiro = p.getProximo();
            } else {
                p.getAnterior().setProximo(p.getProximo());
            }

            if (p.getProximo() != null) { // Não é o último?
                p.getProximo().setAnterior(p.getAnterior());
            }
        }

	}
	
	//extra
	@SuppressWarnings("unused")
	private NoListaDupla<T> obterUltimo(){
		NoListaDupla<T> ultimo = primeiro;
		
		NoListaDupla<T> p = primeiro;
		
		while(p != null) {
			ultimo = p;
			p = p.getProximo();
		}
		
		return ultimo;
	}
	
	
	//metodo do prof
	public void ordemInversa() {
		NoListaDupla<T> p = obterUltimo();
		
		while(p != null) {
			System.out.println(p.getInfo());
			p = p.getAnterior();
		}
	}
	
	
	public void exibirOrdemInversa() {
		 NoListaDupla<T> atual = primeiro;

	        while (atual != null && atual.getProximo() != null) {
	            atual = atual.getProximo();
	        }

	        while (atual != null) {
	            System.out.println(atual.getInfo());
	            atual = atual.getAnterior();
	        }
	}
	
	public void liberar() {
		 NoListaDupla<T> atual = primeiro;

	        while (atual != null) {
	            NoListaDupla<T> proximo = atual.getProximo();
	            atual.setProximo(null);
	            atual.setAnterior(null);
	            atual = proximo;
	        }

	        primeiro = null;
	}
	
	//do prof
	public void libera() {
		NoListaDupla<T> p = primeiro;
		while(p != null) {
			NoListaDupla<T> backup = p.getProximo();
			p.setProximo(null);
			p.setAnterior(null);
			p = backup;
		}
	}
	
	
	@Override
	public String toString() {
		String listaDupla = "";
		
		NoListaDupla<T> atual = primeiro;

	        while (atual != null) {
	        	listaDupla+=(atual.getInfo());
	            if (atual.getProximo() != null) {
	            	listaDupla+=(", ");
	            }
	            atual = atual.getProximo();
	        }
			return listaDupla + ".";
	 }
	
	
	//Extra
	 // Método para obter o nó na posição fornecida
    public NoListaDupla<T> obterNo(int posicao) {
        if (posicao < 0 || posicao >= tamanho()) {
            throw new IndexOutOfBoundsException("Posição inválida");
        }

        NoListaDupla<T> atual = primeiro;
        for (int i = 0; i < posicao; i++) {
            atual = atual.getProximo();
        }

        return atual;
    }

    // Método para retornar o tamanho da lista
    public int tamanho() {
        int tamanho = 0;
        NoListaDupla<T> atual = primeiro;

        while (atual != null) {
            tamanho++;
            atual = atual.getProximo();
        }

        return tamanho;
    }
    
    // Método para encontrar o índice do primeiro valor duplicado na lista
    public int duplicado0() {
        NoListaDupla<T> atual = primeiro;
        int indice = 0;
        
        while (atual != null) {
            if (verificarDuplicado(atual)) {
                return indice;
            }
            
            atual = atual.getProximo();
            indice++;
        }

        return -1;
    }
    
    // Método auxiliar para verificar duplicados a partir de um nó
    private boolean verificarDuplicado(NoListaDupla<T> no) {
        T valor = no.getInfo();
        NoListaDupla<T> atual = no.getProximo();

        while (atual != null) {
            if (valor.equals(atual.getInfo())) {
                return true;
            }
            
            atual = atual.getProximo();
        }

        return false;
    }
    
    
    
    public ListaDupla<T> criarSubLista(int inicio, int fim) {
    	// Verifica se os índices são válidos
        if (inicio < 0 || inicio > fim) {
            throw new IndexOutOfBoundsException("Inválido"); 
        }
        
        // Cria uma nova lista dupla para armazenar a sublista
        ListaDupla<T> newList = new ListaDupla<>();
        // Inicializa newNo com o primeiro nó da lista atual
        NoListaDupla<T> newNo = this.getPrimeiro();
       
        // Variável para rastrear a posição atual na lista
        int posicao = 0;

        // Avança até o índice de início
        while (posicao < inicio) {
        	 // Move para o próximo nó
            newNo = newNo.getProximo(); 
            // Incrementa a posição
            posicao++; 
        }

        // Adiciona os nós à nova lista até o índice de fim
        while (posicao <= fim && newNo != null) {
        	// Insere a informação do nó atual na nova lista
            newList.inserir(newNo.getInfo());
            // Move para o próximo nó
            newNo = newNo.getProximo(); 
            // Incrementa a posição
            posicao++; 
        }
        
        // Retorna a sublista criada
        return newList;
    }
    
}
