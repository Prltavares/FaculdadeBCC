import java.util.Scanner;

public class Uni3Exe14 {
    public static void main(String[] args) {
        
    Scanner teclado = new Scanner(System.in);
    System.out.println("Distancia percorrida(km)");
    double Distancia = teclado.nextDouble();
    System.out.println("tempo percorrido(hrs)");
    double tempo = teclado.nextDouble();
    double velocidade = Distancia / tempo;
    double combustivelgasto = Distancia / 12;
    
    System.out.printf("a velociade media foi de %.2f km/h e a quantidade de combustivel usado foi %.2f\n", velocidade, combustivelgasto);
 teclado.close();
    }
}
