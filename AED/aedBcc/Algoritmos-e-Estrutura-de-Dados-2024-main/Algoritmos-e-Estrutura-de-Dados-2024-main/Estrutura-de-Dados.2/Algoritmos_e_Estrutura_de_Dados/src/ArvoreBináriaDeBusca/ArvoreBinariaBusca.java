package ArvoreBináriaDeBusca;

/**
 * @autor Larissa Zózimo Antunes
 */
public class ArvoreBinariaBusca<T extends Comparable<T>> extends ArvoreBinariaAbstract<T> {
    
    // Método para inserir um novo nó na árvore binária com o valor fornecido
    public void inserir(T info) {
        NoArvoreBinaria<T> novoNo = new NoArvoreBinaria<>(info); // Cria um novo nó com o valor fornecido
        
        if (estaVazia()) { // Se a árvore estiver vazia, define o novo nó como raiz
            setRaiz(novoNo);
        } else {
            NoArvoreBinaria<T> atual = getRaiz(); // Pega a raiz atual da árvore
            NoArvoreBinaria<T> paiAtual;
            
            while (true) {
                paiAtual = atual; // Mantém uma referência ao pai do nó atual
                if (info.compareTo(atual.getInfo()) < 0) { // Se o valor é menor que o valor do nó atual
                    atual = atual.getEsquerda(); // Move para o filho esquerdo
                    if (atual == null) { // Se o filho esquerdo é nulo, insere o novo nó aqui
                        paiAtual.setEsquerda(novoNo);
                        return; // Sai do método após inserir o nó
                    }
                } else { // Se o valor é maior ou igual ao valor do nó atual
                    atual = atual.getDireita(); // Move para o filho direito
                    if (atual == null) { // Se o filho direito é nulo, insere o novo nó aqui
                        paiAtual.setDireita(novoNo);
                        return; // Sai do método após inserir o nó
                    }
                }
            }
        }
    }

    // Método para buscar um nó que contém o valor fornecido
    public NoArvoreBinaria<T> buscar(T info) {
        NoArvoreBinaria<T> atual = getRaiz(); // Começa a busca a partir da raiz
        
        while (atual != null && !atual.getInfo().equals(info)) { // Enquanto não encontrar o nó ou alcançar o final da árvore
            if (info.compareTo(atual.getInfo()) < 0) // Se o valor é menor que o valor do nó atual
                atual = atual.getEsquerda(); // Move para o filho esquerdo
            else 
                atual = atual.getDireita(); // Move para o filho direito
        }
        
        return atual; // Retorna o nó encontrado ou null se não encontrar
    }

    // Método auxiliar para remover o sucessor de um nó (usado na remoção de um nó com dois filhos)
    private NoArvoreBinaria<T> extrairSucessor(NoArvoreBinaria<T> no) {
        NoArvoreBinaria<T> atual = no.getDireita(); // Começa a partir do filho direito do nó a ser removido
        NoArvoreBinaria<T> paiDoSucessor = no;
        NoArvoreBinaria<T> sucessor = no;
        
        while (atual != null) { // Encontra o menor valor na subárvore direita
            paiDoSucessor = sucessor;
            sucessor = atual;
            atual = atual.getEsquerda();
        }
        
        if (sucessor != no.getDireita()) { // Ajusta as referências para manter a integridade da árvore
            paiDoSucessor.setEsquerda(sucessor.getDireita());
            sucessor.setDireita(no.getDireita());
        }
        
        return sucessor; // Retorna o sucessor
    }

    // Método para remover um nó que contém o valor fornecido
    public void retirar(T info) {
        NoArvoreBinaria<T> atual = getRaiz(); // Começa a busca a partir da raiz
        NoArvoreBinaria<T> paiAtual = null;
        boolean filhoEsquerdo = false;
        
        // Localiza o nó a ser removido
        while (atual != null && !atual.getInfo().equals(info)) {
            paiAtual = atual;
            
            if (info.compareTo(atual.getInfo()) < 0) { // Se o valor é menor que o valor do nó atual
                filhoEsquerdo = true;
                atual = atual.getEsquerda(); // Move para o filho esquerdo
            } else {
                filhoEsquerdo = false;
                atual = atual.getDireita(); // Move para o filho direito
            }
        }
        
        if (atual != null) { // Se encontrou o nó a ser removido
            // Avalia se o nó é folha
            if (atual.getEsquerda() == null && atual.getDireita() == null) {
                // Caso 1: Nó folha
                if (atual == getRaiz()) {
                    setRaiz(null); // Se é a raiz, remove a raiz
                } else {
                    if (filhoEsquerdo) {
                        paiAtual.setEsquerda(null); // Remove o nó folha ajustando a referência do pai
                    } else {
                        paiAtual.setDireita(null);
                    }
                }                
            } else if (atual.getDireita() == null) {
                // Caso 2: Nó com apenas um filho à esquerda
                if (atual == getRaiz()) {
                    setRaiz(atual.getEsquerda()); // Ajusta a raiz se necessário
                } else {
                    if (filhoEsquerdo) {
                        paiAtual.setEsquerda(atual.getEsquerda()); // Ajusta a referência do pai
                    } else {
                        paiAtual.setDireita(atual.getEsquerda());
                    }
                }                    
            } else if (atual.getEsquerda() == null) {
                // Caso 2: Nó com apenas um filho à direita
                if (atual == getRaiz()) {
                    setRaiz(atual.getDireita()); // Ajusta a raiz se necessário
                } else {
                    if (filhoEsquerdo) {
                        paiAtual.setEsquerda(atual.getDireita()); // Ajusta a referência do pai
                    } else {
                        paiAtual.setDireita(atual.getDireita());
                    }
                }                        
            } else {
                // Caso 3: Nó com filhos à esquerda e à direita
                NoArvoreBinaria<T> sucessor = extrairSucessor(atual); // Encontra o sucessor
                if (atual == getRaiz()) {
                    setRaiz(sucessor); // Ajusta a raiz se necessário
                } else {
                    if (filhoEsquerdo) {
                        paiAtual.setEsquerda(sucessor); // Ajusta a referência do pai
                    } else {
                        paiAtual.setDireita(sucessor);
                    }
                }
                sucessor.setEsquerda(atual.getEsquerda()); // Ajusta a referência do filho esquerdo do sucessor
            }
        }
    }
}
