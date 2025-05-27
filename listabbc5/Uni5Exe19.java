import java.util.Scanner;

public class Uni5Exe19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalRecebido = 0;

        while (true) {
            System.out.print("Valor da compra: ");
            double valor = sc.nextDouble();

            if (valor == 0) break;

            double desconto = (valor > 500) ? 0.2 : 0.15;
            double valorFinal = valor - (valor * desconto);
            totalRecebido += valorFinal;

            System.out.printf("Valor a pagar: R$%.2f\n", valorFinal);
        }

        System.out.printf("O valor total recebido foi de R$%.2f\n", totalRecebido);
        sc.close();
    }
}
