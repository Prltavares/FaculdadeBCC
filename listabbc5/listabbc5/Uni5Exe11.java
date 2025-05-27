public class Uni5Exe11 {
    public static void main(String[] args) {
        int totalBiscoitos = 0;
        int biscoitosNaHora = 1; 

        
        for (int hora = 1; hora <= 16; hora++) {
            totalBiscoitos += biscoitosNaHora;
            biscoitosNaHora *= 3; 
        }

        System.out.println("Total de biscoitos quebrados no final do dia: " + totalBiscoitos);
    }
}
