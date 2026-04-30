package ListaEncadeada;

public class TesteListaEncadeadaCircular {
    public static void main(String[] args) {
        ListaEncadeadaCircular<Integer> lista = new ListaEncadeadaCircular<>();

        // Teste: Inserir elementos na lista
        lista.inserir(10);
        lista.inserir(20);
        lista.inserir(30);
        lista.inserir(40);
        lista.inserir(50);

        System.out.println("Lista após inserção de elementos:");
        System.out.println(lista);

        // Teste: Verificar comprimento
        System.out.println("Comprimento da lista: " + lista.obterComprimento());

        // Teste: Buscar elemento
        System.out.println("Buscando elemento 30: " + lista.buscar(30));
        System.out.println("Buscando elemento 99: " + lista.buscar(99));

        // Teste: Retirar elemento
        lista.retirar(30);
        System.out.println("Lista após retirar o elemento 30:");
        System.out.println(lista);

        // Teste: Verificar comprimento após remoção
        System.out.println("Comprimento da lista após remoção: " + lista.obterComprimento());

        // Teste: Obter elemento por índice
        try {
            System.out.println("Elemento na posição 2: " + lista.obterNo(2).getInfo());
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Erro ao obter elemento na posição 2: " + e.getMessage());
        }

        // Teste: Exibir lista inversa
        System.out.println("Lista inversa:");
        System.out.println(lista.exibirInverso());

        // Teste: Duplicado
        System.out.println("Índice do primeiro duplicado: " + lista.duplicado());

        // Teste: Lista vazia
        System.out.println("Lista está vazia? " + lista.estaVazia());

        // Teste: Liberar lista
        lista.liberar();
        System.out.println("Lista após liberar:");
        System.out.println(lista);
        System.out.println("Comprimento da lista após liberar: " + lista.obterComprimento());
        System.out.println("Lista está vazia? " + lista.estaVazia());
    }
}
