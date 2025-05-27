
import java.util.Scanner;

public class Uni4Exe14 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        
        System.out.print("Digite o dia: ");
        int dia = teclado.nextInt();

        System.out.print("Digite o mês: ");
        int mes = teclado.nextInt();

        System.out.print("Digite o ano: ");
        int ano = teclado.nextInt();

        
        if (dia > 0 && dia <= 31 && mes > 0 && mes <= 12) {
            
            if (mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12) {
                System.out.println("Válida");
            } 
            
            else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {
                if (dia <= 30) {
                    System.out.println("Válida");
                } else {
                    System.out.println("Não válida");
                }
            } 
          
            else {
                if (dia <= 29) {
                    if (dia == 29) {
                        
                        if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                            System.out.println("Válida");
                        } else {
                            System.out.println("Não válida");
                        }
                    } else {
                        System.out.println("Válida");
                    }
                } else {
                    System.out.println("Não válida");
                }
            }
        } else {
            System.out.println("Não válida");
        }

       teclado.close();
    }
}
