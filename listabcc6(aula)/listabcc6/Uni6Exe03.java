import java.util.Scanner;

public class Uni6Exe03 {

    public static void main(String[] args) {
        double[] valores = new double[12];

        lerValores(valores);
        ajustarValores(valores);
        escreverValores(valores);
    }

    
    public static void lerValores(double[] vetor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 12 valores reais:");

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor[i] = sc.nextDouble();
        }
    }

  
    public static void ajustarValores(double[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            if (i % 2 == 0) {
                vetor[i] *= 1.02; 
            } else {
                vetor[i] *= 1.05; 
            }
        }
    }

    
    public static void escreverValores(double[] vetor) {
        System.out.println("\nValores atualizados:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.printf("Posição %d: %.2f\n", i, vetor[i]);
        }
    }
}
