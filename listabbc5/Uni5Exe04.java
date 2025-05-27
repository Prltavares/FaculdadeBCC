public class Uni5Exe04 {
    public static void main(String[] args) {
        double soma = 0.0;
        int numerador = 3;
        int denominador = 2;

        for (int i = 1; i <= 20; i++) {
            soma += (double) numerador / denominador;
            numerador += 2;
            denominador += 2;
        }

        System.out.printf("O valor de S é: %.4f\n", soma);
    }
}
