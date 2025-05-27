import java.util.Scanner;

public class Uni5Exe01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        for (int i = 1; i <= 20; i++) {
            System.out.print("Digite o " + i + "º número: ");
            int numero = input.nextInt();

            if (numero % 2 == 0) {
                System.out.println("Par");
            } else {
                System.out.println("Ímpar");
            }
        }

        input.close();
    }
}
