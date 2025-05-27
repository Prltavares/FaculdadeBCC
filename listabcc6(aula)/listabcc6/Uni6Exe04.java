import java.util.Scanner;

public class Uni6Exe04 {

    public static void main(String[] args) {
        final int TAM = 10;
        int[] vetor1 = new int[TAM];
        int[] vetor2 = new int[TAM];
        int[] vetor3 = new int[TAM];

        lerVetor(vetor1, "Vetor 1");
        lerVetor(vetor2, "Vetor 2");

        somarVetores(vetor1, vetor2, vetor3);

        System.out.println("\n--- Resultados ---");
        mostrarVetor(vetor1, "Vetor 1");
        mostrarVetor(vetor2, "Vetor 2");
        mostrarVetor(vetor3, "Vetor Soma");
    }

   
    public static void lerVetor(int[] vetor, String nome) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite os valores do " + nome + ":");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(nome + "[" + i + "]: ");
            vetor[i] = sc.nextInt();
        }
    }

    
    public static void somarVetores(int[] v1, int[] v2, int[] v3) {
        for (int i = 0; i < v1.length; i++) {
            v3[i] = v1[i] + v2[i];
        }
    }

   
    public static void mostrarVetor(int[] vetor, String nome) {
        System.out.print(nome + ": ");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }
}
