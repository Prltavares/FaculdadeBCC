
import java.util.Scanner;

public class Uni3Exe05 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("digitar a quantidade de frangos que a granja possui");

        double qntFrango = teclado.nextDouble();
        double Valanelchip = 4.00;
        double ValanelAlimento = 3.50;
        double gastototal = qntFrango * (Valanelchip + 2 * ValanelAlimento);

        System.out.printf("O gasto total para marcar %.0f é %.1f\n",qntFrango,gastototal);

        teclado.close();
    }
}
