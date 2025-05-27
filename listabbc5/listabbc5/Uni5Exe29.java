import java.util.Scanner;

public class Uni5Exe29 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int valor = sc.nextInt();
        int[] cedulas = {20, 10, 5, 2, 1};
        for (int cedula : cedulas) {
            int qtd = valor / cedula;
            valor %= cedula;
            System.out.println("Notas de " + cedula + ": " + qtd);
        }
    }
}
