import java.util.Scanner;

public class Uni5Exe30 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int M = sc.nextInt();
        int somaMochila = 0, somaFora = 0;
        String dentro = "", fora = "";

        for (int i = N; i > 0; i -= K) {
            if (somaMochila + i <= M) {
                somaMochila += i;
                dentro += i + " ";
            } else {
                somaFora += i;
                fora += i + " ";
            }
        }

        System.out.println("Entraram na mochila: " + dentro);
        System.out.println("Ficaram fora da mochila: " + fora);
        System.out.println("Soma dos que entraram: " + somaMochila);
        System.out.println("Soma dos que ficaram fora: " + somaFora);
    }
}
