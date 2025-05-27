import java.util.Scanner;

public class  ex2 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("informe a quantidade de vezes que deseja executar");
        int qtdVezes = teclado.nextInt();

        int contagem = 0;

        while (contagem <= qtdVezes) {
            System.out.println("valor da contagem: " + contagem);
            contagem++;
        }
        teclado.close();

    }

}