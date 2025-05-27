import java.util.Scanner;

public class Uni3Exe04 {
    public static void main(String[] args) {
     
    Scanner teclado = new Scanner(System.in);
    System.out.println("digitar notas do aluno"); 

    double nota1 = teclado.nextDouble();
    double nota2 = teclado.nextDouble();
    double nota3 = teclado.nextDouble();

    double mediaPonderada = ((nota1 * 5) + (nota2 * 3) + (nota3 * 2 )) / 10;
    System.out.printf("a media ponderada do aluno é %.2f\n", mediaPonderada);

    teclado.close();


    }

}