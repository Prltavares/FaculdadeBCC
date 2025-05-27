
import java.util.Scanner;

public class Uni4Exe10 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("qual é a idade de marquinhos?");
        int idadeDeMarquinhos = teclado.nextInt();
        System.out.println("qual é a idade de zezinho?");
        int idadeDeZezinho = teclado.nextInt();
        System.out.println("qual é a idade de Luluzinha?");
        int idadeDeLuluzinha = teclado.nextInt();
         

       if ( idadeDeMarquinhos < idadeDeZezinho && idadeDeMarquinhos< idadeDeLuluzinha) {
        System.out.println(" o marquinhos é caçula");
        
       }else if (idadeDeZezinho < idadeDeMarquinhos && idadeDeZezinho < idadeDeLuluzinha)
       System.out.println("o zezinho é caçula");
       else {
        System.out.println("Luluzinha é a caçula");
       }
       teclado.close();
    }
}
