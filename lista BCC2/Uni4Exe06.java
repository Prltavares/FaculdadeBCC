
import java.util.Scanner;

public class Uni4Exe06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite um caractere (M/F/I)");
        char genero = scanner.next().toUpperCase().charAt(0);

        switch (genero) {
            case 'M':
            System.out.println("Masculino");
            break;
            case 'F':
            System.out.println("Feminino");
            break;
            case 'I':
            System.out.println("não informado");
            break;
            default:
            System.out.println("Entrada incorreta");

        }
        scanner.close();
    }
}
