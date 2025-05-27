
import java.util.Scanner;

public class Uni4Exe09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("digite o primeiro numero inteiro");
        int num1 = teclado.nextInt();
        System.out.println("digite o segundo numero inteiro");
        int num2 = teclado.nextInt();

        if (num1 % num2 == 0 || num2 % num1 == 0) {
            System.out.println("os numeros são multiplos");
            } else {
                System.out.println("os numeros não são multiplos ");

            } 
            teclado.close();


    }
}
