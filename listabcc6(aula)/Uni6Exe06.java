import java.util.Scanner;

public class Uni6Exe06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Informe o tamanho do vetor (N): ");
        int N = sc.nextInt();

       
        double[] vetor = new double[N];

        
        preencherVetor(vetor);

        
        System.out.print("Informe um valor real para verificar se existe no vetor: ");
        double valor = sc.nextDouble();

        
        if (verificarValor(vetor, valor)) {
            System.out.println("O valor " + valor + " está presente no vetor.");
        } else {
            System.out.println("O valor " + valor + " não está presente no vetor.");
        }

        sc.close();
    }

    public static void preencherVetor(double[] vetor) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe " + vetor.length + " valores reais para preencher o vetor:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Valor " + (i + 1) + ": ");
            vetor[i] = sc.nextDouble();
        }
    }


    public static boolean verificarValor(double[] vetor, double valor) {
        for (double num : vetor) {
            if (num == valor) {
                return true;
            }
        }
        return false;
    }
}
