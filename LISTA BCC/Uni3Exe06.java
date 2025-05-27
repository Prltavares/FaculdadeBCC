
import java.util.Scanner;

public class Uni3Exe06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Digite o peso do prato montado por você, em KG:");
        double pesototal = teclado.nextDouble();
        double pesoComida = pesototal - 0.75;
        double valorTotal = pesoComida * 25;
        System.out.printf("o valor do prato do cliente é  R$%.2f\n", valorTotal);

        teclado.close();






    }
}
