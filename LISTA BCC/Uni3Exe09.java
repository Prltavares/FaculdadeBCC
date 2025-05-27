
import java.util.Scanner;

public class Uni3Exe09 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("valor do Raio");
        Double ValorRaio = teclado.nextDouble();
        System.out.println("Valor da Altura");
        Double ValorAltura = teclado.nextDouble();
        double ValorPi = Math.PI;
        Double valorVolume = ValorPi * Math.pow(ValorRaio, 2) *ValorAltura;
        System.out.printf("o volume da lata de óleo é %.2f\n", valorVolume);
        
        teclado.close();



    }
}
