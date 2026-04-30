package ListaDuplamenteEncadeada;


public class teste<T> {

	public static void main(String[] args) {
        ListaDupla<Integer> lista = new ListaDupla<>();
        
        // Inserir valores na lista
        lista.inserir(5);
        lista.inserir(4);
        lista.inserir(15);
        lista.inserir(10);
        
        //prova
        ListaDupla<Integer> listaClonada = lista.clonar();
        NoListaDupla<Integer> atualClonado = listaClonada.getPrimeiro();

        while (atualClonado != null) {
            System.out.println("Valor da lista clonada: " + atualClonado.getInfo());
            atualClonado = atualClonado.getProximo();
        }
        
      //extra verifica duplicado
        int indiceDuplicado = lista.duplicado0();
        if (indiceDuplicado != -1) {
            System.out.println("Primeiro valor duplicado no índice: " + indiceDuplicado); // Deve imprimir 3
        } else {
            System.out.println("Não há valores duplicados na lista.");
        }
        
        //extra obter no
        try {
            NoListaDupla<Integer> no = lista.obterNo(0);
            System.out.println("Nó na posição: " + no.getInfo()); // Deve imprimir 10
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Posição inválida");
        }
        
        
        //tamanho da lista
        System.out.println("Tamanho da lista: " + lista.tamanho());
        
        //toString
        System.out.println("Lista: " + lista.toString());
        
        // Buscar um valor
        NoListaDupla<Integer> noEncontrado = lista.buscar(10);
        if (noEncontrado != null) {
            System.out.println("\nValor encontrado: " + noEncontrado.getInfo());
        } else {
            System.out.println("\nValor não encontrado.");
        }
        
        //Retirar Valor
        lista.retirar(10);
        System.out.println("Lista atualizada: " + lista);
        
        // Exibir a lista na ordem
        System.out.println("Lista na ordem: " + lista);
        
        // Exibir a lista na ordem inversa
        System.out.print("Lista na ordem inversa: ");
        lista.exibirOrdemInversa();
        
        //Liberar-Limpar a lista
        lista.liberar();
        System.out.println("Lista Liberada: " + lista);
        
       
    }
	
}
