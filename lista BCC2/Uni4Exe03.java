
import java.util.Scanner;

public class Uni4Exe03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("digite o primeiro numero inteiro");
        int numint1 = scanner.nextInt();
        System.err.println("digite o segundo numero inteiro");
        int numint2 = scanner.nextInt();

        if (numint1 > numint2) {
        System.err.println(" o valor " + numint1 + " é maior do que o valor" + numint2);
         } else if (numint2 > numint1) {
            System.err.println("o valor " + numint2 + " é maior do que o valor" + numint1);

         }else {
            System.err.println("os valores são iguais");
         }
        scanner.close();
    }
}