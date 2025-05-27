
import java.util.Scanner;

public class Uni3Exe08 {
public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);
    System.out.println("quantos dolares você quer trocar?");
    double Valortrocar = teclado.nextDouble();
    System.out.println("valor da cotação do dolar");
    double cotaçãodolar = teclado.nextDouble();
    double valorReais = Valortrocar * cotaçãodolar;
    System.out.printf("o atendente deve devolver R$%.2f para o cliente.\n",valorReais);
    
    teclado.close();

}
}
