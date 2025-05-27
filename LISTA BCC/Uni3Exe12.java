
import java.util.Scanner;

public class Uni3Exe12 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Digite o nome do funcionario");
        String Nome = teclado.nextLine();
        
        System.out.println("Quantidade de horas trabalhadas no mês");
        int horastrabalhadas =teclado.nextInt();

        System.out.println("número de dependentes");
        int Nmrdependentes = teclado.nextInt();
        
        Double salariotrabalho = horastrabalhadas * 10.0;
        Double salariofamilia = Nmrdependentes * 60.0;
        Double salariobruto = salariotrabalho + salariofamilia;

        Double descontoinss = salariotrabalho *0.085;
        Double descontoimpostoderenda = salariotrabalho * 0.05;
        double totaldescontos = descontoinss + descontoimpostoderenda;
        
        double salarioliquido =salariobruto -totaldescontos;
        System.out.printf("o Funcionario %s possui um salario bruto de R$%.2f e um salario líquido de R$%.2f\n", Nome, salariobruto, salarioliquido);
        
        teclado.close();
    }
}
