import java.util.Scanner;

public class Uni5Exe32 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o dia da semana do 1º dia do mês (1-Domingo, ..., 7-Sábado): ");
        int diaSemana = scanner.nextInt();
        System.out.print("Digite o número de dias do mês: ");
        int totalDias = scanner.nextInt();

        System.out.println("D  S  T  Q  Q  S  S");

        for (int i = 1; i < diaSemana; i++) {
            System.out.print("   ");
        }

        for (int dia = 1; dia <= totalDias; dia++) {
            System.out.printf("%2d ", dia);
            if ((dia + diaSemana - 1) % 7 == 0) {
                System.out.println();
            }
        }
        System.out.println();
        scanner.close();
    }
}
