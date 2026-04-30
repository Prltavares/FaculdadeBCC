public class TestePL01 {
    public static void main(String[] args) {
        System.out.println("--- Executando Plano de Testes PL01 - Árvore Binária ---");

        // Caso 1: Conferir se é reconhecida árvore vazia[cite: 2]
        ArvoreBinaria<Integer> arvoreVazia = new ArvoreBinaria<>(); // Criar uma árvore binária de inteiros[cite: 2]
        System.out.println("Caso 1 (estaVazia == true): " + arvoreVazia.estaVazia()); // O método estaVazia() deve resultar em true[cite: 2]

        // Caso 2: Conferir se é reconhecida árvore não vazia[cite: 2]
        ArvoreBinaria<Integer> arvoreUmNo = new ArvoreBinaria<>();
        arvoreUmNo.setRaiz(new NoArvoreBinaria<>(5)); // Adicionar um nó contendo o valor 5[cite: 2]
        System.out.println("Caso 2 (estaVazia == false): " + arvoreUmNo.estaVazia()); // O método estaVazia() deve resultar em false[cite: 2]

        // Preparação para os Casos 3 a 8: Montagem da Árvore de Teste
        // Representação textual desejada: <1<2<><4<><>>><3<5<><>><6<><>>>>[cite: 2]
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2, null, no4);

        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3, no5, no6);

        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1, no2, no3);

        ArvoreBinaria<Integer> arvoreTeste = new ArvoreBinaria<>();
        arvoreTeste.setRaiz(no1);

        // Caso 3: Conferir a representação textual da árvore usando o caminho pré-ordem[cite: 2]
        System.out.println("Caso 3 (toString pré-ordem):");
        System.out.println("Esperado: <1<2<><4<><>>><3<5<><>><6<><>>>>"); //[cite: 2]
        System.out.println("Obtido:   " + arvoreTeste.toString());

        // Caso 4: Avaliar se um valor armazenado na raiz pertence à árvore (buscar o valor 1)[cite: 2]
        System.out.println("Caso 4 (pertence 1 == true): " + arvoreTeste.pertence(1)); // Pertence() deve resultar em true[cite: 2]

        // Caso 5: Avaliar se um valor armazenado num nó não raiz e não folha pertence à árvore (buscar o valor 3)[cite: 2]
        System.out.println("Caso 5 (pertence 3 == true): " + arvoreTeste.pertence(3)); // Pertence() deve resultar em true[cite: 2]

        // Caso 6: Avaliar se um valor armazenado num nó folha pertence à árvore (buscar o valor 6)[cite: 2]
        System.out.println("Caso 6 (pertence 6 == true): " + arvoreTeste.pertence(6)); // Pertence() deve resultar em true[cite: 2]

        // Caso 7: Conferir se a árvore conclui que determinado dado não pertence à árvore (buscar o valor 10)[cite: 2]
        System.out.println("Caso 7 (pertence 10 == false): " + arvoreTeste.pertence(10)); // Pertence() deve resultar em false[cite: 2]

        // Caso 8: Verificar se a árvore consegue contar a quantidade de nós de uma árvore com altura igual a 2[cite: 2]
        System.out.println("Caso 8 (contarNos == 6): " + arvoreTeste.contarNos()); // contarNos() deve resultar em 6[cite: 2]
    }
}