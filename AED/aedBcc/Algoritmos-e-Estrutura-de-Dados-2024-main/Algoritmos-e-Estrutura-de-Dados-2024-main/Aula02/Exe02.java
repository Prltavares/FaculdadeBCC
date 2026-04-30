package Aula02;
import java.util.Vector;

public class Exe02 {

	    private Vector<String> registros = new Vector<>();

	    public void cadastrar(String registro) {
	        if (!registros.contains(registro)) {
	            registros.add(registro);
	            System.out.println("Registro cadastrado!");
	        } else {
	            System.out.println("Registro já cadastrado!");
	        }
	    }

	    public void selecionarTodosOsRegistros() {
	        if (registros.isEmpty()) {
	            System.out.println("Não há registros para serem selecionados!");
	            return;
	        }

	        System.out.println("\nSeleção de todos os registros:");
	        for (String registro : registros) {
	            System.out.println(registro);
	        }
	    }

	    public void pesquisarTermo(String termo) {
	        if (registros.isEmpty()) {
	            System.out.println("Não há registros para serem pesquisados!");
	            return;
	        }

	        System.out.println("\nPesquisa por termo: " + termo);
	        for (String registro : registros) {
	            if (registro.contains(termo)) {
	                System.out.println(registro);
	            }
	        }
	    }

	    public void alterarDados(String antigoRegistro, String novaRegistro) {
	        if (registros.contains(antigoRegistro)) {
	            int index = registros.indexOf(antigoRegistro);
	            registros.set(index, novaRegistro);
	            System.out.println("Registro alterado!");
	        } else {
	            System.out.println("Registro não encontrado!");
	        }
	    }

	    public void remover(String registro) {
	        if (registros.contains(registro)) {
	            registros.remove(registro);
	            System.out.println("Registro removido!");
	        } else {
	            System.out.println("Registro não encontrado!");
	        }
	    }

	    public Vector<String> getRegistros() {
	        return registros;
	    }

	    public void setRegistros(Vector<String> registros) {
	        this.registros = registros;
	    }

}
