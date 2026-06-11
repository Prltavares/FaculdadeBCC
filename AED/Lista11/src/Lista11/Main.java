package Lista11;

import java.util.Arrays;

/**
 * Programa demonstrativo para a Lista 11 - Buscas (simples).
 * Contém exemplos de busca linear e binária (iterativa/recursiva).
 */
public class Main {
    public static void main(String[] args) {
        int[] dados = {3, 1, 4, 1, 5, 9, 2, 6, 5};

        System.out.println("Array original: " + Arrays.toString(dados));

        // Busca linear
        int chave = 5;
        int idxLinear = BuscaSimples.buscaLinear(dados, chave);
        System.out.println("Busca linear: valor=" + chave + " -> índice=" + idxLinear);

        // Para busca binária precisamos ordenar
        int[] ordenado = Arrays.copyOf(dados, dados.length);
        Arrays.sort(ordenado);
        System.out.println("Array ordenado: " + Arrays.toString(ordenado));

        int idxBinIter = BuscaBinariaIterativa.buscaBinaria(ordenado, chave);
        System.out.println("Busca binária iterativa: valor=" + chave + " -> índice=" + idxBinIter);

        int idxBinRec = BuscaBinariaRecursiva.buscaBinariaRec(ordenado, chave);
        System.out.println("Busca binária recursiva: valor=" + chave + " -> índice=" + idxBinRec);

        // Exemplos adicionais
        System.out.println("Procurando 7 (não presente): linear=" + BuscaSimples.buscaLinear(dados, 7)
                + ", binária=" + BuscaBinariaIterativa.buscaBinaria(ordenado, 7));
    }
}

