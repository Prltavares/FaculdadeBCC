import java.util.Scanner;

public class Uni4Exe13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite a primeira carta (1 = AS, 2 = 2, 3 = 3, 7 = 7, 11 = Valete, 12 = Dama, 13 = Rei): ");
        int carta1 = scanner.nextInt();

        System.out.print("Digite a segunda carta: ");
        int carta2 = scanner.nextInt();

        System.out.print("Digite a terceira carta: ");
        int carta3 = scanner.nextInt();

        
        int qtCartasBoas = 0;

        if (carta1 == 1 || carta1 == 2 || carta1 == 3) {
            qtCartasBoas++;
        }

        if (carta2 == 1 || carta2 == 2 || carta2 == 3) {
            qtCartasBoas++;
        }

        if (carta3 == 1 || carta3 == 2 || carta3 == 3) {
            qtCartasBoas++;
        }

        
        if (qtCartasBoas == 1) {
            System.out.println("TRUCO");
        } else if (qtCartasBoas == 2) {
            System.out.println("SEIS");
        } else if (qtCartasBoas == 3) {
            System.out.println("NOVE");
        }


        scanner.close();
    }
}