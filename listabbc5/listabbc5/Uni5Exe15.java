import java.util.Scanner;

public class Uni5Exe15 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        while (true) {
            System.out.print("Nome do aluno: ");
            String nome = teclado.nextLine();

            if (nome.equalsIgnoreCase("fim")) {
                break;
            }

            System.out.print("Nota 1: ");
            double nota1 = teclado.nextDouble();
            System.out.print("Nota 2: ");
            double nota2 = teclado.nextDouble();
            teclado.nextLine(); // limpar o buffer

            double media = (nota1 + nota2) / 2;
            System.out.printf("A média do(a) %s é %.1f\n", nome, media);
        }

        teclado.close();
    }
}
