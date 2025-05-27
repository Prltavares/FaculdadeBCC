import java.util.Scanner;

public class Uni6Exe07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

       
        System.out.print("Informe o tamanho do vetor (máximo 20): ");
        int N = sc.nextInt();

        
        if (N > 20) {
            System.out.println("O tamanho máximo do vetor é 20.");
            return;
        }

        
        int[] vetor = new int[N];

        
        preencherVetor(vetor, N);

       
        ordenarVetor(vetor);

       
        exibirVetor(vetor);

        sc.close();
    }

    
    public static void preencherVetor(int[] vetor, int N) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe " + N + " números inteiros para preencher o vetor:");

        for (int i = 0; i < N; i++) {
            int valor;
            boolean existe;
            do {
                System.out.print("Valor " + (i + 1) + ": ");
                valor = sc.nextInt();

               
                existe = false;
                for (int j = 0; j < i; j++) {
                    if (vetor[j] == valor) {
                        existe = true;
                        System.out.println("Número já existe no vetor. Informe um valor diferente.");
                        break;
                    }
                }
            } while (existe);

            
            vetor[i] = valor;
        }
    }

    
    public static void ordenarVetor(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (vetor[j] > vetor[j + 1]) {
                  
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    
    public static void exibirVetor(int[] vetor) {
        System.out.print("Vetor ordenado: ");
        for (int num : vetor) {
            System.out.print("[" + num + "] ");
        }
        System.out.println();
    }
}
