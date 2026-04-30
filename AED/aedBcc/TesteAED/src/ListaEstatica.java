public class ListaEstatica<T> {
	
	private T[] info;
	private int tamanho;

	/**
	 * Cria uma lista vazia
	 */
	@SuppressWarnings("unchecked")
	public ListaEstatica() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	
	/**
	 * Adiciona um valor na lista
	 * @param valor Dado a ser adicionado
	 */
	public void inserir(T valor) {
		if (tamanho == info.length) {
			redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}
	

	/**
	 * Provoca um pseudo redimensionamento do vetor info
	 */
	private void redimensionar() {
		@SuppressWarnings("unchecked")
		T[] novo = (T[]) new Object[info.length + 10];

		for (int i=0; i<info.length; i++) {
			novo[i] = info[i];
		}
		
		info = novo;
	}	
	
	
	/**
	 * Exibe o conteúdo da lista
	 */
	public void exibir() {
		for (int i=0; i<tamanho; i++) {
			System.out.println(info[i]);
		}
	}
	
	
	/**
	 * Procura na lista um determinado valor
	 * @param valor Dado a ser pesquisado
	 * @return posição do valor na lista. Caso não seja encontrado
	 * retorna -1.
	 */
	public int buscar(T valor) {
		for (int i=0; i<tamanho; i++) {
			if (info[i].equals(valor)){
				return i;
			}
		}
		
		return -1;
	}
	
	
	/**
	 * Retira um dado da lista
	 * @param valor Dado a ser removido
	 */
	public void retirar(T valor) {
		int posicao = buscar(valor);
		
		if (posicao > -1) {
			for (int i=posicao+1; i<tamanho; i++) {
				info[i-1] = info[i];
			}
			info[tamanho - 1]=null;
			tamanho--;
		}
	}
	
	
	/**
	 * limpa a estrutura de dados, de forma que a 
	 * lista esteja vazia
	 */
	@SuppressWarnings("unchecked")
	public void liberar() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	
	/**
	 * Retorna o dado armazenado numa determinada posição
	 * da lista.
	 * @param posicao Posição do dado
	 * @return Dado localizado
	 */
	public T obterElemento(int posicao) {
		if (posicao >= 0 && (posicao < tamanho)) {
			return info[posicao];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	
	/**
	 * Avalia se a lista está vazia ou contem dados armazenados.
	 * @return true se a lista estiver vazia, senão false.
	 */
	public boolean estaVazia() {
		return tamanho==0;
	}
	
	
	/**
	 * Retorna o tamanho atual da lista, isto é,
	 * a quantidade de dados já armazenados na estrutura de dados
	 * @return Quantidade de dados armazenados
	 */
	public int getTamanho() {
		return tamanho;
	}
	
	
	/**
	 * Retorna string contendo os dados armazenados na lista
	 */
	@Override
	public String toString() {
		String resultado = "";
		
		for (int i=0; i<tamanho; i++) {
			if (i > 0) {
				resultado += ",";
			}
			resultado += info[i].toString(); 
		}
		
		return resultado;
	}

	public void inverter() {
		int qtdTrocas = getTamanho()/2;
		int esquerda = 0;
		int direita = getTamanho() - 1;
		
		for (int i = 1; i < qtdTrocas; i++) {
			T backup = info[direita];
			info[direita] = info[esquerda];
			info[esquerda] = backup;
			
			direita --;
			esquerda ++;
        }
	}
	

	
	
		/**
	     * Insere um valor na lista em uma posição específica.
	     * @param posicao Posição onde o valor deve ser inserido
	     * @param valor Dado a ser inserido
	     */
	    public void inserir(int posicao, T valor) {
	        if (posicao < 0 || posicao > tamanho) {
	            throw new IndexOutOfBoundsException("posicao invalida");
	        }
	
	        if (tamanho == info.length) {
	            redimensionar();
	        }
	
	        for (int i = tamanho; i > posicao; i--) {
	            info[i] = info[i - 1];
	        }
	
	        info[posicao] = valor;
	        tamanho++;
	    }
	    
	    
	    /**
			public void inserir(int posicao, T valor) {
		    // Verifica se a posição é válida
		    if (posicao < 0 || posicao > tamanho) {
		        throw new IndexOutOfBoundsException();
		    }
		
		    // Verifica se há necessidade de redimensionar o array
		    if (tamanho == info.length) {
		        redimensionar();
		    }
		
		    // Desloca elementos para a direita para abrir espaço na posição desejada
		    for (int i = tamanho; i > posicao; i--) {
		        info[i] = info[i - 1];
		    }
		
		    // Insere o valor na posição especificada
		    info[posicao] = valor;
		
		    // Incrementa o tamanho da lista
		    tamanho++;
		}
	  */
	     
}
