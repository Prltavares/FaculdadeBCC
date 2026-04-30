package Aula01;
import java.util.LinkedList;
import java.util.Queue;

public class Exe4 {

	    private Queue<String> fila = new LinkedList<>();

	    public void cadastrarAtendimento(String nome) {
	        fila.add(nome);
	        System.out.println("Atendimento cadastrado!");
	    }

	    public void removerAtendimento() {
	        if (fila.isEmpty()) {
	            System.out.println("Não há atendimentos remover!");
	            return;
	        }

	        System.out.println("Atendimento removido: " + fila.poll());
	    }

	    public void finalizar() {
	        System.out.println("Sistema finalizado!");
	    }

	    public Queue<String> getFila() {
	        return fila;
	    }

	    public void setFila(Queue<String> fila) {
	        this.fila = fila;
	    }
}
