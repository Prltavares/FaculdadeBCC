import java.util.Scanner;

public class Uni5Exe16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        double somaAlturaMulheres = 0;
        int contMulheres = 0;

        double somaAlturaGrupo = 0;
        int contGrupo = 0;

        while (true) {
            System.out.print("Altura (0 para sair): ");
            double altura = teclado.nextDouble();
            if (altura == 0) {
                break;
            }

            System.out.print("Gênero (M/F/O): ");
            char genero = teclado.next().charAt(0);

            somaAlturaGrupo += altura;
            contGrupo++;

            if (genero == 'F' || genero == 'f') {
                somaAlturaMulheres += altura;
                contMulheres++;
            }
        }

        if (contMulheres > 0) {
            double mediaMulheres = somaAlturaMulheres / contMulheres;
            System.out.printf("A média da altura das mulheres é: %.2f\n", mediaMulheres);
        } else {
            System.out.println("Nenhuma mulher no grupo.");
        }

        if (contGrupo > 0) {
            double mediaGrupo = somaAlturaGrupo / contGrupo;
            System.out.printf("A média de altura do grupo é: %.2f\n", mediaGrupo);
        } else {
            System.out.println("Nenhuma pessoa no grupo.");
        }

        teclado.close();
    }
}
