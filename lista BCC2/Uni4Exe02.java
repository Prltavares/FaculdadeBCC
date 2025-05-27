
import java.util.Scanner;

public class Uni4Exe02 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("entre com um valor inteiro maior do que 0:");
        int Valorint = scanner.nextInt();
        if (Valorint <=0) {
            System.err.println("O valor deve ser maior que 0");
        } else {

        if(Valorint % 2==0) {
         System.err.println("o  numero é par");

        } else {
             System.err.println("o numero é impar");


        }
    }

    scanner.close();
}
}

        

  
