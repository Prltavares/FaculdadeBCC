public class Main {

    public static void main(String[] args) {

        ListaEstatica lista = new ListaEstatica();

        // Caso 1
        lista.inserir(5);
        lista.inserir(10);
        lista.inserir(15);
        lista.inserir(20);

        System.out.println("Caso 1: " + lista.toString()); // 5,10,15,20

        // Caso 2
        System.out.println("Caso 2: " + lista.getTamanho()); // 4

        // Caso 3
        System.out.println("Caso 3: " + lista.buscar(15)); // 2

        // Caso 4
        System.out.println("Caso 4: " + lista.buscar(30)); // -1

        // Caso 5
        lista.retirar(10);
        System.out.println("Caso 5 toString: " + lista.toString()); // 5,15,20
        System.out.println("Caso 5 tamanho: " + lista.getTamanho()); // 3

        // Caso 6 (forçar redimensionamento)
        ListaEstatica lista2 = new ListaEstatica();
        for (int i = 1; i <= 15; i++) {
            lista2.inserir(i);
        }
        System.out.println("Caso 6: " + lista2.toString());
        System.out.println("Caso 6 tamanho: " + lista2.getTamanho());

        // Caso 7
        ListaEstatica lista3 = new ListaEstatica();
        lista3.inserir(5);
        lista3.inserir(10);
        lista3.inserir(15);
        lista3.inserir(20);

        System.out.println("Caso 7: " + lista3.obterElemento(3)); // 20

        // Caso 8 (Exceção)
        try {
            System.out.println(lista3.obterElemento(5));
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Caso 8: Exceção lançada corretamente.");
        }

        // Caso 9
        lista3.liberar();
        System.out.println("Caso 9 (estaVazia): " + lista3.estaVazia()); // true
    }
}