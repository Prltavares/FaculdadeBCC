import java.util.Scanner;

public class Uni5Exe23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String opcao;
        
        do {
            System.out.print("Nome do vendedor: ");
            String nome = sc.next();
            double totalVendas = 0;

            System.out.print("Número de produtos vendidos: ");
            int n = sc.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.print("Valor do produto " + i + ": ");
                double valor = sc.nextDouble();
                totalVendas += valor;
            }

            double salario = totalVendas * 0.3;
            System.out.printf("Nome: %s | Total vendido: R$%.2f | Salário: R$%.2f\n", nome, totalVendas, salario);

            System.out.print("Deseja digitar os dados de mais um vendedor? (SIM/NÃO): ");
            opcao = sc.next();
        } while (opcao.equalsIgnoreCase("SIM"));

        sc.close();
    }
}
