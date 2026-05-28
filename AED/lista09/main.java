import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        System.out.println("======================================================");
        System.out.println("PLANO DE TESTES PL01 - MAPA DE DISPERSÃO");
        System.out.println("======================================================\n");

        // ---------------------------------------------------------
        // CASO 1: Inserir e localizar um único dado
        // ---------------------------------------------------------
        System.out.println("--- CASO 1: Inserção e Busca Simples ---");
        MapaDispersao<Aluno> mapa1 = new MapaDispersao<>(53); // Capacidade de 53

        Aluno obj1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        mapa1.inserir(obj1.getMatricula(), obj1);

        Aluno resultado1 = mapa1.buscar(12000);

        System.out.println("Buscando matrícula 12000...");
        System.out.println("Aluno encontrado: " + resultado1);
        System.out.println("É a mesma instância na memória? " + (obj1 == resultado1));
        System.out.println("------------------------------------------------------\n");

        // ---------------------------------------------------------
        // CASO 2: Inserir vários objetos sem colisão
        // ---------------------------------------------------------
        System.out.println("--- CASO 2: Inserção Múltipla ---");
        MapaDispersao<Aluno> mapa2 = new MapaDispersao<>(53);

        Aluno a1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno a2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno a3 = new Aluno(12500, "Marta", LocalDate.of(2001, 2, 18));
        Aluno a4 = new Aluno(13000, "Lucas", LocalDate.of(1998, 11, 25));

        mapa2.inserir(a1.getMatricula(), a1);
        mapa2.inserir(a2.getMatricula(), a2);
        mapa2.inserir(a3.getMatricula(), a3);
        mapa2.inserir(a4.getMatricula(), a4);

        System.out.println("Buscando 12000: " + mapa2.buscar(12000));
        System.out.println("Buscando 14000: " + mapa2.buscar(14000));
        System.out.println("Buscando 12500: " + mapa2.buscar(12500));
        System.out.println("Buscando 13000: " + mapa2.buscar(13000));
        System.out.println("------------------------------------------------------\n");

        // ---------------------------------------------------------
        // CASO 3: A Prova de Fogo (Tratamento de Colisões)
        // ---------------------------------------------------------
        System.out.println("--- CASO 3: Inserção e Busca COM COLISÃO ---");
        MapaDispersao<Aluno> mapa3 = new MapaDispersao<>(53);

        Aluno c1 = new Aluno(12000, "Jean", LocalDate.of(2000, 1, 1));
        Aluno c2 = new Aluno(14000, "Pedro", LocalDate.of(1999, 1, 20));
        Aluno c3 = new Aluno(14226, "Marta", LocalDate.of(2001, 2, 18));
        Aluno c4 = new Aluno(17180, "Lucas", LocalDate.of(1998, 11, 25));

        mapa3.inserir(c1.getMatricula(), c1);
        mapa3.inserir(c2.getMatricula(), c2);
        mapa3.inserir(c3.getMatricula(), c3);
        mapa3.inserir(c4.getMatricula(), c4);

        System.out.println("Matemática da Colisão no Hash (Tamanho 53):");
        System.out.println("12000 % 53 = " + (12000 % 53) + " (Jean)");
        System.out.println("14226 % 53 = " + (14226 % 53) + " (Marta) -> COLIDIU COM JEAN!");
        System.out.println("14000 % 53 = " + (14000 % 53) + " (Pedro)");
        System.out.println("17180 % 53 = " + (17180 % 53) + " (Lucas) -> COLIDIU COM PEDRO!\n");



        System.out.println("Buscando 12000 (Índice 22): " + mapa3.buscar(12000));
        System.out.println("Buscando 14226 (Índice 22): " + mapa3.buscar(14226)); // Achou na lista encadeada!
        System.out.println("Buscando 14000 (Índice 8) : " + mapa3.buscar(14000));
        System.out.println("Buscando 17180 (Índice 8) : " + mapa3.buscar(17180)); // Achou na lista encadeada!
    }
}
