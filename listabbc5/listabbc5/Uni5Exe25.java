import java.util.Scanner;

public class Uni5Exe25 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pontosE = 0, pontosD = 0;
        while (true) {
            String ponto = sc.next();
            if (ponto.equals("E")) {
                pontosE++;
            } else if (ponto.equals("D")) {
                pontosD++;
            }
            if ((pontosE >= 21 || pontosD >= 21) && Math.abs(pontosE - pontosD) >= 2) {
                break;
            }
        }
        System.out.println(pontosE > pontosD ? "E venceu" : "D venceu");
    }
}