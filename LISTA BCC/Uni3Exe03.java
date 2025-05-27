
import java.util.Scanner;

public class Uni3Exe03 {
    public static void main(String[] args) {
     
    Scanner teclado = new Scanner(System.in);
    System.out.println("digitar o preço do litro da gasolina");
    double PreçoLitro = teclado.nextDouble();
    System.out.println("digitar o valor que quer pagar na gasolina");
    double ValorPagar =teclado.nextDouble();
    double litros = ValorPagar / PreçoLitro;
    System.out.printf("O motorista conseguiu colocar: %.2f litros.\n", litros);


    teclado.close();

    
    }
}
