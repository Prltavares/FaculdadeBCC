import java.util.Scanner;

public class Uni5Exe05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int n;
        do {
            System.out.print("Digite o valor de n (maior que 2): ");
            n = teclado.nextInt();
        } while (n <= 2);

        int par = 8;
        int impar = 10;

        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) { 
                System.out.print(par + " ");
                par *= 2;
            } else { 
                System.out.print(impar + " ");
                impar += 8;
            }
        }

        teclado.close();
    }
}
