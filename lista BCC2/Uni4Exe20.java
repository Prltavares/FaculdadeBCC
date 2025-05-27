import java.util.Scanner;

public class Uni4Exe20 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a nota da prova 1: ");
        double notaProva1 = teclado.nextDouble();

        System.out.print("Digite a nota da prova 2: ");
        double notaProva2 = teclado.nextDouble();

        System.out.print("Digite a nota da prova 3: ");
        double notaProva3 = teclado.nextDouble();

        System.out.print("Digite a nota dos exercícios: ");
        double notaExercicios = teclado.nextDouble();

        double media = (notaProva1 + notaProva2 * 2 + notaProva3 * 3 + notaExercicios) / 7;

        String conceito;
        String situacao;

        if (media >= 9.0) {
            conceito = "A";
            situacao = "Aprovado";
        } else if (media >= 7.5) {
            conceito = "B";
            situacao = "Aprovado";
        } else if (media >= 6.0) {
            conceito = "C";
            situacao = "Aprovado";
        } else if (media >= 4.0) {
            conceito = "D";
            situacao = "Reprovado";
        } else {
            conceito = "E";
            situacao = "Reprovado";
        }

        System.out.printf("A média de aproveitamento foi: %.2f. Conceito: %s. %s\n", media, conceito, situacao);

        teclado.close();
    }
}