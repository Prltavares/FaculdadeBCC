package Aula02;
import java.util.LinkedList;
import java.util.Scanner;

public class Exe04 {

	    private LinkedList<No> nomes = new LinkedList<>();

	    private static class No {
	        private String nome;
	        private No proximo;

	        public No(String nome) {
	            this.nome = nome;
	        }

	        public String getNome() {
	            return nome;
	        }

	        public void setNome(String nome) {
	            this.nome = nome;
	        }

	        public No getProximo() {
	            return proximo;
	        }

	        public void setProximo(No proximo) {
	            this.proximo = proximo;
	        }
	    }

	    public void cadastrar(String nome) {
	        No no = new No(nome);

	        if (nomes.isEmpty()) {
	            nomes.addFirst(no);
	        } else {
	            No ultimoNo = nomes.getLast();
	            ultimoNo.setProximo(no);
	            nomes.addLast(no);
	        }
	    }

	    public void listarTodosOsNomes() {
	        if (nomes.isEmpty()) {
	            System.out.println("Não há nomes para serem listados!");
	            return;
	        }

	        System.out.println("\nLista de todos os nomes:");
	        for (No no : nomes) {
	            System.out.println(no.getNome());
	        }
	    }

	    public void finalizar() {
	        System.out.println("Sistema finalizado!");
	    }

	    public LinkedList<No> getNomes() {
	        return nomes;
	    }

	    public void setNomes(LinkedList<No> nomes) {
	        this.nomes = nomes;
	    }

}
