public class EXvetor3 {


    public static void main(String[] args) {
    
        String[] nomes = new String[3];
        
        nomes[0] = "Pedro";
        nomes[1] = "Renan";
        nomes[2] = "Luna";

        for (String nome : nomes) {
            System.out.println(nome);
        }

        String[] nomes2 = new String[nomes.length+2];

        for (int idx = 0; idx < nomes.length; idx++) {
        nomes2[idx] = nomes[idx];
        }
 
        nomes = nomes2;

        nomes[3] = "Bla bla bla";
        nomes[4] = "xyz";
        
        

        }
        
    }
    

