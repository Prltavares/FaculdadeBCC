import java.util.Scanner;

public class Uni4Exe24 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Valor 1: ");
        int a = scanner.nextInt();
        System.out.print("Valor 2: ");
        int b = scanner.nextInt();
        System.out.print("Valor 3: ");
        int c = scanner.nextInt();

      
        System.out.print("Opção (1 - Crescente, 2 - Decrescente, 3 - Maior no meio): ");
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1: 
                if (a > b) { int temp = a; a = b; b = temp; }
                if (a > c) { int temp = a; a = c; c = temp; }
                if (b > c) { int temp = b; b = c; c = temp; }
                System.out.println(a + " " + b + " " + c);
                break;

            case 2:
                if (a < b) { int temp = a; a = b; b = temp; }
                if (a < c) { int temp = a; a = c; c = temp; }
                if (b < c) { int temp = b; b = c; c = temp; }
                System.out.println(a + " " + b + " " + c);
                break;

            case 3:
                int menor = Math.min(a, Math.min(b, c));
                int maior = Math.max(a, Math.max(b, c));
                int meio = a + b + c - menor - maior; 
                System.out.println(menor + " " + maior + " " + meio);
                break;

            default:
                System.out.println("Opção inválida!");
        }

        scanner.close();
    }
}
