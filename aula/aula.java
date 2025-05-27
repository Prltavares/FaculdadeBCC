
import java.util.Scanner;



public class aula {
  public static void main(String[] args) {
    Scanner teclado = new Scanner (System.in);
    System.out.println("Digite o comprimento");
    double comprimento = teclado.nextDouble();
    System.out.println("Digite a largura");
    double largura = teclado.nextDouble();
   
    double area = largura * comprimento;
  
    System.out.println("Área=" + area);
    teclado.close();
  }
}