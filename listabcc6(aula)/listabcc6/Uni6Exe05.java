import java.util.Scanner;

public class Uni6Exe05 {

    public static void main(String[] args) {
        final int TAM = 5;
        String[] rapaz = new String[TAM];
        String[] moca = new String[TAM];

        lerRespostas(rapaz, "Rapaz");
        lerRespostas(moca, "Moça");

        int afinidade = calcularAfinidade(rapaz, moca);
        mostrarResultado(afinidade);
    }

    
    public static void lerRespostas(String[] vetor, String pessoa) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Respostas de " + pessoa + ":");
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("Pergunta " + (i + 1) + " (SIM, NAO ou IND): ");
            vetor[i] = sc.next().toUpperCase();
        }
    }

    
    public static int calcularAfinidade(String[] rapaz, String[] moca) {
        int afinidade = 0;

        for (int i = 0; i < rapaz.length; i++) {
            String r = rapaz[i];
            String m = moca[i];

            if (r.equals(m)) {
                afinidade += 3;
            } else if (r.equals("IND") || m.equals("IND")) {
                afinidade += 1;
            } else if ((r.equals("SIM") && m.equals("NAO")) || (r.equals("NAO") && m.equals("SIM"))) {
                afinidade -= 2;
            }
        }

        return afinidade;
    }

    
    public static void mostrarResultado(int afinidade) {
        System.out.println("\nÍndice de afinidade: " + afinidade);

        if (afinidade == 15) {
            System.out.println("Casem!");
        } else if (afinidade >= 10) {
            System.out.println("Vocês têm muita coisa em comum!");
        } else if (afinidade >= 5) {
            System.out.println("Talvez não dê certo :(");
        } else if (afinidade >= 0) {
            System.out.println("Vale um encontro.");
        } else if (afinidade >= -9) {
            System.out.println("Melhor não perder tempo");
        } else {
            System.out.println("Vocês se odeiam!");
        }
    }
}
