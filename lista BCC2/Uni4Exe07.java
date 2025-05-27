import java.util.Scanner;

public class Uni4Exe07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Entre com o peso da carta (em gramas): ");
        double peso = scanner.nextDouble();

        double valorPagar = 0.45; 
        if (peso > 50) {
            double pesoExcedido = peso - 50; 
            int adicional = (int) (pesoExcedido / 20); 
            if (pesoExcedido % 20 != 0) { 
                adicional++;
            }
            valorPagar += 0.45 * adicional; 

        System.out.printf("Custo do selo: %.2f\n", valorPagar);

        scanner.close();
    }
}
}