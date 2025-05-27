import java.util.Scanner;

public class Uni5Exe20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Massa inicial (em Kg): ");
        double massa = sc.nextDouble();

        double massaFinal = massa;
        int tempo = 0;

        while (massaFinal >= 0.5) {
            massaFinal /= 2;
            tempo += 50;
        }

        System.out.printf("Massa final: %.3f Kg\n", massaFinal);
        System.out.println("Tempo necessário: " + tempo + " segundos");
        sc.close();
    }
}
