
import java.util.Scanner;

public class Uni3Exe07 {
public static void main(String[] args) {
    Scanner teclado = new Scanner(System.in);

System.out.println("quantidade de latas de 350ml");
int qntlata350 = teclado.nextInt();

System.out.println("quantidade de garrafas de 650ml");
int qntgarrafa650 = teclado.nextInt();

System.out.println("quantidades de garrafas de 2L");
int qntgarrafa2L = teclado.nextInt();

Double qntdeLt= ( (qntlata350 * 0.35) + (qntgarrafa650 * 0.65) + (qntgarrafa2L * 2.0 ));

System.out.printf("quantidade de Litros comprados é %.2f\n ", qntdeLt);
}
}
