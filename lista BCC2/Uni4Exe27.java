import java.util.Scanner;

public class Uni4Exe27 { 

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        
        System.out.print("Digite a hora de chegada (0-23): ");
        int horaChegada = scanner.nextInt();
        System.out.print("Digite o minuto de chegada (0-59): ");
        int minChegada = scanner.nextInt();

       
        System.out.print("Digite a hora de partida (0-23): ");
        int horaSaida = scanner.nextInt();
        System.out.print("Digite o minuto de partida (0-59): ");
        int minSaida = scanner.nextInt();

       
        if (horaChegada < 0 || horaChegada > 23 || minChegada < 0 || minChegada > 59 ||
            horaSaida < 0 || horaSaida > 23 || minSaida < 0 || minSaida > 59) {
            System.out.println("Dados de entrada inválidos!");
          
        }

        
        int tempoChegada = horaChegada * 60 + minChegada;
        int tempoSaida = horaSaida * 60 + minSaida;
        int tempoEstacionamento = tempoSaida - tempoChegada;

       
        int horasEstacionamento;
        if (tempoEstacionamento <= 29) {
            horasEstacionamento = 1; 
        } else {
            horasEstacionamento = (tempoEstacionamento + 29) / 60; 
        }

       
        double preco = 0.0;
        if (horasEstacionamento <= 2) {
            preco = horasEstacionamento * 5.0;
        } else if (horasEstacionamento <= 4) {
            preco = 2 * 5.0 + (horasEstacionamento - 2) * 7.5;
        } else {
            preco = 2 * 5.0 + 2 * 7.5 + (horasEstacionamento - 4) * 10.0;
        }

       
        System.out.println("Tempo estacionado: " + horasEstacionamento + " horas");
        System.out.printf("Preço cobrado = R$%.2f\n", preco);

        scanner.close();
    }
}