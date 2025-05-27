import java.util.Scanner;

public class Uni5Exe07 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        
        System.out.print("Digite o número de elementos (n): ");
        int n = teclado.nextInt();

        
        double maiorNumero = Double.MIN_VALUE;
        double menorNumero = Double.MAX_VALUE;

        
        for (int i = 1; i <= n; i++) {
            System.out.print("Digite o número " + i + ": ");
            double numero = teclado.nextDouble();

            
            if (numero > maiorNumero) {
                maiorNumero = numero;
            }
            if (numero < menorNumero) {
                menorNumero = numero;
            }
        }

        
        System.out.println("Maior número: " + maiorNumero);
        System.out.println("Menor número: " + menorNumero);

        teclado.close();
    }
}
