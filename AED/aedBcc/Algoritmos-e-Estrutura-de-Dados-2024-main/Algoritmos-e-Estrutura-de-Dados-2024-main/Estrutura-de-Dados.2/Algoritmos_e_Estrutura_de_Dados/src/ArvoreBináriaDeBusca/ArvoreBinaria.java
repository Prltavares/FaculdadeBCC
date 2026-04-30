package ArvoreBináriaDeBusca;

/**
 * @autor Larissa Zózimo Antunes
 */
public class ArvoreBinaria<T> extends ArvoreBinariaAbstract<T> {

    // Método para definir a raiz da árvore
    public void definirRaiz(NoArvoreBinaria<T> raiz) {
        super.setRaiz(raiz);
    }

    // Método para localizar um nó que armazena um determinado dado, retornando este nó
    public NoArvoreBinaria<T> procurar(T info) {
        return procurar(getRaiz(), info);
    }

    // Método auxiliar recursivo para procurar o nó contendo a informação passada por parâmetro, partindo de um determinado nó passado por parâmetro
    private NoArvoreBinaria<T> procurar(NoArvoreBinaria<T> no, T info) {
        if (no == null) { // Se o nó atual é nulo, significa que o dado não foi encontrado
            return null;
        } else {
            if (no.getInfo().equals(info)) { // Se o nó atual contém a informação procurada, retorna este nó
                return no;
            } else {
                NoArvoreBinaria<T> noEncontrado;

                // Continua a busca na subárvore esquerda
                noEncontrado = procurar(no.getEsquerda(), info);
                if (noEncontrado == null) {
                    // Se não encontrado na subárvore esquerda, continua a busca na subárvore direita
                    noEncontrado = procurar(no.getDireita(), info);
                }

                // Retorna o nó localizado, ou null se não encontrado
                return noEncontrado;
            }
        }
    }

	@Override
	public NoArvoreBinaria<T> buscar(T info) {
		// TODO Auto-generated method stub
		return null;
	}
}
