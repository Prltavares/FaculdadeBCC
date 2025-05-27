import java.util.Scanner;

public class Uni6Exe10 {
    private static final int TAMANHO_MAX = 50;
    private static int[] vetor = new int[TAMANHO_MAX];
    private static int quantidade = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\nMENU:");
            System.out.println("1 - Incluir valor");
            System.out.println("2 - Pesquisar valor");
            System.out.println("3 - Alterar valor");
            System.out.println("4 - Excluir valor");
            System.out.println("5 - Mostrar valores");
            System.out.println("6 - Ordenar valores");
            System.out.println("7 - Inverter valores");
            System.out.println("8 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1 -> incluirValor(sc);
                case 2 -> pesquisarValor(sc);
                case 3 -> alterarValor(sc);
                case 4 -> excluirValor(sc);
                case 5 -> mostrarValores();
                case 6 -> ordenarValores();
                case 7 -> inverterValores();
                case 8 -> System.out.println("Sistema encerrado.");
                default -> System.out.println("Opção inválida.");
            }
        } while (opcao != 8);

        sc.close();
    }

    private static void incluirValor(Scanner sc) {
        if (quantidade >= TAMANHO_MAX) {
            System.out.println("Vetor cheio. Não é possível incluir mais valores.");
            return;
        }

        System.out.print("Informe um valor a ser incluído: ");
        vetor[quantidade] = sc.nextInt();
        quantidade++;
        System.out.println("Valor incluído com sucesso!");
    }

    private static void pesquisarValor(Scanner sc) {
        System.out.print("Informe o valor a ser pesquisado: ");
        int valor = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            if (vetor[i] == valor) {
                System.out.println("Valor encontrado na posição " + i);
                return;
            }
        }
        System.out.println("Valor não encontrado.");
    }

    private static void alterarValor(Scanner sc) {
        System.out.print("Informe o valor a ser alterado: ");
        int antigo = sc.nextInt();
        System.out.print("Informe o novo valor: ");
        int novo = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            if (vetor[i] == antigo) {
                vetor[i] = novo;
                System.out.println("Valor alterado com sucesso!");
                return;
            }
        }
        System.out.println("Número não encontrado.");
    }

    private static void excluirValor(Scanner sc) {
        System.out.print("Informe o valor a ser excluído: ");
        int valor = sc.nextInt();

        for (int i = 0; i < quantidade; i++) {
            if (vetor[i] == valor) {
                for (int j = i; j < quantidade - 1; j++) {
                    vetor[j] = vetor[j + 1];
                }
                quantidade--;
                System.out.println("Valor excluído com sucesso!");
                return;
            }
        }
        System.out.println("Valor não encontrado.");
    }

    private static void mostrarValores() {
        if (quantidade == 0) {
            System.out.println("Nenhum valor cadastrado.");
            return;
        }

        System.out.println("Valores no vetor:");
        for (int i = 0; i < quantidade; i++) {
            System.out.print(vetor[i] + " ");
        }
        System.out.println();
    }

    private static void ordenarValores() {
        for (int i = 0; i < quantidade - 1; i++) {
            for (int j = 0; j < quantidade - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
        System.out.println("Valores ordenados em ordem crescente.");
    }

    private static void inverterValores() {
        for (int i = 0; i < quantidade / 2; i++) {
            int temp = vetor[i];
            vetor[i] = vetor[quantidade - 1 - i];
            vetor[quantidade - 1 - i] = temp;
        }
        System.out.println("Valores invertidos com sucesso.");
    }
}
