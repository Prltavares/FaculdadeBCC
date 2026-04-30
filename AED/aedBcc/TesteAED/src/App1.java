public class App1 {
	public static void main(String [] args) {
		ListaEstaticaL1 lista = new ListaEstaticaL1();

        lista.inserirOrdenado(20);
        lista.inserirOrdenado(10);
        lista.inserirOrdenado(30);
        lista.inserirOrdenado(5);

        lista.exibir(); // Deve exibir: 5, 10, 20, 30
	}
}
