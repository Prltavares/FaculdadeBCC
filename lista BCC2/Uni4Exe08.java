
import java.util.Scanner;

public class Uni4Exe08 {
   public static void main(String[] args) {
       Scanner teclado = new Scanner(System.in);
       System.out.println("infome a letra");
       char letra = teclado.next().charAt(0);
       letra =Character.toLowerCase(letra);
       if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') {
        System.out.println("é vogal");
       }
         else {
            System.out.println("não é vogal");
    
         }

         teclado.close();





   } 
}
