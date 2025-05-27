
import java.util.Scanner;

public class Uni3Exe10 {
    public static void main(String[] args) {
    
    
    Scanner teclado = new Scanner(System.in);
    System.out.println("Valor cateto oposto");
    Double ValorCateto = teclado.nextDouble();
    System.out.println("Valor cateto adjacente");
    Double ValorcatetoAdj = teclado.nextDouble();
    Double hipotenusa = Math.sqrt(Math.pow(ValorCateto,2) + Math.pow(ValorcatetoAdj, 2));
    System.out.printf("O Valor da hipotenusa é %.2f\n", hipotenusa);

    teclado.close();
    }

}
