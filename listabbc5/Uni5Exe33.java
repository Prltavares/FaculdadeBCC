import java.util.Scanner;

public class Uni5Exe33 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] votos = new int[7]; // índice 1-6 usados
        int voto;

        do {
            System.out.print("Digite seu voto (1-4 candidatos, 5 nulo, 6 branco, 0 para sair): ");
            voto = scanner.nextInt();
            if (voto >= 0 && voto <= 6) {
                if (voto != 0) {
                    votos[voto]++;
                }
            } else {
                System.out.println("Opção incorreta");
            }
        } while (voto != 0);

        int total = 0;
        for (int i = 1; i <= 6; i++) {
            total += votos[i];
        }

        for (int i = 1; i <= 4; i++) {
            System.out.println("Total de votos do candidato " + i + ": " + votos[i]);
        }
        System.out.println("Total de votos nulos: " + votos[5]);
        System.out.println("Total de votos em branco: " + votos[6]);

        if (total > 0) {
            double percentualNuloBranco = ((double)(votos[5] + votos[6]) / total) * 100;
            System.out.printf("Percentual de nulos e brancos: %.2f%%\n", percentualNuloBranco);
        }

        scanner.close();
    }
}
