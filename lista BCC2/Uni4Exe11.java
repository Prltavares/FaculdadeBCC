
import java.util.Scanner;

public class Uni4Exe11 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Idade do primeiro irmao");
         int idadeIrmao1 = teclado.nextInt();
         System.out.println("Idade do segundo irmao");
         int idadeIrmao2 =teclado.nextInt();
         System.out.println("Idade do terceiro irmao");
         int idadeIrmao3 = teclado.nextInt();

         if ( idadeIrmao1 == idadeIrmao2 && idadeIrmao2 == idadeIrmao3) {
            System.out.println("Trigêmeos");
         }else if (idadeIrmao1 == idadeIrmao2 || idadeIrmao1 == idadeIrmao3 || idadeIrmao2 == idadeIrmao3) {
          System.out.println(" gêmeos");
            }else {
            System.out.println("Apenas irmaos");

         }
         teclado.close();
    }
}

