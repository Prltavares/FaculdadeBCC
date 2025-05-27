import java.util.Scanner;

public class Uni5Exe06 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        double somaAlturas = 0;
        int quantidadePessoas = 20;

        
        for (int i = 1; i <= quantidadePessoas; i++) {
            System.out.print("Altura da pessoa " + i + ": ");
            double altura = teclado.nextDouble();
            somaAlturas += altura; 
        }

      
        double mediaAlturas = somaAlturas / quantidadePessoas;

        
        System.out.println("A média das alturas é: " + mediaAlturas);

        teclado.close();
    }
}
