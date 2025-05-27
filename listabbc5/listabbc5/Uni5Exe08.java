import java.util.Scanner;

public class Uni5Exe08 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        
        System.out.print("Digite o número de elementos (n): ");
        int n = teclado.nextInt();

        
        int menorNegativo = Integer.MAX_VALUE; 
        int somaPositivos = 0;
        int quantidadePositivos = 0;

        
        for (int i = 1; i <= n; i++) {
            System.out.print("Digite o número " + i + ": ");
            int numero = teclado.nextInt();

            
            if (numero < 0 && numero < menorNegativo) {
                menorNegativo = numero;
            }

            
            if (numero > 0) {
                somaPositivos += numero;
                quantidadePositivos++;
            }
        }

        
        if (menorNegativo != Integer.MAX_VALUE) {
            System.out.println("Menor valor negativo: " + menorNegativo);
        } else {
            System.out.println("Não há valores negativos.");
        }

        if (quantidadePositivos > 0) {
            double mediaPositivos = (double) somaPositivos / quantidadePositivos;
            System.out.println("Média dos números positivos: " + mediaPositivos);
        } else {
            System.out.println("Não há números positivos.");
        }

        teclado.close();
    }
}
