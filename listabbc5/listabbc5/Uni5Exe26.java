import java.util.Scanner;

public class Uni5Exe26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int acima = 0, total = 0, aceitos150 = 0;
        double valorMax = sc.nextDouble();

        while (true) {
            double pedagio = sc.nextDouble();
            if (pedagio < 0) break;
            int distancia = sc.nextInt();
            total++;
            if (pedagio > valorMax) {
                acima++;
            } else if (distancia > 150) {
                aceitos150++;
            }
        }

        System.out.println(acima + " (trechos com valor acima do qual ele nega-se a pagar)");
        System.out.println(total + " (quantidade de trechos informados)");
        System.out.println(aceitos150 + " (trechos acima de 150km com valor aceito por ele)");
    }
}
