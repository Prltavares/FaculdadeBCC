import java.util.Scanner;

public class Uni5Exe14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        int abaixo10 = 0, entre10e20 = 0, acima20 = 0;
        double totalCompra = 0, totalVenda = 0, totalLucro = 0;
        
        
        for (int i = 1; i <= 20; i++) {
            System.out.println("Mercadoria " + i + ":");
            
            System.out.print("Nome: ");
            String nome = scanner.nextLine(); 
            
            System.out.print("Preço de compra (PC): ");
            double pc = scanner.nextDouble(); 
            
            System.out.print("Preço de venda (PV): ");
            double pv = scanner.nextDouble(); 
            
            
            double lucro = pv - pc;
            double percentualLucro = (lucro / pc) * 100;
            
            
            if (percentualLucro < 10) {
                abaixo10++;
            } else if (percentualLucro >= 10 && percentualLucro <= 20) {
                entre10e20++;
            } else {
                acima20++;
            }
            
           
            totalCompra += pc;
            totalVenda += pv;
            totalLucro += lucro;
            
            scanner.nextLine(); 
        }
        
       
        System.out.println("Relatório de Lucro das Mercadorias:");
        System.out.println("Mercadorias com lucro < 10%: " + abaixo10);
        System.out.println("Mercadorias com lucro entre 10% e 20%: " + entre10e20);
        System.out.println("Mercadorias com lucro > 20%: " + acima20);
        System.out.println("Valor total de compra: R$ " + totalCompra);
        System.out.println("Valor total de venda: R$ " + totalVenda);
        System.out.println("Lucro total: R$ " + totalLucro);
        
        scanner.close();
    }
}
