import java.util.Scanner;

public class Uni5Exe28 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] votos = new int[4];
        while (true) {
            int voto = sc.nextInt();
            if (voto >= 1 && voto <= 4) votos[voto - 1]++;
            System.out.println("mais um voto: s (SIM) / n (NÃO)?");
            String cont = sc.next();
            if (cont.equalsIgnoreCase("n")) break;
        }
        int total = 0;
        for (int v : votos) total += v;
        String[] nomes = {"Nenhum de Nós", "CPM22", "Skank", "Jota Quest"};
        for (int i = 0; i < 4; i++) {
            System.out.printf("%s: %d votos (%.1f%%)\n", nomes[i], votos[i], 100.0 * votos[i] / total);
        }
        int max = 0;
        for (int i = 1; i < 4; i++) {
            if (votos[i] > votos[max]) max = i;
        }
        System.out.println("Vencedor: " + nomes[max]);
    }
}