package Arvore;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
public class TesteArvoreBinaria {
    public static void main(String[] args) {
        testArvoreVazia();
        testArvoreNaoVazia();
        testToString();
        testPertence();
        testPertenceValorNaRaiz();
        testPertenceValorNoNaoRaizNaoFolha();
        testPertenceValorNoFolha();
        testNaoPertence();
        testContarNos();
    }

    public static void testArvoreVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        if (arvore.estaVazia()) {
            System.out.println("Teste testArvoreVazia passou.");
        } else {
            System.out.println("Teste testArvoreVazia falhou.");
        }
    }

    public static void testArvoreNaoVazia() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        NoArvoreBinaria<Integer> no = new NoArvoreBinaria<>(5);
        arvore.setRaiz(no);
        if (!arvore.estaVazia()) {
            System.out.println("Teste testArvoreNaoVazia passou.");
        } else {
            System.out.println("Teste testArvoreNaoVazia falhou.");
        }
    }

    public static void testToString() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();

        String expected = "<1<2<><4<><>>><3<5<><>><6<><>>>>";
        if (arvore.toString().equals(expected)) {
            System.out.println("Teste testToString passou.");
        } else {
            System.out.println("Teste testToString falhou.");
        }

        System.out.println("Obtido: " + arvore.toString());
        System.out.println("Esperado: " + expected);
    }

    public static void testPertence() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();

        if (arvore.pertence(5)) {
            System.out.println("Teste testPertence (valor 5) passou.");
        } else {
            System.out.println("Teste testPertence (valor 5) falhou.");
        }

        if (!arvore.pertence(7)) {
            System.out.println("Teste testPertence (valor 7) passou.");
        } else {
            System.out.println("Teste testPertence (valor 7) falhou.");
        }
    }

    public static void testPertenceValorNaRaiz() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();
        if (arvore.pertence(1)) {
            System.out.println("Teste testPertenceValorNaRaiz passou.");
        } else {
            System.out.println("Teste testPertenceValorNaRaiz falhou.");
        }
    }

    public static void testPertenceValorNoNaoRaizNaoFolha() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();
        if (arvore.pertence(3)) {
            System.out.println("Teste testPertenceValorNoNaoRaizNaoFolha passou.");
        } else {
            System.out.println("Teste testPertenceValorNoNaoRaizNaoFolha falhou.");
        }
    }

    public static void testPertenceValorNoFolha() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();
        if (arvore.pertence(6)) {
            System.out.println("Teste testPertenceValorNoFolha passou.");
        } else {
            System.out.println("Teste testPertenceValorNoFolha falhou.");
        }
    }

    public static void testNaoPertence() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();
        if (!arvore.pertence(10)) {
            System.out.println("Teste testNaoPertence passou.");
        } else {
            System.out.println("Teste testNaoPertence falhou.");
        }
    }

    public static void testContarNos() {
        ArvoreBinaria<Integer> arvore = criarArvoreExemplo();
        if (arvore.contarNos() == 6) {
            System.out.println("Teste testContarNos passou.");
        } else {
            System.out.println("Teste testContarNos falhou.");
        }
    }

    private static ArvoreBinaria<Integer> criarArvoreExemplo() {
        ArvoreBinaria<Integer> arvore = new ArvoreBinaria<>();
        NoArvoreBinaria<Integer> no1 = new NoArvoreBinaria<>(1);
        NoArvoreBinaria<Integer> no2 = new NoArvoreBinaria<>(2);
        NoArvoreBinaria<Integer> no3 = new NoArvoreBinaria<>(3);
        NoArvoreBinaria<Integer> no4 = new NoArvoreBinaria<>(4);
        NoArvoreBinaria<Integer> no5 = new NoArvoreBinaria<>(5);
        NoArvoreBinaria<Integer> no6 = new NoArvoreBinaria<>(6);

        no1.setEsquerda(no2);
        no1.setDireita(no3);
        no2.setDireita(no4);
        no3.setEsquerda(no5);
        no3.setDireita(no6);

        arvore.setRaiz(no1);
        return arvore;
    }
}
