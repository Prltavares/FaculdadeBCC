
import java.util.Scanner;

public class Uni4Exe12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("entre com o comprimento do lado 1");
        double lado1 = teclado.nextDouble();
        System.out.println("entre com o comprimento do lado 2");
        double lado2 = teclado.nextDouble();
        System.out.println("entre com o comprimento do lado 2");
        double lado3 = teclado.nextDouble();

        if (lado1 <(lado2 + lado3)&& lado2 <(lado1 + lado3 ) && lado3 < (lado1 + lado2)) {

        } else {
            System.out.println("os lados não formam um triâgulo");
        
        }
        if ( lado1 == lado2 && lado2 == lado3) {
            System.out.println("Triângulo equiátero");

        }else if ( lado1 == lado2 || lado1 == lado3 || lado2 == lado3){
            System.out.println("Triângulo isóceles");
        }else {
            System.out.println("Triângulo escaleno");
        }
        teclado.close();
    }
}

