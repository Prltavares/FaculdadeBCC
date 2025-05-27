import java.util.Scanner;

public class Uni4Exe18 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Dia do vencimento: ");
        int diaVencimento = teclado.nextInt();
        
        System.out.print("Dia do pagamento: ");
        int diaPagamento = teclado.nextInt();
        
        System.out.print("Valor da prestação: ");
        double valorPrestacao = teclado.nextDouble();
        
        double valorFinal = valorPrestacao;
        int diasAtraso = diaPagamento - diaVencimento;
        
        if (diaPagamento <= diaVencimento) {
            valorFinal = valorPrestacao * 0.9;
            System.out.println("O pagamento está em dia. O valor da prestação = R$" + String.format("%.2f", valorFinal));
        } else if (diasAtraso <= 5) {
            System.out.println("O pagamento está atrasado. O valor da prestação = R$" + String.format("%.2f", valorPrestacao));
        } else {
            double multa = 0.02 * diasAtraso * valorPrestacao;
            valorFinal = valorPrestacao + multa;
            System.out.println("O pagamento está atrasado. Multa de 2% por dia de atraso. Valor da prestação = R$" + String.format("%.2f", valorFinal));
        }
        
        teclado.close();
    }
}
