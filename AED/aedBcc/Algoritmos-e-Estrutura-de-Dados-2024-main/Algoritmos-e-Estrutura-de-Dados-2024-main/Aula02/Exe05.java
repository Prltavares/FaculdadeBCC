package Aula02;
import java.util.HashMap;
import java.util.Map;

public class Exe05 {
	
	    private Map<String, Aluno> alunos = new HashMap<>();

	    private static class Aluno {
	        private String nome;
	        private boolean aprovado;

	        public Aluno(String nome, boolean aprovado) {
	            this.nome = nome;
	            this.aprovado = aprovado;
	        }

	        public String getNome() {
	            return nome;
	        }

	        public void setNome(String nome) {
	            this.nome = nome;
	        }

	        public boolean isAprovado() {
	            return aprovado;
	        }

	        public void setAprovado(boolean aprovado) {
	            this.aprovado = aprovado;
	        }
	    }

	    public void cadastrar(String nome, boolean aprovado) {
	        alunos.put(nome, new Aluno(nome, aprovado));
	    }

	    public void selecionar(String nome) {
	        Aluno aluno = alunos.get(nome);
	        if (aluno != null) {
	            System.out.println("Nome: " + aluno.getNome());
	            System.out.println("Aprovado: " + aluno.isAprovado());
	        } else {
	            System.out.println("Aluno não encontrado!");
	        }
	    }

	    public void alterar(String nome, boolean aprovado) {
	        Aluno aluno = alunos.get(nome);
	        if (aluno != null) {
	            aluno.setAprovado(aprovado);
	            System.out.println("Aluno alterado!");
	        } else {
	            System.out.println("Aluno não encontrado!");
	        }
	    }

	    public void excluir(String nome) {
	        Aluno aluno = alunos.remove(nome);
	        if (aluno != null) {
	            System.out.println("Aluno removido!");
	        } else {
	            System.out.println("Aluno não encontrado!");
	        }
	    }

	    public void estatisticas() {
	        int totalAlunos = alunos.size();
	        int totalAprovados = 0;
	        int totalReprovados = 0;

	        for (Aluno aluno : alunos.values()) {
	            if (aluno.isAprovado()) {
	                totalAprovados++;
	            } else {
	                totalReprovados++;
	            }
	        }

	        System.out.println("Estatísticas:");
	        System.out.println("Total de alunos: " + totalAlunos);
	        System.out.println("Total de aprovados: " + totalAprovados);
	        System.out.println("Total de reprovados: " + totalReprovados);
	    }

	    public Map<String, Aluno> getAlunos() {
	        return alunos;
	    }

	    public void setAlunos(Map<String, Aluno> alunos) {
	        this.alunos = alunos;
	    }

}
