
import java.util.Scanner;

public class EXvetor2 {

    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);

        System.out.println("informe a quantidade de noems que você...");
        
        int qntNomes = teclado.nextInt();

        String[] nomes = new String[qntNomes];
        
        for (int idx = 0; idx < nomes.length; idx++) {

        System.out.println("Digite o nome para a posição[" + idx + "]");
        String Nome = teclado.next();
        nomes[idx] = Nome;

        }


        for (int idx = 0; idx < nomes.length; idx++){
            System.out.println("nome da posição");
        }       

        System.out.println("FIM");
    }
}