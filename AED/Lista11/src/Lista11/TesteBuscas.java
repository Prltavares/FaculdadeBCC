package Lista11;

/**
 * Plano de Testes PL01 para Algoritmos de Busca.
 */
public class TesteBuscas {

    public static void main(String[] args) {
        System.out.println("===== PLANO DE TESTES PL01 - BUSCAS =====\n");

        Integer[] vetorTeste = {0, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        System.out.println("Caso 1: Busca Linear procurando 20");
        BuscaLinear<Integer> buscaLinear1 = new BuscaLinear<>();
        buscaLinear1.setInfo(vetorTeste);
        int resultado1 = buscaLinear1.buscar(20);
        System.out.println("Resultado: " + resultado1);
        System.out.println("Esperado: 2");
        System.out.println("Status: " + (resultado1 == 2 ? "✓ PASSOU" : "✗ FALHOU") + "\n");

        System.out.println("Caso 2: Busca Linear em Vetor Ordenado procurando 40");
        BuscaLinearVetorOrdenado<Integer> buscaLinearOrdenado = new BuscaLinearVetorOrdenado<>();
        buscaLinearOrdenado.setInfo(vetorTeste);
        int resultado2 = buscaLinearOrdenado.buscar(40);
        System.out.println("Resultado: " + resultado2);
        System.out.println("Esperado: 4");
        System.out.println("Status: " + (resultado2 == 4 ? "✓ PASSOU" : "✗ FALHOU") + "\n");

        System.out.println("Caso 3: Busca Binária procurando 70");
        BuscaBinaria<Integer> buscaBinaria1 = new BuscaBinaria<>();
        buscaBinaria1.setInfo(vetorTeste);
        int resultado3 = buscaBinaria1.buscar(70);
        System.out.println("Resultado: " + resultado3);
        System.out.println("Esperado: 7");
        System.out.println("Status: " + (resultado3 == 7 ? "✓ PASSOU" : "✗ FALHOU") + "\n");

        System.out.println("Caso 4: Busca Binária procurando 75 (não existe)");
        BuscaBinaria<Integer> buscaBinaria2 = new BuscaBinaria<>();
        buscaBinaria2.setInfo(vetorTeste);
        int resultado4 = buscaBinaria2.buscar(75);
        System.out.println("Resultado: " + resultado4);
        System.out.println("Esperado: -1");
        System.out.println("Status: " + (resultado4 == -1 ? "✓ PASSOU" : "✗ FALHOU"));
    }
}

