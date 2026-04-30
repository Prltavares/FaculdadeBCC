public class ListaTest {
	
	public static void main(String[] args) {
		ListaEstaticaProva<Integer> lista = new ListaEstaticaProva<>();
		
		lista.inserir(10);
	    lista.inserir(20);
	    lista.inserir(30);
	    lista.inserir(40);
	    lista.inserir(50);
		lista.inverter();
		lista.exibir();
		
		
        System.out.println("Lista antes da inserção:");
        lista.exibir();

        // Inserir elemento na posição 2
        lista.inserir(2, 99);

        System.out.println("\nLista após inserir 99 na posição 2:");
        lista.exibir();

        // Inserir elemento na primeira posição livre (posição 6)
        lista.inserir(6, 88);

        System.out.println("\nLista após inserir 88 na posição 6:");
        lista.exibir();

        // Tentativa de inserção em uma posição inválida (deve lançar exceção)
        try {
            lista.inserir(8, 77);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("\nExceção ao tentar inserir na posição 8: " + e.getMessage());
        }

        // Inserir elemento na posição 0
        lista.inserir(0, 5);

        System.out.println("\nLista após inserir 5 na posição 0:");
        lista.exibir();
    }	
}
