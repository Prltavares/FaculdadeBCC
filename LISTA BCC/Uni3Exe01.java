import java.util.Scanner;

public class Uni3Exe01 { 


    public static void main(String[] args) {


        Scanner teclado = new Scanner(System.in);

        System.out.println("digite o comprimento do terreno");
        double comprimento = teclado.nextDouble();
        System.out.println("Digite a largura do terreno");
        double largura = teclado.nextDouble();
        double area = largura * comprimento;
        System.out.println("Área=" + area); 
        teclado.close();
        

    

    }
}