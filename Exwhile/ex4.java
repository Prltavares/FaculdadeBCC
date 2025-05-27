import java.util.Scanner;

public class  ex4 {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String opcao = "";
        do {
            
        System.out.println("menu:");
        System.out.println("a) maior temperatura registrada");
        System.out.println("b) menor temperatura registrada");
        System.out.println("c) valores ordenados em ordem crescente");
        System.out.println("d) média das temperaturas");
        System.out.println("x) informe X para sair");
        opcao = teclado.next().toUpperCase();
        

        
        switch (opcao) { 
            case 'a'
           
                System.out.println("maior temperatura registrada:");
            break;
            case 'b':
            
                System.out.println("menor temperatura registrada:");
            break;
            case 'c':
            
            System.out.println("temperaturas em ordem crescente:");
            
            break;
            case 'd':
            
            System.out.println("média das temperaturas: ");
            break;
            default:
            System.out.println("opção inválida. execute o programa novamente.");
            break;
    }

} while (opcao.equals("X"));
        
        teclado.close();

    }
}