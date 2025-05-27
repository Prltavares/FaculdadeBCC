import java.util.Scanner;

public class Uni4Exe26 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

      
        System.out.println("Escolha uma opção:");
        System.out.println("T: calcular a área de um triângulo de base b e altura h");
        System.out.println("Q: calcular a área de um quadrado de lado l");
        System.out.println("R: calcular a área de um retângulo de base b e altura h");
        System.out.println("C: calcular a área de um círculo de raio r");

      
        System.out.print("Opção: ");
        char opcao = scanner.next().charAt(0);

        
        switch (opcao) {
            case 'T':
            case 't':
                System.out.print("Digite a base do triângulo: ");
                double baseT = scanner.nextDouble();
                System.out.print("Digite a altura do triângulo: ");
                double alturaT = scanner.nextDouble();
                double areaT = (baseT * alturaT) / 2;
                System.out.println("Área do triângulo = " + areaT);
                break;

            case 'Q':
            case 'q':
                System.out.print("Digite o lado do quadrado: ");
                double ladoQ = scanner.nextDouble();
                double areaQ = ladoQ * ladoQ;
                System.out.println("Área do quadrado = " + areaQ);
                break;

            case 'R':
            case 'r':
                System.out.print("Digite a base do retângulo: ");
                double baseR = scanner.nextDouble();
                System.out.print("Digite a altura do retângulo: ");
                double alturaR = scanner.nextDouble();
                double areaR = baseR * alturaR;
                System.out.println("Área do retângulo = " + areaR);
                break;

            case 'C':
            case 'c':
                System.out.print("Digite o raio do círculo: ");
                double raioC = scanner.nextDouble();
                double areaC = Math.PI * Math.pow(raioC, 2);
                System.out.println("Área do círculo = " + areaC);
                break;

            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}
