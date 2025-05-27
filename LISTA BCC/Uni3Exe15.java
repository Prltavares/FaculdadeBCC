
import java.util.Scanner;

public class Uni3Exe15 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("qual é o numero inteiro (até 3 digitos)");
        int numero =teclado.nextInt();
        int centenas = numero/100;
        
        int dezenas = (numero % 100) /10;

        int unidades = numero % 10;
        
        System.out.printf("%d centena(S) %d dezena(s) %d unidade(s)\n", centenas, dezenas, unidades);

        teclado.close();


    }
}
