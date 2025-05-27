import java.util.Scanner;

public class Uni5Exe13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        
        System.out.print("Número total de reabastecimentos: ");
        int totalReabastecimentos = scanner.nextInt();
        
        double totalKm = 0;
        double totalCombustivel = 0;
        
       
        for (int i = 1; i <= totalReabastecimentos; i++) {
            System.out.print("Parada " + i + ": Quilometragem: ");
            double quilometragem = scanner.nextDouble();
            System.out.print("Combustível: ");
            double combustivel = scanner.nextDouble();
            
            
            double kmPorLitro = quilometragem / combustivel;
            System.out.println("Parada " + i + ": " + kmPorLitro + " km por litro");
            
            
            totalKm += quilometragem;
            totalCombustivel += combustivel;
        }
        
       
        double kmMediaPorLitro = totalKm / totalCombustivel;
        System.out.println("Quilometragem média obtida por litro: " + kmMediaPorLitro);
        
        scanner.close();
    }
}
