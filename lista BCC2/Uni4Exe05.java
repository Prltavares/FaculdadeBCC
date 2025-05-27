
import java.util.Scanner;

public class Uni4Exe05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("a cor é azul?");
        boolean resposta = scanner.nextBoolean();
        if (resposta) {
            System.err.println("sim");
        } else {
            System.err.println("não");

        }
        scanner.close();
        }

    }

