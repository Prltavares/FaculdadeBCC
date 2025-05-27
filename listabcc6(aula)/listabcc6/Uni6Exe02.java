import java.util.Scanner;

public class Uni6Exe02 {

    public static void main(String[] args) {
        double[] valores = new double[12];

        lerValores(valores);

        double media = calcularMedia(valores);

        exibirMaioresQueMedia(valores, media);
    }

   
    public static void lerValores(double[] vetor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite 12 valores reais:");

        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor[i] = sc.nextDouble();
        }
    }

    
    public static double calcularMedia(double[] vetor) {
        double soma = 0;
        for (double valor : vetor) {
            soma += valor;
        }
        return soma / vetor.length;
    }


    public static void exibirMaioresQueMedia(double[] vetor, double media) {
        System.out.println("\nMédia dos valores: " + media);
        System.out.println("Valores maiores que a média:");

        for (double valor : vetor) {
            if (valor > media) {
                System.out.println(valor);
            }
        }
    }
}
