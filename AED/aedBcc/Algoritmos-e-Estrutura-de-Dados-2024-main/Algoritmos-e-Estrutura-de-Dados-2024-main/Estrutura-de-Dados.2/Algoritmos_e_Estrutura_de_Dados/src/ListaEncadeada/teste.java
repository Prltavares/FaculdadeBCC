package ListaEncadeada;

import ListaDuplamenteEncadeada.ListaDupla;

public class teste<T> {
        public static void main(String[] args) {

                ListaEncadeada<Integer> lista = new ListaEncadeada<>();

                // Inserir valores na lista
                lista.inserir(5);
                lista.inserir(4);
                lista.inserir(15);
                lista.inserir(10);

                System.out.println(lista.obterComprimento());
                System.out.println(lista.exibirInverso());
                System.out.println(lista.toString());

                ListaDupla<Integer> lista2 = new ListaDupla<>();

                // Inserir valores na lista
                lista2.inserir(5);
                lista2.inserir(4);
                lista2.inserir(15);
                lista2.inserir(10);

                // tamanho da lista
                System.out.println("Tamanho da lista: " + lista2.tamanho());

                // toString
                System.out.println("Lista: " + lista2.toString());
        }
}
