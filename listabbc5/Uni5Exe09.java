import java.util.Scanner;

public class Uni5Exe09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

       
        System.out.print("Digite o número de alunos (n): ");
        int n = teclado.nextInt();
        teclado.nextLine(); 

        
        String nomes18Anos = "";
        int quantidadeAcima20Anos = 0;

        
        for (int i = 1; i <= n; i++) {
            System.out.print("Nome: ");
            String nome = teclado.nextLine();
            System.out.print("Idade: ");
            int idade = teclado.nextInt();
            teclado.nextLine(); 

            
            if (idade == 18) {
                if (!nomes18Anos.isEmpty()) {
                    nomes18Anos += " e ";
                }
                nomes18Anos += nome;
            }

            
            if (idade > 20) {
                quantidadeAcima20Anos++;
            }
        }

        
        if (!nomes18Anos.isEmpty()) {
            System.out.println("Nomes dos alunos que tem 18 anos: " + nomes18Anos);
        } else {
            System.out.println("Não há alunos com 18 anos.");
        }

        System.out.println("Quantidade de alunos que tem idade acima de 20 anos: " + quantidadeAcima20Anos);

        teclado.close();
    }
}
