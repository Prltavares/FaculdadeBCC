
import java.util.Scanner;

public class Uni3Exe11 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("temperatura em °C");
        Double celsius = teclado.nextDouble();
        double fahrenheit = (9.0/5) *  celsius + 32;
        System.err.printf("a temperatura em Fahrenheit é %.2f\n", fahrenheit);

        teclado.close();

    }
}
