public class main {
	public static void main(String[] args) {
		ListaDupla<Integer> lista = new ListaDupla<>();
		System.out.println("\nCaso 1: Inclusão de dados e consistência das ligações");
		lista.inserir(5);
		lista.inserir(10);
		lista.inserir(15);
		lista.inserir(20);
		System.out.println("Ordem direta: " + lista);
		System.out.print("Ordem inversa: ");
		lista.exibirOrdemInversa();

		System.out.println("\nCaso 2: Buscar elemento no início");
		NoListaDupla<Integer> noBusca20 = lista.buscar(20);
		System.out.println("Buscar(20): " + (noBusca20 != null ? noBusca20.getInfo() : "null"));

		System.out.println("\nCaso 3: Buscar elemento no meio");
		NoListaDupla<Integer> noBusca10 = lista.buscar(10);
		System.out.println("Buscar(10): " + (noBusca10 != null ? noBusca10.getInfo() : "null"));

		System.out.println("\nCaso 4: Remover elemento no início (20)");
		lista.retirar(20);
		System.out.println("Ordem direta após retirar 20: " + lista);
		System.out.print("Ordem inversa: ");
		lista.exibirOrdemInversa();

		System.out.println("\nCaso 5: Remover elemento no meio (10)");
		lista.retirar(10);
		System.out.println("Ordem direta após retirar 10: " + lista);
		System.out.print("Ordem inversa: ");
		lista.exibirOrdemInversa();

		System.out.println("\nCaso 6: Remover elemento no fim (5)");
		lista.retirar(5);
		System.out.println("Ordem direta após retirar 5: " + lista);
		System.out.print("Ordem inversa: ");
		lista.exibirOrdemInversa();

		System.out.println("\nCaso 7: Liberar dados da lista");
		lista.liberar();
		System.out.println("Lista após liberar: " + lista);
	}
}
