
import java.util.Scanner;

public class Uni3Exe02 {
    public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("digite o valor do par de sapatos:");
    double precoSapato =teclado.nextDouble();
    double desconto = precoSapato * 12/100;
    double precoFinal = precoSapato - desconto;
    System.out.printf("O valor do desconto é de R$%.2f\n", desconto);
    System.out.printf("O preço do par de sapatos com desconto é R$%.2f\n", precoFinal);

    teclado.close();
    
    }
}
