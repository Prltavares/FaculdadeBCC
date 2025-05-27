import java.util.Scanner;

public class Uni5Exe18 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int[] canais = {4, 5, 9, 12};
        int[] audiencias = new int[4];
        int totalPessoas = 0;

        while (true) {
            System.out.print("Canal (0 para sair): ");
            int canal = teclado.nextInt();

            if (canal == 0) {
                break;
            }

            System.out.print("Pessoas assistindo: ");
            int pessoas = teclado.nextInt();

            switch (canal) {
                case 4:
                    audiencias[0] += pessoas;
                    break;
                case 5:
                    audiencias[1] += pessoas;
                    break;
                case 9:
                    audiencias[2] += pessoas;
                    break;
                case 12:
                    audiencias[3] += pessoas;
                    break;
                default:
                    System.out.println("Canal inválido.");
            }

            totalPessoas += pessoas;
        }

        for (int i = 0; i < canais.length; i++) {
            if (totalPessoas > 0) {
                double percentual = (double) audiencias[i] / totalPessoas * 100;
                System.out.printf("Percentual de audiência do canal %d: %.0f%%\n", canais[i], percentual);
            } else {
                System.out.printf("Nenhuma audiência registrada para o canal %d\n", canais[i]);
            }
        }

        teclado.close();
    }
}
