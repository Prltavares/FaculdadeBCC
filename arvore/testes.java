public class testes{
    public static void main(String[] args) {
        System.out.println("--- Executando Plano de testes PL01 - Árvore n-ária ---");

        // Montando a árvore de teste de acordo com o diagrama
        NoArvore<Integer> n1 = new NoArvore<>(1);
        NoArvore<Integer> n2 = new NoArvore<>(2);
        NoArvore<Integer> n3 = new NoArvore<>(3);
        NoArvore<Integer> n4 = new NoArvore<>(4);
        NoArvore<Integer> n5 = new NoArvore<>(5);
        NoArvore<Integer> n6 = new NoArvore<>(6);
        NoArvore<Integer> n7 = new NoArvore<>(7);
        NoArvore<Integer> n8 = new NoArvore<>(8);
        NoArvore<Integer> n9 = new NoArvore<>(9);
        NoArvore<Integer> n10 = new NoArvore<>(10);

        // Estabelecendo as hierarquias (Filhos de 2, 3 e 4)
        n2.inserirFilho(n5);
        n2.inserirFilho(n6);
        n2.inserirFilho(n7);

        n3.inserirFilho(n8);

        n4.inserirFilho(n9);
        n4.inserirFilho(n10);

        // Conectando os nós filhos à raiz
        n1.inserirFilho(n2);
        n1.inserirFilho(n3);
        n1.inserirFilho(n4);

        // Criando a árvore e setando a raiz
        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(n1);

        // Caso 1: Validar representação textual [cite: 209]
        System.out.println("\nCaso 1 (Representação Textual):");
        System.out.println("Esperado: <1<2<5><6><7>><3<8>><4<9><10>>>");
        System.out.println("Obtido:   " + arvore.toString());

        // Caso 2: Validar método buscar() localizando um nó existente (7)
        System.out.println("\nCaso 2 (pertence 7 == true): " + arvore.pertence(7));

        // Caso 3: Validar método pertence() com um dado que não consta (55)
        System.out.println("Caso 3 (pertence 55 == false): " + arvore.pertence(55));

        // Caso 4: Validar método contarNos()
        System.out.println("Caso 4 (contarNos == 10): " + arvore.contarNos());
    }
}