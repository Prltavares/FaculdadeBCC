import java.util.Scanner;

public class Uni5Exe27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            int dia = sc.nextInt();
            if (dia < 1 || dia > 30) {
                System.out.println("Dia inválido");
                continue;
            }
            int manha = sc.nextInt();
            int tarde = sc.nextInt();
            double valor = 0;
            if (dia <= 15) {
                int total = manha + tarde;
                if (total > 100) valor = total * 0.8;
                else valor = total * 0.5;
            } else {
                valor = manha * 0.4 + tarde * 0.3;
            }
            System.out.printf("R$ %.2f (valor recebido)\n", valor);
            System.out.println("Novo funcionário: (1.sim 2.não)?");
            int novo = sc.nextInt();
            if (novo == 2) break;
        }
    }
}