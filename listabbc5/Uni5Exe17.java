import java.util.Scanner;

public class Uni5Exe17 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        int inscricaoMaisAlto = 0, inscricaoMaisBaixo = 0, numero;
        double alturaMaisAlto = 0, alturaMaisBaixo = Double.MAX_VALUE;
        double somaAlturas = 0;
        int totalAtletas = 0;

        while (true) {
            System.out.print("Nº de inscrição: ");
            numero = teclado.nextInt();

            if (numero == 0) {
                break;
            }

            System.out.print("Altura: ");
            double altura = teclado.nextDouble();

            somaAlturas += altura;
            totalAtletas++;

            if (altura > alturaMaisAlto) {
                alturaMaisAlto = altura;
                inscricaoMaisAlto = numero;
            }

            if (altura < alturaMaisBaixo) {
                alturaMaisBaixo = altura;
                inscricaoMaisBaixo = numero;
            }
        }

        if (totalAtletas > 0) {
            double media = somaAlturas / totalAtletas;

            System.out.printf("O atleta mais baixo tem %.2fm e o seu número de inscrição é %d\n", alturaMaisBaixo, inscricaoMaisBaixo);
            System.out.printf("O atleta mais alto tem %.2fm e o seu número de inscrição é %d\n", alturaMaisAlto, inscricaoMaisAlto);
            System.out.printf("A altura média do grupo de atletas é: %.2f\n", media);
        } else {
            System.out.println("Nenhum atleta informado.");
        }

        teclado.close();
    }
}
