
import java.util.Scanner;

public class Uni3Exe13 {
    
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("altura da parede");
        double Alturaparede = teclado.nextDouble();

        System.out.println("comprimento da parede");
        double comprimentoparede = teclado.nextDouble();

        double Mtqdr = Alturaparede * comprimentoparede;
        double preçoazulejo = 12.50;
        double totalazulejos = Mtqdr * 9;

        double valorfinal = totalazulejos * preçoazulejo;
        
        System.out.printf("O valor final é R$%.2f\n", valorfinal);
        
                teclado.close();
            }
        
            }

