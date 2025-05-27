
import java.util.Scanner;

public class Uni3Exe16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("digite o valor total da compra");
        int valorCompra = teclado.nextInt();
        System.out.println("digite o valor dado pelo cliente");
        int valorDado = teclado.nextInt();
        int troco = valorDado - valorCompra;

        int notas100 = troco/100;
        troco = troco % 100;
        int notas10 = troco/10;
        troco = troco % 10;

        int notas1 = troco;

        System.out.printf("O número mínimo de notas de troco é: %d\n", (notas100 + notas10+ notas1));
        System.out.printf("Quantidade de notas de 100 necessárias é: %d\n", notas100);
        System.out.printf("quantidade de notas de 10 necessárias é: %d\n", notas10);
        System.out.printf("quantidade de notas de 1 necessárias é: %d\n", notas1);

        teclado.close();
    }
}
