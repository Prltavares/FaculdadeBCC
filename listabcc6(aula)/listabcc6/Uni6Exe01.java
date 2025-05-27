import java.util.Scanner;

public class Uni6Exe01 {

    public static void main(String[] args) {
        int[] numeros = new int[10];

        lerNumeros(numeros);
        escreverInverso(numeros);
    }

  
    public static void lerNumeros(int[] vetor) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite 10 números inteiros:");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Número " + (i + 1) + ": ");
            vetor[i] = sc.nextInt();
        }
    }

    public static void escreverInverso(int[] vetor) {
        System.out.println("\nNúmeros em ordem inversa:");
        for (int i = vetor.length - 1; i >= 0; i--) {
            System.out.println(vetor[i]);
        }
    }
}
