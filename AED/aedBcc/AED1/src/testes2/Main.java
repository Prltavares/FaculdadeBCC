Package testes2;
public class Main {
    public static void main(String[] args) {
        
        System.out.println("=== TESTANDO A LISTA ESTÁTICA ===");
        
        // Criando a lista com tamanho fixo MUITO PEQUENO (capacidade 2) para forçar o redimensionamento
        ListaEstatica<String> lista = new ListaEstatica<>(2);
        System.out.println("Capacidade inicial: " + lista.getCapacidade());

        System.out.println("\n--- 1. INSERÇÃO O(1) no Fim ---");
        lista.adicionarNoFim("Java");
        lista.adicionarNoFim("Python");
        imprimirLista(lista);
        
        System.out.println("\n--- 2. O GARGALO DO REDIMENSIONAMENTO O(n) ---");
        System.out.println("A lista está cheia (2/2). Vamos tentar adicionar 'C++' no fim.");
        lista.adicionarNoFim("C++"); // Isso vai acionar o método garantirCapacidade()
        System.out.println("Nova capacidade após redimensionar: " + lista.getCapacidade());
        imprimirLista(lista);

        System.out.println("\n--- 3. INSERÇÃO O(n) no Início (Deslocamento) ---");
        System.out.println("Adicionando 'C' na posição 0. Todos os outros serão empurrados.");
        lista.adicionarNoMeio(0, "C");
        imprimirLista(lista);

        System.out.println("\n--- 4. BUSCAS: O(1) vs O(n) ---");
        System.out.println("Busca O(1) por índice [2]: " + lista.buscarPorIndice(2));
        System.out.println("Busca O(n) varrendo pelo valor 'Python': Está na posição " + lista.buscarPorValor("Python"));

        System.out.println("\n--- 5. REMOÇÃO O(1) vs O(n) ---");
        System.out.println("Removendo do Fim O(1)...");
        lista.removerDoFim(); // Remove o C++ sem mover ninguém
        imprimirLista(lista);
        
        System.out.println("\nRemovendo do Início O(n) (Posição 0)...");
        lista.remover(0); // Remove o C e puxa todo mundo pra esquerda
        imprimirLista(lista);
    }

    // Método para visualizar a lista rodando
    public static void imprimirLista(ListaEstatica<String> lista) {
        System.out.print("Estado da memória: [ ");
        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.print(lista.buscarPorIndice(i) + " ");
        }
        System.out.println("]");
    }
}
    public static void main(String[] args) {
        
        System.out.println("=== TESTANDO A LISTA ESTÁTICA ===");
        
        // Criando a lista com tamanho fixo MUITO PEQUENO (capacidade 2) para forçar o redimensionamento
        ListaEstatica<String> lista = new ListaEstatica<>(2);
        System.out.println("Capacidade inicial: " + lista.getCapacidade());

        System.out.println("\n--- 1. INSERÇÃO O(1) no Fim ---");
        lista.adicionarNoFim("Java");
        lista.adicionarNoFim("Python");
        imprimirLista(lista);
        
        System.out.println("\n--- 2. O GARGALO DO REDIMENSIONAMENTO O(n) ---");
        System.out.println("A lista está cheia (2/2). Vamos tentar adicionar 'C++' no fim.");
        lista.adicionarNoFim("C++"); // Isso vai acionar o método garantirCapacidade()
        System.out.println("Nova capacidade após redimensionar: " + lista.getCapacidade());
        imprimirLista(lista);

        System.out.println("\n--- 3. INSERÇÃO O(n) no Início (Deslocamento) ---");
        System.out.println("Adicionando 'C' na posição 0. Todos os outros serão empurrados.");
        lista.adicionarNoMeio(0, "C");
        imprimirLista(lista);

        System.out.println("\n--- 4. BUSCAS: O(1) vs O(n) ---");
        System.out.println("Busca O(1) por índice [2]: " + lista.buscarPorIndice(2));
        System.out.println("Busca O(n) varrendo pelo valor 'Python': Está na posição " + lista.buscarPorValor("Python"));

        System.out.println("\n--- 5. REMOÇÃO O(1) vs O(n) ---");
        System.out.println("Removendo do Fim O(1)...");
        lista.removerDoFim(); // Remove o C++ sem mover ninguém
        imprimirLista(lista);
        
        System.out.println("\nRemovendo do Início O(n) (Posição 0)...");
        lista.remover(0); // Remove o C e puxa todo mundo pra esquerda
        imprimirLista(lista);
    }

    // Método para visualizar a lista rodando
    public static void imprimirLista(ListaEstatica<String> lista) {
        System.out.print("Estado da memória: [ ");
        for (int i = 0; i < lista.getTamanho(); i++) {
            System.out.print(lista.buscarPorIndice(i) + " ");
        }
        System.out.println("]");
    }
}