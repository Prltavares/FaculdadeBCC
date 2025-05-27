import java.util.Scanner;

public class  ex3 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("informe um texto para ser convertido:");
        String texto = teclado.nextLine();

     while (texto.length() != 0 && !texto.isBlank()) {
            System.out.println(texto. toUpperCase());
            
            System.out.println("informe um texto para ser convertido:");
            texto = teclado.nextLine();
        }
        
    }
}