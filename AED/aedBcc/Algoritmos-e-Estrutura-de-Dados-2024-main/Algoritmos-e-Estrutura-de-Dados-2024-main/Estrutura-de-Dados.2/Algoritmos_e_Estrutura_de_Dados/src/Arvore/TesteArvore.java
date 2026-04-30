package Arvore;
/**
 * 
 * @autor Larissa Zózimo Antunes
 */
public class TesteArvore {

    public static void main(String[] args) {
        Arvore<Integer> arvore = criarArvore();

        // Teste de representação textual da árvore
        String resultado = arvore.toString();
        if ("<1<2<5><6><7>><3<8>><4<9><10>>>".equals(resultado)) {
            System.out.println("Teste de Representação Textual - Passou!");
        } else {
            System.out.println("Teste de Representação Textual - Falhou!");
        }
        
        System.out.println("<1<2<5><6><7>><3<8>><4<9><10>>>");
        System.out.println(arvore.toString());
    }

    public static Arvore<Integer> criarArvore() {
        // Criando os nós da árvore conforme a representação desejada
        NoArvore<Integer> no10 = new NoArvore<>(10);
        NoArvore<Integer> no9 = new NoArvore<>(9);
        NoArvore<Integer> no8 = new NoArvore<>(8);
        NoArvore<Integer> no7 = new NoArvore<>(7);
        NoArvore<Integer> no6 = new NoArvore<>(6);
        NoArvore<Integer> no5 = new NoArvore<>(5);
        NoArvore<Integer> no4 = new NoArvore<>(4);
        NoArvore<Integer> no3 = new NoArvore<>(3);
        NoArvore<Integer> no2 = new NoArvore<>(2);
        NoArvore<Integer> no1 = new NoArvore<>(1);

        // Montando a estrutura da árvore
        no2.setPrimeiro(no5);
        no2.getPrimeiro().setProximo(no6);
        no2.getPrimeiro().getProximo().setProximo(no7);

        no3.setPrimeiro(no8);

        no4.setPrimeiro(no9);
        no4.getPrimeiro().setProximo(no10);

        no1.setPrimeiro(no2);
        no1.getPrimeiro().setProximo(no3);
        no1.getPrimeiro().getProximo().setProximo(no4);

        Arvore<Integer> arvore = new Arvore<>();
        arvore.setRaiz(no1);

        return arvore;
    }
    
}



