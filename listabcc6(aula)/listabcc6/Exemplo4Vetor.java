public class Exemplo4Vetor {

    public static void main(String[] args) {
        
        String[] nomes = new String[3];

        nomes[0] = "André";
        nomes[1] = "Felipe";
        nomes[2] = "Bürger";

        for (String nome : nomes) {
            System.out.println(nome);
        }

        String[] nomes2 = new String[nomes.length+2];

        for (int idx = 0; idx < nomes.length; idx++) {
            nomes2[idx] = nomes[idx];
        }

        nomes = nomes2;

        nomes[3] = "Bla bla bla";
        nomes[4] = "XYZ";

        System.out.println("---- -----");

        for (String nome : nomes) {
            System.out.println(nome);
        }
    }

}