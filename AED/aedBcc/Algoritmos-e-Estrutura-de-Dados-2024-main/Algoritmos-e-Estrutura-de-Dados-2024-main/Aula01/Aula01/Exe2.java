
public class Exe2 {
	private String[] nomes = new String[10];
	private int tamanho = 0;

	public void cadastrar(String nome) {
		if (tamanho < 10) {
			nomes[tamanho++] = nome;
			System.out.println("Cadastrado!");
		} else {
			System.out.println("Aramazenamento cheio!");
		}
	}

	public void listarNomes() {
		for (int i = 0; i < tamanho; i++) {
			System.out.println("Lista de nomes: " + nomes[i]);
		}
	}

	public void alterar(int indice, String novoNome) {
		if (indice >= 0 && indice <= tamanho) {
			nomes[indice] = novoNome;
			System.out.println("Nome alterado!");
		} else {
			System.out.println("Indice inv�lido");
		}

	}

	public void remover(int indice) {
		if (indice >= 0 && indice <= tamanho) {
			for (int i = indice; i < tamanho - 1; i++) {
				nomes[i] = nomes[i + 1];
			}
			tamanho--;
			System.out.println("Nome removido!");
		} else {
			System.out.println("Indice invalido!");
		}

	}

	public void finalizar() {
		System.out.println("Programa finalizado!");
		System.exit(0);
	}
}
