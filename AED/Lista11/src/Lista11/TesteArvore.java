package Lista11;

/**
 * Classe de teste para Árvores Binárias de Busca (PL01).
 * Contém os casos de teste apresentados na lista de exercícios.
 */
public class TesteArvore {

    public static void main(String[] args) {
        System.out.println("===== PLANO DE TESTES PL01 - ÁRVORES BINÁRIAS =====\n");

        // ===== CASO 1: Inserção =====
        System.out.println("Caso 1: Inserção de [50, 30, 70, 40, 25, 75, 65, 35, 60]");
        ArvoreBinariaBusca<Integer> arvore1 = new ArvoreBinariaBusca<>();

        int[] inserir1 = {50, 30, 70, 40, 25, 75, 65, 35, 60};
        for (int valor : inserir1) {
            arvore1.inserir(valor);
        }

        String resultado1 = arvore1.toString();
        String esperado1 = "<50<30<25<><>><40<35<><>><>>>><70<65<60<><>><>><75<><>>>>";

        System.out.println("Resultado: " + resultado1);
        System.out.println("Esperado:  " + esperado1);
        System.out.println("Status: " + (resultado1.equals(esperado1) ? "✓ PASSOU" : "✗ FALHOU"));

        // Se falhou, exibe a diferença
        if (!resultado1.equals(esperado1)) {
            System.out.println("DIFERENÇA DETECTADA!");
            System.out.println("Resultado tem " + resultado1.length() + " caracteres");
            System.out.println("Esperado tem " + esperado1.length() + " caracteres");
        }
        System.out.println();

        // ===== CASO 2: Remoção de Folha =====
        System.out.println("Caso 2: Remoção de folha [50, 30, 25, 40] removendo 40");
        ArvoreBinariaBusca<Integer> arvore2 = new ArvoreBinariaBusca<>();

        int[] inserir2 = {50, 30, 25, 40};
        for (int valor : inserir2) {
            arvore2.inserir(valor);
        }

        System.out.println("Antes da remoção: " + arvore2.toString());
        arvore2.remover(40);

        String resultado2 = arvore2.toString();
        String esperado2 = "<50<30<25<><>><>><>>";

        System.out.println("Depois da remoção: " + resultado2);
        System.out.println("Esperado:         " + esperado2);
        System.out.println("Status: " + (resultado2.equals(esperado2) ? "✓ PASSOU" : "✗ FALHOU"));
        System.out.println();

        System.out.println("Caso 3: Remoção de nó com 1 filho [80, 52, 90, 48, 71, 63, 67] removendo 71");
        ArvoreBinariaBusca<Integer> arvore3 = new ArvoreBinariaBusca<>();

        int[] inserir3 = {80, 52, 90, 48, 71, 63, 67};
        for (int valor : inserir3) {
            arvore3.inserir(valor);
        }

        System.out.println("Antes da remoção: " + arvore3.toString());
        arvore3.remover(71);

        String resultado3 = arvore3.toString();
        String esperado3 = "<80<52<48<><>><63<><67<><>>>><90<><>>>";

        System.out.println("Depois da remoção: " + resultado3);
        System.out.println("Esperado:         " + esperado3);
        System.out.println("Status: " + (resultado3.equals(esperado3) ? "✓ PASSOU" : "✗ FALHOU"));

        if (!resultado3.equals(esperado3)) {
            System.out.println("DIFERENÇA DETECTADA!");
        }
        System.out.println();

        // Resumo
        int totalCasos = 3;
        int casosCorretos = (resultado1.equals(esperado1) ? 1 : 0) +
                           (resultado2.equals(esperado2) ? 1 : 0) +
                           (resultado3.equals(esperado3) ? 1 : 0);

        System.out.println("===== RESUMO =====");
        System.out.println("Status: " + (resultado3.equals(esperado3) ? "✓ PASSOU" : "✗ FALHOU"));
    }
}
