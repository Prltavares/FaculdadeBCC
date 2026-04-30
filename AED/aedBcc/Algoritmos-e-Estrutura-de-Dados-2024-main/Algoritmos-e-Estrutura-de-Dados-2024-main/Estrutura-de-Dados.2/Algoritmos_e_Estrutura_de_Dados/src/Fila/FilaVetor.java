package Fila;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
public class FilaVetor <T> implements Fila<T>{
   
		/*
	     * formula para inserir de forma circular
	     * 
	     * tamanho + inicio
	     * quando o limite for < que tamanho + inicio
	     * (tamanho + inicio) - limite
	     * ou 
	     * (tamanho + inicio)%limite(resto da divisão)
	     * tamanho-1;
	     */
	
	    @SuppressWarnings("unchecked")
		private T[] info;
	    private int limite;
	    private int inicio;
	    private int tamanho;
	    
	    @SuppressWarnings("unchecked")
		public FilaVetor(int limite) {
	        this.info = (T[]) new Object[limite];
	        this.limite = limite;
	        this.tamanho = 0;
	        this.inicio = 0;
	    }
	    
	    @Override    
	    public void inserir(T v) {
	        if (limite == tamanho) {
	            throw new FilaCheiaException();
	        }
	        info[((inicio + tamanho) % limite)] = v;
	        tamanho++;
	    }
	    
	    public int getLimite() {
			return limite;
		}

	    @Override    
	    public boolean estaVazia() {
	        return (tamanho == 0);
	    }
	    
	    @Override    
	    public T peek() {
	        if (estaVazia())
	            throw new FilaVaziaException();
	        return info[inicio];
	    }
	    
	    @Override    
	    public T retirar() {
	        T backup = peek();
	        
	        info[inicio] = null;
	        inicio = (inicio+1) % limite;
	        tamanho--;
	        
	        return backup;
	    }
	    
	    
	    @SuppressWarnings("unchecked")
		@Override    
	    public void liberar() {
	        info = (T[]) new Object[limite];
	        tamanho = 0;
	        inicio = 0;
	    }
	    
	    
	    public FilaVetor<T> criarFilaConcatenada(FilaVetor<T> f2){
	        FilaVetor<T> nova = new FilaVetor<>(this.limite + f2.limite);
	        int indice = this.inicio;
	        for (int i = 0; i < tamanho; i++) {
	           nova.inserir(this.info[indice]);
	           indice = (indice+1)%limite;
	        }
	        indice = f2.inicio;
	        for (int i = 0; i < f2.tamanho; i++) {
	           nova.inserir(f2.info[indice]);
	           indice = (indice+1)%limite;
	        }
	        return nova;
	    }
	    
	    
		@Override    
	    public String toString() {
			String retorno = "";
			int indice = inicio;
	        for (int i = 0; i < this.tamanho; i++) {
	            if(i > 0) {
	            	retorno += ", "; 
	            }
	            retorno = retorno + info[indice].toString();
	            indice = (indice + 1) % limite;
	        }
	        
	        return retorno.toString();
	    }
		
		@SuppressWarnings("unchecked")
		public void encolher() {
			T[] novalistaFila = (T[]) new Object[tamanho]; //Ciração de um novo array com tamanho igual ao número de elementos da lista
			
			int indice = inicio; //crio a variavel indice que é inicializada para a posição de inicio
			int aux = 0;//crio  uma variavel auxiliar para rastrear a posição no novalistaFila
			
			while(aux < tamanho) { //este while copia os elementos do antigo array para o novalistaFila
				novalistaFila[aux] = info[indice]; //copia o elemento da posicao "indice" do array antigo para a posiçao "aux" do novo array
				indice = (indice + 1) % limite;//Atualiza o indice. Move para a proxima poxiçao e pode "circular" de volta caso seja necessário
				aux++;//incrementa a variável auxiliar("aux")
			}
			
			info = novalistaFila;// substitui o array antigo pelo novalistaFila que é o novo array encolhido
			limite = tamanho; //Utiliza o limite para armazenar o novo tamanho
			inicio = 0;//O indice é reiniciadp, voltando para 0
		}
		
}
	
	
	

