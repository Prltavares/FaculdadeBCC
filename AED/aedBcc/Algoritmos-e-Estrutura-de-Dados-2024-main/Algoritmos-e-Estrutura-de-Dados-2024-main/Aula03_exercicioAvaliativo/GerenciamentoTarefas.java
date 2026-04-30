package Aula03_exercicioAvaliativo;
import java.util.LinkedList;
import java.util.Queue;


public class GerenciamentoTarefas {

	    private Queue<String> filaTarefas;

	    public GerenciamentoTarefas() {
	        filaTarefas = new LinkedList<>();
	    }

	    public void adicionarTarefa(String tarefa) {
	        filaTarefas.offer(tarefa);
	    }

	    public void concluirTarefa() {
	        if (!filaTarefas.isEmpty()) {
	            filaTarefas.poll();
	        } else {
	            System.out.println("Nenhuma tarefa pendente no momento.");
	        }
	    }

	    public String obterProximaTarefa() {
	        if (!filaTarefas.isEmpty()) {
	            return filaTarefas.peek();
	        } else {
	            return "Nenhuma tarefa pendente no momento.";
	        }
	    }

	    public void imprimirTarefas() {
	        System.out.println("Tarefas pendentes:");
	        for (String tarefa : filaTarefas) {
	            System.out.println("- " + tarefa);
	        }
	    }
}
