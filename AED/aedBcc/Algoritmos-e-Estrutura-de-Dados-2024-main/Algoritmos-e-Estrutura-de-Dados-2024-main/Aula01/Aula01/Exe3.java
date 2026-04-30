import java.util.ArrayList;
import java.util.List;

public class Exe3 {

	private List<Produto> produtos = new ArrayList<>();

	public void adicionarProduto(String nome, double preco) {
		produtos.add(new Produto(nome, preco));
	}

	public void listarProdutos() {
		for (Produto produto : produtos) {
			System.out.println(produto);
		}
	}

	public void pesquisarProdutos(String termo) {
		System.out.println("Resultados da pesquisa: " + termo);
		for (Produto produto : produtos) {
			if (produto.getNome().contains(termo)) {
				System.out.println(produto);
			}
		}
	}

	public void atualizarProduto(String nomeAntigo, String novoNome, double novoPreco) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			if (produto.getNome().equals(nomeAntigo)) {
				produtos.set(i, new Produto(novoNome, novoPreco));
				System.out.println("Produto atualizado");
				return;
			}
		}
		System.out.println("Produto n�o encontrado");
	}

	public void removerProduto(String nome) {
		for (int i = 0; i < produtos.size(); i++) {
			Produto produto = produtos.get(i);
			if (produto.getNome().equals(nome)) {
				produtos.remove(i);
				System.out.println("Produto removido");
				return;
			}
		}
		System.out.println("Produto n�o encontrado");
	}

	public void finalizar() {
		System.out.println("Sistema fechado");
		System.exit(0);
	}

	public static class Produto {
		private String nome;
		private double preco;

		public Produto(String nome, double preco) {
			this.nome = nome;
			this.preco = preco;
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public double getPreco() {
			return preco;
		}

		public void setPreco(double preco) {
			this.preco = preco;
		}

		@Override
		public String toString() {
			return "Produto{" +
					"nome='" + nome + '\'' +
					", preco=" + preco +
					'}';
		}
	}
}
