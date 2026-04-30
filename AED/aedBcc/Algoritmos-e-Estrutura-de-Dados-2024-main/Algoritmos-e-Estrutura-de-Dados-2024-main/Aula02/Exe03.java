package Aula02;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exe03 {
	
	public class Produtos {
	    private List<Map<String, String>> produtos = new ArrayList<>();
	    private Map<String, Integer> segmentos = new HashMap<>();

	    public void cadastrar(String nome, String segmento) {
	        if (!segmentos.containsKey(segmento)) {
	            segmentos.put(segmento, 1);
	        } else {
	            segmentos.put(segmento, segmentos.get(segmento) + 1);
	        }

	        Map<String, String> produto = new HashMap<>();
	        produto.put("nome", nome);
	        produto.put("segmento", segmento);
	        produtos.add(produto);
	        System.out.println("Produto cadastrado!");
	    }

	    public void selecionarTodosOsRegistros() {
	        if (produtos.isEmpty()) {
	            System.out.println("Não há produtos para serem selecionados!");
	            return;
	        }

	        System.out.println("\nSeleção de todos os produtos:");
	        for (Map<String, String> produto : produtos) {
	            System.out.println(produto);
	        }
	    }

	    public void quantidadeDeSegmentos() {
	        if (segmentos.isEmpty()) {
	            System.out.println("Não há segmentos para serem exibidos!");
	            return;
	        }

	        System.out.println("\nQuantidade de segmentos:");
	        for (Map.Entry<String, Integer> entry : segmentos.entrySet()) {
	            System.out.println("Segmento: " + entry.getKey() + ", Quantidade: " + entry.getValue());
	        }
	    }

	    public void alterarDados(String nomeAntigo, String nomeNovo, String segmento) {
	        boolean alterado = false;
	        for (int i = 0; i < produtos.size(); i++) {
	            Map<String, String> produto = produtos.get(i);
	            if (produto.get("nome").equals(nomeAntigo)) {
	                produto.put("nome", nomeNovo);
	                alterado = true;
	                System.out.println("Produto alterado!");
	                break;
	            }
	        }

	        if (!alterado) {
	            System.out.println("Produto não encontrado!");
	        }
	    }

	    public void remover(String nome) {
	        boolean removido = false;
	        for (int i = 0; i < produtos.size(); i++) {
	            Map<String, String> produto = produtos.get(i);
	            if (produto.get("nome").equals(nome)) {
	                produtos.remove(i);
	                removido = true;
	                System.out.println("Produto removido!");
	                break;
	            }
	        }

	        if (!removido) {
	            System.out.println("Produto não encontrado!");
	        }
	    }

	    public List<Map<String, String>> getProdutos() {
	        return produtos;
	    }

	    public void setProdutos(List<Map<String, String>> produtos) {
	       
	    }
	}
}
