

import java.util.Scanner;

// Vetor com String, pedir para informar os nomes para popular e imprimir depois.
public class Exemplo03Vetor {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);

        System.out.println("Informe a quantidade de nomes que você vai inserir:");
        int qtdNomes = teclado.nextInt();

        String[] nomes = new String[qtdNomes];

        for (int idx = 0; idx < nomes.length; idx++) {
            System.out.println("Digite um nome para a posição[" + idx + "]:");
            String nome = teclado.next();
            nomes[idx] = nome;
        }

        for (int idx = 0; idx < nomes.length; idx++) {
            System.out.println("Nome da posição[" + idx + "] = " + nomes[idx]);
        }

        System.out.println("----- -----");

        for (String nome : nomes) {
            System.out.println(nome);
        }


    }

}