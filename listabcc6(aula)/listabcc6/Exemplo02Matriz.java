
// Matriz inicialização, atribuição e leitura
public class Exemplo02Matriz {

    public static void main(String[] args) {
        int[][] matriz = new int[6][3];

        int matriz2[][] = new int[6][3];

        int matriz3[][] = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9},
            {10, 11, 12},
            {13, 14, 15},
            {16, 17, 18},
        };

        for (int x = 0; x < matriz3.length; x++) {
            for (int y = 0; y < matriz3[x].length; y++) {
                System.out.print(matriz3[x][y] + "\t");
            }
            System.out.println();
        }
    }

}
