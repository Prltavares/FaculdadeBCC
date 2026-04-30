public class ListaEstaticaObject {
		
		private Object[] info;
		private int tamanho;

		//a
		public ListaEstaticaObject() {
			info = new Object[10];
			tamanho = 0;
		}
		
		//b
		private void redimensionar() {
			Object[] vet = new Object[info.length + 10];
			for (int i=0; i<info.length; i++) {
				vet[i] = info[i];
			}
			info = vet;
		}
		
		//c
		public void inserir(Object valor) {
			if (tamanho == info.length) {
				redimensionar();
			}
			info[tamanho] = valor;
			tamanho++;
		}
		
		//d
		public void exibir() {
			for (int i=0; i<tamanho; i++) {
				System.out.println(info[i]);
			}
		}
		
		//e
		public int buscar(Object valor) {
			for (int i=0; i<tamanho; i++) {
				if (info[i] == valor) {
					return i;
				}
			}
			
			return -1;
		}
		
		//f
		public void retirar(int valor) {
			int posicao = buscar(valor);
			
			if (posicao > -1) {
				for (int i=posicao; i<tamanho-1; i++) {
					info[i-1] = info[i];
				}
				tamanho--;
			}
		}
		
		//g
		public void liberar() {
			info = new Object[10];
			tamanho = 0;
		}
		
		//h
		public Object obterElemento(int posicao) {
			if (posicao >= 0 && (posicao < tamanho)) {
				return info[posicao];
			} else {
				throw new IndexOutOfBoundsException();
			}
		}
		
		//i
		public boolean estaVazia() {
			return tamanho==0;
		}
		
		//j
		public int getTamanho() {
			return tamanho;
		}
		
		//k
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
		
}

	

