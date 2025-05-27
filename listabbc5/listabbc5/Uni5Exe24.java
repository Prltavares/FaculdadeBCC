import java.util.Scanner;

public class Uni5Exe24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String continuar;
        double pesoTotal = 0;

        do {
            System.out.print("Peso do peixe (em Kg): ");
            double peso = sc.nextDouble();
            pesoTotal += peso;

            if (pesoTotal > 50) {
                System.out.println("Limite de peso excedido. Peixe desclassificado.");
                break;
            }

            System.out.print("Deseja digitar os dados de mais um peixe? (SIM/NÃO): ");
            continuar = sc.next();
        } while (continuar.equalsIgnoreCase("SIM"));

        System.out.printf("Peso total da pesca: %.2f Kg\n", pesoTotal);
        sc.close();
    }
}
