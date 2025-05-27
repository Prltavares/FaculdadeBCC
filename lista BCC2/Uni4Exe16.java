import java.util.Scanner;

public class Uni4Exe16 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.print("Digite a idade do primeiro homem: ");
        int homem1 = teclado.nextInt();
        System.out.print("Digite a idade do segundo homem: ");
        int homem2 = teclado.nextInt();
        System.out.print("Digite a idade da primeira mulher: ");
        int mulher1 = teclado.nextInt();
        System.out.print("Digite a idade da segunda mulher: ");
        int mulher2 = teclado.nextInt();

        int homemMaisVelho = Math.max(homem1, homem2);
        int homemMaisNovo = Math.min(homem1, homem2);
        int mulherMaisVelha = Math.max(mulher1, mulher2);
        int mulherMaisNova = Math.min(mulher1, mulher2);

        int soma = homemMaisVelho + mulherMaisNova;
        int produto = homemMaisNovo * mulherMaisVelha;

        System.out.println("Soma: " + soma);
        System.out.println("Produto: " + produto);

        System.out.println("Idades digitadas: Homens - " + homem1 + " e " + homem2 + 
                           ", Mulheres - " + mulher1 + " e " + mulher2);

        teclado.close();
    }
}
