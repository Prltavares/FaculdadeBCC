package ArvoreBináriaDeBusca;
/** 
 * @autor Larissa Zózimo Antunes
 */
public class NoArvoreBinaria <T> {
	
	private T info;
	private NoArvoreBinaria<T> esquerda;
	private NoArvoreBinaria<T> direita;
	
	// Construtor da classe NoArvoreBinaria, cria um no sem filhos com determinado valor passado por parametro
	public NoArvoreBinaria(T info) {
		this.info = info;
		esquerda = null;
		direita = null;
	}
	
	// Construtor da classe NoArvoreBinaria, definindo os filhos e o seu valor passado por parametro
	public NoArvoreBinaria(T info, NoArvoreBinaria<T> esq, NoArvoreBinaria<T> dir) {
		this.info = info;
		this.esquerda = esq;
		this.direita = dir;
	}
	
	// Determina o valor do no
	public void setInfo (T info) {
		this.info = info;
	}
	
	// Retorna o valor do no
	public T getInfo() {
		return info;
	}
	
	// Retorna o filho a esquerda do no
	public NoArvoreBinaria<T> getEsquerda () {
		return esquerda;
	}
	
	// Retorna o filho a direita do no
	public NoArvoreBinaria<T> getDireita () {
		return direita;
	}

	// Define o filho a esquerda do no
	public void setEsquerda(NoArvoreBinaria<T> esquerda) {
		this.esquerda = esquerda;
		
	}
	
	// Define o filho a direita do no
	public void setDireita(NoArvoreBinaria<T> direita) {
		this.direita = direita;
		
	}
	
}
