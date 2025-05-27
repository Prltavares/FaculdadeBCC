
import java.util.Scanner;


public class Uni4Exe04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.err.println("entre com um número de ponto flutuante maior que 0:");
        double numero = scanner.nextDouble();
        if (numero <= 0 ){
        System.err.println("O numero tem que ser maior que 0:");
        } else { 
            double parteDecimal = numero - (int) numero;
            if (parteDecimal > 0) { 
                System.err.println("Casas decimais foram digitadas");
            } else {
                System.err.println("Casas decimais não foram digitadas");
            }

        }
        scanner.close();

    }

}