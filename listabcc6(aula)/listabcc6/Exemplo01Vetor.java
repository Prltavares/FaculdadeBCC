public class Exemplo01Vetor {

    public static void main(String[] args) {
        int vetor1[] = new int[10];

        int[] vetor2 = new int[5];
        vetor2[0] = 1;
        vetor2[1] = 2;
        vetor2[2] = 3;
        vetor2[3] = 4;
        vetor2[4] = 5;

        int[] vetor3 = {1, 2, 3, 4, 5};

        for (int idx = 0; idx < vetor3.length; idx++) {
            System.out.println("Posição[" +idx+"] = " + vetor3[idx]);
        }

        System.out.println(" ---- ----- ");

        for (int idx = vetor3.length - 1; idx >= 0; idx--) {
            System.out.println("Posição[" +idx+"] = " + vetor3[idx]);
        }

        System.out.println(" ---- ----- ");


        for (int numero : vetor3) {
            System.out.println(numero);
        }

    }
}