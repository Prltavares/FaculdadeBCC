/**
 * 
 * @autor Larissa Zózimo Antunes
 */
public class ListaEstaticaProva <T>{
	private T[] info;
	private int tamanho;

	
	@SuppressWarnings("unchecked")
	public ListaEstaticaProva() {
		info = (T[]) new Object[10];
		tamanho = 0;
	}
	
	
	public void inserir(T valor) {
		if (tamanho == info.length) {
			redimensionar();
		}
		info[tamanho] = valor;
		tamanho++;
	}
	
	private void redimensionar() {
		@SuppressWarnings("unchecked")
		T[] novo = (T[]) new Object[info.length + 10];

		for (int i=0; i<info.length; i++) {
			novo[i] = info[i];
		}
		
		info = novo;
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
	
	public T obterElemento(int posicao) {
		if (posicao >= 0 && (posicao < tamanho)) {
			return info[posicao];
		} else {
			throw new IndexOutOfBoundsException();
		}
	}
	
	public boolean estaVazia() {
		return tamanho==0;
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
	
	 public void inserir(int posicao, T valor) {
		 	// Verifica se a posição é válida
	        if (posicao < 0 || posicao > tamanho) {
	            throw new IndexOutOfBoundsException("posicao invalida");
	        }
	
	     // Verifica se o array está cheio e redimensiona se necessário
	        if (tamanho == info.length) {
	            redimensionar();
	        }
	
	     //Desloca os elementos para abrir espaço na posição especificada
	        for (int i = tamanho; i > posicao; i--) {
	            info[i] = info[i - 1];
	        }
	        
	        // Insere o novo valor na posição especificada
	        info[posicao] = valor;
	        tamanho++;
	}
}

