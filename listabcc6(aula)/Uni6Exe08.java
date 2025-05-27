import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Uni6Exe08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int LIMITE = 20;

        System.out.print("Informe a quantidade de valores (máximo 20): ");
        int n = scanner.nextInt();
        
        if (n > LIMITE || n <= 0) {
            System.out.println("Quantidade inválida! Deve ser entre 1 e 20.");
            return;
        }

        double[] vetor = new double[n];

       
        for (int i = 0; i < n; i++) {
            System.out.print("Informe o valor para a posição " + (i + 1) + ": ");
            vetor[i] = scanner.nextDouble();
        }

       
        Map<Double, Integer> frequencia = new HashMap<>();

        for (int i = 0; i < n; i++) {
            double valor = vetor[i];
            frequencia.put(valor, frequencia.getOrDefault(valor, 0) + 1);
        }

       
        System.out.println("\nVALOR     FREQUÊNCIA");
        for (Map.Entry<Double, Integer> entrada : frequencia.entrySet()) {
            System.out.printf("%.2f     %d\n", entrada.getKey(), entrada.getValue());
        }

        scanner.close();
    }
}
