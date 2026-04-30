public class ListaEstaticaTreino<T> {
	private T[] info;
	private int tamanho;
	
	@SuppressWarnings("unchecked")
	public ListaEstaticaTreino() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	@SuppressWarnings("unchecked")
	public void redimensionar() {
		Object[] novo = (T[]) new Object[info.length + 10];

		for (int i=0; i<info.length; i++) {
			novo[i] = (T) info[i];
		}
		info = (T[]) novo;
	}
	
	public void inserir(T valor) {
		if(tamanho==info.length) {
			redimensionar();
		}
		info[tamanho]=valor;
		tamanho++;
	}

	 public void exibir() {
		 for (int i=0; i<tamanho; i++) {
				System.out.println(info[i]);
			}
	        
	    }
	
	public int buscar(T valor) {
		for (int i=0; i<tamanho; i++) {
			if (info[i].equals(valor)){
				return i;
			}
		}
		return -1;
	}
	
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
	
	@SuppressWarnings("unchecked")
	public void liberar() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	@SuppressWarnings("unchecked")
	public T obterElemanto(int posicao) {
		return info[1];
	}

	public boolean estaVazia() {
		return tamanho==0;
		//if(tamanho==0){
		//return false
		//}
	}
	
	public int getTamanho() {
		return tamanho;
	}
	
	
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
	        int qtdTrocas = getTamanho() / 2;
	        int esquerda = 0;
	        int direita = getTamanho() - 1;

	        for (int i = 0; i < qtdTrocas; i++) {
	            T backup = (T) info[direita];
	            info[direita] = info[esquerda];
	            info[esquerda] = backup;

	            direita--;
	            esquerda++;
	        }
	    }

}
