import java.util.Scanner;

public class Uni4Exe19 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite o valor de x: ");
        double x = teclado.nextDouble();

        System.out.print("Digite o valor de y: ");
        double y = teclado.nextDouble();

        if (x == 0 && y == 0) {
            System.out.println("0");
        } else if (x > 0 && y > 0) {
            System.out.println("1");
        } else if (x < 0 && y > 0) {
            System.out.println("2");
        } else if (x < 0 && y < 0) {
            System.out.println("3");
        } else if (x > 0 && y < 0) {
            System.out.println("4");
        } else {
            System.out.println("O ponto está sobre um dos eixos.");
        }

        teclado.close();
    }
}