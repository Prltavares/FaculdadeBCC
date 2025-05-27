import java.util.Scanner;

public class Uni4Exe17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a renda anual: ");
        double rendaAnual = teclado.nextDouble();
        System.out.print("Digite a quantidade de dependentes: ");
        int dependentes = teclado.nextInt();

        double rendaLiquida = rendaAnual - (rendaAnual * (dependentes * 0.02));
        double imposto = 0;
        int percentual = 0;

        if (rendaLiquida > 10000) {
            imposto = rendaLiquida * 0.15;
            percentual = 15;
        } else if (rendaLiquida > 5000) {
            imposto = rendaLiquida * 0.10;
            percentual = 10;
        } else if (rendaLiquida > 2000) {
            imposto = rendaLiquida * 0.05;
            percentual = 5;
        }

        if (imposto > 0) {
            System.out.println("O imposto é de " + percentual + "%: R$ " + imposto);
        } else {
            System.out.println("Isento de imposto.");
        }

        teclado.close();
    }
}
