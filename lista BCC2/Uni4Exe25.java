import java.util.Scanner;

public class Uni4Exe25 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

     
        System.out.println("Escolha uma opção:");
        System.out.println("1 - Soma de dois números.");
        System.out.println("2 - Diferença entre dois números.");
        System.out.println("3 - Produto entre dois números.");
        System.out.println("4 - Divisão entre dois números.");

       
        System.out.print("Opção: ");
             int opcao = scanner.nextInt();

    
        System.out.print("Valor 1: ");
             double num1 = scanner.nextDouble();
        System.out.print("Valor 2: ");
            double num2 = scanner.nextDouble();

       
        switch (opcao) {
            case 1:
            System.out.println("Resultado: " + (num1 + num2));
                break;
            case 2:
            System.out.println("Resultado: " + (num1 - num2));
                break;
            case 3:
            System.out.println("Resultado: " + (num1 * num2));
                break;
            case 4:
                if (num2 != 0) {
            System.out.println("Resultado: " + (num1 / num2));
                } else {
            System.out.println("Erro: divisão por zero não permitida!");
                }
                break;
            default:
            System.out.println("Erro: opção inválida!");
        }

        scanner.close();
    }
}
