public class main {
	public static void main(String[] args) {
		ListaEncadeada<Integer> lista = new ListaEncadeada<>();

		// Caso 1: Verificar se é reconhecida lista vazia
		System.out.println("Caso 1: " + (lista.estaVazia() == true));

		// Caso 2: Verificar se é reconhecida lista não vazia
		lista.inserir(5);
		System.out.println("Caso 2: " + (lista.estaVazia() == false));

		// Caso 3: Validar inclusão de um número
		System.out.println("Caso 3: " + (lista.getPrimeiro().getInfo() == 5 && lista.getPrimeiro().getProximo() == null));

		// Caso 4: Validar inclusão de 3 números
		lista = new ListaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		System.out.println("Caso 4: " + (lista.getPrimeiro().getInfo() == 5 && lista.getPrimeiro().getProximo().getInfo() == 10 && lista.getPrimeiro().getProximo().getProximo().getInfo() == 15));

		// Caso 5: Validar busca de dados na primeira posição
		lista = new ListaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		System.out.println("Caso 5: " + (lista.buscar(20) != null && lista.buscar(20).getInfo() == 20));

		// Caso 6: Validar busca de dados no meio da lista
		System.out.println("Caso 6: " + (lista.buscar(15) != null && lista.buscar(15).getInfo() == 15));

		// Caso 7: Validar busca de dado inexistente
		System.out.println("Caso 7: " + (lista.buscar(50) == null));

		// Caso 8: Validar exclusão do primeiro elemento da lista
		lista = new ListaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.retirar(20);
		System.out.println("Caso 8: " + (lista.obterComprimento() == 3 && lista.buscar(20) == null));

		// Caso 9: Validar exclusão do elemento do meio da lista
		lista = new ListaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		lista.retirar(15);
		System.out.println("Caso 9: " + (lista.obterComprimento() == 3 && lista.buscar(15) == null));

		// Caso 10: Validar que obterNo() retorna nó da posição 0
		lista = new ListaEncadeada<>();
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		System.out.println("Caso 10: " + (lista.obterNo(0) != null && lista.obterNo(0).getInfo() == 5));

		// Caso 11: Validar que obterNo() retorna nó da última posição
		System.out.println("Caso 11: " + (lista.obterNo(3) != null && lista.obterNo(3).getInfo() == 20));

		// Caso 12: Validar que obterNo() recusa tentativa de ler posição inválida
		boolean caso12 = false;
		try {
			NoLista<Integer> n = lista.obterNo(10);
			caso12 = (n == null);
		} catch (Exception e) {
			caso12 = true;
		}
		System.out.println("Caso 12: " + caso12);

		// Caso 13: Validar método obterComprimento() para lista vazia
		lista = new ListaEncadeada<>();
		System.out.println("Caso 13: " + (lista.obterComprimento() == 0));

		// Caso 14: Validar método obterComprimento() para lista não vazia
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		System.out.println("Caso 14: " + (lista.obterComprimento() == 4));
	}
}
