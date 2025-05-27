import java.util.Scanner;

public class Uni5Exe34 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalHospedes = 0;

        while (true) {
            System.out.println("1. Encerrar conta de um hóspede");
            System.out.println("2. Verificar número de contas encerradas");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            if (opcao == 1) {
                scanner.nextLine(); // limpa buffer
                System.out.print("Nome do hóspede: ");
                String nome = scanner.nextLine();
                System.out.print("Número de diárias: ");
                int diarias = scanner.nextInt();
                double taxaServico;

                if (diarias < 15) {
                    taxaServico = 7.5;
                } else if (diarias == 15) {
                    taxaServico = 6.5;
                } else {
                    taxaServico = 5.0;
                }

                double total = diarias * 50 + taxaServico * diarias;
                System.out.printf("%s deve pagar: R$ %.2f\n", nome, total);
                totalHospedes++;

            } else if (opcao == 2) {
                System.out.println("Número de contas encerradas: " + totalHospedes);
            } else if (opcao == 3) {
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        scanner.close();
    }
}
