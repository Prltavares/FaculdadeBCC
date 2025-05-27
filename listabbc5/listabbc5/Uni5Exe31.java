import java.util.Scanner;

public class Uni5Exe31 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um número inteiro positivo: ");
        int numero = scanner.nextInt();
        System.out.print(numero + " = ");

        int divisor = 2;
        while (numero > 1) {
            if (numero % divisor == 0) {
                System.out.print(divisor);
                numero /= divisor;
                if (numero > 1) {
                    System.out.print(" x ");
                }
            } else {
                divisor++;
            }
        }
        scanner.close();
    }
}
