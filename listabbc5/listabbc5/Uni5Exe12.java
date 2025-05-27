import java.util.Scanner;

public class Uni5Exe12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o número de linhas (n): ");
        int n = scanner.nextInt();
        
        System.out.println("\nTriângulo de Floyd com " + n + " linhas:");
        
        int numero = 1; 
        
        for (int linha = 1; linha <= n; linha++) {
            for (int coluna = 1; coluna <= linha; coluna++) {
                System.out.print(numero + " ");
                numero++;
            }
            System.out.println(); 
        }
        
        scanner.close();
    }
}