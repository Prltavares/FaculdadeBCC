package Arvore;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
	import java.util.ArrayList;
	import java.util.List;

	public class Arvore <T>{
		private NoArvore<T> raiz;

	    public Arvore() {
	        raiz = null;
	    }

	    public void setRaiz(NoArvore<T> raiz) {
	        this.raiz = raiz;
	    }

	    public NoArvore<T> getRaiz() {
	        return raiz;
	    }

	    
	    public String toString() {
	        if (raiz != null) {
	            return obterRepresentacaoTextual(raiz);
	        }
	        return "";
	    }

	    private String obterRepresentacaoTextual(NoArvore<T> no) {
	        StringBuilder s = new StringBuilder("<");
	        s.append(no.getInfo());

	        NoArvore<T> p = no.getPrimeiro();
	        while (p != null) {
	            s.append(obterRepresentacaoTextual(p));
	            p = p.getProximo();
	        }
	        s.append(">");

	        return s.toString();
	    }



	    public boolean pertence(T info) {
	        if (raiz != null) {
	            return pertence(raiz, info);
	        }
	        return false;
	    }

	    private boolean pertence(NoArvore<T> no, T info) {
	        if (no.getInfo().equals(info)) {
	            return true; // O dado foi encontrado na árvore.
	        }

	        // Verificar em todos os filhos do nó atual.
	        NoArvore<T> filho = no.getPrimeiro();
	        while (filho != null) {
	            if (pertence(filho, info)) {
	                return true; // O dado foi encontrado em um dos filhos.
	            }
	            filho = filho.getProximo();
	        }

	        return false; // O dado não foi encontrado na árvore.
	    }

	    public int contarNos() {
	        if (raiz != null) {
	            return contarNos(raiz);
	        }
	        return 0; // A árvore está vazia.
	    }

	    private int contarNos(NoArvore<T> no) {
	        int qtd = 1; // Inicializa com 1 para contar o próprio nó.
	        
	        // Itera sobre os filhos do nó atual e adiciona o número de nós em cada subárvore.
	        NoArvore<T> filho = no.getPrimeiro();
	        while (filho != null) {
	            qtd += contarNos(filho);
	            filho = filho.getProximo();
	        }

	        return qtd;
	    }
	    
	    //extra 
	    public int profundidade(T info) {
	        return profundidade(raiz, info, 0);
	    }

	    private int profundidade(NoArvore<T> no, T info, int depth) {
	        if (no == null) {
	            return -1; // O nó não foi encontrado na árvore.
	        }

	        if (no.getInfo().equals(info)) {
	            return depth; // O nó foi encontrado, retorna a profundidade.
	        }

	        // Tenta encontrar o nó nos filhos do nó atual.
	        NoArvore<T> filho = no.getPrimeiro();
	        while (filho != null) {
	            int profundidadeFilho = profundidade(filho, info, depth + 1);
	            if (profundidadeFilho != -1) {
	                return profundidadeFilho; // O nó foi encontrado em um dos filhos.
	            }
	            filho = filho.getProximo();
	        }

	        return -1; // O nó não foi encontrado na árvore.
	    }
	    
	    public int contarFolhas() {
	        if (raiz != null) {
	            return contarFolhas(raiz);
	        }
	        return 0; // A árvore está vazia.
	    }

	    private int contarFolhas(NoArvore<T> no) {
	        if (no == null) {
	            return 0;
	        }

	        if (no.getPrimeiro() == null) {
	            return 1; // O nó é uma folha, pois não possui filhos.
	        }

	        int folhas = 0;

	        // Itera sobre os filhos do nó atual e conta as folhas em cada subárvore.
	        NoArvore<T> filho = no.getPrimeiro();
	        while (filho != null) {
	            folhas += contarFolhas(filho);
	            filho = filho.getProximo();
	        }

	        return folhas;
	    }
	    
	    public String emOrdem(NoArvore<T> no) {
	        if (no == null) {
	            return "";
	        }

	        StringBuilder resultado = new StringBuilder();
	        resultado.append(no.getInfo()).append(" ");

	        NoArvore<T> filho = no.getPrimeiro();
	        while (filho != null) {
	            resultado.append(emOrdem(filho));
	            filho = filho.getProximo();
	        }

	        return resultado.toString();
	    }

}
