public class Uni5Exe22 {
    public static void main(String[] args) {
        double salario = 2000;
        int ano = 1996;
        double aumento = 0.015;

        while (ano <= 2025) {
            salario += salario * aumento;
            aumento *= 2;
            ano++;
        }

        System.out.printf("Salário atual em 2025: R$%.2f\n", salario);
    }
}
