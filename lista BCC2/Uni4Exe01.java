
import java.util.Scanner;

//A jornada de trabalho semanal de um funcionário é de 40 horas. 
//O funcionário que trabalhar mais de 40 horas receberá hora extra, 
//cujo cálculo é o valor da hora regular com um acréscimo de 50%. 
//Escreva um algoritmo que leia o número de horas trabalhadas em um mês, 
//o valor por hora e escreva o salário total do funcionário, 
//que deverá ser acrescido das horas extras, caso tenham sido trabalhadas (considere que o mês possua 4 semanas exatas).
//Para resolver este problema pode se utilizar do algoritmo descrito no fluxograma:




 public class Uni4Exe01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner (System.in);
        System.out.println("Entre com as horas trabalhadas no mês:");
        int horasmes = scanner.nextInt();
        System.out.println("Entre com o valor pago por hora:");
        Double horasvalor = scanner.nextDouble();

        double  salarioTotal = horasmes * horasvalor;

        if (horasmes > 160) {
            double horasExtra = horasmes - 160;
            double salarioExtra = horasExtra * (horasvalor /2);
            salarioTotal += salarioExtra;
        }

        System.out.printf("O salário total é: %.2f\n", salarioTotal);

        scanner.close();
    }
}

 