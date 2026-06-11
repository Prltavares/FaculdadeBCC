package teste;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calculadora calculadora = new Calculadora();
        boolean executando = true;

        while (executando) {
            exibirMenu();
            int opcao = lerOpcao(scanner);

            if (opcao == 0) {
                executando = false;
                System.out.println("Calculadora encerrada.");
            } else if (opcao >= 1 && opcao <= 4) {
                double primeiroNumero = lerNumero(scanner, "Primeiro numero: ");
                double segundoNumero = lerNumero(scanner, "Segundo numero: ");

                try {
                    double resultado = calcular(calculadora, opcao, primeiroNumero, segundoNumero);
                    System.out.printf("Resultado: %.2f%n", resultado);
                } catch (ArithmeticException e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Opcao invalida.");
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("=== Calculadora ===");
        System.out.println("1. Somar");
        System.out.println("2. Subtrair");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        System.out.println("0. Sair");
        System.out.print("Opcao: ");
    }

    private static int lerOpcao(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.print("Informe uma opcao valida: ");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private static double lerNumero(Scanner scanner, String mensagem) {
        System.out.print(mensagem);
        while (!scanner.hasNextDouble()) {
            System.out.print("Informe um numero valido: ");
            scanner.next();
        }
        return scanner.nextDouble();
    }

    private static double calcular(Calculadora calculadora, int opcao, double a, double b) {
        switch (opcao) {
            case 1:
                return calculadora.somar(a, b);
            case 2:
                return calculadora.subtrair(a, b);
            case 3:
                return calculadora.multiplicar(a, b);
            case 4:
                return calculadora.dividir(a, b);
            default:
                throw new IllegalArgumentException("Opcao invalida.");
        }
    }
}
